package javamiddle.a_exception;

import javabasic.E_ExtendInterfaceAbstract.Garen;
import javabasic.E_ExtendInterfaceAbstract.Hero;

class TestEnemyHeroIsDeadException extends Exception{

    public static void main(String[] args) {

        Hero garen = new Garen();
        garen.name = "盖伦";
        garen.hp = 616;

        Hero teemo =  new Garen();
        teemo.name = "提莫";
        teemo.hp = 0;

        try {
            garen.attackHero(teemo);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("异常的具体原因:"+e.getMessage());
            e.printStackTrace();
        }

    }
}
