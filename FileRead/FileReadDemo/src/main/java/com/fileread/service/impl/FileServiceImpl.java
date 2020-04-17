package com.fileread.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fileread.dto.FileReadDTO;
import com.fileread.entity.FileRead;
import com.fileread.repository.FileRepository;
import com.fileread.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private FileRepository fileRepository;
	@Value(value = "${app.filepath}")
	private String filepath;

	/*
	 * @Override public void fileRead(() throws IOException { FileRead fileRead =
	 * new FileRead(); try { InputStream inputStream = new FileInputStream(new
	 * File(filepath)); BufferedReader reader = new BufferedReader(new
	 * InputStreamReader(inputStream)); StringBuilder out = new StringBuilder();
	 * String line; while ((line = reader.readLine()) != null) { out.append(line); }
	 * System.out.println(out.toString()); fileRead.setMessage(out.toString());
	 * fileRepository.save(fileRead); reader.close();
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	@Override
	public void fileRead(FileReadDTO fileReadDTO) throws IOException {
	
		FileRead fileRead = new FileRead();
		int currentLine=0;
		try {
			InputStream inputStream = new FileInputStream(new File(filepath));
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder out = new StringBuilder();
			String line;
			while(currentLine<fileReadDTO.getStartLine())
			{
				if(reader.readLine()==null)
				{
					throw new IOException("File too Small");
				}
				currentLine++;
			}
			while(currentLine<=fileReadDTO.getEndLine())
			{
			line=reader.readLine();
			if(line==null)
			{
				return;
			}
			out.append(line);
			currentLine++;
			}
			System.out.println(out.toString());
			fileRead.setMessage(out.toString());
			fileRepository.save(fileRead);
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
