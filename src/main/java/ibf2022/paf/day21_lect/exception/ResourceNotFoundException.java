package ibf2022.paf.day21_lect.exception;

// Exception only happens during runtime (thus RTE)
public class ResourceNotFoundException extends RuntimeException {
    
    //these are constructors LOL
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
