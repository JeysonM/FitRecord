package ucb.bo.edu.diplomadofit;

/**
 * Created by USER on 17/11/2017.
 */

public class ClientofList {

    private String id;
    private String name;
    private int edad;
    private  float estatura;
    private float peso ;
    private float grasa;
    private float imc;
    private String telefono;

    public ClientofList(String id, String name, int edad, float estatura, float peso, float grasa, float imc, String telefono) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
        this.grasa = grasa;
        this.imc = imc;
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getGrasa() {
        return grasa;
    }

    public void setGrasa(float grasa) {
        this.grasa = grasa;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }




}
