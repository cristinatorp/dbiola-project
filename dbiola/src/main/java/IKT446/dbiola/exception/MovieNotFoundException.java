package IKT446.dbiola.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Could not find a movie with ID = " + id + ".");
    }
}
