package coms.UploadAndDownloadService.model;

public class ResponseFileInfo {
	private String filename;
	private String filetype;
	private float filesize;
	private String downloadurl;
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public float getFilesize() {
		return filesize;
	}
	public void setFilesize(float filesize) {
		this.filesize = filesize;
	}
	public String getDownloadurl() {
		return downloadurl;
	}
	public void setDownloadurl(String downloadurl) {
		this.downloadurl = downloadurl;
	}
	public ResponseFileInfo(String filename, String filetype, float filesize, String downloadurl) {
		super();
		this.filename = filename;
		this.filetype = filetype;
		this.filesize = filesize;
		this.downloadurl = downloadurl;
	}
	public ResponseFileInfo() {
		super();
	}
	
}

