package guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class GuavaTableDemo {

    public static void main(String[] args) {
        Table<String, String, String> table= HashBasedTable.create();
        table.put("first", "id", "10000");
        table.put("first", "name", "lilei");
        table.put("second", "id", "10001");
        table.put("second", "name", "hanmeimei");

        System.out.println(table.get("first", "id"));
        System.out.println(table.get("first", "name"));
    }
}
