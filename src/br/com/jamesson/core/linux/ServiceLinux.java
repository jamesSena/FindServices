package br.com.jamesson.core.linux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceLinux {

	public boolean findService(String serviceName) {
		try {
			File[] contents = new File("/proc").listFiles();
			if(contents == null)return false;

			for (File f : contents) {
				if (f.getAbsolutePath().matches("\\/proc\\/\\d+")) {
					if (readFileProcess(f.getAbsolutePath().concat("/status"), serviceName))
						return true;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean readFileProcess(String filename, String serviceName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
			String strLine = br.readLine().split(":")[1].trim();
			br.close();
			if (strLine.equals(serviceName))
				return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
}
