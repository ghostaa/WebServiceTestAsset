package com.ibm.btt.wsc.mapper.beans;

import java.util.UUID;

import com.ibm.btt.element.simple.PropertyConverter;


public class UnCloneableFieldConverter implements PropertyConverter {

	@Override
	public Object convertToValue(String text) {
		UUID uuid = UUID.fromString(text);
		UnCloneableField ucf = new UnCloneableField();
		ucf.setUuid(uuid);
		return ucf;
	}

}
