package com.accenture.jspcustomtag.ComponentsValueObjects;

public enum COMPONENT_TYPES_ENUM {
	INPUTTEXT("inputText"),
	OUTPUTTEXT("output"), 
	RADIO("radio"), 
	CHECKBOX("checkbox"), 
	COMBOBOX("combobox");
	
	public final String COMPONENT_TYPE;
	
	COMPONENT_TYPES_ENUM(String type){
		COMPONENT_TYPE=type;
	}
	
}