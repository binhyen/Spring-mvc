<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>

<body>
	<%-- <h1>Home page</h1>
	<h1>Menu</h1>
	<jsp:include page="menu.jsp">
	<jsp:param value="${menu }" name="menu"/>
</jsp:include>
	<%@ include file="menu.jsp"%> --%>
	<div class="container">
		
		<!-- Heading Row -->
		<div class="row align-items-center my-5">
			<div class="col-lg-7">
				<img class="img-fluid rounded mb-4 mb-lg-0"
					src="https://cdn.bongdaplus.vn/Assets/Media/2020/02/10/70/de-jong.jpg" alt="">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light">Business Name or Tagline</h1>
				<p>This is a template that is great for small businesses. It
					doesn't have too much fancy flare to it, but it makes a great use
					of the standard Bootstrap core components. Feel free to use this
					template for any project you want!</p>
				<a class="btn btn-primary" href="#">Call to Action!</a>
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				<p class="text-white m-0">This call to action card is a great
					place to showcase some important information or display a clever
					tagline!</p>
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			<%-- <c:forEach items="${model}" var="item">
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<div class="card-body">
							<h2 class="card-title">${item.title}</h2>
							<p class="card-text">${item.shortDescription}</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary btn-sm">Chi tiết</a>
						</div>
					</div>
				</div>
				<!-- /.col-md-4 -->
			</c:forEach> --%>
			<c:forEach items="${model}" var="item">
				<div class="col-md-4 mb-5">
					<div class="card h-100">
					
						<a href="<c:url value='/news/detail'/>">
								<img class="card-img-top" src="https://cdn.bongdaplus.vn/Assets/Media/2020/02/10/70/de-jong.jpg" alt="hi">
							</a>	
						<div class="card-body">
							
							<h4 class="card-title">${item.title}</h4>
							<p class="card-text">${item.shortDescription}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!-- /.row -->

	</div>
</body>

</html>