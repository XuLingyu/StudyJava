import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gisquest.cloud.ruleexcutor.client.GisRuleEngineClient;
import com.gisquest.cloud.ruleexcutor.client.request.FormCheckByRuleIdRequest;
import com.gisquest.cloud.ruleexcutor.client.response.FormCheckByRuleIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    char a= 's';
    String str ;
    char[] chars = {'a', 'b', 'c'} ;
    public void exchange(String str, char[] chars){
        str = "sad";
        chars[0] = 'g';

    }

    static void regT(String str, String i) {
        String reg = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0," + i + "})?$";

        Pattern pattern=Pattern.compile(reg);
        Matcher match=pattern.matcher(str);
        System.out.print(match.matches());
    }

    public static Boolean isObjectNotEmpty(Object obj) {
    String str = String.valueOf(obj);
    return StringUtils.isNotBlank(str);
}

    public static void main(String[] args){
        GisRuleEngineClient gisRuleEngineClient = new GisRuleEngineClient();
        FormCheckByRuleIdRequest data = new FormCheckByRuleIdRequest();
        FormCheckByRuleIdResponse response = gisRuleEngineClient.formCheckByRuleIds(data);

        A a1 = new A("A1",12);
        A a2 = new A("A1",12);
        List list = new ArrayList();
        list.add(a1);
        list.add(a2);
        String aas = JSON.toJSONString(list);
        JSONArray jsonObject = JSONObject.parseArray(aas);

        String asdasd = "adsa";


    }





}

