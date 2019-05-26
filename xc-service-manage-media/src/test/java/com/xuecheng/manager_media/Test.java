package com.xuecheng.manager_media;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.ch.FileKey;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: houyong
 * @Date: 2019/4/27 21:42
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @org.junit.Test
    public void check() throws Exception {
        //源文件
        File file = new File("C:\\Users\\houyw\\Desktop\\1.wmv");
        //目标文件
        String destPath = "C:\\Users\\houyw\\Desktop\\my\\";


        RandomAccessFile read_file = new RandomAccessFile(file, "r");

        long length = file.length();
        long chunkSize = 1 * 1024 * 1024;
        long nums = (long) Math.ceil(length * 1.0 / chunkSize);
        int len;
        byte[] buffer = new byte[4096];
        for (int i = 0; i < nums; i++) {
            File file1 = new File(destPath + i);
            RandomAccessFile accessFile = new RandomAccessFile(file1, "rw");
            while (-1 != (len = read_file.read(buffer))) {
                accessFile.write(buffer, 0, len);
                if (file1.length() > chunkSize) {
                    break;
                }
            }
            accessFile.close();
        }
        read_file.close();
    }

    @org.junit.Test
    public void mergeFile() throws Exception {
        String resoucePath = "C:\\Users\\houyw\\Desktop\\my\\";
        File destFile = new File("C:\\Users\\houyw\\Desktop\\2.wmv");
        destFile.createNewFile();

        File file = new File(resoucePath);
        File[] files = file.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName());
            }
        });
        RandomAccessFile accessFile = new RandomAccessFile(destFile, "rw");
        byte[] buffer = new byte[4096];
        for (File f : files) {
            RandomAccessFile read_file = new RandomAccessFile(f, "r");
            int len = -1;
            while (-1 != (len = read_file.read(buffer))) {
                accessFile.write(buffer, 0, len);
            }
            read_file.close();
        }
        accessFile.close();
    }


}
