package bo;

import java.util.ArrayList;

import bean.loaibean;
import bean.monanbean;
import dao.loaidao;


public class loaibo {
	loaidao ldao = new loaidao();
	   ArrayList<loaibean> ds;
	   public ArrayList<loaibean> getloai(){
		   ds=ldao.getloai();
		   return ds;
	   }
	   public loaibean getLoaiById(String id) {
		   return ldao.getLoaiById(id);
	   }
	   public void xoa(String loaiid) {
		   ldao.xoa(loaiid);
	   }
	   public void them(String maloai, String tenloai) {
		   ldao.them(maloai, tenloai);
	   }
	   public void sua(String maloai, String tenloai) {
		   ldao.sua(maloai, tenloai);
	   }
	   public int getTotalLoai() {
		   return ldao.getTotalLoai();
	   }
	   public ArrayList<loaibean> pagingLoai(int index){
		   return ldao.pagingLoai(index);
	   }
	   public static void main(String[] args) {
		loaibo lbo = new loaibo();
		System.out.println(lbo.getTotalLoai());
	}
}
