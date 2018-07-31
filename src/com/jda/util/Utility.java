package com.jda.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Utility<T> {
	ObjectMapper mapper = new ObjectMapper();
	public List<T> read(String fileName, Class<T> className) throws IOException{
		//List<T> listOfDoctors = mapper.readValue(new File(fileName), new TypeReference<List<T>>(). {});
		List<T> listOfDoctors = mapper.readValue(new File(fileName), mapper.getTypeFactory().constructCollectionType(List.class, className));
		return listOfDoctors;
	}

}
