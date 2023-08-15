package com.example.demo.funcional;
@FunctionalInterface
public interface IPersonaFunction <T,R> {

	
	public T apply(R arg);
	
}
