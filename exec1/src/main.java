import java.util.*;

public class main {

    public static void main(String[] args) {
        Car[] cars = {
                new Car("Ford", "Mondeo",
                        1999, 2000, 120, false),
                new Car("Toyota", "Corolla",
                        2006, 1502, 75, true),
                new Car("Opel", "Astra",
                        2003, 1450, 80, false)
        };

        Plane[] planes = {
                new Plane("Supermarine ", "Spitfire",
                        1936, 2297 , false, (float) 11.23),
                new Plane("Hawker", "Hurricane",
                        1935, 2606, false, (float)12.19),
                new Plane("Messerschmitt", "Bf 108",
                        1937, 2247, true, (float)9.92)
        };

        for (int i=0;i<1000;i++) {
            Random num = new Random();
            if (num.nextBoolean()) {
                cars[i%3].drive();
                planes[i%3].fly();
            }
            if (num.nextBoolean()) {
                cars[i%3].stop();
                planes[i%3].land();
            }
            if (cars[i%3].needsMaintenance) {
                System.out.println(cars[i%3].toString());
                cars[i%3].repair();
            }
        }
    }
}
