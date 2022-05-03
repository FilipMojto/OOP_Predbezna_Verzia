package application_interface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import custom_interfaces.MainStream;
import custom_interfaces.OutputStream;

public class ObjectOutput extends FileCompatibility implements MainStream, OutputStream {
	private FileOutputStream fileOutput = null;
	private ObjectOutputStream objOut = null;
	
	@Override
	public ObjectOutputStream getStream() {
		return this.objOut;
	}
	
	@Override
	public void closeStream() throws IOException {
		this.objOut.close();
		this.fileOutput.close();
	}
	
	@Override
	public void writeStream(Object stream) throws IOException {
		
		this.objOut.writeObject(stream);
	}
	
	public ObjectOutput(File file) throws IOException {
		super(file);
		
		this.fileOutput = new FileOutputStream(file.getAbsolutePath());
		this.objOut = new ObjectOutputStream(fileOutput);
	}
}
