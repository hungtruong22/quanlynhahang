package bo;

import java.util.ArrayList;
import java.util.Collection;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds=
			   new ArrayList<giohangbean>();
	   public void GHThem(String mamonan, String tenmonan, long soluong, long gia , String anh) {
		   for(giohangbean h: ds)
			   if(h.getMamonan().equals(mamonan)) {
				   h.setSoluong(h.getSoluong()+ soluong);
				   return;
			   }
		   ds.add(new giohangbean(mamonan, tenmonan, soluong, gia, anh));
	   }
	   public long Tongtien() {
		   long s=0;
		   for(giohangbean h: ds)
			   s=s+h.getThanhtien();
		   return s;
	   }

	   public void GHXoa(String mamonan) {
		  
		   for(giohangbean h: ds)
			   if(h.getMamonan().equals(mamonan)) {
				   ds.remove(h);
				   return;
	   }
	   
	   }
}
