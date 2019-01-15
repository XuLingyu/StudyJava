package javamiddle.j_clone;

import javabasic.E_ExtendInterfaceAbstract.Hero;

import java.util.ArrayList;
import java.util.List;

public class TestClone {
    public static void main(String args[]){
        List<Animal> animals = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            animals.add(new Animal("Animal " + i));
        }
        System.out.println("Generated list heroes");
        animals.forEach(h-> System.out.println(h));
        Animal animal = animals.get(0);
        animal.setAge(100);
        System.out.println("change the hp of hero, the value of heroes 1  changed ,too ");
        System.out.println("animal: " + animal);
        System.out.println("animals.get(0): " + animals.get(0));
        System.out.println("use clone() of Object, clone returns a new object rather than a reference object");
        Animal cloneAnimal = (animals.get(1)).clone();
        cloneAnimal.setAge(10);
        System.out.println("clone animal:" + cloneAnimal);
        System.out.println("animals.get(1)" + animals.get(1));


    }
}
