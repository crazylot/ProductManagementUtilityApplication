package net.javaguides.hibernate.web;

import java.util.Base64;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.javaguides.hibernate.dao.ProductDAO;
import net.javaguides.hibernate.model.Product;
/**
 * Servlet implementation class ProductManagement
 */
@WebServlet("/")
@MultipartConfig
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ProductDAO prodobj;
	public static String usernametobepassed;

    public void init() {
    	prodobj = new ProductDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				addProduct(request, response);
				break;
			case "/delete":
				deleteProduct(request, response);
				break;
			case "/edit":
				editform(request, response);
				break;
			case "/update":
				editProduct(request, response);
				break;
			default:
				listProduct(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String title = request.getParameter("title");
		String quantity = request.getParameter("quantity");
		String size = request.getParameter("size");
		String username = request.getParameter("username");
		usernametobepassed=username;
		//to get image in byte[] format
		Part part = request.getPart("image");
		String filename = part.getSubmittedFileName();
	    System.out.println(filename);
		InputStream is = null;
		if(part!=null)
		{
			is = part.getInputStream();
		}
		byte[] data = new byte[is.available()];
		is.read(data);
		//------
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int bytesRead = -1;
		while ((bytesRead = is.read(data)) != -1) {
			outputStream.write(data, 0, bytesRead);
			}

		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);

		Product newproduct = new Product(title, quantity, size, data, base64Image,usernametobepassed);
		ProductDAO.saveProduct(newproduct); //saveproduct method is static
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
        dispatcher.forward(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO.deleteProduct(id);
        response.sendRedirect("Product.jsp");
	}
	
	private void editform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = ProductDAO.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditForm.jsp");
        request.setAttribute("ProductTobechanged", existingProduct);
        dispatcher.forward(request, response);
	}
	
	private void editProduct(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, IOException, ServletException
		{
			int id = Integer.parseInt(request.getParameter("id"));
		    String title = request.getParameter("title");
		    String quantity = request.getParameter("quantity");
		    String size = request.getParameter("size");
		    //extra
		    Part part = request.getPart("image");
			String filename = part.getSubmittedFileName();
		    System.out.println(filename);
			InputStream is = null;
			if(part!=null)
			{
				is = part.getInputStream();
			}
			byte[] data = new byte[is.available()];
			is.read(data);
		    Product prod = new Product(id, title, quantity, size,data);
		    ProductDAO.EditProduct(prod);
		    response.sendRedirect("Product.jsp");
		}
    
/*	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Product> allproducts;
    //  allproducts = prodobj.getAllProducts(usernametobepassed);
		request.setAttribute("allproducts", allproducts);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
        dispatcher.forward(request, response);
	}*/
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Product> allproducts;
		allproducts = prodobj.getAllProducts();
		request.setAttribute("allproducts", allproducts);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
        dispatcher.forward(request, response);
	}
}
