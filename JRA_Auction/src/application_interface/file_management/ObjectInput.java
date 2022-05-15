package application_interface.file_management;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInput extends FileCompatibility {
	private FileInputStream fileIn = null;
	private ObjectInputStream objIn = null;
	
	public Object deserializeObject() throws IOException, ClassNotFoundException {
		return this.objIn.readObject();
	}
	
	public void closeStream() throws IOException {
		this.objIn.close();
		this.fileIn.close();
	}	
	
	public ObjectInput(File file) throws IOException {
		super(file);
		
		this.fileIn = new FileInputStream(file.getAbsolutePath());
		this.objIn = new ObjectInputStream(fileIn);
		
	}
}
