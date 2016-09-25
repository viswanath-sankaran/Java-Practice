package com.accenture.jspcustomtag.ComponentsValueObjects;

public class SelectOneComponentVO {

	private String selectKey;
	private String selectValue;

	public SelectOneComponentVO(String selectKey, String selectValue) {
		super();
		this.selectKey = selectKey;
		this.selectValue = selectValue;
	}

	public String getSelectKey() {
		return selectKey;
	}

	public String getSelectValue() {
		return selectValue;
	}

}
