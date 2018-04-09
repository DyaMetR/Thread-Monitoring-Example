package threadmonitoringexample.base;

/**
 * FullStorageException
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class FullStorageException extends Exception {
    
    private final String DEFAULT_MESSAGE = "Attempted to put items on a full Storage.";
    
    @Override
    public String toString() {
        return DEFAULT_MESSAGE;
    }
    
}
