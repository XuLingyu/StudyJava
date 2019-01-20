package javahigh.GarbageCollection;

import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.Map;
import java.util.Vector;

public class UseGC {
    class Test{
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(this.getClass().getName() + "finalizer() runs");
        }
    }
    public static void main(String args[]){
        Test test = new UseGC().new Test();
        // second and thrid Test Object lost their references, and it will be finalized by GC.
        Test test1 = new UseGC(). new Test();
        Test test2 = new UseGC(). new Test();
        test1 = test;
        test2 = test;
        System.gc();
    }
}
