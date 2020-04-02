package javase.base.lambda.im;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("tom");
        list.add("jerry");
        list.add("shuke");
        list.add("beita");
        list.add("damu");

        // 1. 业务实现
        List<String> lista = new ArrayList<String>();
        for (String s : list) {
            if (s.length() > 3) {
                lista.add(s);
            }
        }
        System.out.println(lista);

        // 2. 底层规则
        List<String> listb = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String s = it.next();
            if(s.length() > 3) {
                listb.add(s);
            }
        }
        System.out.println(listb);

        // 3. stream实现
        List listc = list.stream().filter(s->s.length()>3).collect(Collectors.toList());
        System.out.println(listc);
    }
}
