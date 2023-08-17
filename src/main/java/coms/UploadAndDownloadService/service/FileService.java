package coms.UploadAndDownloadService.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import coms.UploadAndDownloadService.model.FileInfo;


public interface FileService {

	public String FileUpload(MultipartFile file);
	public List<FileInfo> showAll();
	public FileInfo GetAFile(String fileid);
}
