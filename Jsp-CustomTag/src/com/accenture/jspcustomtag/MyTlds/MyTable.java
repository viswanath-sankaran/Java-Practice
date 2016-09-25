package com.accenture.jspcustomtag.MyTlds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.accenture.jspcustomtag.ComponentsValueObjects.COMPONENT_TYPES_ENUM;
import com.accenture.jspcustomtag.ComponentsValueObjects.TableComponentVO;
import com.sun.xml.internal.ws.wsdl.writer.document.Types;


public class MyTable extends TagSupport {

	private String defaultBodyPosition = "position: relative; top: 100px;left: 40%;";
	private TableComponentVO binding;

	public TableComponentVO getBinding() {
		return binding;
	}

	public void setBinding(TableComponentVO binding) {
		this.binding = binding;
	}

	@Override
	public int doStartTag() {
		try {
			JspWriter out = pageContext.getOut();

			Map<Integer, String> captionMap = binding.getComponent_caption();
			Map<Integer, String> typeMap = binding.getComponent_type();
			ArrayList<String> valueList = binding.getComponent_value_list();

			if (binding.getNumberOfColumns().equals(captionMap.size())
					&& binding.getNumberOfColumns().equals(typeMap.size())
					&& (valueList.size() % binding.getNumberOfColumns() == 0)) {

				buildTable(out);
			} else {

				buildErrorMsgDiv(out);
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	private void buildErrorMsgDiv(JspWriter out) throws IOException {

	}

	private void buildTable(JspWriter out) throws IOException {
		Map<Integer, String> captionMap = binding.getComponent_caption();
		Map<Integer, String> typeMap = binding.getComponent_type();
		ArrayList<String> valueList = binding.getComponent_value_list();
		Integer noOfCol = binding.getNumberOfColumns();
		int i = 0;
		out.write("<div style='style='font-weight: bold; color: red; font-size: large;"
				+ defaultBodyPosition + ">");
		out.write("<table  align='center' border='2'  width='50%'>");
		out.write("<tr bgcolor='#E1D4D4'>");
		// Build table header
		Iterator captionItr = captionMap.entrySet().iterator();
		while (captionItr.hasNext()) {
			Map.Entry captions = (Map.Entry) captionItr.next();
			out.write("<th>");
			out.write((String) captions.getValue());
			out.write("</th>");
		}
		out.write("</tr>");

		do {
			Iterator fldTypeItr = typeMap.entrySet().iterator();
			out.write("<tr>");
			while (fldTypeItr.hasNext()) {
				Map.Entry fldType = (Map.Entry) fldTypeItr.next();
				out.write("<td>");
				buildComponents(out,
						COMPONENT_TYPES_ENUM.valueOf(((String) fldType
								.getValue()).toUpperCase()), valueList.get(i));
				out.write("</td>");
				i++;
			}
			out.write("</tr>");
		} while (i < valueList.size());
		// http://stackoverflow.com/questions/17741721/getting-string-value-from-enum-in-java
		out.write("</table>");
	}

	private void buildComponents(JspWriter out, COMPONENT_TYPES_ENUM type,
			String value) throws IOException {
		
		switch (type) {
		case INPUTTEXT: {
			out.write("<input type='text' value='" + value + "'/>");
			break;
		}
		case OUTPUTTEXT: {
			out.write(value);
			break;
		}
		case RADIO: {
			out.write("<input type='radio' value='" + value + "' name='view'/>");
			break;
		}
		case CHECKBOX: {
			out.write("<input type='checkbox'  onclick='selectRow(this);'/>");
			break;
		}
		case COMBOBOX: {
			//out.write("<input type='text' value='" + value + "'/>");
			buildCalenderCombo(out, value);
			break;
		}

		}
	}

	private void buildCalenderCombo(JspWriter out, String dateVal)
			throws IOException {
		ArrayList<String> dateList = loadCalenderValues("date");
		ArrayList<String> monthList = loadCalenderValues("month");
		ArrayList<String> yearList = loadCalenderValues("year");
		out.write("<select>");
		for(String date:dateList){
			out.write("<option value='"+date+"' ");
			if(Integer.parseInt(dateVal.split("-")[0])==Integer.parseInt(date)){
				out.write("selected='selected'");
			}
			out.write(">"+date+"</option>");
		}
		out.write("</select>");
		//
		out.write("<select>");
		for(String month:monthList){
			out.write("<option value='"+month.substring(0, 3)+"' ");
			if(dateVal.split("-")[1].equalsIgnoreCase(month.substring(0, 3))){
				out.write("selected='selected'");
			}
			out.write(">"+month+"</option>");
		}
		out.write("</select>");
		out.write("<select>");
		for(String year:yearList){
			out.write("<option value='"+year+"' ");
			if(Integer.parseInt(year)==Integer.parseInt(dateVal.split("-")[2])){
				out.write("selected='selected'");
			}
			out.write(">"+year+"</option>");
		}
		out.write("</select>");
	}

	private ArrayList<String> loadCalenderValues(String type) {
		ArrayList<String> returnList = new ArrayList<String>();
		switch (type) {
		case "date": {
			for (int i = 1; i <= 31; i++) {
				returnList.add(i + "");
			}
			break;
		}
		case "month": {
			returnList.add("January");
			returnList.add("February");
			returnList.add("March");
			returnList.add("April");
			returnList.add("May");
			returnList.add("June");
			returnList.add("July");
			returnList.add("August");
			returnList.add("September");
			returnList.add("October");
			returnList.add("November");
			returnList.add("December");
			break;
		}
		case "year": {
			for (int i = 1950; i <= 2000; i++) {
				returnList.add(i + "");
			}
			break;
		}
		}
		return returnList;
	}

}