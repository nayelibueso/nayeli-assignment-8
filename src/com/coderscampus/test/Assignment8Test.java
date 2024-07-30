package com.coderscampus.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

import com.coderscampus.Assignment8;

public class Assignment8Test {
	
	//Step 1: asycnhronus data fetching 
	
	//Define a test method NAMED getDataAsync( )that will perform asynchronus fetching. 
	@Test
	public void getDataAsync() {
		//Create an instance of the 'Assignment8' Class NAMED 'assignment'
		Assignment8 assignment = new Assignment8();
		//Create an 'ExecutorService' with  fixed thread pool of [Test] 10 threads NAMED 'executor'. This allows us to run multiple tasks in parallel.
		ExecutorService executor = Executors.newFixedThreadPool(10);
		//Create a list of 'CompletableFuture' objects NAMED 'futures' and set it equal to an ArrayList. These objects represents asynchronus tasks that will be executed. 
		List<CompletableFuture<Void>> futures = new ArrayList<>(); //This is like a folder where you keep all the tickets. It's declared once and used to collect all the tickets.
		//for loop to create and run asycnhronus tasks.
		//loop 1000 time b/c 'getNumbers' returns 1000 records each time 
		for (int i = 0; i < 1000; i++) {
			//inside the loop, we create a 'CompleteableFuture' NAMED 'future' that runs the 'getNumbers' method asynchronusly using the 'executor' 
																					
			CompletableFuture<Void> future = CompletableFuture.runAsync(() -> { 
				List<Integer> numbersList = assignment.getNumbers();
				System.out.println(numbersList);
				//the results ('numberList'^) is printed
			}, executor);
			//Each 'completableFuture' is added to the 'futures' list
			futures.add(future);
		}
		
		//wait for all futures to complete
			//Use a 'CompletableFuture.allOf' to wait for all futures to complete. This method takes an array of 'CompletableFuture' objects and returns a new 'CompletableFuture' that is completed when all of the given 
			//futures complete. Call 'join' on this new 'completableFuture' to block intill all tasks are done.
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
		//shut down the executer
		executor.shutdown();
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Step 2: Count thread-safe Ocurrences of Each Number 
		//Create instance of the 'Assignment8' class
		//Create an 'ExecutorService' with  fixed thread pool of [Test] 10 threads NAMED 'executor'. This allows us to run multiple tasks in parallel.
		//Create a synchronized map to hold the counts of each number Named counts .
		//Create a list of 'CompletableFuture' objects NAMED 'futures' and set it equal to an ArrayList. These objects represents asynchronus tasks that will be executed.
		//Creae a for loop that submiuts 1000 tasks to the executer 
			////inside the loop, we create a 'CompleteableFuture' NAMED 'future' that runs the 'getNumbers' method asynchronusly using the 'executor' 
			//Fetch 1000 numbers 
			//Update counts for each number using a for loop inside this for loop 
				// mkae 'number' represent each individual integer in 'numberList' as the loop iterates through the list  (imsgine you have a list of #, this loop goes through each number one by one
		//Wait for all tasks to complete 
			//Use a 'CompletableFuture.allOf' to wait for all futures to complete. This method takes an array of 'CompletableFuture' objects and returns a new 'CompletableFuture' that is completed when all of the given 
			//futures complete. Call 'join' on this new 'completableFuture' to block intill all tasks are done.
		//Print the results using a for loop 
			//inside the loop, for each number, check how many times the number appears in the database, if the number dosent appear, assume it is 0
			//for each number, print out the number along with its count
		//shut down the executor 
		
		
	}
	
	

}
