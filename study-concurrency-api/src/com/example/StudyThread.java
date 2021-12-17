package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class StudyThread {

	public static void main(String[] args) throws InterruptedException {
		// Java Application -> java -jar app.jar -> Process
		// Thread Programming
		// Single Process - Multiple Thread
		// Socket, RMI (Remote Method Invocation)
		// Process -> Stack (local var.), Heap (instances), Text (method), Data (static)
		// Thread -> Stack, Heap -> Shared Memory - Between Threads
		// Parallel Programming -> i) Shared Memory (Java) ii) Message Passing -> Actor
		// Model

		// Thread Programming: i) Runnable Thread ii) Callable Thread
		RunnableTask2 task = new RunnableTask2();
		Thread t1 = new Thread(task, "t1");
		Thread t2 = new Thread(task, "t2");
		Thread t3 = new Thread(task, "t3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.err.println("Application is done: " + task.getCounter());
	}

}

class RunnableTask implements Runnable { // Thread-safe
	private int counter = 0; // instance variable -> Heap

	@Override
	public void run() {
		for (var i = 0; i < 10_000; ++i)
			synchronized (this) { // critical section -> mutual exclusion
				counter++;
			}
	}

	public int getCounter() {
		return counter;
	}

}

class RunnableTask2 implements Runnable { // Thread-safe
	private AtomicInteger counter = new AtomicInteger(0); // instance variable -> Heap

	@Override
	public void run() {
		for (var i = 0; i < 10_000; ++i)
			counter.incrementAndGet();
	}

	public int getCounter() {
		return counter.get();
	}

}
