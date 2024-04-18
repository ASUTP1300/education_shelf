package enum_;

import java.util.Arrays;

class Enums {
    public static void main(String[] args) {
        String sochi = "Сочи";

        Arrays.stream(City.values()).filter(c -> c.name().equals(sochi)).findFirst().get();
    }
}





enum City {
    MOSCOW("Москва"),
    SOCHI("Сочи");
    City(String cityName) {
    }


}