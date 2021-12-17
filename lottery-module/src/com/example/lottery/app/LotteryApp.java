package com.example.lottery.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.impl.StandardLotteryService;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var lotteryService = new StandardLotteryService();
		var services = ServiceLoader.load(RandomNumberService.class);
		var props = new Properties();
		props.load(new FileInputStream(new File("src","configuration.properties")));
		var level = QualityLevel.valueOf(props.getProperty("service.quality"));
		RandomNumberService randomNumberService = null;
		for (var service : services) {
			var clazz = service.getClass();
			
			if (clazz.isAnnotationPresent(ServiceQuality.class)) {
				var serviceQuality = clazz.getDeclaredAnnotation(ServiceQuality.class);
				if (serviceQuality.value() == level) {
					randomNumberService = service;
					break;
				}
			}
		}
		lotteryService.setRandomNumberService(randomNumberService);
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);

	}

}
