package com.example.app;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.domain.Animal;
import com.example.domain.Cat;
import com.example.domain.Fish;
import com.example.domain.Pet;
import com.example.domain.Spider;

@SuppressWarnings("unused")
public class AnimalApp {

	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>(List.of(
		    new Spider(),
		    new Cat(),
		    new Fish("Free Willy"),
		    new Cat("Garfield"),
		    new Fish("Nemo"),
		    new Spider()
		));
		animals.add(new Fish("Jaws"));
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) { // guard
				((Pet) animal).play(); // safe from ClassCastException
			}
		}
		var numOfPets = 0L;
		for (Animal animal : animals) { // outer animals
			if (animal instanceof Pet)
				numOfPets++;
		}
		System.err.println("Number of pets is " + numOfPets);
		// Functional Programming: function -> i) Higher-order Function  
		//                                    ii) Pure function -> immutable -> thread-safe 
		// Functional Interface -> SAM (Single Abstract Method)
		final int x= 42; // effectivelly final
		Predicate<Animal> ifPet = animal -> animal instanceof Pet ;
		numOfPets = 
		animals.stream()
			   .parallel()
		       .filter(ifPet) // filter is a higher-order function
		       .count();
		var numOfPetLegs=
		animals.stream()
		       .filter(AnimalUtility::isPet)
		       //.mapToInt(animal -> animal.getLegs())
		       .mapToInt(Animal::getLegs) // method reference
		       .sum();
		System.out.println("numOfPetLegs: "+numOfPetLegs);
		var animalCounts =
		animals.stream().parallel().collect(groupingBy(Animal::getClass,counting()));
		animalCounts.forEach( (clazz,count) -> System.out.println(clazz.getSimpleName()+": "+count));
		var pets = animals.stream().filter(ifPet).collect(Collectors.toList());
		pets = animals.stream().filter(ifPet).toList(); // since java 16
	   }

}

interface AnimalUtility {
	static boolean isPet(Animal animal) { // since java 8
		return animal instanceof Pet;
	}
}