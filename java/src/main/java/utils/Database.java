package utils;


import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Database {

    // 帮派
    private static List<String> gangsList = (ArrayList) Stream.of(new String[]{"通天岛", "太一宫", "巨鲸帮", "飞天拉面神教"}).collect(Collectors.toList());
    // 招式
    private static List<String> gestList = (ArrayList) Stream.of(new String[]{"白蛇吐芯", "海底捞月", "二龙戏珠", "青龙摆尾", "饿虎扑食", "白鹤亮翅", "美女照镜", "渔郎问津", "四面埋伏", "童子拜佛", "如来神掌", "凌波微步", "猴子摘桃", "移花接木", "斗转星移", "六脉神剑", "见龙在田", "飞龙在天", "亢龙有悔", "利涉大川", "鱼跃于渊", "羝羊触潘", "损则有孚", "屡霜冰至", "潜龙勿用", "时乘六龙", "神龙摆尾", "或跃在渊", "突如其来", "双龙取水", "鸿渐于陆", "震惊百里", "龙战于野", "密云不雨", "落英神剑掌", "旋风扫叶腿", "碧波掌", "玉萧剑法", "弹指神通", "灵鳌步", "兰花拂穴手", "劈空掌", "少商剑--手太阴肺经", "商阳剑--厥阴心包经", "中冲剑--手少阴心经", "関冲剑--手太阳小肠经", "少冲剑--手阳明胃经", "少泽剑--手少阳三焦经", "浪迹天涯", "花前月下", "清饮小酌", "雁行斜击", "白虹经天", "抚琴按箫", "扫雪烹茶", "松下对弈", "池边调鹤", "小园艺菊", "茜窗夜话", "柳荫联句", "竹帘临池", "举案齐眉", "皓腕玉镯", "帘下梳妆", "黯然销魂掌", "独孤九剑"}).collect(Collectors.toList());
    // 等级
    private static List<String> levelLIst = (ArrayList) Stream.of(new String[]{"凝气", "筑基", "结丹", "元婴", "天人", "半神", "大乘", "太古", "主宰"}).collect(Collectors.toList());

    // 姓
    String lastname = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范" +
            "彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜" +
            "顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅" +
            "庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝" +
            "管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄曲家封芮羿储" +
            "靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫";
    // 名
    String firstname = "的一是在不了有和人这中大为上个国我以要他时来用们生到作地于出就分对成会可主发年动同工也能下过" +
            "子说产种面而方后多定行学法所民得经十三之进着等部度家电力里如水化高自二理起小物现实加量都两体" +
            "制机当使点从业本去把性好应开它合还因由其些然前外天政四日那社义事平形相全表间样与关各重新线内" +
            "数正心反你明看原又么利比或但质气第向道命此变条只没结解问意建月公无系军很情者最立代想已通并提" +
            "直题党程展五果料象员革位入常文总次品式活设及管特件长求老头基资边流路级少图山统接知较长将组见" +
            "计别她手角期根论运农";

    public static List<String> getSynchronized(String key){
        if(key.equals("gangs"))
            return Collections.synchronizedList(gangsList);
        if(key.equals("gest"))
            return Collections.synchronizedList(gestList);
        if(key.equals("level"))
            return Collections.synchronizedList(levelLIst);
        throw new IllegalArgumentException();
    }

    public static String getSql(String key){
        if(key.equals("gangs"))
            return "insert into gangs(name,status) values(‘%s’,1)";
        if(key.equals("gest"))
            return "insert into gest(name,dps) values('%s',"+new Random(1000).nextInt(100)+")";
        if(key.equals("level"))
            return "insert into level(name) values('%s')";
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

    }
}
