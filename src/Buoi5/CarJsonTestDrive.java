package Buoi5;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CarJsonTestDrive {
    public static void main(String[] args) {
        Car car = new Car("100", 2022, "XXXX");

        Car car2 = new Car("101",
                2025, "XXYY");

        Car car3 = new Car("102",
                2027, "zzzzzzz");
                

        List<Car> list = new ArrayList<>();
        list.add(car);
        list.add(car2);
        list.add(car3);

        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("cars.json")){
            //code
            gson.toJson(list, writer);

        }catch(Exception e){ e.printStackTrace();}

    }

}
