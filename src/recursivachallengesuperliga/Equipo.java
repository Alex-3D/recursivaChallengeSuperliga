/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivachallengesuperliga;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Alex3D
 */
public class Equipo {
        private String nombre;
        private ArrayList<Socio> Socios;                           

        public Equipo(String nombre, ArrayList<Socio> Socios) {
            this.nombre = nombre;
            this.Socios = Socios;
        }

        public String getNombre() {
            return nombre;
        }

        public ArrayList<Socio> getSocios() {
            return Socios;
        }  

        public Integer getCantidadDeSocios() {
            return Socios.size();
        }

        public Integer getPromedioEdad() {
            Integer promedio = 0;

            for(Socio unSocio : Socios) {
                promedio += unSocio.getEdad();
            }

            promedio = promedio/Socios.size();
            return promedio;
        }

        public Integer getMayorEdad() {
            Integer mayorEdad = 0;
            for(Socio unSocio : Socios) {
                if(unSocio.getEdad() > mayorEdad) {
                    mayorEdad = unSocio.getEdad();
                }
            }
            
            return mayorEdad;
        }

        public Integer getMenorEdad() {
            Integer menorEdad = Socios.get(0).getEdad();
            for(Socio unSocio : Socios) {
                if(unSocio.getEdad() < menorEdad) {
                    menorEdad = unSocio.getEdad();
                }
            }
            
            return menorEdad;
        }
        
        public static Comparator<Equipo> cantidadDeSociosComparator = new Comparator<Equipo>() {
            @Override
            public int compare(Equipo e1, Equipo e2) {
                return e2.getCantidadDeSocios() - e1.getCantidadDeSocios();
            }
        };
        
        @Override
        public String toString() {
            return "Equipo{" + "nombre=" + nombre + ", promedio de edad=" + this.getPromedioEdad() + ", Mayor edad=" + this.getMayorEdad() + ", Menor edad=" + this.getMenorEdad() + '}';
        }
                              
    }
