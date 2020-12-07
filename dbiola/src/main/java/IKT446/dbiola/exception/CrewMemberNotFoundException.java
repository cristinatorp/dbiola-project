package IKT446.dbiola.exception;

public class CrewMemberNotFoundException extends RuntimeException {
    public CrewMemberNotFoundException(Long id) {
        super("Could not find a crew member with ID = " + id + ".");
    }
}
