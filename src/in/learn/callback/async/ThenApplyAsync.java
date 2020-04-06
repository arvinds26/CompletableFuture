package in.learn.callback.async;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplyAsync {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		/*
		 * Asynchronous Callback:
		 * 
		 * The task inside thenApply() is executed in the same thread where the
		 * supplyAsync() task is executed, or in the main thread if the supplyAsync()
		 * task completes immediately. If we want to increase the parallelism of our
		 * program furthermore and want to run the callback task on a separate thread —
		 * asynchronous callbacks are the solution.
		 * 
		 * We can use thenApplyAsync() callback in place of thenApply(), then this task
		 * will be executed in a different thread obtained from
		 * ForkJoinPool.commonPool().
		 * 
		 * We could also pass an Executor to the thenApplyAsync() callback, then the
		 * task will be executed in a thread obtained from the Executor’s thread pool.
		 */

		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();

		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			return user;
		}).thenApplyAsync(userName -> {
			return "Hey " + userName;
		}).thenApplyAsync(someString -> {
			return someString + ". You are learning callback-thenApplyAsync";
		});

		System.out.println(cf.get());
	}
}
