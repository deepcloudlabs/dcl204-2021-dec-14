package com.example.exercises;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		var countries = countryDao.findAllCountries();
		
		Set<String> continents = new HashSet<>();
		for (var country : countries) {
			String continent = country.getContinent();
			continents.add(continent);
		}
		System.out.println(continents);
		
		var kitalar = 
		countries.stream() // select distinct continent from countries order by continent
		         .map(Country::getContinent)
		         .map(String::toLowerCase)
		         .distinct()
		         .sorted()
		         .toList();
		System.out.println(kitalar);
		
		var worldPopulation = 
		countries.stream()
		         .mapToLong(Country::getPopulation)
		         .sum();
		System.out.println(worldPopulation);
		
		Map<String,Long> continentPopulations =
		// select continent, sum(population) from countries grouping by continent
		countries.stream()
		         .collect(groupingBy(Country::getContinent,Collectors.summingLong(Country::getPopulation)));
		continentPopulations.forEach(
				(continent,population)-> System.out.println(continent+": "+population)
		);
		
		// select continent from countries grouping by continent
		Map<String,List<Country>> continentCountries =
				countries.stream()
				         .collect(groupingBy(Country::getContinent));
		continentCountries.forEach(
				(continent,contCtries)-> System.out.println(continent+": "+contCtries));		
		// select continent,count(*) from countries grouping by continent
		Map<String,Long> continentCounts =
				countries.stream()
						 .parallel()
				         .collect(groupingBy(Country::getContinent,counting()));
		continentCounts.forEach(
				(continent,count)-> System.out.println(continent+": "+count));
				
	}

}