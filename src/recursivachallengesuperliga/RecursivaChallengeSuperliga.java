/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivachallengesuperliga;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Alex3D
 */
public class RecursivaChallengeSuperliga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SociosManager Manager = new SociosManager();
        Manager.leerYParsearSocios("socios.csv");
        Manager.cantidadTotalDePersonasRegistradas();
                
        System.out.println("El promedio de edad de los socios de racing es: "+ Manager.promedioDeEdadDeSocios("Racing"));
        Manager.listar100PrimerosSociosCasadosUniversitarios();
        System.out.println("Los 5 nombres mas comunes entre los socios de river son: ");
        Manager.los5NombresMasComunesDe("River");
        Manager.listaDeEquiposOrdenadaSegunCantidadDeSocios();
    }
    
    
}
