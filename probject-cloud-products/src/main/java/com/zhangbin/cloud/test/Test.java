package com.zhangbin.cloud.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: zb
 * @date: 2020/01/02/16:02
 * @description:
 */
@RestController
@Slf4j
public class Test {

    private List<Greeting> objListCache = new  ArrayList<Greeting>();

    @RequestMapping("/greeting")
    public Greeting greeting() {
        System.out.println("List进了.....");
        log.info("cleantheList!!!!!!!!!!");
        log.debug("ceshi");
        Greeting greeting = new Greeting();
        if (objListCache.size() >= 100000) {
            log.info("cleantheList!!!!!!!!!!");
            objListCache.clear();
        } else {
            objListCache.add(greeting);
        }
        return greeting;
    }

    public static void main(String[] args) {
        int a = 4;
        int c = ~a;
        System.out.println(c);
    }

}

@Data
class Greeting {
    private String message1;
    private String message2;
    private String message3;
    private String message4;
    private String message5;
    private String message6;
    private String message7;
    private String message8;
    private String message9;
    private String message10;
    private String message11;
    private String message12;
    private String message13;
    private String message14;
    private String message15;
    private String message16;
    private String message17;
    private String message18;
    private String message19;
    private String message20;
}

