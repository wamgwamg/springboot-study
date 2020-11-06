package com.example.job;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobApplicationTests {

    @Test
    void contextLoads() {

        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        c(a,b);
        System.out.println(a+"---"+b);
    }

    public static void c(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }

}
