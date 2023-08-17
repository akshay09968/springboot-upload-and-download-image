package coms.UploadAndDownloadService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import coms.UploadAndDownloadService.model.FileInfo;
import coms.UploadAndDownloadService.model.ResponseFileInfo;
import coms.UploadAndDownloadService.service.FileService;

@RestController
@RequestMapping("/v1/api")
public class FileController {
	
	@Autowired
	FileService fs;
	
	@PostMapping("/fload")
	public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile file){
		try {
			String res = fs.FileUpload(file);
			if(res.equals("Success"))
			return new ResponseEntity<String>("File Uploaded.....", HttpStatus.OK);
		}catch(Exception e) {
			
		}
		return new ResponseEntity<String>("File Error.....", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> GetFileDownload(@PathVariable("id") String id){
		FileInfo finfo = fs.GetAFile(id);
		if(finfo!=null) {
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attactment; filename=\""+ finfo.getFilename()+"\"").body(finfo.getFiledata());
		}
		return new ResponseEntity("File not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/vall")
	public ResponseEntity<List<ResponseFileInfo>> ViewAllInfo(){
		List<ResponseFileInfo> responseAll = new ArrayList<ResponseFileInfo>();
		List<FileInfo> fall = fs.showAll();
		
		ResponseFileInfo rinfo = null;
		
		for(FileInfo f : fall) {
			
			String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("v1/api/files/").path(f.getFileID()).toUriString();
										//servername: http://localhost:7979            //getmapping text    //id value from db						
			
			rinfo = new ResponseFileInfo(f.getFilename(), f.getFiletype(), f.getFiledata().length, fileDownloadUrl);
			responseAll.add(rinfo);
			 
		}
		return new ResponseEntity<List<ResponseFileInfo>>(responseAll, HttpStatus.OK);
	}
} 





