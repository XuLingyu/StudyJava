package expressionparse;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:xuly
 * @Date: 2019/10/18 17:00
 * @Description:
 */
public class TestExpression {
    public static void main(String[] args) {

        String expression = "aa=1010";
        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile("a +b>10");
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 10);
        env.put("b", 45);
        env.put("c", -199.100);
        // 执行表达式
        Boolean result = (boolean) compiledExp.execute(env);
        System.out.println(result);

    }
}
