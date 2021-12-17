package com.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class AuditingHandler implements InvocationHandler{
	private Object target;
	
	public AuditingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.err.println(String.format("%s runs at %s.",method.getName(),new Date()));
		System.err.println("Parameters are "+Arrays.toString(args));
		var result = method.invoke(target, args);
		System.err.println(String.format("%s returns %s.",method.getName(),result));
		return result;
	}

}
