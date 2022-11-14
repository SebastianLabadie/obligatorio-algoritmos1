
package sistemaDistribucion;

public class nodoCamion {
    String matricula;
    int toneladasMaxSoportadas;
    nodoCamion siguiente;

    public nodoCamion(String matricula, int toneladasMaxSoportadas) {
        this.matricula = matricula;
        this.toneladasMaxSoportadas = toneladasMaxSoportadas;
        this.siguiente = null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getToneladasMaxSoportadas() {
        return toneladasMaxSoportadas;
    }

    public void setToneladasMaxSoportadas(int toneladasMaxSoportadas) {
        this.toneladasMaxSoportadas = toneladasMaxSoportadas;
    }

    


    public nodoCamion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCamion siguiente) {
        this.siguiente = siguiente;
    }
    
}
