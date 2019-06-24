/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivachallengesuperliga;

import java.util.Comparator;

/**
 *
 * @author Alex3D
 */
public class Socio {
   public enum estudios {
        SIN,
        PRIMARIO,
        SECUNDARIO,
        TERCIARIO,
        UNIVERSITARIO
    }
    
    private String nombre;
    private Integer edad;
    private String equipo;
    private String estadoCivil;
    private estudios nivelDeEstidios;

    public Socio(String nombre, String edad, String equipo, String estadoCivil, String nivelDeEstidios) {
        this.nombre = nombre;
        this.edad = new Integer(edad);
        this.equipo = equipo;
        this.estadoCivil = estadoCivil;
        switch(nivelDeEstidios) {
            case "Secundario":
                this.nivelDeEstidios = estudios.SECUNDARIO;
                break;
            case "Terciario":
                this.nivelDeEstidios = estudios.TERCIARIO;
                break;
            default:
                this.nivelDeEstidios = estudios.UNIVERSITARIO;                
        }        
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public estudios getNivelDeEstidios() {
        return nivelDeEstidios;
    }
    
    public static Comparator<Socio> edadComparator = new Comparator<Socio>() {
            @Override
            public int compare(Socio s1, Socio s2) {
                return s1.getEdad() - s2.getEdad();
            }
    };
    
    public static Comparator<Socio> nombreComparator = new Comparator<Socio>() {
            @Override
            public int compare(Socio s1, Socio s2) {
                String socioName1 = s1.getNombre().toUpperCase();
                String socioName2 = s2.getNombre().toUpperCase();
                
                return socioName1.compareTo(socioName2);
            }
    };

    @Override
    public String toString() {
        return "Socio{" + "nombre=" + nombre + ", edad=" + edad + ", equipo=" + equipo + ", estadoCivil=" + estadoCivil + ", nivelDeEstidios=" + nivelDeEstidios + '}';
    }
    
    public String toStringNombreEdadEquipo() {
        return "Socio{" + "nombre=" + nombre + ", edad=" + edad + ", equipo=" + equipo  + '}';
    }
    
}
