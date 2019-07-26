package ciphersearch;

import java.io.*;
import java.util.*;
import java.awt.*;

public class DocSearch {
	
	ArrayList<String> path= new ArrayList<String>();
	ArrayList<String> name= new ArrayList<String>();
	int index= 0;
	
	DocSearch (String pat, String nam){
		
		path.add(pat);
		name.add(nam);
		index= path.indexOf(pat);
	}
	
	DocSearch (int x) {
		index= x;
	}
	
	public void open() {
		
		try {
			
		File file= new File(path.get(index));
		
		if( file.exists()) {
			Process pro= Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path.get(index));
			pro.waitFor();
		}
		else {
			System.out.println("File does not exist");
		}
			
		}
		catch (Exception e) {
			
		}
	}
	

}
