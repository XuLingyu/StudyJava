package javamiddle.j_clone;

import java.io.Serializable;
import java.util.Date;

public class Animal implements Cloneable, Runnable, Serializable {
    StringBuffer name;
    int age;
    Date birth;
    public Animal(String name) {
        this.name = new StringBuffer(name);
        birth = new Date();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    public void setName(StringBuffer name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void changeBirth(){
        this.birth.setTime(0);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Animal animal= (Animal) super.clone();
        //深拷贝（非基本数据类型或者string 都需要深拷贝）
        animal.birth = (Date) this.getBirth().clone();
        return animal;

    }

    @Override
    public void run() {
        System.out.println("animal's run()");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
