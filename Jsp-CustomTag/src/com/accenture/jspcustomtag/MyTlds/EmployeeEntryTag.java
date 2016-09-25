package com.accenture.jspcustomtag.MyTlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.accenture.jspcustomtag.beans.EmployeeBean;


public class EmployeeEntryTag extends TagSupport {

	private ArrayList<String> type;
	private ArrayList<EmployeeBean> value;
	private String defaultBodyPosition = "position: relative; top: 100px;left: 40%;";
	private ArrayList<String> captions;
	
	public ArrayList<String> getCaptions() {
		return captions;
	}
	
	public void setCaptions(ArrayList<String> captions) {
		this.captions = captions;
	}

	public ArrayList<String> getType() {
		return type;
	}

	public void setType(ArrayList<String> type) {
		this.type = type;
	}

	public ArrayList<EmployeeBean> getValue() {
		return value;
	}

	public void setValue(ArrayList<EmployeeBean> value) {
		this.value = value;
	}

	public String getDefaultBodyPosition() {
		return defaultBodyPosition;
	}

	public void setDefaultBodyPosition(String defaultBodyPosition) {
		this.defaultBodyPosition = defaultBodyPosition;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			
			if(captions.size()==type.size()){
				buildTable(pageContext.getOut());
			}else {
				buildInvalidMsg(pageContext.getOut());
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SKIP_BODY;
	}

	private void buildTable(JspWriter out)
			throws IOException {
		out.write("<div style='style='font-weight: bold; color: red; font-size: large;" + defaultBodyPosition + ">");
		//out.write("Employee Details Below");
		out.write("<table  align='center' border='2'  width='50%'>");
		// Header tr open
		out.write("<tr bgcolor='#E1D4D4'>");
		out.write("<th>");
		out.write("</th>");
		for(int head=0;head<captions.size();head++){
			out.write("<th>");
			out.write(captions.get(head));
			out.write("</th>");
		}		
		out.write("</tr>");
		// Header tr close
		for(EmployeeBean empBean:value){
			out.write("<tr>");
			out.write("<td>");
			out.write("<input type='checkbox' onclick='selectRow(this);'/>");
			out.write("</td>");
			for(int fld=0;fld<type.size();fld++){
				out.write("<td>");
				String fldValue="";
				if(fld==0)
					fldValue=empBean.getEmpId();
				else if(fld==1)
					fldValue=empBean.getEmpName();
				else if(fld==2)
					fldValue=empBean.getDOB();
				
				buildComponents(out, type.get(fld), fldValue);
				out.write("</td>");
			}
			out.write("</tr>");
		}
		
		/*out.write("</tr>");
		out.write("<tr>");
		out.write("<td>");
		out.write("EMP01");
		out.write("</td>");
		out.write("<td>");
		out.write("Viswa");
		out.write("</td>");
		out.write("<td>");
		out.write("20/Jun/2016");
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>");
		out.write("EMP02");
		out.write("</td>");
		out.write("<td>");
		out.write("Siva");
		out.write("</td>");
		out.write("<td>");
		out.write("04/July/2016");
		out.write("</td>");
		out.write("</tr>");*/
		
		out.write("</table>");
		out.write("</div>");
	}

	private void buildInvalidMsg(JspWriter out) throws IOException {
		out.write("<div style='font-weight: bold; color: red; font-size: large;"
				+ defaultBodyPosition + "'>");
		out.write("Invalid userdetail component attribute....");
		out.write("</div>");
	}
	
	private void buildComponents(JspWriter out,String fieldType,String fldValue) throws IOException{
		switch(fieldType){
		case "inputText":
			out.write("<input type='input' value='"+fldValue+"'/>");
			break;
		case "outputText":
			out.write(fldValue);
			break;
		case "calenderCombo":
			out.write("<input type='input' value='"+fldValue+"'/>");
			break;
		default:
			System.out.println("inValid field Type");
			
		}
	}
	
	private void buildComboBox(JspWriter out,String fldValue)throws IOException{
		
	}
}
