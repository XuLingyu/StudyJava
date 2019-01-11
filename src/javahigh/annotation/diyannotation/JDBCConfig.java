package javahigh.annotation.diyannotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE,METHOD}) //可以用用在类/接口上，还可以用在方法上
@Retention(RetentionPolicy.RUNTIME) //表示这是一个运行时注解，即运行起来之后，才获取注解中的相关信息
@Inherited //可以被子类继承
@Documented //执行javadoc的时候，本注解会生成相关文
public @interface JDBCConfig {
    String ip();
    int port() default 3306;
    String database();
    String encoding();
    String loginName();
    String password();
}