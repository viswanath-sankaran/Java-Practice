package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ComponentsValueObjects.TableComponentVO;

public class WelcomeServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		String homepage="MyPages/userDetail.jsp";
		try {
			//System.out.println("my servlet");
			request.getSession().setAttribute("tableAttributes", buildTableComponent());
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
		
		tblVo.setNumberOfColumns(3);
		captionMap.put(1, "Id");
		captionMap.put(2, "Name");
		captionMap.put(3, "DOB");
		tblVo.setComponent_caption(captionMap);
		
		fldTypeMap.put(1, "outputText");
		fldTypeMap.put(2, "inputText");
		fldTypeMap.put(3, "combobox");
		tblVo.setComponent_type(fldTypeMap);
		
		valueList.add("Emp001");
		valueList.add("Viswa");
		valueList.add("20-Jun-1988");
		valueList.add("Emp002");
		valueList.add("Siva");
		valueList.add("04-July-1988");
		valueList.add("Emp003");
		valueList.add("Charini");
		valueList.add("21-Jun-1991");
		tblVo.setComponent_value_list(valueList);
		
		return tblVo;
	}
}
