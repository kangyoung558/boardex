<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../includes/header.jsp" />
<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.
	</p>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 mt-2 font-weight-bold text-primary float-left">Board
				List</h6>
			<a href="register" class="btn btn-sm btn-primary float-right">writer</a>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
					<div class="row">
						<div class="col-sm-12 col-md-6">
							<div class="dataTables_length" id="dataTable_length">
								<label>Show 
									<select id="amountNumber" name="dataTable_length"  class="custom-select custom-select-sm form-control form-control-sm">
										<option value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select> entries
								</label>
							</div>
						</div>
						<div class="col-sm-12 col-md-6">
							<div id="dataTable_filter" class="dataTables_filter dataTables_length">
								<form id="searchForm">
								<label>Search : 
									<select id="searchMenu" name="type"  class="custom-select custom-select-sm form-control form-control-sm">
										<option value="">--</option>
										<option value="T">제목</option>
										<option value="C">내용</option>
										<option value="W">작성자</option>
										<option value="TC">제목 or 내용</option>
										<option value="TW">제목 or 작성자</option>
										<option value="CW">내용 or 작성자</option>
										<option value="TCW">제목 or 내용 or 작성자</option>
									</select> entries
									<input type="search" name="keyword" class="form-control form-control-sm mr-1" placeholder="" aria-controls="dataTable">
									<button  class="btn btn-sm btn-facebook float-right">search</button>
								</label>
								<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
        						<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
								</form>
							</div>
						</div>
					</div>
					<div class="row">
						<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>수정일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="board">
									<tr>
										<td>${board.bno}</td>
										<td><a href="get${pageMaker.cri.listLink}&bno=${board.bno}"><c:out value="${board.title}" /><span class="text-muted ml-1">[${board.replyCnt}]</span></a></td>
										<td><c:out value="${board.writer}" /></td>
										<td><fmt:formatDate value="${board.regdate}" /></td>
										<td><fmt:formatDate value="${board.updateDate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-5">
							<div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">Showing ${list[0].bno} to ${list[pageMaker.cri.amount-1].bno} of ${pageMaker.total} entries</div>
						</div>
						<div class="col-sm-12 col-md-7">
							<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
								<ul class="pagination">
									<c:if test="${pageMaker.prev}"> 
										<li class="paginate_button page-item previous" id="dataTable_previous">
											<a href="list${pageMaker.cri.listLink2}&pageNum=${pageMaker.startPage - 1}" aria-controls="dataTable" tabindex="0" class="page-link">Prev</a>
										</li>
									</c:if>
									<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
										<li class="paginate_button page-item ${num == pageMaker.cri.pageNum ? 'active' : ''}" >
											<a href="list${pageMaker.cri.listLink2}&pageNum=${num}" aria-controls="dataTable" tabindex="0" class="page-link">${num}</a>
										</li>
									</c:forEach>
									<c:if test="${pageMaker.next}">
										<li class="paginate_button page-item next" id="dataTable_next">
											<a href="list${pageMaker.cri.listLink2}&pageNum=${pageMaker.endPage + 1}" aria-controls="dataTable" tabindex="0" class="page-link">Next</a>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- /.container-fluid -->

</div>
<!--Result Modal-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="myModalLabel">Alert</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		var result = '${result}';

		checkModal(result);
		history.replaceState({}, null, null);
		function checkModal(result) {
			if (result === '' || history.state) {
				return;
			}
			if (parseInt(result) > 0) {
				$(".modal-body").html("게시글" + result + "번 게시글이 등록 되었습니다");
			}
			$("#myModal").modal("show");
		}
		$("#amountNumber").change(function() {
			console.log(location);
			location.href = "list${pageMaker.cri.listLink3}&amount=" + $(this).val();
		}).val('${pageMaker.cri.amount}');
		
		$("#searchMenu").val('${pageMaker.cri.type}')
			.next().val('${pageMaker.cri.keyword}')
	});
</script>
<!-- End of Main Content -->

<jsp:include page="../includes/footer.jsp" />
