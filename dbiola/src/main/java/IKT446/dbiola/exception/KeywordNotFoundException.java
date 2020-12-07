package IKT446.dbiola.exception;

public class KeywordNotFoundException extends RuntimeException {
    public KeywordNotFoundException(Long id) {
        super("Could not find a keyword with ID = " + id + ".");
    }
}
