
package in.learn.callback;

import java.util.concurrent.CompletableFuture;

public class ThenAccept {

	/*
	 * If you do not want to return anything from the callback function and just
	 * want to run some piece of code after the completion of the CompletableFuture,
	 * then we can use thenAccept() method.
	 * 
	 * CompletableFuture.thenAccept() takes a Consumer<T> and returns
	 * CompletableFuture<Void>. It has access to the result of the CompletableFuture
	 * on which it is attached.
	 */

	public static void main(String[] args) {
		thenAcceptExample();
	}

	public static void thenAcceptExample() {
		CompletableFuture.supplyAsync(() -> {
			Product product = new Product(1L, "name", "description");
			return product;
		}).thenAccept(product1 -> {
			System.out.println("Got product detail from service >> " + product1.getName());
		});

	}

}
