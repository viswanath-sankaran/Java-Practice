package com.accenture.jspcustomtag.MyTlds;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CaptionTag extends TagSupport {

	private String value;
	private String style;
	private String defaultStyle="style='font-weight: bold; color: blue; font-size: large; border: thin;'";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getDefaultStyle() {
		return defaultStyle;
	}

	public void setDefaultStyle(String defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

	@Override
	public int doStartTag() {

		try {
			JspWriter out = pageContext.getOut();
			if(style!=null){
				out.write("<div style='"+style+"'>");
			}else{
				out.write("<div"+defaultStyle+">");
			}
			out.write("<center>");
			out.write(value);
			out.write("</center>");
			out.write("</div>");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
