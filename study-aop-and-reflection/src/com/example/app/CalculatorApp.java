package com.example.app;

import java.lang.reflect.Proxy;

import com.example.handler.AuditingHandler;
import com.example.service.Calculator;
import com.example.service.impl.StandardCalculator;

public class CalculatorApp {

	public static void main(String[] args) {
		Calculator calc = new StandardCalculator();
		var clazz = calc.getClass();
		var clazzLoader = clazz.getClassLoader();
		var interfaces = clazz.getInterfaces();
		System.err.println(calc.getClass());
		calc = (Calculator) Proxy.newProxyInstance(
				clazzLoader, interfaces, new AuditingHandler(calc)); 
		System.err.println(calc.getClass());
		System.err.println("2+7: "+calc.add(2, 7));
		System.err.println("2-7: "+calc.sub(2, 7));
		System.err.println("2*7: "+calc.mul(2, 7));
		System.err.println("2/7: "+calc.div(2, 7));

	}

}
