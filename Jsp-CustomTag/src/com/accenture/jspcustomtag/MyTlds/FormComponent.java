package com.accenture.jspcustomtag.MyTlds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.accenture.jspcustomtag.ComponentsValueObjects.COMPONENT_TYPES_ENUM;
import com.accenture.jspcustomtag.ComponentsValueObjects.FormComponentVO;
import com.accenture.jspcustomtag.ComponentsValueObjects.NEW_COMPONENT_TYPES_ENUM;


public class FormComponent extends TagSupport {

	public ArrayList<FormComponentVO> binding;


	public ArrayList<FormComponentVO> getBinding() {
		return binding;
	}

	public void setBinding(ArrayList<FormComponentVO> binding) {
		this.binding = binding;
	}

	@Override
	public int doStartTag() {
		try {
			JspWriter writeComp = pageContext.getOut();
			writeComp.write("<div align='center' style='width:100%'>");
			if (binding.size() > 0) {
				writeComp.write("<table align='center' style='width:50%'>");
				buildFormComponent(writeComp);
				writeComp.write("</table>");
			} else {
				writeComp.write("Component mapping not Available");
			}
			writeComp.write("</div>");
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return SKIP_BODY;
	}

	private void buildFormComponent(JspWriter writeComp) throws IOException {
		for (FormComponentVO formCompObj : binding) {
			writeComp.write("<tr>");
			writeComp.write("<td style='width:20%'>");
			writeComp.write(formCompObj.getComponentCaption());
			writeComp.write("</td>");
			writeComp.write("<td style='width:20%'>");
			buildComponent(writeComp,
					NEW_COMPONENT_TYPES_ENUM.valueOf(formCompObj
							.getComponentType().toUpperCase()),
					formCompObj.getComponentValue(),
					formCompObj.getComponentListValues());
			writeComp.write("</td>");
			writeComp.write("</tr>");
		}
	}

	private void buildComponent(JspWriter writeComp,
			NEW_COMPONENT_TYPES_ENUM compType, String compValue,
			List<String> compValueList) throws IOException {
		switch (compType) {
		case TEXTBOX: {
			writeComp.write("<input type='text' value='" + compValue + "'/>");
			break;
		}
		case LABEL: {
			writeComp.write(compValue);
			break;
		}
		case RADIOBUTTON: {
			buildRadioComponent(writeComp, compValueList, compValue);
			break;
		}
		case CHECKBOX: {
			writeComp
					.write("<input type='checkbox'  onclick='selectRow(this);'/>");
			break;
		}
		case SELECTITEM: {
			// out.write("<input type='text' value='" + value + "'/>");
			buildSelectComponent(writeComp, compValueList, compValue);
			break;
		}

		}
	}

	private void buildSelectComponent(JspWriter writeComp,List<String> compValueList,String compValue) throws IOException{
		writeComp.write("<select>");
		for(String value:compValueList){
			if(value.equals(compValue)){
				writeComp.write("<option value='"+value+"' selected='selected'>"+value+"</option>");
			}else{
				writeComp.write("<option value='"+value+"'>"+value+"</option>");
			}
		}
		writeComp.write("</select>");
	}
	
	private void buildRadioComponent(JspWriter writeComp,List<String> compValueList,String compValue) throws IOException{
		for(String value:compValueList){
			if(value.equalsIgnoreCase(compValue)){
				writeComp.write("<input type='radio' checked>"+value);
			}else{
				writeComp.write("<input type='radio'>"+value);		
			}
		}
		
	}
}
