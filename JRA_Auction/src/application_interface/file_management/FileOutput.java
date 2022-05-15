package application_interface.file_management;

import java.io.File;
import java.io.IOException;

import custom_interfaces.Serialization;

public class FileOutput extends ObjectOutput implements Runnable {
	private FileScanner fileScan;
	
	private Serialization method;
	
	public void serializeFile(Serialization method) {
		
		method.serializeFile(this, this.fileScan);
	}
	
	public FileOutput(File originalFile, File serializedFile, Serialization method) throws IOException {
		super(serializedFile);
		new FileCompatibility(originalFile);
		this.method = method;
		this.fileScan = new FileScanner(originalFile);
	}

	@Override
	public void run() {
		this.serializeFile(method);
	}
}
