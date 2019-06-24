/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivachallengesuperliga;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex3D
 */
public class SociosManager {
    private ArrayList<Socio> socios;

    public SociosManager() {
        socios = new ArrayList<>();
    }
    
    public void leerYParsearSocios(String fileName) {
        String fileToParse = fileName;
        BufferedReader fileReader = null;
         
        //Delimiter used in CSV file
        final String DELIMITER = ";";
        try
        {            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
            String line = fileReader.readLine();
             
            //Read the file line by line
            while (line != null)
            {
                //Get all tokens available in line
                String[] datosSocio = line.split(DELIMITER);
                Socio unSocio = new Socio(datosSocio[0], datosSocio[1], datosSocio[2], datosSocio[3], datosSocio[4]);
                socios.add(unSocio);            
//                System.out.println(unSocio.toString());
                line = fileReader.readLine();
            }            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cantidadTotalDePersonasRegistradas(){
        System.out.println("La cantidad total de personas registradas es "+socios.size());
    }
    
    public ArrayList<Socio> dameSociosDelClub(String Cuadro) {
        ArrayList<Socio> sociosDelClub = new ArrayList<Socio>();
        
        for(Socio unSocio : socios) {
            if(unSocio.getEquipo().equals(Cuadro))
                sociosDelClub.add(unSocio);
        }
        
        return sociosDelClub;
    }
    
    public Integer promedioDeEdadDeSocios(String club) {
        Equipo unEquipo = new Equipo(club, this.dameSociosDelClub(club));
        return unEquipo.getPromedioEdad();
    }
    
    public void listar100PrimerosSociosCasadosUniversitarios() {    
        //Este metodo los devuelve ordenados por edad.
        ArrayList<Socio> sociosFiltrados = new ArrayList<>();
        //Filtramos de la lista los socios que estan casados y son universitarios.    
        for(Socio unSocio : socios) {
            if(unSocio.getEstadoCivil().equals("Casado") && unSocio.getNivelDeEstidios().equals(Socio.estudios.UNIVERSITARIO)) {
                sociosFiltrados.add(unSocio);
            }            
        }
        
        sociosFiltrados.sort(Socio.edadComparator);
        
        int i =0;
        for(Socio unSocioFiltrado : sociosFiltrados) {
            System.out.println(unSocioFiltrado.toStringNombreEdadEquipo());            
            i++;
            if(i>=100)
                break;
        }
    }
    
    public void los5NombresMasComunesDe(String club) {
        /**
         * Primero filtro los socios de river y luego lo ordeno por nombre, para poder pasar linealmente (5 veces) por la
         * lista, y buscar los 5 maximos (1 en cada recorrido).
         * Si bien este no es el modo mas eficiente me aprecio el mas claro y simple.
         * Si se busca mayor eficiencia, se podria usar un countingSort de los nombres y quedarse con los 5 primeros.
         */
        ArrayList<String> masComunes = new ArrayList<>();
        ArrayList<Socio> sociosDeRiver= this.dameSociosDelClub(club);
        
        sociosDeRiver.sort(Socio.nombreComparator);                
        
        for(int i=0;i<5;i++) {            
            String nombreActual = sociosDeRiver.get(0).getNombre();
            String nombreMasComun = nombreActual;
            int max = 1;
            int actual = 1;
            for(Socio unSocio : sociosDeRiver) {
                String nombreSocio = unSocio.getNombre();
                if(!masComunes.contains(nombreSocio)) {
                    if(nombreActual.equals(nombreSocio)) {
                        actual++;
                        if(actual > max) {
                            max = actual;
                            nombreMasComun = nombreActual;
                        }
                    } else {
                        nombreActual= nombreSocio;
                        actual = 1;
                    }
                }
            }            
            masComunes.add(nombreMasComun);
        }
        
        for(String nombreComun : masComunes)
            System.out.println(nombreComun);
    }
    
    public void listaDeEquiposOrdenadaSegunCantidadDeSocios() {
        ArrayList<String> nombresDeEquipos = this.listadoDeEquipos();
        ArrayList<Equipo> equipos = new ArrayList<>();
        
        for(String nombre : nombresDeEquipos) {
            ArrayList<Socio> sociosDelEquipo = this.dameSociosDelClub(nombre);
            Equipo unEquipo = new Equipo(nombre, sociosDelEquipo);
            equipos.add(unEquipo);
        }
        
        equipos.sort(Equipo.cantidadDeSociosComparator);
        
        for(Equipo unEquipo : equipos) {
            System.out.println(unEquipo.toString());
        }
        
    }
    
    private ArrayList<String> listadoDeEquipos() {
        ArrayList<String> nombresEquipos = new ArrayList<>();
        
        for(Socio unSocio : socios) {
            if(!nombresEquipos.contains(unSocio.getEquipo()))
                nombresEquipos.add(unSocio.getEquipo());
        }
        
        return nombresEquipos;
    }
    
}
