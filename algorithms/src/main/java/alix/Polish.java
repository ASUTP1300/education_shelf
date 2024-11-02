package src.main.java.alix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polish {

    public static void main(String[] args) {
       String[] test1 = {"1", "2", "+", "21", "-", "21", "*"};
       String[] test2 = {"3", "4", "7", "+", "-"};



        System.out.println("test1: " + calculate(test1));
        System.out.println("test2: " + calculate(test2));

    }

    //[1, 2, +, 12, -, 21, *]
    //[3, 12, 21, -, 21, *]

  public static int calculate(String[] tokens) {
      List<Integer> res = new ArrayList<>();

      List<String> signs = Arrays.asList("+", "*", "/", "-");


      for (int i = 0; i < tokens.length; i++) {
          if (signs.contains(tokens[i])) {
              res.add(operate(tokens[i], res.remove(res.size() - 2), res.remove(res.size() - 1)));
          } else {
              res.add(Integer.parseInt(tokens[i]));
          }
      }
      return res.get(0);

  }

 static int operate(String sign, int a, int b) {
        switch (sign) {
            case "+" -> { return a + b; }
            case "-" -> { return a - b; }
            case "*" -> { return a * b; }
            case "/" -> { return a / b; }
        }
        throw new RuntimeException("Undefined sign!");
  }
}
