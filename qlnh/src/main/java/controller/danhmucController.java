package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.monanbean;
import bo.loaibo;
import bo.monanbo;

/**
 * Servlet implementation class danhmucController
 */
@WebServlet("/danhmucController")
public class danhmucController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public danhmucController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
		String maloai = request.getParameter("maloai");
		// da lay dc danh muc 
		monanbo sbo = new monanbo();
		loaibo lbo = new loaibo();
		ArrayList<monanbean> list = sbo.getMonanByCategory(maloai);
		request.setAttribute("dsmonan", list);
		 ArrayList<loaibean> dsloai = lbo.getloai();
	     request.setAttribute("dsloai", dsloai);
	     monanbean last = sbo.getNewFood();
	     request.setAttribute("last", last);
	     request.setAttribute("maloai", maloai);
	     
	     
		 RequestDispatcher rd = request.getRequestDispatcher("./view/web/htmonan.jsp");
	     rd.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
