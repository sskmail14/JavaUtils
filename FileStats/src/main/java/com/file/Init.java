package com.file;

import java.io.File;
import java.util.Map;

import com.file.stats.FileStats;

public class Init
{
    public static void main(String[] ar){
		if(ar.length >= 1){
			Map<String,Object> result = new FileStats().getFileStats(ar);
			System.out.println("Resultant Map : "+result);
		}else{
			System.out.println("Please input (atleast or atmost) only one file path");
		}
	}
}
