package IKT446.dbiola.exception;

public class ProductionCompanyNotFoundException extends RuntimeException {
    public ProductionCompanyNotFoundException(Long id) {
        super("Could not find a production company with ID = " + id + ".");
    }
}
