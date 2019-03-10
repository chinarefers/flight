package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origin = request.getParameter("origin");
		String dest = request.getParameter("dest");
		String date = request.getParameter("date");
		String[] str = date.split("/");
		String newDate="";
		//日期转换 年-月-日
		newDate+=str[2];
		if(str[0].length()==1){
			newDate+="0"+str[0];
		}else{
			newDate+=str[0];
		}
			
		if(str[1].length()==1){
			newDate+="0"+str[1];
		}else{
			newDate+=str[1];
		}
		String rowKey=newDate+origin+dest;
		request.setAttribute("row", rowKey);
		System.out.println(rowKey);
		
		
		request.getRequestDispatcher("data.jsp?rowKey="+rowKey).forward(request, response);
		
		//request.getRequestDispatcher("info.jsp?rowKey="+rowKey).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
