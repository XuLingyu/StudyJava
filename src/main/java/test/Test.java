package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gisquest.cloud.ruleexcutor.client.GisRuleEngineClient;
import com.gisquest.cloud.ruleexcutor.client.request.FormCheckByRuleIdRequest;
import com.gisquest.cloud.ruleexcutor.client.response.FormCheckByRuleIdResponse;
import com.gisquest.cloud.ruleexcutor.client.response.ResponseBodyVo;
import javabasic.E_ExtendInterfaceAbstract.Garen;
import javamiddle.g_JDBC.DAO.Hero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void swap(Student st1, Student st2) {
        Student temp = st1;
        st1 = st2;
        st2 = temp;
    }

    public static java.lang.Boolean validateTel(java.lang.String arg0) {
        java.lang.String regex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领]（\\d{4}）[\\u4E00-\\u9FA5]{0,15}不动产权第\\d{7}号$";
        if (arg0.matches(regex))return true;
        return false;
    }


    public static void main(String[] args) {
       System.out.println(validateTel("云（1548）我我我我我我我我我我我我我我我不动产权第0163239号"));
        System.out.println(validateTel("云（1548）不动产权第0163239号"));
        System.out.println(validateTel("BDC212100a3455Z4454"));
        System.out.println(validateTel("1（1548）不动产权第0163239号"));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student {
        String name;
        Integer age;

    }
}

