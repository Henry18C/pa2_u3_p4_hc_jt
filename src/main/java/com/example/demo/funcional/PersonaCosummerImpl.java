package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaCosummerImpl implements IPersonaConsumer<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaCosummerImpl.class);


	@Override
	public void accept(String arg) {
		// TODO Auto-generated method stub
		LOGGER.info(arg);
	}


}
