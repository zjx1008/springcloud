package com.atguigu.springcloud.config;

/**
 * @author zjx
 * @create 2020-05-07-13:00
 */
public class test {
static String  test="";
    public static void main(String[] args) {

        a(1,true);
        a();
        a(1L);
        a(1);
        a(Double.valueOf(1));
        System.out.println(test);
    }
    static void a (Object o){
        test+="1";
    }
    static void a (Object... o){
        test+="2";
    }
    static void a (StackOverflowError... i){

        test+="3";
    }
    static void a (Long o){
        test+="4";
    }
    static void a (double o){
        test+="6";
    }
}
