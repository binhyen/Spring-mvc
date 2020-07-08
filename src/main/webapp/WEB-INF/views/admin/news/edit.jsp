<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<c:url var="APIurl" value="/api/news"></c:url>
<c:url var="NEWurl" value="/quan-tri/bai-viet/danh-sach"></c:url>
<c:url var="EDITurl" value="/quan-tri/bai-viet/chinh-sua"></c:url>
<!DOCTYPE html>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>
	
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Home</a>
					</li>
	
					<li>
						<a href="#">Forms</a>
					</li>
					<li class="active">Form Elements</li>
				</ul><!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<!-- <div class="page-header">
					<h1>
						Form Elements
						<small>
							<i class="ace-icon fa fa-angle-double-right"></i>
							Common form elements and layouts
						</small>
					</h1>
				</div> -->
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
								${messageResponse}
							</div>
						</c:if>
						
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="categoryCode">Thể loại:</label>
								<div class="col-sm-9">
								<%-- <select class="col-xs-10 col-sm-5" id="categoryCode" name="categoryCode">
									<option value="">Chọn thể loại</option>
									<c:forEach items="categories" var="item">
										<option value="${item.code}">${item.name}</option>
									</c:forEach>
								</select> --%>
									<form:select path="categoryCode" id="categoryCode">
										<form:option value="" label="--Chọn thể loại--"/>
										<form:options items="${categories}"/>
									</form:select>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="title">Tên bài viết</label>
								<div class="col-sm-9">
									<%-- <input type="text" id="title" name="title" value="${model.title}"  class="col-xs-10 col-sm-5"> --%>
									<form:input type="text" id="title" path="title" class="col-xs-10 col-sm-5"/>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="thumbnail">Ảnh đại diện</label>
								<div class="col-sm-9">
									<input type="file" id="thumbnail" name="thumbnail">
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="shortDescription">Mô tả ngắn</label>
								<div class="col-sm-9">
									<form:textarea id="shortDescription" path="shortDescription" rows="4" cols="50"/>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="content">Nội dung</label>
								<div class="col-sm-9">
									<form:textarea id="content" path="content" rows="4" cols="50"/>
								</div>
							</div>
							
							<div class="space-4"></div>
							<form:hidden path="id" id="newId"/>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" id="btnAddOrUpdateNews">
										<i class="ace-icon fa fa-check bigger-110"></i>
										<c:if test="${not empty model.id}">
											Cập nhật bài viết
										</c:if>
										<c:if test="${empty model.id}">
											Thêm bài viết
										</c:if>
										
									</button>
	
									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										Hủy
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#btnAddOrUpdateNews').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();

			$.each(formData, function(i,v){
				data[""+v.name+""] = v.value;
			});
			var id = $('#newId').val();
			if (id == "") {
				addNews(data);
			} else {
				updateNews(data);
			}
		});

		function addNews(data) {
	        $.ajax({
	            url:'${APIurl}',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	                window.location.href = "${EDITurl}?id="+result.id+"&message=insert_success";
	            },
	            error: function (error) {
	                window.location.href = "${NEWurl}?page=1&limit=2&message=error_system";
	            }
	        })
	    }
	    function updateNews(data) {
	        $.ajax({
	            url:'${APIurl}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	                console.log(result);
	                window.location.href = "${EDITurl}?id="+result.id+"&message=update_success";
	            },
	            error: function (error) {
	                console.log(error);
	                window.location.href = "${EDITurl}?id="+result.id+"&message=error_system";
	            }
	        })
	    }
	</script>
</body>
</html>