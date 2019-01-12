package javabasic.E_ExtendInterfaceAbstract;

public class Item {

    String name;
    int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Item() {
        this(null, 0);
    }

    public Item(String name, int damage) {

        this.name = name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }
}
