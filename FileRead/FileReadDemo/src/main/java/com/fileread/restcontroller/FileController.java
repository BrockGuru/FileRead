package com.fileread.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fileread.dto.FileReadDTO;
import com.fileread.service.FileService;
@RestController
public class FileController {
	@Autowired
	private FileService fileService;
	@PostMapping(value = "/files")
	public ResponseEntity<Void>fileRead(@RequestBody FileReadDTO readDTO) throws IOException
	{
		fileService.fileRead(readDTO);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
