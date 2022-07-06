import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GestorBaseDatos {

	
	protected String servidor;
	protected String puerto;
	protected String nombreBaseDatos;
	protected String usuario;
	protected String password;
	
	
	protected Connection conexion=null;
	protected Statement peticion;
	protected ResultSet resultados;
	
	public GestorBaseDatos()
	{
		this.servidor="localhost";
		this.puerto="3306";
		this.nombreBaseDatos="gestionestudiantes";
		this.usuario="root";
		this.password="";
	}
	public GestorBaseDatos(String servidor, String puerto, String nbd, String user, String pass)
	{
		
		this.servidor=servidor;
		this.puerto=puerto;
		this.nombreBaseDatos=nbd;
		this.usuario=user;
		this.password=pass;
	}
	
	
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getNombreBaseDatos() {
		return nombreBaseDatos;
	}
	public void setNombreBaseDatos(String nombreBaseDatos) {
		this.nombreBaseDatos = nombreBaseDatos;
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
	
	
	
	
	//Conexion
	
	public boolean conectar()
	{
		try {
			conexion= (Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password );
		    return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	// Validar
	
	public boolean validar(String usuario, String password)
	{
		
		if (conexion!=null)
		{
			
			try {
				peticion = (Statement) conexion.createStatement();
				resultados= (ResultSet) peticion.executeQuery("SELECT * FROM usuarios");
				
				while(resultados.next())
				{
					if (usuario.equalsIgnoreCase(resultados.getString("nombreUsuario")) && password.equals(resultados.getString("passUsuario")))
					{
						return true;
					}
					
					
					
				}
				resultados.close();
				peticion.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
		return false;
	}
	
	
	
	
	public boolean validarAdmin(String usuario, String password)
	{
		
		if (conexion!=null)
		{
			
			try {
				peticion = (Statement) conexion.createStatement();
				resultados= (ResultSet) peticion.executeQuery("SELECT * FROM administrador");
				
				while(resultados.next())
				{
					if (usuario.equalsIgnoreCase(resultados.getString("login")) && password.equals(resultados.getString("password")))
					{
						return true;
					}
					
					
					
				}
				resultados.close();
				peticion.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		
		return false;
	}
	
	

	
	// Método para leer los registros tabla estudiante de la base de datos

		public ArrayList<Estudiante> Extraer(String consulta) {

			Estudiante es = null;
			ArrayList<Estudiante> est = new ArrayList<Estudiante>();

			if (conexion != null) {

				try {
					peticion = (Statement) conexion.createStatement();
					resultados = (ResultSet) peticion.executeQuery(consulta);

					while (resultados.next()) {
						es = new Estudiante();
				
						es.setNumeroDni(resultados.getString("DniEstudiante"));
						es.setApellidos(resultados.getString("apellidosEstudiante"));
						es.setNombre(resultados.getString("nombreEstudiante"));
					
					
						est.add(es);

					}

				

				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

			return est;
		}
	
	
	
	
	
	
	
	public boolean crearCurso(String nombreCurso ,String tabla)
	{
				
		boolean resultado=false;
		String consulta="";
		Connection conexion=null;
		Statement s=null;
		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s = (Statement)conexion.createStatement(); 
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		try {
			consulta = "INSERT INTO curso (nombreCurso) VALUES ('" +nombreCurso+ "')";
			resultado =s.execute(consulta);
					

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return resultado;
	}
	
	
	

	// Borrar Curso
	
	public boolean borrarCurso(String nombreCurso ,String tabla)
	{
				
		boolean resultado=false;
		String consulta="";
		Connection conexion=null;
		Statement s=null;
		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s = (Statement)conexion.createStatement(); 
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		try {
			consulta = "DELETE FROM curso WHERE nombreCurso = ('" +nombreCurso+ "')";
			resultado =s.execute(consulta);
					

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return resultado;
	}
	
	
	
		
	
	public boolean crearNivel(String nombreNivel ,String tabla)
	{
				
		boolean resultado=false;
		String consulta="";
		Connection conexion=null;
		Statement s=null;
		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s = (Statement)conexion.createStatement(); 
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		try {
			consulta = "INSERT INTO nivelestudios (nombreNivel) VALUES ('" +nombreNivel+ "')";
			resultado =s.execute(consulta);
					

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return resultado;
	}
	
	
	
	// Borrar Nivel
	
		public boolean borrarNivel(String nombreNivel ,String tabla)
		{
					
			boolean resultado=false;
			String consulta="";
			Connection conexion=null;
			Statement s=null;
			
			
			try {
				conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				s = (Statement)conexion.createStatement(); 
			} catch (SQLException e) {
					e.printStackTrace();
			}
				
			try {
				consulta = "DELETE FROM nivelestudios WHERE nombreNivel = ('" +nombreNivel+ "')";
				resultado =s.execute(consulta);
						

			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			
			return resultado;
		}
	
	
		
		
		// Borrar DNI
		
			public boolean borrarDni(String numeroDni ,String tabla)
			{
						
				boolean resultado=false;
				String consulta="";
				Connection conexion=null;
				Statement s=null;
				
				
				try {
					conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					s = (Statement)conexion.createStatement(); 
				} catch (SQLException e) {
						e.printStackTrace();
				}
					
				try {
					consulta = "DELETE FROM estudiante WHERE dniEstudiante = ('" +numeroDni+ "')";
					resultado =s.execute(consulta);
							

				} catch (SQLException e) {
					e.printStackTrace();
				
				}
				
				return resultado;
			}
		
	
	
	
	
	public boolean crearEstudiante(String dniEstudiante ,String apellidosEstudiante,String nombreEstudiante,String cursoEstudiante,String nivelEstudiante,String tabla)
	{
				
		boolean resultado=false;
		String consulta="";
		Connection conexion=null;
		Statement s=null;
		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s = (Statement)conexion.createStatement(); 
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		try {
			consulta = "INSERT INTO estudiante (dniEstudiante,apellidosEstudiante,nombreEstudiante,cursoEstudiante,nivelEstudiante) VALUES ('" +dniEstudiante+ "','" +apellidosEstudiante+"','" +nombreEstudiante+"','" +cursoEstudiante+ "','" +nivelEstudiante+ "')";
			resultado =s.execute(consulta);
					

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return resultado;
	}
	
	
	// Crear Usuario
	
	public boolean crearUsuario(String user ,String pass,String tabla)
	{
				
		boolean resultado=false;
		String consulta="";
		Connection conexion=null;
		Statement s=null;
		
		
		try {
			conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			s = (Statement)conexion.createStatement(); 
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
		try {
			consulta = "INSERT INTO usuarios (nombreUsuario,passUsuario) VALUES ('" +user+ "','" +pass+"')";
			resultado =s.execute(consulta);
					

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		return resultado;
	}
	
	
	
	// Borrar Usuario
	
	
	
				public boolean borrarUsuario(String user ,String tabla)
				{
							
					boolean resultado=false;
					String consulta="";
					Connection conexion=null;
					Statement s=null;
					
					
					try {
						conexion=(Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+":"+this.puerto+"/"+ this.nombreBaseDatos,this.usuario,this.password);
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						s = (Statement)conexion.createStatement(); 
					} catch (SQLException e) {
							e.printStackTrace();
					}
						
					try {
						consulta = "DELETE FROM usuarios WHERE nombreUsuario = ('" +user+ "')";
						resultado =s.execute(consulta);
								

					} catch (SQLException e) {
						e.printStackTrace();
					
					}
					
					return resultado;
				}
				
				
				
				
				
								
				
			
			        
			        
	
 }

