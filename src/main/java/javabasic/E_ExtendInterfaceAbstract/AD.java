package javabasic.E_ExtendInterfaceAbstract;


public interface AD {

    //属性必须初始化
    public static final int A = 111;

    //方法必须public，abstract(默认)
    void physicAttack();

    public abstract void physicDefense();

    //java 8 默认方法
    default public void magicDefense(){
        System.out.println("Interface AD default method: magicDefense");

    }




}