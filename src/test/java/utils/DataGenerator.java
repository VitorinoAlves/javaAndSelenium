package utils;

import java.util.Random;

public class DataGenerator {
    public String emailGenarator(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username"+ randomInt +"@gmail.com";
    }
}
