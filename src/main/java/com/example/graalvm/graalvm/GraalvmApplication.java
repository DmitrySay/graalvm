package com.example.graalvm.graalvm;

import com.example.graalvm.graalvm.config.LiquibaseRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(LiquibaseRuntimeHints.class)
public class GraalvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraalvmApplication.class, args);
	}

}
