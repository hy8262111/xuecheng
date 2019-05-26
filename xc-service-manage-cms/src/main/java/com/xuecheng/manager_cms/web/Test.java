package com.xuecheng.manager_cms.web;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import sun.java2d.pipe.SpanIterator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: houyong
 * @Date: 2019/4/15 22:11
 * @describe
 */
public class Test {
    public static void main(String[] args){

        /*List<String> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i + "");
        }


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (String num : nums) {
            new Thread(() -> {
                try {
                    Thread.sleep(400);
                } catch (Exception e) {

                }
                System.out.println(num);
            });
        }*/

        /*int bidCount = 52;
        double ceil = bidCount / 5;
        double temp = Math.ceil(ceil);
        System.out.println("temp=" + temp);

        ceil = bidCount / 5.0;
        System.out.println("ceil=" + ceil);

        temp = Math.ceil(ceil);
        System.out.println("temp=" + temp);*/




        /*int test = test((x, y) -> {
            return x + y;
        }, 2, 3);
        System.out.println(test);*/


    }

    public static int test(Cal cal, int x, int y) {
        return cal.add(x, y);
    }
}
