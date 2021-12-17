package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;
import com.example.random.service.ServiceQuality;

@ServiceQuality(QualityLevel.STANDARD)
public class StandardRandomNumberService implements RandomNumberService {

	@Override
	public int generate(int min, int max) {
		System.err.println("StandardRandomNumberService::generate");		
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
