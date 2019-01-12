package javabasic.C_ChracterAndString;

/*
1.对byte,short,float,double进行自动拆箱和自动装箱
2.byte和Integer之间能否进行自动拆箱和自动装箱
3.通过Byte获取byte的最大值
 */
public class BoxingAndUnboxing {
    public static void main(String[]arge) {


        //boxing: primitive types => wrapper classes
        //int => Integer
        int i = 5;
        Integer i2 = new Integer(i);
        System.out.println(i2);

        //unboxing: wrapper classes => primitive types
        //Integer => int
        Integer i3 = new Integer(5);
        int i4 = i3.intValue();
        System.out.println(i4);

        byte a = 5;
        Byte a1 = a;//auto boxing
        System.out.println(a1);
        byte a2 = a1;//auto unboxing
        System.out.println(a2);

        short b = 5;
        Short b1 = b;//auto boxing
        System.out.println(b1);
        short b2 = b1;//auto unboxing
        System.out.println(b2);


        //byte和Integer之间不可以进行自动装箱和拆箱
        //byte e = 5;
        //Integer e1 = e;//自动装箱
        //不能从byte转为Integer
        //byte e2 = e1;//自动拆箱
        //不能从Integer转为byte

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
    }
}

