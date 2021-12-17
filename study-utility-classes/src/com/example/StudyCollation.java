package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class StudyCollation {

	public static void main(String[] args) throws ParseException {
		String name1 = "şima";
		String name2 = "shema";
		System.out.println("name1==name2: "+name1.equals(name2) );
		String name3 = "şule";
		String name4 = "schule";
		System.out.println("name3==name4: "+name3.equals(name4) );
		List<String> names= new ArrayList<>();
		names.add("şule");
		names.add("sema");
		names.add("şima");
		names.add("zehra");
		names.add("Ayşegül");
		Collections.sort(names);
		System.out.println(names);
		String basicRules=  "< a < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < z ";
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
                "& c ; ç & o ; ö & ğ ; g" ;		
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);
		System.out.println("name1==name2: "+collator.equals(name1,name2) );
		System.out.println("name3==name4: "+collator.equals(name3,name4) );
		Comparator<String> orderAsc = collator::compare;
		Collections.sort(names,orderAsc.reversed());
		System.out.println(names);
	}

}
