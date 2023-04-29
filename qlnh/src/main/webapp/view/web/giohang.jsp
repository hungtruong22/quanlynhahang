<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ hàng</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<style>
.logo-cang{
	width: 100%;
	height: 70px;
	background-size: cover; 
}
</style>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark ps-fixed">
		<div class="container">
			<a class="navbar-brand" href="htmonan"> <img class="logo-cang"
				alt="logocang" src="./anhcang/cang.jpg">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<c:if test="${dn.laquanly == true}">
						<li class="nav-item"><a class="nav-link" href="#">Tài
								khoản Admin</a></li>
						<li class="nav-item"><a class="nav-link"
							href="quanlymonanController">QL Món Ăn</a></li>
						<li class="nav-item"><a class="nav-link"
							href="quanlyloaiController">QL Loại</a></li>
						<li class="nav-item"><a class="nav-link"
							href="xacnhanController">Xác nhận</a></li>
						<li class="nav-item"><a class="nav-link"
							href="danhsachchuyentienController">KH chuyển tiền</a></li>
						<li class="nav-item"><a class="nav-link"
							href="thongkeController">Thống kê</a></li>
					</c:if>
					<c:if test="${dn.lanhanvien == true}">
						<li class="nav-item"><a class="nav-link" href="#">Tài
								khoản Nhân Viên</a></li>
						<li class="nav-item"><a class="nav-link" href="htgio">Đặt
								món</a></li>
						<li class="nav-item"><a class="nav-link"
							href="lichsumuahangController">Lịch sử mua hàng</a></li>
					</c:if>

					<c:if test="${dn != null}">
						<li class="nav-item"><a class="nav-link" href="#">Hello
								${dn.tendn}</a></li>
						<li class="nav-item"><a class="nav-link"
							href="dangxuatController">Logout</a></li>
					</c:if>
					<c:if test="${dn == null}">
						<li class="nav-item"><a class="nav-link"
							href="dangnhapController">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Signup</a>
						</li>
					</c:if>
				</ul>

				<form action="timkiemController" method="post"
					class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm">
						<input value="${tk}" name="txttk" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Search...">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</nav>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<form action="suaxoa" method="post">
									<table class="table">
										<thead>
											<tr>
												<th scope="col" class="border-0 bg-light">
													<div class="p-2 px-3 text-uppercase">Chọn</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="p-2 px-3 text-uppercase">Mã MA</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="py-2 text-uppercase">Tên MA</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="py-2 text-uppercase">Ảnh</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="py-2 text-uppercase">Giá</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="py-2 text-uppercase">Số lượng</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="p-2 px-3 text-uppercase">Sửa số lượng</div>
												</th>
												<th scope="col" class="border-0 bg-light">
													<div class="p-2 px-3 text-uppercase">Thành tiền</div>
												</th>
											</tr>
										</thead>
										<tbody>
											<p style="display: none;">
												<c:out value="gstt"></c:out>
											</p>
											<p style="display: none;">
												<c:out value="demsl"></c:out>
											</p>
											<c:forEach items="${ds}" var="h" varStatus="stt">
												<tr>
													<p style="display: none">${stt.count}</p>
													<p style="display: none" name="stt">${gstt = gstt + stt.count}</p>

													<td><input type="checkbox" name="butcheck"
														value="${h.getMamonan()}"></td>
													<td>${h.getMamonan()}</td>
													<td>${h.getTenmonan()}</td>
													<td><img class="card-img-top" src="${h.anh}"></td>
													<td>${h.getGia()}</td>
													<td>${h.getSoluong()}</td>
													<p style="display: none">${demsl = demsl+ h.getSoluong()}</p>
													<td><input type="number" min="0"
														name="txt${h.getMamonan()}">
														<button type="submit" name="butsua"
															value="${h.getMamonan()}">Update</button>
														<button type="submit" name="butxoa"
															value="${h.getMamonan()}">Delete</button></td>
													<td>${h.getThanhtien()}</td>

												</tr>

											</c:forEach>

										</tbody>
									</table>
								</form>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">
						<!--<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
							<div class="p-4">
								<div class="input-group mb-4 border rounded-pill p-2">
									<input type="text" placeholder="Nhập Voucher"
										aria-describedby="button-addon3" class="form-control border-0">
									<div class="input-group-append border-0">
										<button id="button-addon3" type="button"
											class="btn btn-dark px-4 rounded-pill">
											<i class="fa fa-gift mr-2"></i>Sử dụng
										</button>
									</div>
								</div>
							</div>
						</div>-->
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>
							<div class="p-4">
								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng tiền</strong><strong>${tongtien}
											vnđ</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng số lượng</strong><strong>
											${demsl}</strong></li>
									<!--<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí vận chuyển</strong><strong>Free
											ship</strong></li>-->
									<% long gantt = 0;
											%>
									<c:if test="${demsl < 3}">
										<li class="d-flex justify-content-between py-3 border-bottom"><strong
											class="text-muted">Giá Khuyến mãi</strong><strong>${gantt =0}
												vnđ</strong></li>
									</c:if>
									<c:if test="${demsl >= 3 && demsl <= 10}">
										<li class="d-flex justify-content-between py-3 border-bottom"><strong
											class="text-muted">Giá Khuyến mãi</strong> <strong>${gantt = tongtien*(20/100)}
												vnđ</strong></li>
									</c:if>
									<c:if test="${demsl > 10}">
										<li class="d-flex justify-content-between py-3 border-bottom"><strong
											class="text-muted">Giá Khuyến mãi</strong> <strong>${gantt = tongtien*(30/100)}
												vnđ</strong></li>

									</c:if>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng thanh toán</strong>
										<h5 class="font-weight-bold">${tongtien-gantt}vnđ</h5></li>
								</ul>
								<a href="datController"
									class="btn btn-dark rounded-pill py-2 btn-block">Đặt món</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>