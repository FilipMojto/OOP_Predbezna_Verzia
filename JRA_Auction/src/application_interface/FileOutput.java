package application_interface;

import java.io.File;
import java.io.IOException;

import custom_interfaces.Serialization;

public class FileOutput extends ObjectOutput {
	private FileScanner fileScan;
	
	public void serializeFile(Serialization serialization) {

		serialization.serializeFile(this, this.fileScan);
	}
	
	public FileOutput(File originalFile, File serializedFile) throws IOException {
		super(serializedFile);
		new FileCompatibility(originalFile);
		this.fileScan = new FileScanner(originalFile);
	}
}
