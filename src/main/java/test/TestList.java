package test;

import java.util.List;

/**
 * @Author: xuly
 * @Date: 2020/7/27 10:45
 * @Description:
 */
public class TestList {

    public static void buildTest(boolean sad, List<A> list) {
        if (sad) {

        } else {
            list.add(new A("A",1));
            list.add(new A("A",1));
            list.add(new A("A",1));
            list.add(new A("A",1));
            list.add(new A("A",1));
            list.add(new A("A",1));
        }


    }

}
