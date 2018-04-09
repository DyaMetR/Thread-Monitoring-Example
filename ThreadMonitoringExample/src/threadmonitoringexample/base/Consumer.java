package threadmonitoringexample.base;

/**
 * Consumer
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 * Attempts to consume from the target's storage
 */
public class Consumer extends Component implements Runnable {

    /**
     * Empty constructor
     */
    public Consumer() {
        
    }
    
    /**
     * Basic constructor. Sets only the target monitor.
     * @param target 
     */
    public Consumer(Monitor target) {
        super(target);
    }
    
    /**
     * Complete constructor
     * @param target
     * @param repetitions 
     */
    public Consumer(Monitor target, int repetitions) {
        super(target, repetitions);
    }
    
    /**
     * Takes a unit away from the target's storage
     */
    public synchronized void take() {
        getTarget().take();
    }

    @Override
    public void run() {
        for (int i=0; i<getRepetitions(); i++) {
           take(); 
        }
    }
    
}
