package projetoLp2.bolao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class ControladorTimes {
	private static ObjectInputStream ois;
	private static ObjectOutputStream out;
	
	@SuppressWarnings("unchecked")
	public static Map<String, TimeCopa> ler() {
		Map<String, TimeCopa> times = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("resources/times.bin"));
			times =  (Map<String, TimeCopa>)ois.readObject();
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
	
	public static void escreve(Map<String, TimeCopa> times) {
		try {
			out = new ObjectOutputStream(new FileOutputStream("resources/times.bin"));
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