package com.java.project;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        AstonList<String> test = new AstonList<>(5);
        List<String> test1 = new ArrayList<>();
        test1.add("15");
        test1.add("16");
        test.add("10");
        test.add("25");
        test.add("36");
        test.remove(2);
        test.addAll(test1);
        test.bubbleSort();
        System.out.println(test);
        System.out.println(test.get(1));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        AstonList<Integer> test2 = new AstonList<>(list);
        AstonService.sort(test2);
        System.out.println(test2);

    }

}
