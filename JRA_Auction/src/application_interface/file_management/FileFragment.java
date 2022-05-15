package application_interface.file_management;

import java.io.EOFException;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import custom_interfaces.ItemAttributes;

public class FileFragment implements ItemAttributes {
	private FileScanner fileScan;
	
	private int validLineSize;
	LinkedList<String> collectedData;
	
	public LinkedList<String> getData() {return this.collectedData;}
	
	@Override public String getItemManufacturer() {return this.collectedData.get(0);}
	@Override public String getItemName() {return this.collectedData.get(1);}
	@Override public String getItemType() {return this.collectedData.get(2);}
	@Override public int getItemPrice() {return Integer.parseInt(this.collectedData.get(3));}
	
	public void collectData() throws InvalidObjectException, EOFException {
		this.collectedData.clear();
		
		try {
			for(int i = 0; i < this.validLineSize; i++) {
				this.collectedData.addLast(fileScan.scanLine());
			}
		}
		catch(NoSuchElementException e) {
			if(this.collectedData.isEmpty()) {throw new NoSuchElementException();}
			
			throw new InvalidObjectException(error_package.FileError.INVALID_DATA_ERROR);
		}
	}
	
	public FileFragment(int validLineSize, FileScanner fileScan) throws IOException {
		this.fileScan = fileScan;
		this.collectedData = new LinkedList<>();
		this.validLineSize = validLineSize;
	}	
}
