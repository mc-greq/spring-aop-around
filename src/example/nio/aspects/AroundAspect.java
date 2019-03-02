package example.nio.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
//@Component
public class AroundAspect {

    @Around("execution(* example.nio.service.TrafficFortuneService.getFortune())")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out the method we are advising on
        String method = proceedingJoinPoint.getSignature().toString();
        System.out.println("==> Executing around advice on method: " + method);

        // get current timestamp
        long begin = System.currentTimeMillis();

        // proceed to executing the method
        Object result = proceedingJoinPoint.proceed();
//        proceedingJoinPoint.proceed();

        // get the end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n==> Duration: " + duration / 1000 + " seconds");

        return result;
    }

    @Around("execution(* example.nio.service.TrafficFortuneService.getFortune(boolean))")
    public Object aroundGetFortuneBool(ProceedingJoinPoint proceedingJoinPoint){

        // print out the method we are advising on
        String method = proceedingJoinPoint.getSignature().toString();
        System.out.println("==> Executing around advice on  throwing method: " + method);

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }catch (Throwable e){
            System.out.println("==> " + e.getMessage());
            result = "Major accident but we handled it and everything is fine!";
        }

        return result;
    }

    @Around("execution(* example.nio.service.TrafficFortuneService.addNumbers(..))")
    public void aroundAddNumbers(ProceedingJoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs();

        int returnArgument = 0;

        for(Object argument: args){
            if(argument instanceof Integer){
                returnArgument = ((Integer) argument) + 10;
            }
        }

        joinPoint.proceed(new Object[]{returnArgument});
    }
}
