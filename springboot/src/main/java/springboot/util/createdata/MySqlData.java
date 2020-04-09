package springboot.util.createdata;

import springboot.action.guava.cache.GuavaCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Controller
public class MySqlData {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ThreadLocal<Random> threadLocal;

    private GuavaCache guavaCache;

    private AtomicInteger count;

    @PostConstruct
    public void init() {
        guavaCache = new GuavaCache();
        threadLocal = ThreadLocal.withInitial(() -> new Random());
        count = new AtomicInteger();
    }

    public static void main(String[] args) {
        MySqlData mySqlData = new MySqlData();
        mySqlData.count = new AtomicInteger();
        for (int i = 0; i < 10000; i++) {
            mySqlData.count.incrementAndGet();
            System.out.println(mySqlData.count.get());
        }
    }

    String sql = "INSERT INTO bigtable.ganta (name, gender, age, teacher, level, gang, student, gest, wife) " +
            "VALUES ('%s', %d, %d, %d, %d, %d, %d, %d, %d)";

    public int getGangs() {
        return threadLocal.get().nextInt(3);
    }

    public int getGest() {
        return threadLocal.get().nextInt(65);
    }

    public int getLevel() {
        return threadLocal.get().nextInt(9);
    }

    public String getName() {
        // 姓
        String firstname = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范" +
                "彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜" +
                "顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅" +
                "庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝" +
                "管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄曲家封芮羿储" +
                "靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫";
        // 名
        String lastname = "的一是在不了有和人这中大为上个国我以要他时来用们生到作地于出就分对成会可主发年动同工也能下过" +
                "子说产种面而方后多定行学法所民得经十三之进着等部度家电力里如水化高自二理起小物现实加量都两体" +
                "制机当使点从业本去把性好应开它合还因由其些然前外天政四日那社义事平形相全表间样与关各重新线内" +
                "数正心反你明看原又么利比或但质气第向道命此变条只没结解问意建月公无系军很情者最立代想已通并提" +
                "直题党程展五果料象员革位入常文总次品式活设及管特件长求老头基资边流路级少图山统接知较长将组见" +
                "计别她手角期根论运农";
        int f = threadLocal.get().nextInt(firstname.length());
        int s = threadLocal.get().nextInt(firstname.length());
        return firstname.substring(f, f + 1)
                + lastname.substring(s, s + 1);
    }

    public int getAge() {
        return threadLocal.get().nextInt(1000);
    }

    public int getGender() {
        return threadLocal.get().nextInt(1);
    }

    @PostMapping("/mysqldata/insert")
    public void insert() {
        count.incrementAndGet();
        String executesql = String.format(this.sql, getName(),
                getGender(),
                getAge(),
                threadLocal.get().nextInt(count.get()),
                getLevel(),
                getGangs(),
                threadLocal.get().nextInt(count.get()),
                getGest(),
                threadLocal.get().nextInt(count.get()));
        log.info(executesql);
        jdbcTemplate.execute(executesql);
    }
}
