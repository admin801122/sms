package com.hxs.sms.util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

	public static String readAll(InputStream input) throws IOException {
		return readAll(input, Charset.defaultCharset());
	}
	
	public static String readAll(InputStream input , String encoding) throws IOException {
		return readAll(input, Charset.forName(encoding));
	}

	public static String readAll(InputStream input, Charset charset)
			throws IOException {
		int count;
		char[] buff = new char[1024];
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input,
				charset));
		while ((count = reader.read(buff)) > 0) {
			sb.append(buff, 0, count);
		}
		return sb.toString();
	}
	
	public static List<String> readLines(InputStream input) throws IOException{
		return readLines(input, Charset.defaultCharset());
	}
	
	public static List<String> readLines(InputStream input , String encoding) throws IOException{
		return readLines(input, Charset.forName(encoding));
	}
	
	public static List<String> readLines(InputStream input, Charset charset)
			throws IOException {
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input,
				charset));
		String line ;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		return lines;
	}
}
