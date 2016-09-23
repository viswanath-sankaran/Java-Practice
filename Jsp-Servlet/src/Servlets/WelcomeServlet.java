package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ComponentsValueObjects.FormComponentVO;
import ComponentsValueObjects.TableComponentVO;

public class WelcomeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String homepage="MyPages/userDetail.jsp";
		try {
			//System.out.println("my servlet");
			//request.getSession().setAttribute("tableAttributes", buildTableComponent());
			request.getSession().setAttribute("formView", getFormComponents());
			response.sendRedirect(homepage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private TableComponentVO buildTableComponent(){
		TableComponentVO tblVo=new TableComponentVO();
		Map<Integer,String> captionMap=new HashMap<Integer, String>();
		Map<Integer,String> fldTypeMap=new HashMap<Integer, String>();
		ArrayList<String> valueList=new ArrayList<String>();
		ArrayList<TableComponentVO> tblAttrList=new ArrayList<TableComponentVO>();
		
		tblVo.setNumberOfColumns(5);
		captionMap.put(1, "");
		captionMap.put(2, "Id");
		captionMap.put(3, "Name");
		captionMap.put(4, "DOB");
		captionMap.put(5, "View");
		tblVo.setComponent_caption(captionMap);
		
		fldTypeMap.put(1, "checkbox");
		fldTypeMap.put(2, "outputText");
		fldTypeMap.put(3, "inputText");
		fldTypeMap.put(4, "combobox");
		fldTypeMap.put(5, "radio");
		tblVo.setComponent_type(fldTypeMap);
		
		valueList.add("");
		valueList.add("Emp001");
		valueList.add("Viswa");
		valueList.add("20-Jun-1988");
		valueList.add("");
		valueList.add("");
		valueList.add("Emp002");
		valueList.add("Siva");
		valueList.add("04-Jul-1988");
		valueList.add("");
		valueList.add("");
		valueList.add("Emp003");
		valueList.add("Charini");
		valueList.add("21-Jun-1991");
		valueList.add("");
		tblVo.setComponent_value_list(valueList);
		
		return tblVo;
	}
	
	
	private ArrayList<FormComponentVO> getFormComponents(){
		
		ArrayList<FormComponentVO>  formComponentList = new ArrayList<FormComponentVO>();
		
		List locationList = Arrays.asList("Chennai", "Madurai", "Trichy");
		List genderList = Arrays.asList("Male");
		
		
		FormComponentVO name = new FormComponentVO("Name", "TextBox", "Vishwa");
		FormComponentVO age = new FormComponentVO("Age", "TextBox", "24");
		FormComponentVO gender = new FormComponentVO("Gender", "RadioButton", genderList,"Male");
		FormComponentVO location = new FormComponentVO("Location", "SELECTITEM", locationList,"Madurai");
		FormComponentVO hobies = new FormComponentVO("Hobies", "TextBox", "Cricket,Songs");
		
				
		formComponentList.add(name);
		formComponentList.add(age);
		formComponentList.add(gender);
		formComponentList.add(location);
		formComponentList.add(hobies);
		
		
		
		return formComponentList;
		
	}
}
