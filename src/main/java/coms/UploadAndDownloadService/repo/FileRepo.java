package coms.UploadAndDownloadService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.UploadAndDownloadService.model.FileInfo;

@Repository
public interface FileRepo extends JpaRepository<FileInfo,String>{

}
