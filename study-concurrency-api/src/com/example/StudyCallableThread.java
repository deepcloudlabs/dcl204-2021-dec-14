package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

public class StudyCallableThread {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int cores= Runtime.getRuntime().availableProcessors();
		var futures = new ArrayList<FutureTask<List<Integer>>>();
		// var tp = Executors.newFixedThreadPool(cores);
		var tp = Executors.newCachedThreadPool();
		for (var i=0;i<10_000;++i) {
			var lotteryTask = new LotteryTask();
			var futureTask = new FutureTask<>(lotteryTask);
			futures.add(futureTask);
			tp.submit(futureTask);
		}
		for (var future : futures) {
			System.err.println(future.get());
		}
		tp.shutdown();
	}

}

class LotteryTask implements Callable<List<Integer>> {

	@Override
	public List<Integer> call() throws Exception {
		return ThreadLocalRandom.current().ints(1, 60)
				.distinct().limit(6).sorted().boxed().toList();
	}
	
}