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
public class Exercise12 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		var continentPopulationSummary =
				worldDao.findAllCountries()
		        .stream()
		        .collect(Collectors.groupingBy(Country::getContinent,Collectors.summarizingLong(Country::getPopulation)));
		continentPopulationSummary.forEach((continent,summary) -> System.out.println(continent+": "+summary));
	}

}
