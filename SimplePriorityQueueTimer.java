package assign03;

import java.util.Random;

public class SimplePriorityQueueTimer {
	
	public static void main(String[] args) {
	    // Do 10000 lookups and use the average running time.
	    int timesToLoop = 10000;
	    Random rand = new Random();
	    
	    // For each problem size n . . .
	    for (int n = 100000; n <= 2000000; n += 100000) {
	    	
	    	long startTime, midpointTime, stopTime;

	    	startTime = System.nanoTime();
	    	System.out.println(startTime);

	    	SimplePriorityQueue<Integer> queueRand = new SimplePriorityQueue<Integer>();

	    	for (int i = 0; i < n; i++) {
	    		int randomInt = rand.nextInt(1000);
	    		queueRand.insert(randomInt);
	    	}
	    	
	    	// Now, run the test.  
	    	midpointTime = System.nanoTime();

	    	for (int i = 0; i < timesToLoop; i++) {
	    		queueRand.findMin();
	    	}

	    	stopTime = System.nanoTime();

	    	double averageTime = ((stopTime - startTime)
	    			/ (double) timesToLoop);

	    	System.out.println(n + "\t" + averageTime);
	  }
	}
}
