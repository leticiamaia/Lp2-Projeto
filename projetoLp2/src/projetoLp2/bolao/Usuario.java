package projetoLp2.bolao;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493334626607355526L;
	protected String username;
	protected String senha;

	public Usuario(String username, String senha) throws Exception {
		if (username == null || username == "")
			throw new Exception("Campos nao podem ser nulos ou vazios.");
		this.username = username;
		this.senha = senha;

	}

	public void mudaSenha(String novaSenha) {
		this.senha = novaSenha;

	}

	public String getUsername() {
		return this.username;
	}

	public boolean login(String usernameInput, String senhaInput) {
		if (usernameInput.equals(this.username)
				&& senhaInput.equals(this.senha)) {
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

}
