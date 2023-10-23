package JavaDemo;

import java.util.Collections;

public class SunDemo {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("....");
        Collections.sort();
        int max=1000000,min=1;
        int ran2 = (int) (Math.random()*(max-min)+min);
        System.out.println(ran2);
    //   System.out.println(Demo(10));
        int i = 10;
        si(i);
        System.out.println("\\\\\\" + i);
    }

    private static void si(int i) {
        i = 6;
        System.out.println("...." + i);
    }

    //TODO 解题思路：
    //首先确认是两位数字交换那么就一定为大于等于10的数
    //同时要求仅限一次并且只能比原数据大，小于其他任一转换数据，那么可以确定排除随机数，只能是尾部数据的调换
    //那么比原数据大，就首先要排除向上转位数是0，然后拿到最后一位非零数值，如果它是最后一位则和前一位对调，如果不是最后一位则和最后一位对调
    private static int Demo(int number){
        int raw = number;
        if (number < 10){
            return raw;
        }
        char[] chars = (number + "").toCharArray();
        char ones = 0;
        for (int i= chars.length - 1;i >= 0;i--){
            if (Integer.parseInt(String.valueOf(chars[i])) > 0){
                if(ones == 0){
                    ones = chars[i];
                    if(i == chars.length - 1){
                        chars[i] = chars[i-1];
                        chars[i-1] = ones;
                    }else{
                        chars[i] = chars[chars.length - 1];
                        chars[chars.length - 1] = ones;
                    }
                }
            }
        }
        return Integer.parseInt(new String(chars)) > raw ? Integer.parseInt(new String(chars)) :raw;
    }



}
