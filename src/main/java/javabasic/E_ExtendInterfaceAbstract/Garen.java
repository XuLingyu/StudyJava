package javabasic.E_ExtendInterfaceAbstract;

import java.util.Objects;

public class Garen extends Hero implements AD {
    public String garenQWER;

    public Garen() {

    }

    public Garen(String name) {
        this(name, 0 , 0);
        //System.out.println("garen is born");
    }

    public Garen( String aa, int hp, int damage) {
        super(aa, hp , damage);
        //System.out.println("garen is born");
    }



    public Garen(int hp, String name, String garenQWER) {
        super(hp, name);
        this.garenQWER = garenQWER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garen)) return false;
        if (!super.equals(o)) return false;
        Garen garen = (Garen) o;
        return Objects.equals(garenQWER, garen.garenQWER);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), garenQWER);
    }

    public void garenSword(){
        System.out.println("I have a bvig sword");
    }


    public void attack() {
        physicAttack();
    }

    @Override

    public void physicAttack() {
        System.out.println("physic attack done");
    }

    @Override
    public void physicDefense() {
        System.out.println("physic defense done");
    }


    @Override
    public String toString() {
        return "Garen{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}
