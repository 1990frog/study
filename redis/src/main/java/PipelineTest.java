import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PipelineTest {

    private static Jedis db = RedisUtils.getInstance();

    public static void unpipeline(){
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            db.set(i+"",System.currentTimeMillis()+"");
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }

    public static void pipeline(){
        long startTime=System.currentTimeMillis();
        Pipeline pipeline = db.pipelined();
        for(int i=20000;i<30000;i++){
            pipeline.set(i+"",System.currentTimeMillis()+"");
        }
        pipeline.sync();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }

    public static void main(String[] args) {
        unpipeline();//517ms
        pipeline();//47ms
    }

}
