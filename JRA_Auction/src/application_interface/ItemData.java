package application_interface;

import java.io.EOFException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ItemData {
	private FileScanner fileScan;
	
	private int validLineSize;
	LinkedList<String> data;
	
	public LinkedList<String> getData() {return this.data;}
	
	public void gatherData() throws InvalidObjectException, EOFException {
		this.data.clear();
		
		try {
			for(int i = 0; i < this.validLineSize; i++) {
				this.data.addLast(fileScan.scanLine());
			}
		}
		catch(NoSuchElementException e) {
			if(this.data.isEmpty()) {throw new NoSuchElementException();}
			
			throw new InvalidObjectException(error.FileError.INVALID_DATA_ERROR);
		}
	}
	
	public ItemData(int validLineSize, FileScanner fileScan) throws IOException {
		this.fileScan = fileScan;
		this.data = new LinkedList<>();
		this.validLineSize = validLineSize;
	}	
}
