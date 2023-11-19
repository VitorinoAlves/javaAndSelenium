package utils;

import java.util.Random;

public class DataGenerator {
    public String emailGenarator(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username"+ randomInt +"@gmail.com";
    }

    public double getValue(String value){
        // Remove non-numeric characters except the dot
        String numericString = value.replaceAll("[^\\d.]", "");

        // Convert the extracted string to a double
        return Double.parseDouble(numericString);
    }
}
