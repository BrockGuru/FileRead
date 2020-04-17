package com.fileread.service;

import java.io.IOException;

import com.fileread.dto.FileReadDTO;

public interface FileService {
	public void fileRead(FileReadDTO fileReadDTO) throws IOException;

}
