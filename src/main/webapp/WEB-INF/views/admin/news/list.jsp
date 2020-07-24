<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/news"></c:url>
<c:url var="NEWurl" value="/quan-tri/bai-viet/danh-sach"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
	<form action="<c:url value='/quan-tri/bai-viet/danh-sach'></c:url>" id="formSubmit" method="get">
	    <div class="main-content-inner">
	        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
	            <ul class="breadcrumb">
	                <li>
	                    <i class="ace-icon fa fa-home home-icon"></i>
	                    <a href="#">Trang chủ</a>
	                </li>
	            </ul><!-- /.breadcrumb -->
	        </div>
	        <div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
										${messageResponse}
							</div>
						</c:if>
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<c:url var="createNewsURL" value="/quan-tri/bai-viet/chinh-sua"/>
										<a flag="info"
										   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
										   title='Thêm bài viết' href='${createNewsURL}'>
											<span>
												<i class="fa fa-plus-circle bigger-110 purple"></i>
												<!-- <i class="fas fa-plus-circle"></i> -->
											</span>
										</a>
										<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
											<span>
												<i class="fa fa-trash-o bigger-110 pink"></i>
											</span>
										</button>
									</div>
								</div>
							</div>
						</div>
			            <div class="row" >
			                <div class="col-xs-12">
								<div class="table-responsive">
			                        <table class="table table-bordered">
			                            <thead>
			                                <tr>
												<th><input type="checkbox" name="" id="checkAll"></th>
			                                    <th>Tên bài viết</th>
			                                    <th>Mô tả ngắn</th>
			                                    <th>Thao tác</th>
			                                </tr>
			                            </thead>
			                            <tbody>
				                            <c:forEach var="item" items="${model.listModel}">
				                            	<tr>
													<td><input type="checkbox"  value="${item.id}" id="checkbox_${item.id}"></td>
				                                    <td>${item.title}</td>
				                                    <td>${item.shortDescription}</td>
				                                    <td>
				                                    	<c:url var="updateNewsURL" value="/quan-tri/bai-viet/chinh-sua">
															<c:param name="id" value="${item.id}"/>
														</c:url>
														<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
														   title="Cập nhật bài viết" href='${updateNewsURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
													</td>
				                                </tr>
				                            </c:forEach>
			                            </tbody>
			                          </table>
			                          <div align="center">
			                          	<ul class="pagination" id="pagination"></ul>
			                          	<input type="hidden" value="" id="page" name="page"/>
										  <input type="hidden" value="" id="limit" name="limit"/>
			                          </div>
								</div>
			                </div>
			            </div>
	            	</div>
				</div>
	        </div>
	    </div>	
	</form>
</div><!-- /.main-content -->
<script type="text/javascript">
	var curentPage = ${model.page};
	var totalPages = ${model.totalPage};
	var limit = ${model.limit};
	$(function () {
	    window.pagObj = $('#pagination').twbsPagination({
	        totalPages: totalPages,
	        visiblePages: limit,
	        startPage: curentPage,
	        onPageClick: function (event, page) {
				if (curentPage != page) {
					$('#limit').val(limit);
					$('#page').val(page);
	                $('#formSubmit').submit();
				}
	        }
	    });
	});

   /* 
    $('#btnDelete').click(function(){
        var data = {};
    	var ids = $('tbody input[type=checkbox]:checked').map(function(){
    		return $(this).val();
        }).get();
    	data["ids"] = ids;
    }); */
   
	
	function warningBeforeDelete() {
		swal({
		  title: "Xác nhận xóa",
		  text: "Bạn có chắc chắn muốn xóa hay không?",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonClass: "btn-success",
		  cancelButtonClass: "btn-danger",
		  confirmButtonText: "Xác nhận",
		  cancelButtonText: "Hủy",
		}).then(
		function(isConfirm) {
			console.log(isConfirm.value);
		  if (isConfirm.value) {
	    	var ids = $('tbody input[type=checkbox]:checked').map(function(){
	    		return $(this).val();
	        }).get();
	    	deleteNews(ids);
		  }
		});
	}
	
	function deleteNews(data) {
        $.ajax({
            url:'${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
				window.location.href = "${NEWurl}?page=1&limit=2&message=delete_success";
            },
            error: function (error) {
                window.location.href = "${NEWurl}?page=1&limit=2&message=error_system";
            }
        })
        
    }
</script>
</body>
</html>