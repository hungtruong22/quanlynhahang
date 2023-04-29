package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();
	 public int Them(String tkid) {
		 return hddao.Them(tkid);
	 }
		 public long maxhd() {
			 return hddao.maxhd();
		 }
		 public static void main(String[] args) {
			hoadonbo hdbo = new hoadonbo();
			System.out.println(hdbo.Them(null));
		}	 
}
