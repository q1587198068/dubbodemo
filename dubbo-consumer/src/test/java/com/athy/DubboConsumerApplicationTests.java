package com.athy;



//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class DubboConsumerApplicationTests {

    @Test
    public void contextLoads() {
        String property = System.setProperty("zookeeper.address", "127.0.0.1");
        System.out.println(property);
        String zookeeperPort = System.setProperty("zookeeper.port", "2181");
        System.out.println(zookeeperPort);
        Properties properties = System.getProperties();
        System.out.println(properties.toString());
    }
    volatile static int i1 = 0;
    @Test
    public void t1() throws Exception {
        int threadNum=10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                        for (int j = 0; j < 10000; j++) {
                            i1++;
                        }
                    long count = countDownLatch.getCount();
                    countDownLatch.countDown();
                    long count1 = countDownLatch.getCount();
                    System.out.println(count+"---"+count1);
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(i1);
    }
}
