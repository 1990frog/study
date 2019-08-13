package java8.stream;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Entity {

    private String code;
    private String value;

    @Override
    public String toString() {
        return "Entity{" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Entity() {
    }

    public Entity(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else{
            Entity entity = (Entity)obj;
            return this.code.equals(entity.getCode());
        }
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.code);
    }

    public static List<Entity> getEntityList(){
        List list = new ArrayList();
        Entity entity1 = new Entity("1","2");
        Entity entity2 = new Entity("1","2");
        Entity entity3 = new Entity("2","3");
        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        return list;
    }

}
