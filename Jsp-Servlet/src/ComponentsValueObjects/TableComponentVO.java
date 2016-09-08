package ComponentsValueObjects;

import java.util.ArrayList;
import java.util.Map;

enum COMPONENT_TYPES{
	INPUTTEXT,OUTPUTTEXT,RADIO;
}

public class TableComponentVO {

	private Map<Integer, String> component_type;
	private Map<Integer, String> component_caption;
	private ArrayList<String> component_value_list;
	private Integer numberOfColumns;

	public Map<Integer, String> getComponent_type() {
		return component_type;
	}

	public void setComponent_type(Map<Integer, String> component_type) {
		this.component_type = component_type;
	}

	public Map<Integer, String> getComponent_caption() {
		return component_caption;
	}

	public void setComponent_caption(Map<Integer, String> component_caption) {
		this.component_caption = component_caption;
	}

	public ArrayList<String> getComponent_value_list() {
		return component_value_list;
	}

	public void setComponent_value_list(ArrayList<String> component_value_list) {
		this.component_value_list = component_value_list;
	}

	public Integer getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(Integer numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

}
