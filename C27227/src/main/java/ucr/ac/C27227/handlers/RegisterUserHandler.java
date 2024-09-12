package ucr.ac.C27227.handlers;

public interface RegisterUserHandler {
    record Command(String name, String email, String password){}

    sealed  interface Result {
         record Success(String message) implements Result{}
         record InvalidData (String ... fields) implements  Result{}
        record EmailAlreadyExists(String email) implements Result{}
    }
    Result registerUser(Command command);
}
