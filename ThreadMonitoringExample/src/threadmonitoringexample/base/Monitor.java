package threadmonitoringexample.base;

/**
 * Monitor
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class Monitor {
    
    private final String EXCEPTION_FAILURE = "The Monitor failed to filter correctly the requests.";
    
    private Storage storage;
    
    /**
     * Constructor
     * @param storage 
     */
    public Monitor(Storage storage) {
        setStorage(storage);
    }
    
    /**
     * Attempts to add a unit to the storage
     * If it's full, the thread will be paused and unpaused when there's
     * space available
     */
    public synchronized void add() {
        // If the storage is full, pause the thread
        while(getStorage().isFull()) {
            try {
                System.err.println(Language.STORAGE_WAIT_ADD_STR+getStorage().getName());
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        
        // If the storage isn't supposedly full, a unit will be added
        // If the monitor fails, the program will be halted
        try {
            getStorage().add();
            notify();
        } catch(FullStorageException e) {
            System.err.println(EXCEPTION_FAILURE);
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    /**
     * Takes away a unit from the storage
     * If it's empty, the thread will be paused and unpaused when there are
     * more units to take
     */
    public synchronized void take() {
        // If the storage is empty, pause the thread 
        while(getStorage().isEmpty()) {
            try {
                System.err.println(Language.STORAGE_WAIT_TAKE_STR+getStorage().getName());
                wait();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        
        // If the storage isn't supposedly empty, a unit will be taken
        // If the monitor fails, the program will be halted
        try {
            getStorage().take();
            notify();
        } catch(EmptyStorageException e) {
            System.err.println(EXCEPTION_FAILURE);
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Returns the target storage
     * @return 
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Sets a new target storage
     * @param storage 
     */
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    
}
