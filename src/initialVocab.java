import LinkedLists.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class initialVocab {

    public void initialVocab(){

        Scanner scn = null;

        try{
           scn =  new Scanner(new FileInputStream("resources/A3_input_file.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
