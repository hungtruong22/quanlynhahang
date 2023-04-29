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

import bean.loaibean;
import bo.giohangbo;
import bo.loaibo;
import bo.monanbo;

/**
 * Servlet implementation class htgio
 */
@WebServlet("/htgio")
public class htgio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loaibo lbo = new loaibo();
		monanbo mabo = new monanbo();
		
		 ArrayList<loaibean> dsloai = new ArrayList<loaibean>();
			dsloai = lbo.getloai();
			request.setAttribute("dssloai", dsloai);
			giohangbo gh;
			HttpSession session = request.getSession();
			if(session.getAttribute("gio")==null){
				gh=new giohangbo();
				session.setAttribute("gio", gh);
			}
			
			gh = (giohangbo)session.getAttribute("gio");
			
			request.setAttribute("ds", gh.ds);
			request.setAttribute("tongtien", gh.Tongtien());
			
			 RequestDispatcher rd = request.getRequestDispatcher("./view/web/giohang.jsp");
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
