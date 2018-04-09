package threadmonitoringexample.base;

/**
 * Storage
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class Storage {
    
    private final int DEFAULT_COUNT = 0;
    
    private String name;
    private int maxCount;
    private int count;
    
    /**
     * Basic constructor
     */
    public Storage() {
        setCount(DEFAULT_COUNT);
    }
    
    /**
     * Basic constructor. Sets the name only.
     * @param name 
     */
    public Storage(String name) {
        setCount(DEFAULT_COUNT);
        setName(name);
    }
    
    /**
     * Basic constructor. Sets the maximum unit limit only.
     * @param maxCount 
     */
    public Storage(int maxCount) {
        setCount(DEFAULT_COUNT);
        setMaxCount(maxCount);
    }
    
    /**
     * Complete constructor
     * @param name
     * @param maxCount 
     */
    public Storage(String name, int maxCount) {
        setCount(DEFAULT_COUNT);
        setName(name);
        setMaxCount(maxCount);
    }
    
    /**
     * Attempts to take a unit
     * @throws EmptyStorageException 
     */
    public void take() throws EmptyStorageException {
        if (getCount() - 1 < 0) {
            throw new EmptyStorageException();
        } else {
            setCount(getCount() - 1);
            System.out.println(Language.STORAGE_TAKE_STR+getName()+" ("+getCount()+"/"+getMaxCount()+")");
        }
    }
    
    /**
     * Attempts to add a unit
     * @throws FullStorageException 
     */
    public void add() throws FullStorageException {
        if (getCount() + 1 > getMaxCount()) {
            throw new FullStorageException();
        } else {
            setCount(getCount() + 1);
            System.out.println(Language.STORAGE_ADD_STR+getName()+" ("+getCount()+"/"+getMaxCount()+")");
        }
    }
    
    /**
     * Returns whether the storage is full
     * @return 
     */
    public boolean isFull() {
        return getCount() >= getMaxCount();
    }
    
    /**
     * Returns whether the storage is empty
     * @return 
     */
    public boolean isEmpty() {
        return getCount() <= 0;
    }

    /**
     * Returns the name of the storage
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new storage name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Returns the current unit count
     * @return 
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets a new unit count
     * @param count 
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Returns the maximum unit limit
     * @return 
     */
    public int getMaxCount() {
        return maxCount;
    }

    /**
     * Sets a new maximum unit limit
     * @param maxCount 
     */
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    
}
