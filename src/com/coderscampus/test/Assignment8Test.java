package com.coderscampus.test;

import org.junit.jupiter.api.Test;

public class Assignment8Test {
	
	//Step 1: asycnhronus data fetching 
	
	//Define a test method NAMED getDataAsync( )that will perform asynchronus fetching. 
	@Test
	public void getDataAsync() {
		//Create an instance of the 'Assignment8' Class NAMED 'assignment'
		
		//Create an 'ExecutorService' with  fixed thread pool of [Test] 10 threads NAMED 'executor'. This allows us to run multiple tasks in parallel.
		
		//Create a list of 'CompletableFuture' objects NAMED 'futures'. These objects represents asynchronus tasks that will be executed. 
		
		//for loop to create and run asycnhronus tasks.
		//loop 1000 time b/c 'getNumbers' returns 1000 records each time 
		//inside the loop, we create a 'CompleteableFuture' that runs the 'getNumbers' method asynchronusly using the 'executor' 
		//the results ('numberList'^) is printed
		//Each 'completableFuture' is added to the 'futures' list
		
		//wait for all futures to complete
		//Use a 'CompletableFuture.allOf' to wait for a'' futures to complete. This method will take an array of 'CompletableFuture' objects and returns a new 'CompletableFuture' that is completed qhwn all of the given 
		//futures complete. Call 'join' on the new 'completableFuture' to block intill all tasks are done.
		//shut down the executer
		
	}
	
	

}
