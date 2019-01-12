package javabasic.E_ExtendInterfaceAbstract;



public class APHero extends Hero{

    public APHero() {

    }

    public APHero(String name) {
        super(name);
        //System.out.println("garen is born");
    }

    public APHero( String aa, int hp, int damage) {
        super(aa, hp , damage);
        //System.out.println("garen is born");
    }


    public void attack() {
        System.out.println("this is ad attack");
    }


}
