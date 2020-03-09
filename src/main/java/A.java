import lombok.Data;

/**
 * @Author:xuly
 * @Date: 2020/3/5 10:03
 * @Description:
 */
@Data
public class A {
    private String name;
    private Integer age;

    public A(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
