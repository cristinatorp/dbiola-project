package IKT446.dbiola.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String jobTitle, String department) {
        super("Could not find a job with title = " + jobTitle + " in department" + department + ".");
    }
}
