package com.coderscampus.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

import com.coderscampus.Assignment8;

public class Assignment8Test { 
	@Test
	public void getDataAsync() {
		Assignment8 assignment = new Assignment8();
		
		ExecutorService executor = Executors.newFixedThreadPool(10);

		Map<Integer, Integer> counts = Collections.synchronizedMap(new HashMap<>());
		
		List<CompletableFuture<Void>> futures = new ArrayList<>(); 
 
		for (int i = 0; i < 1000; i++) {
			CompletableFuture<Void> future = CompletableFuture.runAsync(() -> { 
				List<Integer> numbersList = assignment.getNumbers();
				for (Integer number : numbersList) {
					counts.put(number, counts.getOrDefault(number, 0)+1);
				}
			}, executor);
			futures.add(future);
		}
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
		
		for (int i = 1; i <= 14; i++) {
			int count = counts.getOrDefault(i, 0);
			System.out.println(i + " = " + count);
		}
		executor.shutdown();
	}
}
