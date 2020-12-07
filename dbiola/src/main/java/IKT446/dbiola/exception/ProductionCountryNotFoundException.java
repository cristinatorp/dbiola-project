package IKT446.dbiola.exception;

public class ProductionCountryNotFoundException extends RuntimeException {
    public ProductionCountryNotFoundException(String code) {
        super("Could not find a production country with country code = " + code + ".");
    }
}
