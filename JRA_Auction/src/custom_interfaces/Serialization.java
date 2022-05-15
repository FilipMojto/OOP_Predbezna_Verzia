package custom_interfaces;

import application_interface.file_management.FileOutput;
import application_interface.file_management.FileScanner;

@FunctionalInterface
public interface Serialization {
	public void serializeFile(FileOutput objOut, FileScanner fileScan);
}
