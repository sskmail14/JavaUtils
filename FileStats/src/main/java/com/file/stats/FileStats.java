package com.file.stats;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class FileStats{
	public List<String> finalFileList = new ArrayList<String>();
	public List<String> fileExenstionList = new ArrayList<String>();
	public int totalLines = 0;
	public static void main(String[] ar){
		if(ar.length >= 1){
			FileStats fs = new FileStats();
			fs.setFileExtensions(ar);
			File f = new File(ar[0]);
			fs.generateFileList(f);
			//For printing the list of files
			//System.out.println(fs.finalFileList+" : "+fs.finalFileList.size());
			fs.setNumberOfLinesForFiles(fs.finalFileList);
			System.out.println("Total Number of files from the given extension(s) : "+fs.finalFileList.size());
			System.out.println("Total Number of lines of all files from the given extension(s) : "+fs.totalLines);
		}else{
			System.out.println("Please input (atleast or atmost) only one file path");
		}
	}
	
	public void setNumberOfLinesForFiles(List<String> l){
		l.forEach(fileProp->{
			try(BufferedReader reader = new BufferedReader(new FileReader(fileProp))){
			int lines = 0;
			while (reader.readLine() != null) lines++;
			totalLines += lines;
			}catch(Exception e){
			
			}
		});
	}
	
	private void setFileExtensions(String[] ar){
		//Excluding the first parameter because of the file path
		for(int i =0; i < ar.length; i++){
			if(ar[i].trim().length() > 0)
				fileExenstionList.add(ar[i].trim());
		}
	}
	
	private void generateFileList(File filePath){
			File[] fileList = filePath.listFiles();
			
			for(int i =0; i < fileList.length; i++){
				if(fileList[i].isFile()){
					putFilePath(fileList[i]);
				}else{
					generateFileList(fileList[i]);
				}
			}
	}
	
	private void putFilePath(File filePath){
	String filePathName = filePath.getAbsolutePath().replace("\\","/");
		if(fileExenstionList.isEmpty()){
			finalFileList.add(filePathName);
		}else{
			String[] fileSplitPath = filePathName.split("\\.");
			if(fileSplitPath.length > 1 && fileExenstionList
				.contains(
					fileSplitPath[fileSplitPath.length-1]
				)
			){
				finalFileList.add(filePathName);
			}
		}
	}
}