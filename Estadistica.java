/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manum_000
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.OutputStream;

public class Estadistica {

    //esta clase recibe la respuesta proporcionada por el ninyo/a y suma aciertos o fallos
    private int iAciertosM; //mates
    private int iFallosM;
    private int iAciertosI; //ingles
    private int iFallosI;
    private int iAciertosC;  //castellano
    private int iFallosC;
    static private String sFichero = "src/estadisticas";

    public Estadistica() throws FileNotFoundException, IOException { //inicializamos variables
        File archivo = new File(sFichero);
        if (archivo.createNewFile()) {
            iAciertosM = 0;
            iFallosM = 0;
            iAciertosI = 0;
            iFallosI = 0;
            iAciertosC = 0;
            iFallosC = 0;
            OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(archivo));
            os.write(iAciertosM + "\n" + iFallosM + "\n" + iAciertosI
                    + "\n" + iFallosI + "\n" + iAciertosC + "\n" + iFallosC);
            os.close();
        } else {
            FileReader read = new FileReader(sFichero);
            BufferedReader lec = new BufferedReader(read);
            String leyendo;
            int[] params = new int[6];
            for (int i = 0; (leyendo = lec.readLine()) != null; i++) {
                params[i] = Integer.parseInt(leyendo);
            }
            iAciertosM = params[0];
            iFallosM = params[1];
            iAciertosI = params[2];
            iFallosI = params[3];
            iAciertosC = params[4];
            iFallosC = params[5];

        }
    }

    /**
     * para sumar aciertos o fallos se especifica el nombre de la asignatura que
     * sera uno de los siguientes: mates, ing o cast.
     *
     * @param sAsig String
     */
    public void acierto(String sAsig) throws FileNotFoundException, IOException {
        //sumamos 1 por cada acierto
        //mates
        if (sAsig.compareToIgnoreCase("mates") == 0) {
            iAciertosM++;
        } else if (sAsig.compareToIgnoreCase("ing") == 0) {
            iAciertosI++;
        } else if (sAsig.compareToIgnoreCase("cast") == 0) {
            iAciertosC++;
        }
        FileOutputStream fos = new FileOutputStream(new File(sFichero));
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write(iAciertosM + "\n" + iFallosM + "\n" + iAciertosI
                + "\n" + iFallosI + "\n" + iAciertosC + "\n" + iFallosC);

        osw.close();
    }

    public void fallo(String sAsig) throws IOException {
        //sumamos 1 por cada fallo
        //mates
        if (sAsig.compareToIgnoreCase("mates") == 0) {
            iFallosM++;
        } else if (sAsig.compareToIgnoreCase("ing") == 0) {
            iFallosI++;
        } else if (sAsig.compareToIgnoreCase("cast") == 0) {
            iFallosC++;
        }
        FileOutputStream fos = new FileOutputStream(new File(sFichero));
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write(iAciertosM + "\n" + iFallosM + "\n" + iAciertosI
                + "\n" + iFallosI + "\n" + iAciertosC + "\n" + iFallosC);
        osw.close();
    }

    public int getiAciertosM() {
        return iAciertosM;
    }

    public int getiFallosM() {
        return iFallosM;
    }

    public int getiAciertosI() {
        return iAciertosI;
    }

    public int getiFallosI() {
        return iFallosI;
    }

    public int getiAciertosC() {
        return iAciertosC;
    }

    public int getiFallosC() {
        return iFallosC;
    }

}
