package projetoLp2.bolao.docs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Jogador;

public class CriaFile {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
	    try {
	      try {
	        out = new ObjectOutputStream(new FileOutputStream("admin.bin"));
	        } catch( FileNotFoundException e ) {
	          System.exit(1);
	        }
	      Administrador admin = new Administrador("admin", "1234");
	      out.writeObject(admin);
	      out.close();
	    } catch(IOException e) {
	      System.err.println(e);
	      System.exit(1);
	    }
	    //criar file com lista de usuarios
	    try {
		      try {
		        out = new ObjectOutputStream(new FileOutputStream("usuarios.bin"));
		        } catch( FileNotFoundException e ) {
		          System.exit(1);
		        }
		      List<Jogador> jogadores = new ArrayList<Jogador>();
		      out.writeObject(jogadores);
		      out.close();
		    } catch(IOException e) {
		      System.err.println(e);
		      System.exit(1);
		    }
		    

	}

}
