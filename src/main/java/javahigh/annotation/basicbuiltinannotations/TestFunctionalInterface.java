package javahigh.annotation.basicbuiltinannotations;

//@FunctionalInterface 这是Java1.8 新增的注解，用于约定函数式接口。
// 函数式接口概念： 如果接口中只有一个抽象方法（可以包含多个默认方法或多个static方法），
// 该接口称为函数式接口。函数式接口其存在的意义，主要是配合Lambda 表达式 来使用。
@SuppressWarnings("all")
@FunctionalInterface
public interface TestFunctionalInterface {
    //接口只有一个adAttack方法，那么就可以被注解为@FunctionalInterface,
    // 而接口有两个方法apAttack()和apAttack2(),那么就不能被注解为函数式接口
    public void adAttack();
    //public void adAttack2();
}
