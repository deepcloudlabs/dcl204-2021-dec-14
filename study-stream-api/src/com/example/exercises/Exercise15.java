package com.example.exercises;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise15 {
	private static final WorldDao wordlDao = InMemoryWorldDao.getInstance();

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var streamOfLotteryNumbers = ThreadLocalRandom.current().ints(1, 60) // stream
		                           .distinct()
		                           .limit(6)
		                           .sorted()
		                           .boxed();
		var lotteryNumbers = streamOfLotteryNumbers.toList(); // execution starts now !!!
		var countries = wordlDao.findAllCountries();
		// FP's function: i) Lambda Expression (Pure) ii) ** Method Reference
		// Filter/Map/Reduce Methods
		// 1. intermediary methods: distinct, map, limit, sorted, boxed, ... -> lazy evaluation
		// 2. terminal methods: toList, collect, sum, count, ...
		var city =
				countries.stream()
		         .map(Country::getCapital) // Stream<Integer>
		         .filter(Objects::nonNull) // Stream<Integer>
		         //.map(cityId -> wordlDao.findCityById(cityId))
		         .map(wordlDao::findCityById) // Stream<City>
		         .filter(Objects::nonNull)
		         .max(Comparator.comparing(City::getPopulation));
		city.ifPresent(System.out::println);
	}

}
