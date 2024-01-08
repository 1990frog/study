package com;

import lombok.AllArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author cai
 * @since 2023/2/15
 */
public class GenericStaticClass {
    @AllArgsConstructor
    public static class Test<K>{
        private K k;
        public void printK(){
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        Test test = new Test(1);
        test.printK();
    }
}
