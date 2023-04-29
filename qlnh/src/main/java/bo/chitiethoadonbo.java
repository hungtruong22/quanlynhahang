package bo;

import java.sql.PreparedStatement;

import dao.KetNoi;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao= new chitiethoadondao();
	  public int Them(String mamonan, long soluongdat, long maxmahd) {
		  return ctdao.Them(mamonan, soluongdat, maxmahd);
	  }
}
