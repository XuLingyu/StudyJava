package javamiddle.d_generic;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;
import javabasic.E_ExtendInterfaceAbstract.Item;

import java.util.LinkedList;

public class GenericStack<T> {
    LinkedList<T> values = new LinkedList<T>();

    public void push(T t) {
        values.addLast(t);
    }

    public T pull() {
        return values.removeLast();
    }

    public T peek() {
        return values.getLast();
    }

    public static void main(String[] args) {
        //在声明这个Stack的时候，使用泛型<Hero>就表示该Stack只能放Hero
        GenericStack<Hero> heroStack = new GenericStack<>();
        heroStack.push(new Garen());
        heroStack.push(new Hero());
        //不能放Item
        //heroStack.push(new Item());

        //在声明这个Stack的时候，使用泛型<Item>就表示该Stack只能放Item
        GenericStack<Item> itemStack = new GenericStack<>();
        itemStack.push(new Item());
        //不能放Hero
        //itemStack.push(new Hero());
    }

}
