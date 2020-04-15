import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

@WebServlet("/login")
public class LoginAction extends HttpServlet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	 
	       // Forward toi trang /WEB-INF/views/homeView.jsp
	       // (Người dùng không bao giờ truy cập trực tiếp được vào các trang JSP
	       // đặt trong WEB-INF)
		System.out.println("kjsdfhbjksdfbhdsjkf");
		 
		 String usn = request.getParameter("usn");
		 String pass = request.getParameter("pass");
		 // kiem tra trong DB.
		 //Lay user ---> kem ID.
		 String ID="1001";
		 
		 HttpSession session=request.getSession();  
	     session.setAttribute("id",ID);    
	     Date date = new Date();  
	     request.setAttribute("CurrentYear",date.getYear()+1900);  
	     RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register.jsp");
	        
	       dispatcher.forward(request, response);
	}
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   System.out.println("kjsdfhbjksdfbhdsjkf");
	       doGet(request, response);
	   }

}
