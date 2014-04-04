package projetoLp2.bolao.docs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projetoLp2.bolao.TimeCopa;

public class ControladorTimes {
	private static ObjectInputStream ois;
	private static ObjectOutputStream out;
	
	public static TimeCopa[] ler() {
		TimeCopa[] times = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("times.bin"));
			times =  (TimeCopa[])ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return times;
	}
	
	public static void escreve(TimeCopa[] times) {
		try {
			out = new ObjectOutputStream(new FileOutputStream("times.bin"));
			out.writeObject(times);
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
