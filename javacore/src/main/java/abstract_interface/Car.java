package abstract_interface;

public interface Car {

    Integer VIN = 1;
    default void checkEngine(){
        System.out.println("Ррррр Мочевина");
    }
}
