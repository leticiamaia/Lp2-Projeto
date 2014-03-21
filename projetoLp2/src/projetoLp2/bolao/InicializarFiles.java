package projetoLp2.bolao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InicializarFiles {
	
	public static void main(String[] args) throws IOException {
		ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(
		        new FileOutputStream("C:/admin.bin")));
		objectOut.writeObject(new Administrador("admin","senha"));

	}
}

