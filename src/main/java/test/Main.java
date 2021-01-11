package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author xuly
 * @date 2020/12/28 15:33
 * @description
 */
@EnableAsync
@Component
@Slf4j
public class Main {
    @Autowired
    private AsyncTask asyncTask;

    public void testSyncTask() throws InterruptedException {
// 同步调用
        asyncTask.synCall();
    }

    public static void main(String[] args) throws InterruptedException {
        AsyncTask asyncTask = new AsyncTask();

        log.info("Call from other class start...");
        asyncTask.task1();
        log.info("Call from other class end");
    }
}
