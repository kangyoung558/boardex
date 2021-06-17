package com.momtenting.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.momtenting.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	private ServletContext ServletContext;
	public static final String UPLOAD_PATH ="C:\\20201230\\upload\\";
	
	public void setServletContext(ServletContext servletContext) {
		this.ServletContext = servletContext;
	}
	
	@GetMapping("upload")
	public void uploadForm() {
		log.info("upload get.....");
	}
	
	@GetMapping("uploadajax")
	public void uploadAjax() {
		log.info("uploadAjax get.....");
	}
	
	
	@PostMapping("uploadAction")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody List<AttachFileDTO> upload(MultipartFile[] files, Model model) throws IllegalStateException, IOException {
		
//		String uploadFolder = ServletContext.getRealPath("upload");
		String uploadFolder = "C:/20201230/upload";
		
		//make folder
		File uploadPath = new File(uploadFolder, getFolder());
		if(!uploadPath.exists()){
			uploadPath.mkdirs();
		}
		List<AttachFileDTO> list = new ArrayList<>();
		
		log.info("upload post.....");
		for(MultipartFile mf : files) {
			AttachFileDTO dto = new AttachFileDTO();
			log.info(".....................");
			log.info("upload file name :: " + mf.getOriginalFilename());
			log.info("upload file size :: " + mf.getSize());
			log.info(".....................");
			String uuid = UUID.randomUUID().toString(); 
			String uploadFileName = uuid + "_" + mf.getOriginalFilename();
			File saveFile = new File(uploadPath, uploadFileName);
			mf.transferTo(saveFile);
			
			dto.setFileName(mf.getOriginalFilename());
			dto.setUuid(uuid);
			dto.setUploadPath(getFolder());
			
			if(isImageType(saveFile)) { //이미지일 경우
				FileOutputStream fos = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
				Thumbnailator.createThumbnail(mf.getInputStream(), fos, 1000, 1000);
				fos.close();
				dto.setImage(true);
			}
			list.add(dto);
		}
		return list;
	}
	
	@GetMapping("display")
	public @ResponseBody ResponseEntity<byte[]> getFile(String fileName) throws IOException {
		log.info("fileName :: " + fileName);
		
		File file = new File(UPLOAD_PATH + fileName);
		
		log.info("file :: " + file);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", Files.probeContentType(file.toPath()));
		return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
	}
	
	@GetMapping(value="download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName) throws UnsupportedEncodingException {
		log.info("download file :: "+ fileName);
		
		Resource resource = new FileSystemResource(UPLOAD_PATH + fileName);
		log.info("resource :: " + resource);
		
		String sourceName = resource.getFilename();
		sourceName = sourceName.substring(sourceName.indexOf("_")+1);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Disposition", "attachment; fileName=" + new String(sourceName.getBytes("utf-8"), "iso-8859-1"));
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	@PostMapping("deleteFile")
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody String deleteFile(@RequestBody AttachFileDTO dto) {
		log.info(dto);
		log.info(dto.getDownPath());
		log.info(dto.getThumbPath());
		new File(UPLOAD_PATH, dto.getDownPath()).delete();
		if(dto.isImage()) {
			new File(UPLOAD_PATH, dto.getThumbPath()).delete();
		}
		return "deleted";
	}
	
	private String getFolder() {
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	private boolean isImageType(File file) throws IOException {
		String mime = Files.probeContentType(file.toPath());
		return mime != null && mime.startsWith("image");
	}
}
