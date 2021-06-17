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
     	<div class="card-header py-3">
        	<h6 class="m-0 font-weight-bold text-primary">Board View</h6>
        </div>
        <div class="card-body">
        	<form method="post" class="needs-validation" novalidate>
        		<input type="hidden" name="pageNum" value="${cri.pageNum}">
        		<input type="hidden" name="amount" value="${cri.amount}">
        		<div class="form-group my-5">
    				<label for="bno" class="font-weight-bold text-warning">bno</label>
    				<input type="text" class="form-control"  id="bno" name="bno" required value="${board.bno}" readonly>
    				<div class="valid-feedback">Valid.</div>
       				<div class="invalid-feedback">Check this checkbox to continue.</div>
  				</div>
        		
            	<div class="form-group my-5">
    				<label for="title" class="font-weight-bold text-warning">title</label>
    				<input type="text" class="form-control" placeholder="게시글 제목을 입력하세요" id="title" name="title" required value="${board.title}" >
    				<div class="valid-feedback">Valid.</div>
       				<div class="invalid-feedback">Check this checkbox to continue.</div>
  				</div>
                <div class="form-group my-5">
    				<label for="content" class="font-weight-bold text-warning">content</label>
    				<textarea class="form-control" rows="10" placeholder="게시글 내용을 입력하세요" id="content" name="content" required >${board.content}</textarea>
    				<div class="valid-feedback">Valid.</div>
       				<div class="invalid-feedback">Check this checkbox to continue.</div>
  				</div>
                <div class="form-group my-5">
    				<label for="writer" class="font-weight-bold text-warning">writer</label>
    				<input type="text" class="form-control" placeholder="작성자을 입력하세요" id="writer" name="writer" required value="${board.writer}" readonly>
    				<div class="valid-feedback">Valid.</div>
       				<div class="invalid-feedback">Check this checkbox to continue.</div>
  				</div>
				<a href="list${cri.listLink}" data-oper="list" class="btn btn-outline-info float-right mx-1">List</a>
  				<button data-oper="remove" class="btn btn-outline-danger float-right mx-1" formaction="remove">Remove</button>
  				<button data-oper="modify" class="btn btn-outline-warning float-right mx-1">Modify</button>
			</form>
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
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

 <jsp:include page="../includes/footer.jsp"/>           