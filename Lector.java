
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manum_000
 */

public class Lector {

    FileReader read;
    BufferedReader lec;
    Nivel nTres;
    Nivel nCinco;
    Nivel nSiete;

    public Lector() {

    }
/**
 * metodo que lee las preguntas del fichero txt de preguntas (separadas por ,#) y crea las clases correspondientes de nivel y pregunta
 * @return array de objetos nivel (niveles 3,5,7) que contiene todos los datos que se han creado
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public Nivel[] leerPreguntas() throws FileNotFoundException, IOException {
        read = new FileReader("ruta de android");
        lec = new BufferedReader(read);
        String leyendo = null;
        String splitter = ",#";
        String[] params = null;//separa los parametros para el constructor de cada pregunta
        String[] temp = null; //string en el que se pasarán las 4 opciones de respuesta
        int lv; //nivel en el que se anyadira la pregunta
        Nivel[] niveles;
        niveles = new Nivel[3];

        leyendo = lec.readLine();
        while (leyendo != null) { //bucle que lee linea a linea hasta el final del fichero
            params = leyendo.split(splitter);
            temp = new String[4];
            lv = Integer.parseInt(params[0]);
            //asignamos las opciones en un array de strings auxiliar
            temp[0] = params[5];
            temp[1] = params[6];
            temp[2] = params[7];
            temp[3] = params[8];
            //llamada constructor
            Pregunta inPregunta;
            inPregunta = new Pregunta(params[1], params[2], params[3], Integer.parseInt(params[4]), temp);
            switch (lv) {
                case 3:
                    nTres.anyadirPregunta(inPregunta);
                    break;
                case 5:
                    nCinco.anyadirPregunta(inPregunta);
                    break;
                case 7:
                    nSiete.anyadirPregunta(inPregunta);
                    break;
            }
            leyendo = lec.readLine();
        }

        niveles[0] = nTres;
        niveles[1] = nCinco;
        niveles[2] = nSiete;
return niveles;
    }
/**
 * metodo que lee el fichero que contiene en una linea el nombre de usuario y la contraseña separados por ',#'
 * @return devuelve un array de string donde la pos 0 es el usuario y la pos 1 es la password
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public String[] leerLogin() throws FileNotFoundException, IOException {
        read = new FileReader("ruta de android");
        lec = new BufferedReader(read);    
            String[] login = null;
            String splitter = ",#";
            String usuario=null;
            String password=null;
            String leyendo = null;
            leyendo=lec.readLine();
            login=leyendo.split(splitter);
            return(login);
    }
    
}
