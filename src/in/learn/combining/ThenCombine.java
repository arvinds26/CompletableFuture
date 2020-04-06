package in.learn.combining;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenCombine {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		/*
		 * While thenCompose() is used to combine two CompletableFutures where one
		 * future is dependent on the other, thenCombine() is used when we want two
		 * Futures to run independently and do something after both are complete. The
		 * callback function passed to thenCombine() will be called when both the
		 * CompletableFutures are complete.
		 */

		CompletableFuture<String> oneCf = CompletableFuture.supplyAsync(() -> {
			return "String one";
		});

		CompletableFuture<String> twoCf = CompletableFuture.supplyAsync(() -> {
			return "String two";
		});

		// o and t are results of oneCf and twoCf

		CompletableFuture<String> result = oneCf.thenCombine(twoCf, (o, t) -> {
			return o.replace("String", "Hello,") + "!" + t.replace("String", " combined with ");
		});

		System.out.println(result.get());
	}

}
