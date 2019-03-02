package example.nio.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Heavy traffic and rain expected";
    }

    public void addNumbers(int number){
        System.out.println("Number to be added: " + number);
        System.out.println("Adding 10 to the number:  10 + " + number + " = " + (number + 10));
    }
}
