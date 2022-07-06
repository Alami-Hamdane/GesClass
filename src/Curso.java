

public class Curso {
    private String nombreCurso;
 

    public Curso() {
    }

    public Curso(String nomCurso) {
        this.nombreCurso = nomCurso;
   
       
    }
    
   

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombreCurso + '\'' +
                '}';
    }
}
