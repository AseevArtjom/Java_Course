package wrapper;

import java.nio.DoubleBuffer;

public class WrapperTest {
    public static void main(String[] args) {
        Integer a1 = 10;
        Integer a2 = Integer.valueOf(100);
        Integer a3 = new Integer(40);
        Integer a4 = Integer.parseInt("20");

        Double a5 = 10.1;
        Double a6 = Double.valueOf(20.2);
        Double a7 = new Double(30.3);
        Double a8 = Double.parseDouble("40.4");

        Float a9 = 10.1F;
        Float a10 = Float.valueOf(20.2F);
        Float a11 = new Float(30.3F);
        Float a12 = Float.parseFloat("40.4F");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        Double b1 = 3.14;
        byte b2 = 12;
        short b3 = 12345;
        int b4 = 2147483647;
        float b5 = 2.2231F;

        b2 = b1.byteValue();
        b3 = b1.shortValue();
        b4 = b1.intValue();
        b5 = b1.floatValue();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);

        Double c1 = 123.45;
        Double c2 = Double.NaN;
        Double c3 = Double.POSITIVE_INFINITY;
        Double c4 = Double.NEGATIVE_INFINITY;

        if(Double.isNaN(c2)){
            System.out.println("c2 is Nan");
        }
        if(Double.isInfinite(c3)){
            System.out.println("c3 is infinity");
        }
        if(Double.isInfinite(c4)){
            System.out.println("c4 is infinity");
        }

        Double d1 = 0.0;
        Double d2 = 2.1;
    }
}
