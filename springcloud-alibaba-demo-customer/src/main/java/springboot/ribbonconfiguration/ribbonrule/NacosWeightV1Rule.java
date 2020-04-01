package springboot.ribbonconfiguration.ribbonrule;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.google.common.collect.Lists;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * 直接把double型的权重(weight)，转成了integer计算了，存在精度丢失。
 * InstanceWithWeight太重了，在 weightRandom 还得再两层for循环，还挺吃内存的，建议百度其他权重随机算法优化。不过实际项目一个微服务一般也就三五个实例，所以其实内存消耗也能忍受。不优化问题也不大。
 */
@Slf4j
public class NacosWeightV1Rule extends AbstractLoadBalancerRule {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class InstanceWithWeight {
        private Server server;
        private Integer weight;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        // 获取可用的服务列表
        List<Server> servers = this.getLoadBalancer().getReachableServers();

        List<InstanceWithWeight> instanceWithWeights = servers.stream()
                .map(server -> {
                    // 注册中心只用Nacos，没同时用其他注册中心（例如Eureka），理论上不会实现
                    if (!(server instanceof NacosServer)) {
                        log.error("参数非法，server = {}", server);
                        throw new IllegalArgumentException("参数非法，不是NacosServer实例！");
                    }

                    // 获取nacos权重规则
                    NacosServer nacosServer = (NacosServer) server;
                    Instance instance = nacosServer.getInstance();
                    double weight = instance.getWeight();
                    return new InstanceWithWeight(
                            server,
                            Double.valueOf(weight).intValue()
                    );
                })
                .collect(Collectors.toList());

        Server server = this.weightRandom(instanceWithWeights);

        log.info("选中的server = {}", server);
        return server;
    }

    /**
     * 根据权重随机
     * @param list 实例列表
     * @return 随机出来的结果
     */
    private Server weightRandom(List<InstanceWithWeight> list) {
        List<Server> instances = Lists.newArrayList();
        for (InstanceWithWeight instanceWithWeight : list) {
            int weight = instanceWithWeight.getWeight();
            for (int i = 0; i <= weight; i++) {
                instances.add(instanceWithWeight.getServer());
            }
        }
        int i = new Random().nextInt(instances.size());
        return instances.get(i);
    }

}
