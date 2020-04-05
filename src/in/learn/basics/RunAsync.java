package in.learn.basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class RunAsync {

	public static void main(String[] args) {

		/*
		 * If we want to run some background task asynchronously and do not want to
		 * return anything from that task, that is an ideal use-case of
		 * CompletableFuture.runAsync() method. It takes a Runnable object and returns
		 * CompletableFuture<Void>.
		 */

		CompletableFuture<Void> cf = CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(20);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				System.out.println("It will run in separate thread from main thread");
			}
		});

		CompletableFuture<Void> cfLambda = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("It will run in separate thread from main thread");

		});
	}
}
