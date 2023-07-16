package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Stream.of(1, 2, 3).mapToInt(Integer::intValue).max().getAsInt();
        List<String> list = Arrays.asList();
    }
}