package com.shuttle.sensitive;

public class FilterApplication {
    public static void main(String[] args) {
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter();
        String text = "赌博#学习@@打架!!!看书___抽大烟^运动";
        System.out.println(sensitiveWordFilter.filter(text));
    }
}
