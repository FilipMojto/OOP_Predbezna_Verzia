package custom_interfaces;

import java.io.EOFException;

public interface Scannable {
	public String scanLine() throws EOFException;
	public void resetScan();
	public void closeScan();
}
