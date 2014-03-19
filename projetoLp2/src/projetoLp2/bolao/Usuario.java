package projetoLp2.bolao;

import java.io.Serializable;

public abstract class Usuario implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 493334626607355526L;
	protected String username;
	 protected String senha;
	 
	public void mudaSenha(String novaSenha){
		this.senha = senha;
		
	}
	
	public Usuario(String username, String senha) {
		this.username = username;
		this.senha = senha;
		
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean login(String usernameInput, String senhaInput) {
		if (usernameInput.equals(username) && senhaInput == senha) {
			return true;
		} else return false;
	}
	
}
