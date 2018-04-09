package threadmonitoringexample.caseOfUse;

import threadmonitoringexample.base.Monitor;
import threadmonitoringexample.base.Storage;

/**
 * Warehouse
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class Warehouse {

    private final int DEFAULT_STORAGE_CAPACITY = 100;
    private Storage storage;
    private Monitor monitor;

    /**
     * Basic constructor. Generates a storage with the default capacity.
     */
    public Warehouse() {
        setStorage(new Storage(DEFAULT_STORAGE_CAPACITY));
        setMonitor(new Monitor(getStorage()));
    }
    
    /**
     * Basic constructor. Generates a storage with the capacity only.
     * @param capacity 
     */
    public Warehouse(int capacity) {
        setStorage(new Storage(capacity));
        setMonitor(new Monitor(getStorage()));
    }
    
    /**
     * Basic constructor. Generates a storage with the name only. 
     * @param name 
     */
    public Warehouse(String name) {
        setStorage(new Storage(name, DEFAULT_STORAGE_CAPACITY));
        setMonitor(new Monitor(getStorage()));
    }
    
    /**
     * Complete constructor.
     * @param name
     * @param maxCount 
     */
    public Warehouse(String name, int maxCount) {
        setStorage(new Storage(name, maxCount));
        setMonitor(new Monitor(getStorage()));
    }
    
    /**
     * Complete constructor.
     * @param storage 
     */
    public Warehouse(Storage storage) {
        setStorage(storage);
        setMonitor(new Monitor(storage));
    }
    
    /**
     * Returns the storage
     * @return 
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Sets a new storage
     * @param storage 
     */
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Returns the monitor
     * @return 
     */
    public Monitor getMonitor() {
        return this.monitor;
    }
    
    /**
     * Sets a new monitor
     * @param monitor 
     */
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    
}
