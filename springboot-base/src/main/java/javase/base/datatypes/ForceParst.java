package javase.base.datatypes;

public class ForceParst {

    public static void main(String[] args) {
        int a = 0;
        /**
         * Inconvertible types; cannot cast 'int' to 'java.lang.String'
         */
        //System.out.println((String)0);

        Integer b = 1;
        /**
         * Inconvertible types; cannot cast 'java.lang.Integer' to 'java.lang.String'
         */
        //System.out.println((String)b);

        /**
         *
         *  public static String toString(int i, int radix) {
         *         if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
         *             radix = 10;
         *
         *         if (radix == 10) {
         *             return toString(i);
         *         }
         *
         *         char buf[] = new char[33];
         *         boolean negative = (i < 0);
         *         int charPos = 32;
         *
         *         if (!negative) {
         *             i = -i;
         *         }
         *
         *         while (i <= -radix) {
         *             buf[charPos--] = digits[-(i % radix)];
         *             i = i / radix;
         *         }
         *         buf[charPos] = digits[-i];
         *
         *         if (negative) {
         *             buf[--charPos] = '-';
         *         }
         *
         *         return new String(buf, charPos, (33 - charPos));
         *  }
         *
         */
        System.out.println(String.valueOf(b));
    }
}
