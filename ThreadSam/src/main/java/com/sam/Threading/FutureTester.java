package com.sam.Threading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class FutureTester {
	
	public static void main(String[] args) throws InterruptedException {
	    // TODO Auto-generated method stub
	    int poolCnt =10;
	    Callable<NumberPrinter> numberPrinter = null;
	    ScheduledThreadPoolExecutor schPool = new ScheduledThreadPoolExecutor(
	            poolCnt);
	    ScheduledFuture<NumberPrinter>[] numPrinterFutures = new ScheduledFuture[poolCnt];
	    FutureTask<NumberPrinter>[] futureTask = new FutureTask[poolCnt];

	    for (int i = 0; i < poolCnt; i++) {
	        numberPrinter = new NumberPrinter();
	        futureTask[i] = new FutureTask<NumberPrinter>(numberPrinter);

	        /*
	         * numPrinterFutures[i] = (ScheduledFuture<NumberPrinter>) schPool
	         * .schedule(futureTask[i], 0, TimeUnit.MILLISECONDS);
	         */
	        numPrinterFutures[i] = (ScheduledFuture<NumberPrinter>) schPool
	                .submit(futureTask[i]);
	    }

	    //Thread.sleep(30);

	    if (numPrinterFutures.length > 0) {

	        System.out.println("Task completed ? "
	                + numPrinterFutures[0].isDone());

	        System.out.println("Task cancelled ? "
	                + numPrinterFutures[0].cancel(true));

	        System.out.println("Is task cancelled ? "
	                + numPrinterFutures[0].isCancelled());
	    }
	}

	}

	class NumberPrinter implements Callable<NumberPrinter> {

	private int counter = 10;

	@Override
	public NumberPrinter call() throws Exception {
	    // TODO Auto-generated method stub

	    while (counter > 0) {
	        if (Thread.interrupted()) {/*OUCH !!!*/
	            return null;
	        }
	        System.out.println("counter = " + (counter--));
	    }

	    return this;
	}

	}


