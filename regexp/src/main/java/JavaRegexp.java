import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexp {

    @Test
    public void test1(){
        String s = "1231hjsjkfhasiuo213u1h31ui2h312312h3uijk12";
        String reg = "\\d{3}";
        System.out.println(s.replaceAll(reg, "###"));
    }

    @Test
    public void test2(){
        String content = "I am noob from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    @Test
    public void test3(){
        String s = "abcd&"; // 目标字符串
        String regular1 = "\\w+\\w"; // 贪婪型正则（+ 表示1个或多个）
        String regular2 = "\\w+?\\w"; // 勉强型正则（+? 表示1个或多个）
        String regular3 = "\\w++\\w"; // 占有型正则（++ 表示1个或多个）
        Matcher m1 = Pattern.compile(regular1).matcher(s);
        Matcher m2 = Pattern.compile(regular2).matcher(s);
        Matcher m3 = Pattern.compile(regular3).matcher(s);
        // 调用方法去匹配字符串
        if(m1.find()) {
            System.out.println("贪婪型正则:"+m1.group());
        }
        if(m2.find()) {
            System.out.println("勉强型正则:"+m2.group());
        }
        if(m3.find()) {
            System.out.println("占有型正则:"+m3.group());
        }

    }

    @Test
    public void test4(){
        String s = "a=124_a=789_a=490";
        String regular = "^a=\\d+";
        Matcher m = Pattern.compile(regular).matcher(s);
        if(m.find()){
            System.out.println(m.group());
        }
    }

    /**
     * 就像是$匹配字符串结尾一样，(?=2)也是匹配字符串中为2的位置，然后再去检查(?=2)前面的\\w{3}是否匹配abc，匹配则输出结果。
     * 之所以说是零宽度，是因为(?=2)只是起一个锚点定位作用，此时尾指针指向的不是2后面，而是c后面。
     */
    @Test
    public void test5(){
        // 目标字符串。只想取出字符2前面的abc，(?=exp) 零宽度向前匹配
        String s = "abc1 abc1 abc2 abc3";
        // (?=2),2是锚点，不是位置
        String regular = "\\w{3}(?=2)";
        Matcher m = Pattern.compile(regular).matcher(s);
        while(m.find()) {
            System.out.println(m.group());
        }
    }

    /**
     * 第1次匹配，匹配到前4个a，输出aa；
     * 第2次匹配，是从第2个a后开始向后，而不是第4个a后面，(?=aa) 只标定位置，不占有宽度；
     * 以此类推，最终结果输出为aa aa aa
     */
    @Test
    public void test6(){
        String s = "aaaaaaaa";
        String regular = "aa(?=aa)";
        Matcher m = Pattern.compile(regular).matcher(s);
        while(m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    public void test7(){
        // 目标字符串。 只要求输出2后面的abc
        String s = "1abc 2abc 3abc";
        String regular = "(?<=2)\\w{3}";
        Matcher m = Pattern.compile(regular).matcher(s);
        while(m.find()) {
            System.out.println(m.group());
        }
    }

    /**
     * 在默认情况下，^ 和 $ 只匹配全部字符串的开始与结束位置，
     * 但是如果用（?m）开启多行匹配模式之后， ^ 和 $ 将匹配每一行的开始与结束位置。
     * 所以说，上面上面那个举例正则(?m)\\w{3}$，将会匹配出每一行的最后三个字符。
     */
    @Test
    public void test8(){
        String s = "I care not whether I can succeed\n"
                + "Since in choice of the distance\n"
                + "I simply travel in wind and rain\n"
                + "I care not whether I can win love\n"
                + "Since in deep love with a rose\n"
                + "I just unbosom myself bravely";
        String regular = "(?m)\\w{3}$";
        Matcher m = Pattern.compile(regular).matcher(s);
        while(m.find()) {
            System.out.println(m.group());
        }

    }


}
