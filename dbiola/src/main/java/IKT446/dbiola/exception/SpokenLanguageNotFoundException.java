package IKT446.dbiola.exception;

public class SpokenLanguageNotFoundException extends RuntimeException {
    public SpokenLanguageNotFoundException(String code) {
        super("Could not find a spoken language with language code = " + code + ".");
    }
}
