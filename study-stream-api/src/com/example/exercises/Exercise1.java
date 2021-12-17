package com.example.exercises;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        var directorMovieCounts =
        movies.stream().map(Movie::getDirectors)
                       .flatMap(Collection::stream)
                       .collect(Collectors.groupingBy(identity(),counting()));
        BiConsumer<Director,Long> directorPrintMovieCount = (director,count)-> System.out.println(director.getName()+": "+count);
		directorMovieCounts.forEach(directorPrintMovieCount);
	}

}
