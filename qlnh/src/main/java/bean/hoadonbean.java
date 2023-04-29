package bean;

import java.util.Date;

public class hoadonbean {
	private String mahd;
	private String matk;
	private Date ngaydat;
	private boolean dadat;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(String mahd, String matk, Date ngaydat, boolean dadat) {
		super();
		this.mahd = mahd;
		this.matk = matk;
		this.ngaydat = ngaydat;
		this.dadat = dadat;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public Date getNgaydat() {
		return ngaydat;
	}
	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}
	public boolean isDadat() {
		return dadat;
	}
	public void setDadat(boolean dadat) {
		this.dadat = dadat;
	}
	@Override
	public String toString() {
		return "hoadonbean [mahd=" + mahd + ", matk=" + matk + ", ngaydat=" + ngaydat + ", dadat=" + dadat + "]";
	}
	
	
}
