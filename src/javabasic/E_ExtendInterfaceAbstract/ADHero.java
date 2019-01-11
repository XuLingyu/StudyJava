package javabasic.E_ExtendInterfaceAbstract;

public class ADHero extends Hero{

    public ADHero() {

    }

    public ADHero(String name) {
        super(name);
        //System.out.println("garen is born");
    }

    public ADHero( String aa, int hp, int damage) {
        super(aa, hp , damage);
        //System.out.println("garen is born");
    }


    public void attack() {
        System.out.println("this is ap attack");
    }

}
