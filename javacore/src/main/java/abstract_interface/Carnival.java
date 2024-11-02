package main.java.abstract_interface;



/**
 * Отличие абстрактного класса от интерфейса
 *
 * Абстрактный класс                        | Интерфейс
 * -----------------------------------------|-----------
 * 1. Имеет конструктор                     |Не имеет
 * 2. Поля могут быть приватные             |все поля FINAL PUBLIC
 * 3. Переопределяет Object's методы        |Нет
 * 4. Может иметь статические/нестатические |блоки
 */

public class Carnival extends abstract_interface.Auto implements abstract_interface.Car {
    @Override
    public void checkEngine() {
        super.checkEngine();
    }


    public static void main(String[] args) {
        Carnival carnival = new Carnival();
        carnival.checkEngine();
    }

}
