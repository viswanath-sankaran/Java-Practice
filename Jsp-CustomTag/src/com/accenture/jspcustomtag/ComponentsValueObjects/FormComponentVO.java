package com.accenture.jspcustomtag.ComponentsValueObjects;


import java.util.List;

public class FormComponentVO {

	private String componentCaption;
	private COMPONENT componentType;
	private List componentListValues;
	private String componentValue;

	

	public FormComponentVO(String componentCaption, COMPONENT componentType,
			List componentListValues) {
		super();
		this.componentCaption = componentCaption;
		this.componentType = componentType;
		this.componentListValues = componentListValues;
	}

	public FormComponentVO(String componentCaption, COMPONENT componentType,
			String componentValue) {
		super();
		this.componentCaption = componentCaption;
		this.componentType = componentType;
		this.componentValue = componentValue;
	}

	public FormComponentVO(String componentCaption, COMPONENT componentType,
			List componentListValues, String componentValue) {
		super();
		this.componentCaption = componentCaption;
		this.componentType = componentType;
		this.componentListValues = componentListValues;
		this.componentValue = componentValue;
	}

	public COMPONENT getComponentType() {
		return componentType;
	}

	public void setComponentType(COMPONENT componentType) {
		this.componentType = componentType;
	}

	public String getComponentCaption() {
		return componentCaption;
	}

	public void setComponentCaption(String componentCaption) {
		this.componentCaption = componentCaption;
	}

	public List getComponentListValues() {
		return componentListValues;
	}

	public void setComponentListValues(List componentListValues) {
		this.componentListValues = componentListValues;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}

}
