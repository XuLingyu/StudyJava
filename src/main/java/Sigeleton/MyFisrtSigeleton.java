package Sigeleton;

public class MyFisrtSigeleton {
    private static MyFisrtSigeleton ourInstance = new MyFisrtSigeleton();

    public static MyFisrtSigeleton getInstance() {
        return ourInstance;
    }

    private MyFisrtSigeleton() {
    }
}
