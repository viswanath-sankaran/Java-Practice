package MyTlds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import ComponentsValueObjects.FormComponentVO;

public class FormComponent extends TagSupport {

	private ArrayList<FormComponentVO> binding;

	private JspWriter writeComp = pageContext.getOut();

	public ArrayList<FormComponentVO> getBinding() {
		return binding;
	}

	public void setBinding(ArrayList<FormComponentVO> binding) {
		this.binding = binding;
	}

	@Override
	public int doStartTag() {
		try {
			writeComp.write("<div>");
			if (binding.size() > 0) {
				writeComp.write("<table>");
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
		
	}
}
