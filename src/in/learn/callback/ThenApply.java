package in.learn.callback;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApply {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		/*
		 * Callbacks are the provision for transforming and acting on the result of a
		 * CompletableFuture. For building asynchronous systems, we should be able to
		 * attach a callback to the CompletableFuture which should automatically get
		 * triggered and executed when the Future completes its task.
		 * 
		 * That way, we won’t need to wait for the result of the future(non-blocking),
		 * and we can write the logic that needs to be executed after the completion of
		 * the Future inside our callback function.
		 * 
		 * We can attach a callback to the CompletableFuture using thenApply(),
		 * thenAccept() and thenRun() methods.
		 */

		/*
		 * We can use thenApply() method to process and transform the result of a
		 * CompletableFuture when it arrives. It takes a Function<T,R> as an argument.
		 * Function<T,R> is a simple functional interface representing a function that
		 * accepts an argument of type T and produces a result of type R.
		 * 
		 * We can also write a sequence of transformations on the CompletableFuture by
		 * attaching a series of thenApply() callback methods. The result of one
		 * thenApply() method is passed to the next in the series.
		 */

		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();

		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
			return user;
		}).thenApply(userName -> {
			return "Hey " + userName;
		}).thenApply(someString -> {
			return someString + ". You are learning callback-thenApply";
		});

		System.out.println(cf.get());
	}
}
