package IKT446.dbiola.exception;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(Long id) {
        super("Could not find an actor with ID = " + id + ".");
    }
}
