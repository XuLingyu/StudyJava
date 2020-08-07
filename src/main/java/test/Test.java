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

    public static void main(String[] args) {
      System.out.println(JSON.toJSONString(null));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student {
        String name;
        Integer age;

    }
}

