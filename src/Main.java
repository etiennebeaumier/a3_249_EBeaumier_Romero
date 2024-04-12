import LinkedLists.DoublyLinkedList;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        InitialVocab loader = new InitialVocab();
        DoublyLinkedList vocabList = loader.loadVocabFromFile("resources/A3_input_file.txt");
        Scanner scn = new Scanner(System.in);

        while (true) {
            displayMenu();

            //validates the choice of the user
            String Strchoice = scn.next();
            scn.nextLine();

            while (Strchoice.length() != 1 || Strchoice.charAt(0) < '0' || Strchoice.charAt(0) > '9') {
                System.out.println("Invalid input. Please enter a number.");
                Strchoice = scn.next();
            }

            //choice is now int
            int choice = Integer.parseInt(Strchoice);

            switch (choice) {
                case 7:
                    System.out.println("Enter the name of the file to load from: ");
                    String filename = scn.nextLine();
                    vocabList = loader.loadVocabFromFile("resources/"+filename);
                    break;
                case 9:

                    break;
                case 0:
                    System.out.println("Exiting...");
                    scn.close();
                    System.exit(0);
                    break;
            }
        }


    }



public static void displayMenu() {
    System.out.println("""
            -----------------------------\s
            Vocabulary Control Center\s
            -----------------------------
            1 browse a topic
            2 insert a new topic before another one
            3 insert a new topic after another one
            4 remove a topic
            5 modify a topic
            6 search topics for a word
            7 load from a file
            8 show all words starting with a given letter
            9 save to file
            0 exit
            -----------------------------
            Enter your choice: """);
}
}

