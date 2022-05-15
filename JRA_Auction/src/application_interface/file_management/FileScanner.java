package application_interface.file_management;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import custom_interfaces.Scannable;

public class FileScanner extends FileCompatibility implements Scannable {
	private Scanner fileScan;
	
	public String scanLine() throws NoSuchElementException {
		return this.fileScan.nextLine();
	}
	
	public void resetScan() {
		this.fileScan.reset();
	}
	
	public void closeScan() {
		this.fileScan.close();
	}

	public FileScanner(File file) throws IOException {
		super(file);
		
		this.fileScan = new Scanner(file);
	}

}
