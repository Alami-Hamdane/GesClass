

public class Estudiante {

	private String numeroDni;
	private String apellidos;
	private String nombre;
	private Nivel nivel;
	private Curso curso;

	public Estudiante() {
	}

	public Estudiante(String numeroDni, String apellidos, String nombre, Nivel nivel, Curso curso) {
		this.numeroDni = numeroDni;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.nivel = nivel;
		this.curso = curso;
	}

	public String getNumeroDni() {
		return numeroDni;
	}

	public void setNumeroDni(String numeroDni) {
		this.numeroDni = numeroDni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	

	@Override
	public String toString() {
		return "Estudiante{" + "numeroDni='" + numeroDni + '\'' + ", apellidos='" + apellidos + '\''
				+ ", nombre='" + nombre + '\'' + ", nivel=" + nivel + ", curso=" + curso + '}';
	}

}
