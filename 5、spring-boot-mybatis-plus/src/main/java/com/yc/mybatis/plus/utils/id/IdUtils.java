package com.yc.mybatis.plus.utils.id;

/**
 *
 * id 生成工具类
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 21:22 2023/9/30
 */
public class IdUtils {

    private static SnowflakeIdWorker snowflakeIdWorker;


    static {
        snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
    }

   public static Long getId() {
        return snowflakeIdWorker.nextId();
    }


    public static void main(String[] args) {
        System.out.println(getId());
        int a = 5;
        int b = 10;
        int c = 100;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(a | c ));
    }
}
