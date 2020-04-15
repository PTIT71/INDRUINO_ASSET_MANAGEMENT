import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterAction extends HttpServlet {
	@Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		  String name = request.getParameter("usn");
		  String pass = request.getParameter("pass");
		  String old = request.getParameter("old");
		  
		  //validation name not empty
		  if(name==null || name !=null && name.trim().length()==0)
		  {
			  // Khong nhap username
			  request.setAttribute("message_name", "Khong duoc bo trong");
			  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register.jsp");
		        
		       dispatcher.forward(request, response);
		  }
		  else
		  {
			  if(name.trim().length()>5)
			  {
				// vuot qua max lengt
				  request.setAttribute("message_name", "Khong duoc vuoc qua 5 ky tu");
				  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/register.jsp");
			        
			       dispatcher.forward(request, response);
			  }
		  }
		  //Dao
		  //Luu
		  
	   }
}
