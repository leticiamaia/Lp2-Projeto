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
		this.senha = novaSenha;
		
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
		if (usernameInput.equals(this.username) && senhaInput.equals(this.senha)) {
			return true;
		} else return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	// CONSERTAR O EQUALS! Dois usuários são iguais se seus nomes de usuários são iguais.
	@Override
	public boolean equals(Object obj) {
		Usuario user = (Usuario) obj;
		if (username == null) {
			if (user.getUsername() != null)
				return false;
		} else if (!username.equals(user.getUsername()))
			return false;
		return true;
	}
	
	
	
}
