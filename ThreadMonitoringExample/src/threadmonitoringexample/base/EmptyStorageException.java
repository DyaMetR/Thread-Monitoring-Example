package threadmonitoringexample.base;

/**
 * EmptyStorageException
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class EmptyStorageException extends Exception {

    private final String DEFAULT_MESSAGE = "Attempted to take items from an empty Storage.";
    
    @Override
    public String toString() {
        return DEFAULT_MESSAGE;
    }
    
}
