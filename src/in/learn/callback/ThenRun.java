package in.learn.callback;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenRun {

	/*
	 * thenRun() method is also used as callback function which does not return
	 * anything but executes the logic written inside this block. thenAccept() and
	 * thenRun()methods are consumers and are often used as the last callback in the
	 * callback chain.
	 * 
	 * While thenAccept() has access to the result of the CompletableFuture on which
	 * it is attached, thenRun() doesn’t even have access to the Future’s result. It
	 * takes a Runnable and returns CompletableFuture<Void>
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		thenRunExample();
	}

	public static void thenRunExample() throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			System.out.println("Some function!");
			return "Hey";
		});

		CompletableFuture<Void> cfRun = cf.thenRun(() -> {
			System.out.println("thenRun callback!");
		});

		cfRun.get();
	}
}
