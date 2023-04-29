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
 * Servlet implementation class htmonan
 */
@WebServlet("/htmonan")
public class htmonan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htmonan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setCharacterEncoding("utf-8");
	     monanbo mabo = new monanbo();
	     loaibo lbo = new loaibo();
	     ArrayList<loaibean> dsloai = lbo.getloai();
	     request.setAttribute("dsloai", dsloai);
	     ArrayList<monanbean> dsmonan = mabo.getMonan();
	     request.setAttribute("dsmonan", dsmonan);
	     monanbean last = mabo.getNewFood();
	     request.setAttribute("last", last);
	     
	     String indexPage = request.getParameter("trang");
	     
	     	if(indexPage == null) {
	     		indexPage = "1";
	     	}
	     int trang = Integer.parseInt(indexPage);
	     
	     //b1: lấy về tổng số sữa có trong csdl
	     int dem = mabo.getTotalFood();
			
			int endPage = dem/6;
			if(dem % 3 != 0) {
				endPage++;
			}
			
			ArrayList<monanbean> dstrang = mabo.pagingFood(trang);
			request.setAttribute("dstrang", dstrang);
			
			request.setAttribute("endPage", endPage);
			request.setAttribute("tag", trang);
			
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
