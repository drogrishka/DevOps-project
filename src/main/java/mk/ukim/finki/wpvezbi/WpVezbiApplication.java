package mk.ukim.finki.wpvezbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WpVezbiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WpVezbiApplication.class, args);
    }

}
