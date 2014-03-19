package projetoLp2.bolao.docs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InicializarFiles {
	private static FileInputStream fin;
	private static FileOutputStream fon;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	
	public static void main(String[] args) {
		getObjectFromFileText("admin.bin");
		//ois.write();

	}
	private static void getObjectFromFileText(String fileText) {

		try {
			fin = new FileInputStream(fileText);
			ois.close();
			oos.close();
			fon = new FileOutputStream(fileText);
			ois = new ObjectInputStream(fin);
			oos = new ObjectOutputStream(fon);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void closeFileText() {

		try {
			ois.close();
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
