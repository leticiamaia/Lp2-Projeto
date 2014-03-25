package projetoLp2.bolao.docs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import projetoLp2.bolao.Administrador;
import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.Partida;

public class CriaFile {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
	    try {
	      try {
	        out = new ObjectOutputStream(new FileOutputStream("admin.bin"));
	        } catch( FileNotFoundException e ) {
	        	e.printStackTrace();
	        }
	      Administrador admin = new Administrador("admin", "1234");
	      out.writeObject(admin);
	      out.close();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	    //criar file com lista de usuarios
	    try {
		      try {
		        out = new ObjectOutputStream(new FileOutputStream("usuarios.bin"));
		        } catch( FileNotFoundException e ) {
		        	e.printStackTrace();
		        }
		      List<Jogador> jogadores = new ArrayList<Jogador>();
		      out.writeObject(jogadores);
		      out.close();
		    } catch(IOException e) {
		    	e.printStackTrace();
		    }
		    
	    try {
		      try {
		        out = new ObjectOutputStream(new FileOutputStream("partidas.bin"));
		        } catch( FileNotFoundException e ) {
		        	e.printStackTrace();
		        }
		      Partida[] partidas = new Partida[64];
		      out.writeObject(partidas);
		      out.close();
		    } catch(IOException e) {
		    	e.printStackTrace();
		    }
		    
	}

}
