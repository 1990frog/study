package springboot.productor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class TestController {
//    @Autowired(required = false)
//    private ShareMapper shareMapper;
    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon/test")
    @ResponseBody
    public String ribbonTest(){
        return restTemplate.getForObject("http://user-center/users/{id}",String.class,1);
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") String id){
        log.info("我被访问了！");
        return id;
    }

//    @GetMapping("/test")
//    public List<Share> testInsert() {
//        // 1. 做插入
//        Share share = new Share();
//        share.setCreateTime(new Date());
//        share.setUpdateTime(new Date());
//        share.setTitle("xxx");
//        share.setCover("xxx");
//        share.setAuthor("大目");
//        share.setBuyCount(1);
//
//        this.shareMapper.insertSelective(share);
//
//        // 2. 做查询: 查询当前数据库所有的share  select * from share ;
//        List<Share> shares = this.shareMapper.selectAll();
//
//        return shares;
//    }
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello";
    }

    /**
     * 测试：服务发现，证明内容中心总能找到用户中心
     *
     * @return 用户中心所有实例的地址信息
     */
    @GetMapping("test2")
    public List<ServiceInstance> getInstances() {
        // 查询指定服务的所有实例的信息
        // consul/eureka/zookeeper...
        return this.discoveryClient.getInstances("user-center");
    }

//    @Autowired
//    private TestUserCenterFeignClient testUserCenterFeignClient;
//
//    @GetMapping("test-get")
//    public UserDTO query(UserDTO userDTO) {
//        return testUserCenterFeignClient.query(userDTO);
//    }
//
//    @Autowired
//    private TestBaiduFeignClient testBaiduFeignClient;
//
//    @GetMapping("baidu")
//    public String baiduIndex() {
//        return this.testBaiduFeignClient.index();
//    }
//
//    @Autowired
//    private TestService testService;
//
//    @GetMapping("test-a")
//    public String testA() {
//        this.testService.common();
//        return "test-a";
//    }
//
//    @GetMapping("test-b")
//    public String testB() {
//        this.testService.common();
//        return "test-b";
//    }
//
//    @GetMapping("test-hot")
//    @SentinelResource("hot")
//    public String testHot(
//            @RequestParam(required = false) String a,
//            @RequestParam(required = false) String b
//    ) {
//        return a + " " + b;
//    }
//
//    @GetMapping("test-add-flow-rule")
//    public String testHot() {
//        this.initFlowQpsRule();
//        return "success";
//    }
//
//    private void initFlowQpsRule() {
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule rule = new FlowRule("/shares/1");
//        // set limit qps to 20
//        rule.setCount(20);
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule.setLimitApp("default");
//        rules.add(rule);
//        FlowRuleManager.loadRules(rules);
//    }
//
//    @GetMapping("/test-javase.redis.sentinel-api")
//    public String testSentinelAPI(
//            @RequestParam(required = false) String a) {
//
//        String resourceName = "test-javase.redis.sentinel-api";
//        ContextUtil.enter(resourceName, "test-wfw");
//
//        // 定义一个sentinel保护的资源，名称是test-javase.redis.sentinel-api
//        Entry entry = null;
//        try {
//
//            entry = SphU.entry(resourceName);
//            // 被保护的业务逻辑
//            if (StringUtils.isBlank(a)) {
//                throw new IllegalArgumentException("a不能为空");
//            }
//            return a;
//        }
//        // 如果被保护的资源被限流或者降级了，就会抛BlockException
//        catch (BlockException e) {
//            log.warn("限流，或者降级了", e);
//            return "限流，或者降级了";
//        } catch (IllegalArgumentException e2) {
//            // 统计IllegalArgumentException【发生的次数、发生占比...】
//            Tracer.trace(e2);
//            return "参数非法！";
//        } finally {
//            if (entry != null) {
//                // 退出entry
//                entry.exit();
//            }
//            ContextUtil.exit();
//        }
//    }
//
//    @GetMapping("/test-javase.redis.sentinel-resource")
//    @SentinelResource(
//            value = "test-javase.redis.sentinel-api",
//            blockHandler = "block",
//            blockHandlerClass = TestControllerBlockHandlerClass.class,
//            fallback = "fallback"
//    )
//    public String testSentinelResource(@RequestParam(required = false) String a) {
//        if (StringUtils.isBlank(a)) {
//            throw new IllegalArgumentException("a cannot be blank.");
//        }
//        return a;
//    }
//
//    /**
//     * 1.5 处理降级
//     * - javase.redis.sentinel 1.6 可以处理Throwable
//     *
//     * @param a
//     * @return
//     */
//    public String fallback(String a) {
//        return "限流，或者降级了 fallback";
//    }
//
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/test-rest-template-javase.redis.sentinel/{userId}")
//    public UserDTO test(@PathVariable Integer userId) {
//        return this.restTemplate
//                .getForObject(
//                        "http://user-center/users/{userId}",
//                        UserDTO.class, userId);
//    }
//
//    @GetMapping("/tokenRelay/{userId}")
//    public ResponseEntity<UserDTO> tokenRelay(@PathVariable Integer userId, HttpServletRequest request) {
//        String token = request.getHeader("X-Token");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Token", token);
//
//        return this.restTemplate
//                .exchange(
//                        "http://user-center/users/{userId}",
//                        HttpMethod.GET,
//                        new HttpEntity<>(headers),
//                        UserDTO.class,
//                        userId
//                );
//    }
}
