package application_interface.file_management;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;

import error_package.FileError;

public class FileCompatibility {
	private File file;
	
	public File getFile() {return this.file;}
	
	public void resetStream(File file) throws IOException {
		this.file = file;
		
		this.checkComp();
	}
	
	private void checkComp() throws IOException {
		if(this.file.exists() == false) {
			this.file.createNewFile();
			throw new InvalidObjectException(FileError.MISSING_FILE_ERROR);
		}
		
		if(this.file.canExecute() == false) {
			throw new InvalidObjectException(FileError.FILE_EXECUTION_ERROR);
		}
		
		if(this.file.canRead() == false) {
			throw new InvalidObjectException(FileError.FILE_NOT_READABLE);
		}
	}
	
	public FileCompatibility(File file) throws IOException {
		this.file = file;
		this.checkComp();
	}
}
