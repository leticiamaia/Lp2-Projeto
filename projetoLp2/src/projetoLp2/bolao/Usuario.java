package projetoLp2.bolao;

public abstract class Usuario {
	
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
	
}
