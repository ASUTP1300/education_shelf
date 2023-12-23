package inherient_;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Пример порядка вызова элементов класса при создании объекта
 *
 * 1. Статический блок класса родителя;
 * 2. Статические поля класса родителя;
 * 3. Статический блок класса наследника;
 * 4. Статические поля класса наследника;
 * 5. Не статический блок класса родителя;
 * 6. Не статические поля класс родителя;
 * 7. Конструктор класса родителя;
 * 8. Не статический блок класса наследника;
 * 9. Не статические поля класса наследника;
 * 10. Конструктор класса наследника;
 */
public class Human {


    private static Function<String, String> func = str ->
    {
        System.out.println(str);
        return str;
    };

    public static void main(String[] args) {
//        new Human(). new Man();
        new Human().new Men();
    }

    class Man {

        static {
            System.out.println("1. Статический блок класса родителя");
        }
        {
            System.out.println("5. Не статический блок класса родителя");
        }
        private static String surname = func.apply("2. Статические поля класса родителя");

        private String name = func.apply("6. Не статические поля класс родителя");

        public Man() {
            System.out.println("7. Конструктор класса родителя");
        }

        String getName() {
            return name;
        }
    }

    class Men extends Man {

        static {
            System.out.println("3. Статический блок класса наследника");
        }
        {
            System.out.println("8. Не статический блок класса наследника");
        }
        private static String surname = func.apply("4. Статические поля класса наследника");
        private String name = func.apply("9. Не статические поля класса наследника");

        public Men() {
            System.out.println("10. Конструктор класса наследника");
        }

        String getName() {
            return name;
        }
    }
}