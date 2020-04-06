package in.learn.combining;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenCompose {
	
	/*
	 * Combining CompletableFutures together :
	 * 
	 * Combine dependent completableFutures using thenCompose():
	 * 
	 * In earlier examples, the Supplier function passed to thenApply() callback
	 * would return a value. What if our use-case is to return a CompletableFuture
	 * instead. That is the primary use-case of thenCompose() method.
	 * 
	 * If our callback function returns a CompletableFuture, and we want a flattened
	 * result from the CompletableFuture chain, we need to use thenCompose().
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> result = getStringOne().thenCompose(s -> getStringTwo(s));
		System.out.println(result.get());
	}
	
	
	static CompletableFuture<String> getStringOne(){
		return CompletableFuture.supplyAsync(()-> {
			return "String one";
		});
	}
	
	static CompletableFuture<String> getStringTwo(String stringone){
		return CompletableFuture.supplyAsync(()-> {
			return stringone + " String two";
		});
	}
	
}
