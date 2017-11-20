package ucb.bo.edu.diplomadofit;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
/**
 * Created by USER on 17/11/2017.
 */

public class Client extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;

    @Ignore
    private int edad;
    private  float estatura;
    private float peso;
    private float grasa;
    private float imc;
    private String telefono;

    public Client()
    {
        this.id="";
        this.name="";
        this.edad=0;
        this.estatura=0.0f;
        this.peso=0.0f;
        this.grasa=0.0f;
        this.imc=0.0f;
        this.telefono="";
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

    @Override
    public String toString() {
        return "Usuario{" +
        "name='" + name + '\'' +
        '}';
        }
}
