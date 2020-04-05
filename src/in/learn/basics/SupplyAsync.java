package in.learn.basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsync {

	/*
	 * On contrary to the above use-case, if we want to run some background task
	 * asynchronously and want to return anything from that task, we should use
	 * CompletableFuture.supplyAsync(). It takes a Supplier<T> and returns
	 * CompletableFuture<T> where T is the type of the value obtained by calling the
	 * given supplier.
	 * 
	 * A Supplier<T> is a simple functional interface which represents a supplier of
	 * results. It has a single get() method where we can write our background task
	 * and return the result.
	 */
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}

				String s1 = "String 1";
				return s1 + " String 2";
			}
		});
		System.out.println(cf.get());
	}

}
