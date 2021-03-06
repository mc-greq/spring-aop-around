package example.nio;

import example.nio.aspects.AroundAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Config {

    @Bean
    public AroundAspect geAroundAspect(){
        return new AroundAspect();
    }
}
