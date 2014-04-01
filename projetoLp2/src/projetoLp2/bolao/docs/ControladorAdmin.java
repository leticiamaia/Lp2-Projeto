package projetoLp2.bolao.docs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projetoLp2.bolao.Administrador;

public class ControladorAdmin {
	
	private static ObjectInputStream ois;
	private static ObjectOutputStream out;
	
	public static Administrador ler() {
		Administrador admin = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("admin.bin"));
			admin =  (Administrador)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return admin;
	}
	
	public static void escreve(Administrador admin) {
		try {
			out = new ObjectOutputStream(new FileOutputStream("admin.bin"));
			out.writeObject(admin);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
