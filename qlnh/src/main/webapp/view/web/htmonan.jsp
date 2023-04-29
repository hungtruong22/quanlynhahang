<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cảng Restaurant</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<style>
.pd-top-100 {
	padding-top: 100px;
}

.ps-fixed {
	position: fixed;
	width: 100%;
	z-index: 1000;
	box-shadow: 2px 2px 4px #000;
}

.text-color {
	color: #f1a21f !important;
	font-weight: 500;
}

.list-cate:hover {
	background-color: #007bff;
	cursor: pointer;
	transition: all 0.8s;
}

.cate-link {
	text-decoration: none !important;
}

.anh {
	width: 100%;
	height: 140px;
}

.can {
	width: 100%;
	height: 320px;
	margin-bottom: 12px;
}
.logo-cang{
	width: 100%;
	height: 70px;
	background-size: cover; 
}
.banner{
	width: 100%;
	height: 200px;
	object-fit: center;
}
.dc{
	display: flex;
	justify-content: center;
	align-items: center;
	position: absolute;
	top: 10rem;
	left: 0;
	right: 0;
	text-align: center;
	margin: 0 auto;
	color: white;
	flex-direction: column;
	width: 100%;
}
.canle{
	padding: 6rem 2rem 1rem 2rem;
	position: relative;
}
</style>
<body>
	<!--begin of menu-->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark ps-fixed">
		<div class="container">
			<a class="navbar-brand" href="htmonan">
				<img class="logo-cang" alt="logocang" src="./anhcang/cang.jpg">
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
							href="quanlytaikhoanController">QL TK</a></li>
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
	<section class="jumbotron text-center pd-top-100 canle">
		<div class="container">
			<img class="banner" alt="" src="./anhcang/banner.jpg">
			<div class="dc">
				<h1 class="jumbotron-heading">Cảng Restaurant</h1>
				<p style="color: white!important; font-weight: 400;" class="lead text-muted mb-0">Uy tín tạo nên thương hiệu</p>
			</div>
		</div>
	</section>
	<!--end of menu-->

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<li class="list-group-item text-white list-cate"><a
							class="text-color cate-link" href="htmonan">Tất cả Món ăn</a></li>

						<c:forEach items="${dsloai}" var="l">
							<c:if test="${maloai == l.maloai}">
								<li class="list-group-item text-white list-cate active"><a
									class="text-color cate-link"
									href="danhmucController?maloai=${l.maloai}">${l.tenloai}</a></li>
							</c:if>
							<c:if test="${maloai != l.maloai}">
								<li class="list-group-item text-white list-cate"><a
									class="text-color cate-link"
									href="danhmucController?maloai=${l.maloai}">${l.tenloai}</a></li>
							</c:if>
						</c:forEach>

					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Món ăn mới</div>
					<div class="card-body">
						<img class="img-fluid" src="${last.anh}" />
						<h5 class="card-title">${last.tenmonan}</h5>
						<p class="bloc_left_price">${last.gia}vnđ</p>
					</div>
				</div>
			</div>

			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${dsmonan}" var="s">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card can">
								<img class="card-img-top anh" src="${s.anh}"
									alt="Card image cap">
								<div class="card-body">
									<h4 class="card-text">
										<a href="maid=${s.mamonan}"
											title="View Product">${s.tenmonan} </a>
									</h4>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block">${s.gia}vnđ</p>
										</div>
										<div class="col">
											<a
												href="giohangController?mamonan=${s.mamonan}&tenmonan=${s.tenmonan}&gia=${s.gia}&anh=${s.anh}"
												class="btn btn-success btn-block">Đặt món ăn</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:forEach begin="1" end="${endPage}" var="i">
							<c:if test="${tag==i}">
								<li class="page-item active"><a class="page-link"
									href="htmonan?trang=${i}">${i}</a></li>
							</c:if>
							<c:if test="${tag != i}">
								<li class="page-item"><a class="page-link"
									href="htmonan?trang=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</nav>

			</div>
		</div>

	</div>

	<!-- Footer -->
	<footer style="background-color: #343a40; margin-top: 24px"
		class="text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-4 col-xl-3">
					<h5>About</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<p class="mb-0">Le Lorem Ipsum est simplement du faux texte
						employé dans la composition et la mise en page avant impression.</p>
				</div>

				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
					<h5>Informations</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><a href="">Link 1</a></li>
						<li><a href="">Link 2</a></li>
						<li><a href="">Link 3</a></li>
						<li><a href="">Link 4</a></li>
					</ul>
				</div>

				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
					<h5>Others links</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><a href="">Link 1</a></li>
						<li><a href="">Link 2</a></li>
						<li><a href="">Link 3</a></li>
						<li><a href="">Link 4</a></li>
					</ul>
				</div>

				<div class="col-md-4 col-lg-3 col-xl-3">
					<h5>Contact</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><i class="fa fa-home mr-2"></i> My company</li>
						<li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
						<li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
						<li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
					</ul>
				</div>
				<div class="col-12 copyright mt-3">
					<p class="float-left">
						<a href="#">Back to top</a>
					</p>

				</div>
			</div>
		</div>
	</footer>
</body>
</html>

