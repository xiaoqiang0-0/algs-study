package com.xiaoqiang.algs.lc;

import java.util.*;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class LC12 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new LC12().intToRoman(i));

        }


    }

    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(rom[i]);
                num-=values[i];
            }
        }

        return sb.toString();
    }

    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman1(int num) {
        return thousands[num / 1000] +
                hundreds[num % 1000 / 100] +
                tens[num % 100 / 10] +
                ones[num % 10];
    }

}
