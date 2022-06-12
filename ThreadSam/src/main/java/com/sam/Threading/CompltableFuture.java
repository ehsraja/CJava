package com.sam.Threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompltableFuture {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		
		completableFuture.complete("Future's Result");
		String result = completableFuture.get();
		System.out.println(result);
		
	}

}
