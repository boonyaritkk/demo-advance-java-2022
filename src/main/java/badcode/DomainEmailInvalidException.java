package badcode;

public class DomainEmailInvalidException extends RuntimeException {
    public DomainEmailInvalidException(String message) {
        super(message);
    }
}
