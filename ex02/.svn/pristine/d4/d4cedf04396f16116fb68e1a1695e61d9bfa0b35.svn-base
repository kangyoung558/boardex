<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2021. 4. 14.오후 3:32:40</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>
	<div class="uploadDiv">
		<input id="files" type="file" name="files" multiple> 
		<button id="uploadBtn" type="button">송신</button>
	</div>
	
	<div class="uploadResult">
		<ul class="list-group list-group-horizontal">
		</ul>
	</div>
	
	<!--Result Modal-->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="modal-body text-center">
					<img class="mv-100">
				</div>
			</div>
		</div>
	</div>
	<script>
		var regex = /(.*?)\.(exe|sh|jsp|php|jar)/gi;
		var maxSize = 1024 * 1024 * 5;
		var cloneObj = $(".uploadDiv").clone();
		var uploadResult = $(".uploadResult ul");
		
		console.log(cloneObj);
		$(".uploadDiv").on("click", "#uploadBtn", function() {
			var formData = new FormData();
			var files = $("#files")[0].files;
			
			console.log(files);
			
			for(var i in files) {
				if(!checkExtension(files[i].name, files[i].size)) {
					$(".uploadDiv").html(cloneObj.html());
					return false;
				}
				formData.append("files", files[i]);
			}
			console.log(formData);		
			
			$.ajax({
				url : 'uploadAction',
				type : 'post',
				data : formData,
				dataType : 'json',
				processData : false,
				contentType : false,
				success : function(result) {
					console.log(result);
					showUploadedFile(result);
					$(".uploadDiv").html(cloneObj.html());
				}
			});
		})
		
		function checkExtension(name, size) {
			if(size >= maxSize) {
				alert("파일 사이즈 초과");
				return false;
			}
			if(regex.test(name)) {
				alert("해당 종류의 파일은 업로드 할수 없습니다.");
				return false;
			}
			return true;
		}
		
		function showUploadedFile(uploadResultArr) {
			var str = "";
			for(var i in uploadResultArr) {
				var obj = uploadResultArr[i];
				console.log(obj);
				str += "<li class='list-group-item' "
				str += " data-filename='" + obj.fileName
				str += "' data-image='" + obj.image
				str += "' data-uuid='" + obj.uuid
				str += "' data-uploadpath='" + obj.uploadPath
				str += "' >"
				if(!obj.image){
					str += "<a href='/download?fileName="+ obj.downPath + "'><i class='fas fa-paperclip text-danger'></i>" + obj.fileName + "</a>" 
				}
				else {
					str += "<a href='javascript:showImage(\""+ obj.downPath +"\")'>";
					str += "<img src = '/display?fileName=" + obj.thumbPath + "'></a>";
				}
				str += "<i class='fas fa-times text-danger removeFileBtn'></i>"
				str += "</li>";
			}
			uploadResult.append(str);
		}
		
		function showImage(path) {
			$("#myModal img").attr("src", "/display?fileName="+path)
			$("#myModal").modal("show");
		}
		$(".uploadResult").on("click", ".removeFileBtn", function() {
			var $li = $(this).closest("li");
			var data = {
				fileName : $li.data("filename"), 
				image : $li.data("image"),
				uuid : $li.data("uuid"),
				uploadPath : $li.data("uploadpath")
			}
			console.log(data);
			console.log(JSON.stringify(data));
			
			$.ajax({
				url : "/deleteFile",
				type : "post",
				data : JSON.stringify(data),
				contentType : "application/json; charset=utf-8",
				success : function(result) {
					alert(result);
					$li.remove();
				}
			}); 
		});
	</script>
</body>
</html>