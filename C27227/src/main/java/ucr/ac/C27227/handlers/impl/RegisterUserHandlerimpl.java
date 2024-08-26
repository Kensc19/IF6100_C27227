package ucr.ac.C27227.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.ac.C27227.handlers.RegisterUserHandler;
import ucr.ac.C27227.jpa.entities.UserEntity;
import ucr.ac.C27227.jpa.repositories.UserRepository;

import java.util.UUID;

@Component
public class RegisterUserHandlerimpl implements RegisterUserHandler {

    @Autowired
    private UserRepository repository;

    @Override
    public Result registerUser(Command command) {
        var user = new UserEntity();
        user.setId(UUID.randomUUID());
        user.setName(command.name());
        user.setEmail(command.email());
        repository.save(user);
        return new Result.Success("Ok");
    }
}
