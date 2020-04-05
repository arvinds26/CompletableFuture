package in.learn.basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class WithExecutor {

	/*
	 * Now, we know that the runAsync() and supplyAsync() methods execute their
	 * tasks in a separate thread which was never explicitly created by us.
	 * 
	 * CompletableFuture executes these tasks in a thread obtained from the global
	 * ForkJoinPool.commonPool().
	 * 
	 * But we can also create a Thread Pool and pass it to runAsync() and
	 * supplyAsync() methods to let them execute their tasks in a thread obtained
	 * from our thread pool.
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(5);
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
		}, executor);
		System.out.println(cf.get());
	}
}
