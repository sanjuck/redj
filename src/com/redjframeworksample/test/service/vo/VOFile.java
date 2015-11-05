package com.redjframeworksample.test.service.vo;

import com.redjframework.http.multipart.FilePart;

public class VOFile {
	FilePart[] file;

	public FilePart[] getFile() {
		return file;
	}

	public void setFile(FilePart[] file) {
		this.file = file;
	}
}
