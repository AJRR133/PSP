package Unidad1.boletin2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorPython {

    public static void main(String[] args) {

        try {

            ProcessBuilder pb = new ProcessBuilder("python", "src\\main\\resources\\fichero.py");

            pb.redirectErrorStream(true); 
            pb.inheritIO(); 

            Process process = pb.start(); 
            process.waitFor();

        } catch (IOException | InterruptedException e) {

            e.printStackTrace();

        }

    }

}

