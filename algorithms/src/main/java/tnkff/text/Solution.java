package tnkff.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            String text = reader.readLine();
            LinkedList<Integer> res = new LinkedList<>();

            Arrays.stream(text.split("#+")).map(String::length).sorted().forEach(res::add);

            System.out.println(res.peekFirst());
            System.out.println(res.peekLast());
        }
    }

}