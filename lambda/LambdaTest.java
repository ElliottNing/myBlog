package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
    List<String> list = new ArrayList<String>(){
        {
          this.add("a");
          this.add("b");
          this.add("c");
          this.add("d");
          this.add("e");
          this.add("f");
        }
    };

    @Test
    public void test1() {
        long time;
        List<Long> times = new ArrayList<>();
        for (int k = 1; k <= 20; k++) {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                list.stream().filter(
                        l -> l.startsWith("f")
                ).forEach(l -> {});
            }
            long end = System.currentTimeMillis();
             time = end - begin;
            System.out.println("第"+ k +"次循环1000000遍，lambda耗时：" + time + "ms");
            times.add(time);
        }
        double t = 0.0;
        for (Long tt:times) {
            t += tt;
        }
        double avg = t/times.size();
        System.out.println("平均耗时：" + avg + "ms");
    }

    @Test
    public void test2() {
        long time;
        List<Long> times = new ArrayList<>();
        for (int k = 1; k <= 20; k++) {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                for (String j : list) {
                    if (j.startsWith("f")) {
                    }
                }
            }
            long end = System.currentTimeMillis();
            time = end - begin;
            System.out.println("第"+ k +"次循环1000000遍，普通写法耗时：" + time + "ms");
            times.add(time);
        }
        double t = 0.0;
        for (Long tt:times) {
            t += tt;
        }
        double avg = t/times.size();
        System.out.println("平均耗时：" + avg + "ms");
    }

}
