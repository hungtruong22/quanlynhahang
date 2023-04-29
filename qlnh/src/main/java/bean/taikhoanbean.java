package bean;

public class taikhoanbean {
	private String matk;
	private String tendn;
	private String matkhau;
	private boolean lanhanvien;
	private boolean laquanly;
	public taikhoanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public taikhoanbean(String matk, String tendn, String matkhau, boolean lanhanvien, boolean laquanly) {
		super();
		this.matk = matk;
		this.tendn = tendn;
		this.matkhau = matkhau;
		this.lanhanvien = lanhanvien;
		this.laquanly = laquanly;
	}
	public String getMatk() {
		return matk;
	}
	public void setMatk(String matk) {
		this.matk = matk;
	}
	public String getTendn() {
		return tendn;
	}
	public void setTendn(String tendn) {
		this.tendn = tendn;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public boolean isLanhanvien() {
		return lanhanvien;
	}
	public void setLanhanvien(boolean lanhanvien) {
		this.lanhanvien = lanhanvien;
	}
	public boolean isLaquanly() {
		return laquanly;
	}
	public void setLaquanly(boolean laquanly) {
		this.laquanly = laquanly;
	}
	@Override
	public String toString() {
		return "taikhoanbean [matk=" + matk + ", tendn=" + tendn + ", matkhau=" + matkhau + ", lanhanvien=" + lanhanvien
				+ ", laquanly=" + laquanly + "]";
	}
	
	
	
}
