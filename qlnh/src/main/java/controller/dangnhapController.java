package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.taikhoanbean;
import bo.taikhoanbo;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		suabo sbo = new suabo();
//		loaibo lbo = new loaibo();
		taikhoanbo tkbo = new taikhoanbo();
		String tendn = request.getParameter("user");
		String matkhau = request.getParameter("pass");
		
		taikhoanbean dn = tkbo.login(tendn, matkhau);
		if(dn == null) {
			request.setAttribute("thongbaoloi", "Đăng nhập sai!");
			RequestDispatcher rd = request.getRequestDispatcher("./view/web/dangnhap.jsp");
		       rd.forward(request, response);
		       
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("dn", dn);
			response.sendRedirect("htmonan");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
