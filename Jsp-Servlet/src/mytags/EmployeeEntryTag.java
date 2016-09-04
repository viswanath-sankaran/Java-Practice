package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class EmployeeEntryTag extends TagSupport {

	private String captions;
	private String type;
	private String value;

	public String getCaptions() {
		return captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			String[] captionArr = captions.split(";");
			String[] typeArr = type.split(";");
			if (captionArr.length == typeArr.length) {
				buildTable(pageContext.getOut(), captionArr, typeArr);
			} else {
				buildInvalidMsg(pageContext.getOut());
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SKIP_BODY;
	}

	private void buildTable(JspWriter out, String[] captionArr, String[] typeArr)
			throws IOException {

	}

	private void buildInvalidMsg(JspWriter out) throws IOException {
		out.write("<div style='font-weight: bold; color: red; font-size: large;'>");
		out.write("Invalid userdetail component attribute....");
		out.write("</div>");
	}
}
