package threadmonitoringexample.base;

/**
 * Producer
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class Producer extends Component implements Runnable {

    /**
     * Empty constructor
     */
    public Producer() {
        
    }
    
    /**
     * Basic constructor. Sets only the target monitor.
     * @param target 
     */
    public Producer(Monitor target) {
        super(target);
    }
    
    /**
     * Complete constructor
     * @param target
     * @param repetitions 
     */
    public Producer(Monitor target, int repetitions) {
        super(target, repetitions);
    }
    
    /**
     * Adds a unit to the target's storage
     */
    public synchronized void add() {
        getTarget().add();
    }

    @Override
    public void run() {
        for (int i=0; i<getRepetitions(); i++) {
           add(); 
        }
    }
    
}
