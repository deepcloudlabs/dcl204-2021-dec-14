package com.example;

import java.util.HashSet;

public class StudyEqualsAndHashCode {

	public static void main(String[] args) {
		var employees = new HashSet<Employee>();
		employees.add(new Employee("1", "tr1", 10_000));
		employees.add(new Employee("1", "tr1", 10_000));
		employees.add(new Employee("1", "tr1", 10_000));
		employees.add(new Employee("2", "tr2", 20_000));
		employees.add(new Employee("2", "tr2", 20_000));
		employees.add(new Employee("2", "tr2", 20_000));
		employees.add(new Employee("3", "tr3", 30_000));
		employees.add(new Employee("3", "tr3", 30_000));
		employees.add(new Employee("3", "tr3", 30_000));
		System.err.println("# of elements: "+employees.size());
		System.out.println(employees.contains(new Employee("2", "tr2", 20_000)));

	}

}
