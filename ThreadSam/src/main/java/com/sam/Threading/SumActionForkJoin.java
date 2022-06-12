package com.sam.Threading;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class SumActionForkJoin extends RecursiveAction {
	
	 private List<Long> data;
	  private static final int SEQUENTIAL_THRESHOLD = 5;

	  public SumActionForkJoin(List<Long> data) {
	    this.data = data;
	  }
	    
	@Override
	  protected void compute() {
	    if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case
	      long sum = computeSumDirectly();
	      System.out.format("Sum of %s: %d\n", data.toString(), sum);
	    } else { // recursive case
	      // Calcuate new range
	      int mid = data.size() / 2;
	      SumActionForkJoin firstSubtask =
	          new SumActionForkJoin(data.subList(0, mid));
	      SumActionForkJoin secondSubtask =
	          new SumActionForkJoin(data.subList(mid, data.size()));

	      firstSubtask.fork(); // queue the first task
	      secondSubtask.compute(); // compute the second task
	   //   firstSubtask.join(); // wait for the first task result

	      // Or simply call
	      //invokeAll(firstSubtask, secondSubtask);
	      
	      
	      
	      // Or simply call
	   //   invokeAll(firstSubtask, secondSubtask);
	    }
	  }
	
	private long computeSumDirectly() {
	    long sum = 0;
	    for (long l: data) {
	      sum += l;
	    }
	    return sum;
	  }
	
	 public static void main(String[] args) {
		    Random random = new Random();

		    List<Long> data = random
		        .longs(12, 1, 5)
		        .boxed()
		        .collect(Collectors.toList());

		    ForkJoinPool pool = new ForkJoinPool();
		    SumActionForkJoin task = new SumActionForkJoin(data);
		    pool.invoke(task);
		  }
	
	

}
