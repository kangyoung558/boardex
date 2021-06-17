<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../includes/header.jsp"/>

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
				    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
				    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
				    	For more information about DataTables, please visit the 
				    <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>
				
				     <!-- DataTales Example -->
				     <div class="card shadow mb-4">
				     	<div class="card-header py-3 post-heading">
				        	<h6 class="m-0 font-weight-bold text-primary">Board View</h6>
				        </div>
				        <div class="card-body">
				        	<form action="" method="post" class="needs-validation" novalidate>
				        		<div class="form-group my-5">
				    				<label for="bon" class="font-weight-bold text-warning">bno</label>
				    				<input type="text" class="form-control"  id="bon" name="bon" required value="${board.bno}" readonly>
				    				<div class="valid-feedback">Valid.</div>
				       				<div class="invalid-feedback">Check this checkbox to continue.</div>
				  				</div>
				        		
				            	<div class="form-group my-5">
				    				<label for="title" class="font-weight-bold text-warning">title</label>
				    				<input type="text" class="form-control" placeholder="게시글 제목을 입력하세요" id="title" name="title" required value="${board.title}" readonly>
				    				<div class="valid-feedback">Valid.</div>
				       				<div class="invalid-feedback">Check this checkbox to continue.</div>
				  				</div>
				                <div class="form-group my-5">
				    				<label for="content" class="font-weight-bold text-warning">content</label>
				    				<textarea class="form-control" rows="10" placeholder="게시글 내용을 입력하세요" id="content" name="content" required readonly>${board.content}</textarea>
				    				<div class="valid-feedback">Valid.</div>
				       				<div class="invalid-feedback">Check this checkbox to continue.</div>
				  				</div>
				                <div class="form-group my-5">
				    				<label for="writer" class="font-weight-bold text-warning">writer</label>
				    				<input type="text" class="form-control" placeholder="작성자을 입력하세요" id="writer" name="writer" required value="${board.writer}" readonly>
				    				<div class="valid-feedback">Valid.</div>
				       				<div class="invalid-feedback">Check this checkbox to continue.</div>
				  				</div>
								<a href="list${cri.listLink}" data-oper="list" class="btn btn-outline-info float-right">List</a>
				  				<a href="modify${cri.listLink}&bno=${board.bno}" data-oper="modify" class="btn btn-outline-warning float-right mx-1">Modify</a>
							</form>
						</div>
					</div>
					<div class="card shadow mb-4">
				     	<div class="card-header py-3">
				        	<h6 class="m-0 mt-2 font-weight-bold text-primary float-left"><i class="fa fa-comments fa-fw float-left"></i> Reply</h6>
				        	<button id="addReplyBtn" class="btn btn-sm btn-primary float-right">New Reply</button>
				        </div>
				        <div class="card-body">
				        	<ul class="list-group chat">
				        	<!-- 	<li class="list-group-item">
						        	<div class="header">
							        	<strong>user00</strong>
							        	<small class="float-right">2021-04-12 12:37</small>
						        	</div>
						        	<p class="mt-2">Good Job <br>Good Job Good Job <br>Good Job</p>
				        		</li> -->
				        	</ul>
				        	<div class="reply-footer">
					        	
				        	</div>
				        </div>
				    </div>
				</div>
				<!--Result Modal-->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="myModalLabel">REPLY MODAL</h5>
								<button class="close" type="button" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">
								<form action="" method="post" class="needs-validation" novalidate>
					        		<div class="form-group">
					    				<label for="reply" class="font-weight-bold text-info">reply</label>
					    				<input type="text" class="form-control"  id="reply" name="reply" required placeholder="New Reply">
					    				<div class="valid-feedback">Valid.</div>
					       				<div class="invalid-feedback">Check this checkbox to continue.</div>
					  				</div>
					        		<div class="form-group">
					    				<label for="replyer" class="font-weight-bold text-info">replyer</label>
					    				<input type="text" class="form-control"  id="replyer" name="replyer" required placeholder="Replyer">
					    				<div class="valid-feedback">Valid.</div>
					       				<div class="invalid-feedback">Check this checkbox to continue.</div>
					  				</div>
					        		<div class="form-group">
					    				<label for="replyDate" class="font-weight-bold text-info">replyDate</label>
					    				<input type="text" class="form-control"  id="replyDate" name="replyDate" required placeholder="2021-01-01 13:50">
					    				<div class="valid-feedback">Valid.</div>
					       				<div class="invalid-feedback">Check this checkbox to continue.</div>
					  				</div>
								</form>
							</div>
							<div class="modal-footer">
								<button id="modalModBtn" class="btn btn-warning btn-sm ac" type="button" data-dismiss="modal">Modify</button>
								<button id="modalRemoveBtn" class="btn btn-danger btn-sm ac" type="button" data-dismiss="modal">Remove</button>
								<button id="modalRegBtn" class="btn btn-primary btn-sm ac" type="button" data-dismiss="modal">Register</button>
								<button id="modalCloseBtn" class="btn btn-secondary btn-sm" type="button" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				
				
                <script>
					// Disable form submissions if there are invalid fields
					(function() {
					  'use strict';
					  window.addEventListener('load', function() {
					    // Get the forms we want to add validation styles to
					    var forms = document.getElementsByClassName('needs-validation');
					    // Loop over them and prevent submission
					    var validation = Array.prototype.filter.call(forms, function(form) {
					      form.addEventListener('submit', function(event) {
					        if (form.checkValidity() === false) {
					          event.preventDefault();
					          event.stopPropagation();
					        }
					        form.classList.add('was-validated');
					      }, false);
					    });
					  }, false);
					})();
				</script>
				
				<script src="/resources/js/reply.js"></script>
				<script>
				 	var bno = <c:out value="${board.bno}"/>;
				 	var replyUL = $(".chat");
				 	var pageNum = 1;
				 	
				 	showList(1);
				 	
				 	function showList(page) {
				 		//목록 호출
						replyService.getList({bno:bno, page:page}, function(result) {
							//댓글 목록 출력
							var list = result.list;
							console.log(result);
							console.log(list);
							
							if(page == -1) showList(result.realEnd);
							
							var str ="";
							replyUL.html("");
							for(var i in list) {
								str += '<li class="list-group-item" data-rno="' + list[i].rno + '">';
								str += '	<div class="header">';
								str += '   		<strong>'+ list[i].replyer +'</strong>';
								str += '    	<small class="float-right">'+ replyService.displayTime(list[i].replyDate) +'</small>';
								str += '	</div>';
								str += '	<p class="mt-2">'+ list[i].reply +'</p>';
								str += '</li>';
							}
							replyUL.html(str);
							
							//댓글 페이징
							str = '<ul class="pagination float-right mt-4">';
							if(result.prev) {
								str += '<li class="paginate_button page-item previous">'; 
								str += '	<a href="' +(result.startPage - 1) + '" class="page-link">Prev</a>'; 
								str += '</li>';	
							}
							for(var i = result.startPage; i <= result.endPage; i++) {
								var active = result.cri.pageNum == i ? "active" : "";
								str += '<li class="paginate_button page-item '+  active +'" >'; 
								str += '	<a href="' + i + '" class="page-link">' + i + '</a>';	
								str += '</li>';
							}
							if(result.next) {
								str += '<li class="paginate_button page-item next">';
								str += '	<a href="' + (result.endPage + 1) + '" class="page-link">Next</a>';
								str += '</li>';
							}
							str += '</ul>';
							$(".reply-footer").html(str);
						})
				 	}
				 	
				 	$(function() {
				 		$("#addReplyBtn").click(function() {
				 			$("#myModal").find("input").val("");
				 			$("#replyDate").closest("div").hide();
				 			$(".ac").hide().eq(2).show();
				 			$("#myModal").modal("show");	
				 		});
				 		
				 		$(".chat").on("click", "li", function() {
				 			var rno = $(this).data("rno");
				 			console.log(rno);
				 			//상세댓글 호출
							replyService.get(rno, function(result) {
								console.log(result);
								$("#reply").val(result.reply);
								$("#replyer").val(result.replyer);
								$("#replyDate").val(replyService.displayTime(result.replyDate)).prop("readonly", true).closest("div").show();
								$("#myModal").data("rno" ,rno);
								
								$(".ac").show().eq(2).hide();
								$("#myModal").modal("show");
							});
				 		});
				 		
				 		//등록적용 이벤트
				 		$("#modalRegBtn").click(function() {
				 			var reply = {bno:bno, reply:$("#reply").val(), replyer:$("#replyer").val()}
				 			console.log(reply);
				 			replyService.add(reply, function(result) {
								alert(result);
								$("#myModal").modal("hide");
								
								showList(-1);
							}); 
				 		});
				 		
				 		//수정적용 이벤트
				 		$("#modalModBtn").click(function() {
				 			var reply = {rno: $("#myModal").data("rno") ,reply:$("#reply").val()}
				 			console.log(reply);
				 			replyService.update(reply, function(result) {
								alert(result);
								$("#myModal").modal("hide");
								
								showList(pageNum);
							}); 
				 		});
				 		
				 		//삭제적용 이벤트
				 		$("#modalRemoveBtn").click(function() {
				 			replyService.remove($("#myModal").data("rno"), function(result) {
								alert(result);
								$("#myModal").modal("hide");
								
								showList(pageNum);
							}); 
				 		});
				 		
				 		//댓글 페이지 버튼 이벤트 
				 		$(".reply-footer").on("click","a", function() {
				 			event.preventDefault();
				 			
				 			pageNum = $(this).attr("href");
				 			showList(pageNum);
				 		});
				 	});
					/* 
					//삭제 호출
					replyService.remove(103, function(result) {
						alert(result);
					}, function(error) {
						alert("삭제 실패");
					});
					*/
					
					
					
				</script>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

 <jsp:include page="../includes/footer.jsp"/>           