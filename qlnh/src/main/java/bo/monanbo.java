package bo;

import java.util.ArrayList;

import bean.monanbean;
import dao.monandao;

public class monanbo {
	monandao madao= new monandao();
	   ArrayList<monanbean> ds;
	   public ArrayList<monanbean> getMonan(){
		   ds=madao.getMonan();
		   return ds;
	   }
	   public monanbean getNewFood() {
		   return madao.getNewFood();
	   }
	   public ArrayList<monanbean> getMonanByCategory(String loaiid){
		   return madao.getMonanByCategory(loaiid);
	   }
	   public monanbean getMonanById(String id) {
		   return madao.getMonanById(id);
	   }
	   public ArrayList<monanbean> searchByName(String tma){
		   return madao.searchByName(tma);
	   }
	   public void xoa(String monanid) {
		   madao.xoa(monanid);
	   }
	   public void them(String mamonan, String tenmonan, Long gia
				, String anh, String maloai) {
		   madao.them(mamonan, tenmonan, gia, anh, maloai);
	   }
	   public void sua(String mamonan, String tenmonan, Long gia
				, String anh, String maloai) {
		   madao.sua(mamonan, tenmonan, gia, anh, maloai);
	   }
	   public int getTotalFood() {
		   return madao.getTotalFood();
	   }
	   public ArrayList<monanbean> pagingFood(int index){
		   return madao.pagingFood(index);
	   }
	   
	   public static void main(String[] args) {
		 monanbo sbo = new monanbo();
		 ArrayList<monanbean> ds = sbo.pagingFood(1);
		 for(monanbean s: ds) {
			 System.out.println(s);
		 }
	}
}
