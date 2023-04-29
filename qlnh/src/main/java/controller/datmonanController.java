package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.taikhoanbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class datmonanController
 */
@WebServlet("/datmonanController")
public class datmonanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datmonanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			taikhoanbean kh = (taikhoanbean) session.getAttribute("dn");
			if (kh == null)
				response.sendRedirect("dangnhapController");
			else {
				hoadonbo hdbo = new hoadonbo();
				chitiethoadonbo ctbo = new chitiethoadonbo();
				giohangbo gh = (giohangbo) session.getAttribute("gio");
				// Tao ra 1 hoa don
				hdbo.Them(kh.getMatk());
				long maxmahd = hdbo.maxhd();
				// Tao ra cac chi tiet hoa don
				for (giohangbean g : gh.ds)
					ctbo.Them(g.getMamonan(), g.getSoluong(), maxmahd);
				session.removeAttribute("gio");
				response.sendRedirect("lichsumuahangController");
			}

		} catch (Exception e) {
			System.out.println("lỗi:"+e.getMessage());
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
