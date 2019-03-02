package example.nio.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class AroundAspect {

    @Around("execution(* example.nio.service.TrafficFortuneService.getFortune(..))")
    public void aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out the method we are advising on
        String method = proceedingJoinPoint.getSignature().toString();
        System.out.println("==> Executing around advice on method: " + method);

        // get current timestamp
        long begin = System.currentTimeMillis();

        // proceed to executing the method
//        Object result = proceedingJoinPoint.proceed();
        proceedingJoinPoint.proceed();

        // get the end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n==> Duration: " + duration / 1000 + " seconds");

//        return result;
    }


}
