package com.accenture.jspcustomtag.MyTlds;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	@Override
	public int doStartTag()throws JspException{
		JspWriter msgWriter=pageContext.getOut();
		try {
			msgWriter.print("Hi Welcome to my tags");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
