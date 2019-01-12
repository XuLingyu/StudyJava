package javamiddle.g_JDBC;

public class Hero {
    //注意这些修饰符，至少为protect，如果为private，则外部类，无法访问
    public int id;
    public String name;
    public float hp;
    public int damage;
    static String copyright;
    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }

    public Hero() {}

    public Hero(int id,String name,float hp,int damage) {
        this.id=id;
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attackHero(Hero h2) {
        System.out.println(this.name+ " 正在攻击 " + h2.getName());
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}
