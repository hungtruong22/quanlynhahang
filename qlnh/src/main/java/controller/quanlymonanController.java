package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;
import bo.monanbo;
import bean.monanbean;
/**
 * Servlet implementation class quanlymonanController
 */
@WebServlet("/quanlymonanController")
public class quanlymonanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlymonanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		monanbo sbo = new monanbo();
		loaibo lbo = new loaibo();
		HttpSession session = request.getSession();
		if (session.getAttribute("dn") == null)
			response.sendRedirect("dangnhapController");
		else {
			ArrayList<monanbean> dsmonan = sbo.getMonan();
			request.setAttribute("dsmonan", dsmonan);

			String indexPage = request.getParameter("trang");

			if (indexPage == null) {
				indexPage = "1";
			}
			int trang = Integer.parseInt(indexPage);

			// b1: lấy về tổng số sữa có trong csdl
			int dem = sbo.getTotalFood();

			int endPage = dem / 6;
			if (dem % 3 != 0) {
				endPage++;
			}

			ArrayList<monanbean> dstrang = sbo.pagingFood(trang);
			request.setAttribute("dstrang", dstrang);

			request.setAttribute("endPage", endPage);
			request.setAttribute("tag", trang);

			RequestDispatcher rd = request.getRequestDispatcher("./view/admin/quanlymonan.jsp");
			rd.forward(request, response);
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
