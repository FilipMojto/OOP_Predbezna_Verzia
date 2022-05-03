package custom_interfaces;

import java.io.IOException;
import java.io.ObjectOutputStream;

public interface OutputStream {
	public ObjectOutputStream getStream();
	public void writeStream(Object stream) throws IOException;
}

