

public class Nivel {
	
    private String nombreNivel;
  

    public Nivel() {
    	
    }

    
    public Nivel(String nomNivel) {
        this.nombreNivel = nomNivel;
       
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    @Override
    public String toString() {
        return "Nivel{" +
                "nombre='" + nombreNivel + '\'' +
               
                '}';
     
    }
}

