package com.file.stats;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FileStats{
	public List<String> finalFileList = new ArrayList<String>();
	public List<String> fileExenstionList = new ArrayList<String>();
	public Integer totalLines = 0;
	
	public Map<String,Object> getFileStats(String[] fp){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		setFileExtensions(fp);
		generateFileList(new File(fp[0]));
		setNumberOfLinesForFiles(finalFileList);
		resultMap.put("TOTAL_FILE_COUNT",Integer.parseInt(finalFileList.size()+""));
		resultMap.put("TOTAL_FILES",finalFileList);
		resultMap.put("TOTAL_FILES_LINES",totalLines);
		return resultMap;
	}
	
	private void setNumberOfLinesForFiles(List<String> l){
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
		for(int i =1; i < ar.length; i++){
			if(ar[i].trim().length() > 0){
				fileExenstionList.add(ar[i].trim());
			}
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