package com.dockerbt.api;

import com.dockerbt.api.controllers.ToolController;
import com.dockerbt.api.mappers.ToolMapperImpl;
import com.dockerbt.api.repositories.ToolRepository;
import com.dockerbt.api.services.impl.ToolServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@OpenAPIDefinition(info = @Info(title = "Tools API", version = "1.0", description = "Rest API for Tools."))
@SpringBootApplication(scanBasePackages = { "com.dockerbt" })
@Slf4j
public class ToolApplication
{
	public static void main(String[] args) {
		SpringApplication.run(ToolApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		Logger logger = LoggerFactory.getLogger(ToolApplication.class);
		ToolController toolController = new ToolController(new ToolServiceImpl(new ToolRepository(), new ToolMapperImpl()));

		logger.info("--------");
		logger.info("GET request");
		logger.info("Toolnumber: " + toolController.getToolById(1L).get().getToolNumber());
		logger.info("--------");
		System.exit(0);
	}
}
