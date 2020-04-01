package com.ribbonconfiguration.ribbonrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class SelectPortRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        // 获取可用的服务列表
        List<Server> servers = this.getLoadBalancer().getAllServers();
        for (Server server : servers){
            if("8001".equals(server.getPort()+"")){
                return server;
            }
        }
        return null;
    }
}
