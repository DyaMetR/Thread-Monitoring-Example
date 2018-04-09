package threadmonitoringexample;

import threadmonitoringexample.base.*;
import threadmonitoringexample.caseOfUse.Warehouse;

/**
 * This program attempts to solve the following problem:
 * 
 * There's a line of production of refined items from raw materials.
 * First, the raw materials are brought to the first warehouse, where these
 * are stored.
 * 
 * Then, the raw materials are brought to the main production line, where
 * a product is refined.
 * 
 * Last but not least, the refined products are taken away for selling.
 */

/**
 * ThreadMonitoringExample
 * @author Alberto Blanco Celdrán
 * @version 1.0
 * @since 15-feb-2018
 */
public class ThreadMonitoringExample {

    private static final int DEFAULT_REPS = 50; // Default material movement per thread
    private static final String RAWMATERIAL_WAREHOUSE_NAME = "Raw materials warehouse";
    private static final String PRODUCTION_WAREHOUSE_NAME = "Refined product warehouse";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Warehouses initialization
        Warehouse rawMaterials = new Warehouse(RAWMATERIAL_WAREHOUSE_NAME);
        Warehouse production = new Warehouse(PRODUCTION_WAREHOUSE_NAME);
        
        // Raw material warehouse procedures
        // Each warehouse has a monitor attached to the storage to control material flow
        Producer rawMaterialInput = new Producer(rawMaterials.getMonitor(), DEFAULT_REPS);
        Consumer rawMaterialsTransport = new Consumer(rawMaterials.getMonitor(), DEFAULT_REPS);
        
        // Move raw materials from the first warehouse, bring them to the second, and process them
        Producer productionProcessor = new Producer(production.getMonitor(), DEFAULT_REPS);
        Consumer productionTake = new Consumer(production.getMonitor(), DEFAULT_REPS);
        
        // Initialize the threads and run
        new Thread(rawMaterialInput).start();
        new Thread(rawMaterialsTransport).start();
        new Thread(productionProcessor).start();
        new Thread(productionTake).start();
    }

}
