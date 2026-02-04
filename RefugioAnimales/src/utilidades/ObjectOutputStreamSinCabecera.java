package utilidades;

import java.io.*;
public class ObjectOutputStreamSinCabecera extends ObjectOutputStream{
	
		protected void writeStreamHeader() throws IOException {
		 reset();	
	 }

		//Constructores
	public ObjectOutputStreamSinCabecera () throws IOException{ 
		super();
		}
	
		public ObjectOutputStreamSinCabecera(OutputStream out) throws IOException{
		super(out);
		}
	}