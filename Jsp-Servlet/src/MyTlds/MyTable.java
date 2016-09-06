package MyTlds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;

import ComponentsValueObjects.COMPONENT_TYPES_ENUM;
import ComponentsValueObjects.TableComponentVO;

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
			}else{
				
				buildErrorMsgDiv(out);
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
	
	private void buildErrorMsgDiv(JspWriter out) throws IOException{
		
	}
	
	private void buildTable(JspWriter out) throws IOException{
		Map<Integer, String> captionMap = binding.getComponent_caption();
		Map<Integer, String> typeMap = binding.getComponent_type();
		ArrayList<String> valueList = binding.getComponent_value_list();
		Integer noOfCol=binding.getNumberOfColumns();
		int i=0;
		out.write("<div style='style='font-weight: bold; color: red; font-size: large;" + defaultBodyPosition + ">");
		out.write("<table  align='center' border='2'  width='50%'>");
		out.write("<tr bgcolor='#E1D4D4'>");
		//Build table header
		Iterator captionItr=captionMap.entrySet().iterator();
		while(captionItr.hasNext()){
			Map.Entry captions=(Map.Entry)captionItr.next();
			out.write("<th>");
			out.write((String)captions.getValue());
			out.write("</th>");
		}
		out.write("</tr>");
		
		do{
			Iterator fldTypeItr=typeMap.entrySet().iterator();
			out.write("<tr>");
			while(fldTypeItr.hasNext()){
				Map.Entry fldType=(Map.Entry)fldTypeItr.next();
				
			}
			out.write("</tr>");
		}while(i>=valueList.size());
		//http://stackoverflow.com/questions/17741721/getting-string-value-from-enum-in-java
		out.write("</table>");
	}
	
	private void buildComponents(JspWriter out,String type){
		
		switch(type){
		//http://stackoverflow.com/questions/17741721/getting-string-value-from-enum-in-java
		}
	}
	
}
