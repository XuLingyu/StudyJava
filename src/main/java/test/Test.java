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

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    /*    GisRuleEngineClient gisRuleEngineClient = new GisRuleEngineClient();
        FormCheckByRuleIdRequest data = new FormCheckByRuleIdRequest();
        FormCheckByRuleIdResponse response = gisRuleEngineClient.formCheckByRuleIds(data);*/
        //在某一线程声明了ABC三种类型的ThreadLocal
       /* ThreadLocal<A> sThreadLocalA = new ThreadLocal<>();
        ThreadLocal<Hero> sThreadLocalB = new ThreadLocal<>();
        ThreadLocal<Garen> sThreadLocalC = new ThreadLocal<>();
        Thread t = new Thread();
        t.start();*/

   /*     final String uri = "http://192.168.99.71:39001/ruleEngine/projectRules";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
        System.out.println();*/

     /*   Mono<String> response = WebClient.create().get().uri("http://192.168.99.71:39001/ruleEngine/projectRules").retrieve().bodyToMono(String.class);
        System.out.println(response.block());*/
       /* int N = 8; //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++) {
            new Worker(i,semaphore).start();
        }*/
        List<String> list = Arrays.asList("foo");
        String joined = String.join(",", list);
        System.out.println(joined);
    }


}

