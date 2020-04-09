package javase.base.datatypes;

public class BaseArrays {

    public static void main(String[] args) {
        int[] ints = {1,2,3};
        Integer[] integers = new Integer[100];
        integers[0]=1;
        integers[1]=2;
        integers[2]=3;
        System.out.println(integers[0]==ints[0]);

    }
}
