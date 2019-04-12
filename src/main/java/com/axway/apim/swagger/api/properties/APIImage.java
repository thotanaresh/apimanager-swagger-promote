package com.axway.apim.swagger.api.properties;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class APIImage {

	private byte[] imageContent = null;
	
	private String filename = null;
	
	private boolean isValid = true;
	
	private String baseFilename = null;
	
	private String contentType = null;
	
	private String fileExtension = null;
	
	public byte[] getImageContent() {
		return imageContent;
	}
	
	public APIImage() {
		super();
	}

	public APIImage(String filename) {
		super();
		this.filename = filename;
	}

	public String getImageType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		if(contentType.toLowerCase().contains("jpeg") || contentType.toLowerCase().contains("jpg")) {
			fileExtension = ".jpg";
		} else if(contentType.toLowerCase().contains("png")) {
			fileExtension = ".jpg";
		} else if(contentType.toLowerCase().contains("gif")) {
			fileExtension = ".gif";
		} else {
			fileExtension = ".unknown";
		}
		this.contentType = contentType;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other instanceof APIImage) {
			APIImage otherImage = (APIImage)other;
			return (Arrays.hashCode(this.imageContent)) == Arrays.hashCode(otherImage.getImageContent());
		} else {
			return false;
		}
	}
	
	public InputStream getInputStream() {
		return new ByteArrayInputStream(this.imageContent);
	}
	
	public String getFilename() {
		if(filename.indexOf("/")!=-1) {
			return filename;
		} else {
			return filename.substring(filename.lastIndexOf("/")+1);
		}
	}

	public boolean isValid() {
		return isValid;
	}

	public void setImageContent(byte[] imageContent) {
		this.imageContent = imageContent;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getBaseFilename() {
		return baseFilename;
	}

	public void setBaseFilename(String baseFilename) {
		this.baseFilename = baseFilename;
	}

	@Override
	public String toString() {
		return "APIImage [filename=" + filename + "]";
	}
}
