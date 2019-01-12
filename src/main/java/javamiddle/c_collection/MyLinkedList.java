package javamiddle.c_collection;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.LinkedList;
import java.util.Queue;


//extends AbstractSequentialList<E>
//implements List<E>, Deque<E>, Cloneable, java.io.Serializable

public class MyLinkedList {



    public static void basicMethods(){
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll =new LinkedList<>();


        //在最后插入新的英雄
        ll.addLast(new Garen("1"));
        ll.addLast(new Garen("2"));
        ll.addLast(new Garen("3"));
        //所以可以很方便的在头部和尾部插入数据
        ll.addFirst(new Garen("0"));
        ll.addLast(new Garen("4"));
        ll.offer(new Garen("5"));
        System.out.println(ll);

        //get
        System.out.println(ll.getFirst());
        //查看最后面的英雄
        System.out.println(ll.getLast());
        //查看不会导致英雄被删除
        System.out.println(ll);

        //remove
        System.out.println(ll.removeFirst());
        //取出最后面的英雄
        System.out.println(ll.removeLast());
        //取出会导致英雄被删除
        System.out.println(ll);
        System.out.println("-------------------------------------------");


        //所不同的是LinkedList还实现了Deque，进而又实现了Queue这个接口
        //Queue代表FIFO 先进先出的队列
        Queue<Hero> q= new LinkedList<Hero>();

        //加在队列的最后面
        System.out.print("初始化队列：\t");
        q.offer(new Garen("Hero1"));
        q.offer(new Garen("Hero2"));
        q.offer(new Garen("Hero3"));
        q.offer(new Garen("Hero4"));

        System.out.println(q);
        System.out.print("把第一个元素取poll()出来:\t");
        //取出第一个Hero，FIFO 先进先出
        Hero h = q.poll();
        System.out.println(h);
        System.out.print("取出第一个元素之后的队列:\t");
        System.out.println(q);

        //把第一个拿出来看一看，但是不取出来
        h=q.peek();
        System.out.print("查看peek()第一个元素:\t");
        System.out.println(h);
        System.out.print("查看并不会导致第一个元素被取出来:\t");
        System.out.println(q);
    }



    /*offer，add区别：

    一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。

    这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。 

    poll，remove区别：

    remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，

    但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。

    peek，element区别：

    element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null*/
    public static void compare(){



        LinkedList<Hero> l1 =new LinkedList<>();
       /* System.out.println("poll empty collection: " + l1.pollFirst());
        System.out.println("remove empty collection: " + l1.removeFirst());*/

        System.out.println("peek empty collection: " + l1.peek());
        System.out.println("element empty collection: " + l1.element());

    }

    public static void main(String[] args) {
        compare();

    }
}
