package ComponentsValueObjects;

import java.util.List;

public class FormComponentVO {

	private String componentType;
	private String componentCaption;
	private List<String> componentListValues;
	private String componentValue;

	public FormComponentVO(String componentType, String componentCaption,
			String componentValue) {
		super();
		this.componentType = componentType;
		this.componentCaption = componentCaption;
		this.componentValue = componentValue;
	}

	public FormComponentVO(String componentType, String componentCaption,
			List<String> componentListValues) {
		super();
		this.componentType = componentType;
		this.componentCaption = componentCaption;
		this.componentListValues = componentListValues;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentCaption() {
		return componentCaption;
	}

	public void setComponentCaption(String componentCaption) {
		this.componentCaption = componentCaption;
	}

	public List<String> getComponentListValues() {
		return componentListValues;
	}

	public void setComponentListValues(List<String> componentListValues) {
		this.componentListValues = componentListValues;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}

}
