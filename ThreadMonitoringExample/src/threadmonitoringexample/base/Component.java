package threadmonitoringexample.base;

/**
 * Component
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 * Component base of a Producer-Consumer situation
 */
public abstract class Component {
    
    private Monitor target;
    private int repetitions;
    
    /**
     * Empty constructor
     */
    public Component() {
        
    }
    
    /**
     * Basic constructor. Sets only the target monitor.
     * @param target 
     */
    public Component(Monitor target) {
        setTarget(target);
    }
    
    /**
     * Complete constructor
     * @param target
     * @param repetitions 
     */
    public Component(Monitor target, int repetitions) {
        setTarget(target);
        setRepetitions(repetitions);
    }
    
    /**
     * Returns the target monitor of the operations
     * @return 
     */
    protected Monitor getTarget() {
        return target;
    }

    /**
     * Sets a new monitor as the target of operations
     * @param target 
     */
    protected void setTarget(Monitor target) {
        this.target = target;
    }

    /**
     * Returns the number of repetitions done
     * @return 
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * Sets a new number of repetitions
     * @param repetitions 
     */
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    
}
