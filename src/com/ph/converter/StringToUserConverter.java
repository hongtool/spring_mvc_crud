package com.ph.converter;

import org.springframework.core.convert.converter.Converter;

import com.ph.POJO.User;

public class StringToUserConverter implements Converter<String, User> {

	@Override
	public User convert(String source) {
		String[] array = source.split("-");
		if(array != null && array.length == 2) {
			User user = new User();
			user.setName(array[0]);
			user.setAge(Integer.parseInt(array[1]));
			return user;
		}
		return null;
	}

}
