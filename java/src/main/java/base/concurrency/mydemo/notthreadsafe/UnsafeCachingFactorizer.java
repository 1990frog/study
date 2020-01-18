package base.concurrency.mydemo.notthreadsafe;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class UnsafeCachingFactorizer {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    public void notThreadSafeService() {
        BigInteger i = get();
        if(i.equals(lastNumber.get())){//存在竞态条件
            System.out.println(lastFactors.get());
        }else{
            BigInteger[] factors = getFactor(i);
            lastNumber.set(i);//存在竞态条件
            lastFactors.set(factors);//存在竞态条件
            System.out.println(factors);
        }
    }

    public synchronized void threadSafeService() {
        BigInteger i = get();
        if(i.equals(lastNumber.get())){//存在竞态条件
            System.out.println(lastFactors.get());
        }else{
            BigInteger[] factors = getFactor(i);
            lastNumber.set(i);//存在竞态条件
            lastFactors.set(factors);//存在竞态条件
            System.out.println(factors);
        }
    }

    public BigInteger get(){
        return BigInteger.ONE;
    }

    public BigInteger[] getFactor(BigInteger bigInteger){
        return new BigInteger[23];
    }

}
