package custom_interfaces;

import application_interface.FileScanner;
import application_interface.FileOutput;

@FunctionalInterface
public interface Serialization {
	public void serializeFile(FileOutput objOut, FileScanner fileScan);
}
