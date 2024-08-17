package ucr.ac.C27227;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Se usa para interactuar con una api
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello, world";
    }
}
