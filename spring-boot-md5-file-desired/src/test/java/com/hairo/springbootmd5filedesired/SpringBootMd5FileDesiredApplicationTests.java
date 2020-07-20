package com.hairo.springbootmd5filedesired;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class SpringBootMd5FileDesiredApplicationTests {

    @Test
    void contextLoads() throws IOException, NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(getRandomStr().getBytes());
        byte s[] = m.digest();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
        }
        try (FileOutputStream out = new FileOutputStream("C:\\Users\\Hairo\\Desktop\\项目相关文件\\objectImport\\a.txt.MD5")){
            out.write(result.getBytes());
            String sourcePath = "C:\\Users\\Hairo\\Desktop\\项目相关文件\\objectImport";
            String newPath = "C:\\Users\\Hairo\\Desktop\\objectImport";
            copyDir(sourcePath,newPath);
            String hex = DigestUtils.md5Hex(new FileInputStream(("C:\\Users\\Hairo\\Desktop\\项目相关文件\\objectImport\\a.txt.MD5")));
            String hex1 = DigestUtils.md5Hex(new FileInputStream(("C:\\Users\\Hairo\\Desktop\\objectImport\\a.txt.MD5")));
            System.out.println(result);
            System.out.println(hex);
            System.out.println(hex1);
        }
    }

    public static String getRandomStr() {
        StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 32; j++) {
                double rand = Math.random();
                double randTri = Math.random() * 3;
                if (randTri >= 0 && randTri < 1) {
                    sb.append((char) (rand * ('9' - '0') + '0'));
                } else if (randTri >= 1 && randTri < 2) {
                    sb.append((char) (rand * ('Z' - 'A') + 'A'));
                } else {
                    sb.append((char) (rand * ('z' - 'a') + 'a'));
                }
            }
        return  sb.toString();
    }

    public static void copyDir(String sourcePath, String newPath) {
        File start = new File(sourcePath);
        File end = new File(newPath);
        String[] filePath = start.list();       //获取该文件夹下的所有文件以及目录的名字
        if(!end.exists()) {
            end.mkdir();
        }
        for(String temp:filePath) {
            //查看其数组中每一个是文件还是文件夹
            if(new File(sourcePath+File.separator+temp).isDirectory()) {
                //为文件夹，进行递归
                copyDir(sourcePath+File.separator+temp, newPath+File.separator+temp);
            }else {
                //为文件则进行拷贝
                copyFile(sourcePath+File.separator+temp, newPath+File.separator+temp);
            }
        }
    }

    public static void copyFile(String sourcePath, String newPath) {
        File start = new File(sourcePath);
        File end = new File(newPath);
        try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream(start));
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(end))) {
            int len = 0;
            byte[] flush = new byte[1024];
            while((len=bis.read(flush)) != -1) {
                bos.write(flush, 0, len);
            }
            bos.flush();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
