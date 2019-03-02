package example.nio;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Config.class, MyLoggerConfig.class})
public class ConfigAll {
}
