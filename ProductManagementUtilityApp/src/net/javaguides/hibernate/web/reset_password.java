package net.javaguides.hibernate.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import net.javaguides.hibernate.model.User;
import net.javaguides.hibernate.util.HiberateUtil;


/**
 * Servlet implementation class reset_password
 */
@WebServlet("/reset_password")
public class reset_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reset_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do get method");
		String username = request.getParameter("username");
		System.out.println(username);
		Session session = HiberateUtil.getsessionfactory().openSession();
		Query query = session.createQuery("FROM User U WHERE U.username = :username");
		query.setParameter("username", username);
		User user = (User)query.uniqueResult();
		
		if (user==null)
			response.getWriter().print("No such User Exists");
		else 
			response.getWriter().print("Your Password is : "+ user.getPassword());
	
		session.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
