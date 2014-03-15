package projetoLp2.bolao;

public abstract class Usuario {
	
	 protected String username;
	 protected String senha;
	 
	public abstract void mudaSenha(String novaSenha);
	
	public String getSenha() {
		return senha;
	}
	
	public String getUsername() {
		return username;
	}
	
}
