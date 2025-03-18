package com.quiz.kata_foo_bar_quix;

import com.quiz.kata_foo_bar_quix.batch.BatchLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataFooBarQuixApplication  implements CommandLineRunner {
	private final BatchLauncher batchLauncher;

	public KataFooBarQuixApplication(BatchLauncher batchLauncher) {
		this.batchLauncher = batchLauncher;
	}


	public static void main(String[] args) {
		SpringApplication.run(KataFooBarQuixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		batchLauncher.runBatch();
	}
}
