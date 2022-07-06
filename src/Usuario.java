

public class Usuario {

	protected String usuario;
	protected String password;

	
	public Usuario()
	{
		this.usuario="";
		this.password="";
		
	}
	public Usuario(String u, String p)
	{
	
		this.usuario=u;
		this.password=p;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
