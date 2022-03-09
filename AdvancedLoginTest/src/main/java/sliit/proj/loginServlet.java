package sliit.proj;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formUsername = request.getParameter("formUsername");
		String formPassword = request.getParameter("formPassword");
		
		try {
			List<Student> StdntDetails = loginDbUtil.validate(formUsername, formPassword);
			request.setAttribute("StdntDetails", StdntDetails);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher req = request.getRequestDispatcher("userAcnt.jsp");
		req.forward(request, response);
	}

}
