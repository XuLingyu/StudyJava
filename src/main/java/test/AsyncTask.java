package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xuly
 * @date 2020/12/28 15:32
 * @description
 */
@Component
@Slf4j
@Async
public class AsyncTask {
    public void synCall() throws InterruptedException {
        log.info("syn method Call task1 start ...");
        task1();
        log.info("syn method Call task1 end");
    }

    public void task1() throws InterruptedException {
        log.info("task1 start ...");
        log.info("Sleep {}s", 3);
        TimeUnit.SECONDS.sleep(3);
        log.info("task1 end");
    }
}
