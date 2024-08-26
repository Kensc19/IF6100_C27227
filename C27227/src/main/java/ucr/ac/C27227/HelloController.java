package ucr.ac.C27227;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.C27227.handlers.RegisterUserHandler;


@RestController //Se usa para interactuar con una api
public class HelloController {

   @Autowired //Inyecta dependencias
   private RegisterUserHandler handler;

    @GetMapping("/hello")
    public String hello(){

        var result = handler.registerUser(
        new RegisterUserHandler.Command(
                "Kendall",
                "ejemplo@gmail.com",
                "12345")
        );

        return switch (result){
            case RegisterUserHandler.Result.Success  success ->
                    success.message();
            case RegisterUserHandler.Result.InvalidData  invalidadData ->
                    "Invalid data: " + String.join(", ", invalidadData.fields());
        };
    }
}
