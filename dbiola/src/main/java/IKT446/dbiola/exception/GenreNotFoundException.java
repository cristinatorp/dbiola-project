package IKT446.dbiola.exception;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(Long id) {
        super("Could not find a genre with ID = " + id + ".");
    }
}
