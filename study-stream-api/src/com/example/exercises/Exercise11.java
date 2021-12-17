package com.example.exercises;

import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise11 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of world countries
		var worldPopulationSummary = worldDao.findAllCountries().stream()
		        .collect(Collectors.summarizingLong(Country::getPopulation));
		System.out.println(worldPopulationSummary);
	}

}
