package bo;

import java.util.ArrayList;

import bean.taikhoanbean;
import dao.taikhoandao;

public class taikhoanbo {
	taikhoandao tkdao = new taikhoandao();
	ArrayList<taikhoanbean> ds;
	public ArrayList<taikhoanbean> getTK(){
		   ds=tkdao.getTK();
		   return ds;
	   }
	public taikhoanbean login(String user, String pass) {
		   return tkdao.login(user, pass);
	   }
	public taikhoanbean kiemtrataikhoantontai(String user) {
		   return tkdao.kiemtrataikhoantontai(user);
	   }   
	public void signup(String user, String pass) {
		 tkdao.signup(user, pass);
	}
	
	public static void main(String[] args) {
		taikhoanbo tkbo = new taikhoanbo();
		tkbo.login("minhhung", "123");
	}
}
