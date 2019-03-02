package example.nio;

import example.nio.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoRun {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAll.class);

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);


        System.out.println("\nMain Program:");
        System.out.println("Calling getFortune()");
        System.out.println("My fortune is: " + trafficFortuneService.getFortune());

        trafficFortuneService.addNumbers(10);

        System.out.println("Calling getFortune() and throwing an exception");
        System.out.println(trafficFortuneService.getFortune(true));

        System.out.println("Done!");

        context.close();
    }
}
