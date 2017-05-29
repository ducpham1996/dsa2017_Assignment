package com.dsa.files;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class write_file {
	public void test(String file_name, String text) {
		try {
			//FileWriter fw = new FileWriter(file_name, true);
			file_path filepath = new file_path();
			PrintWriter writer = new PrintWriter(filepath.filepath()+ file_name);
			writer.print("");
			writer.println(text);
			writer.close();
			//fw.write(text);			
			//fw.close();
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
	public void write(String file_name,String text) throws IOException{
		file_path filepath = new file_path();
		Writer out = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(filepath.filepath()+ file_name), "UTF-8"));
			try {
			    out.write(text);
			} finally {
			    out.close();
			}
	}
//	public static void main(String[] args) {
//		write_file wf = new write_file();
//		try{
//			wf.test("", "Vưu Lạc hoàng");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
}
