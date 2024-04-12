import LinkedLists.DoublyLinkedList;
import LinkedLists.Vocab;

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
                case 2:
                    System.out.println("-----------------------------");
                    System.out.println("Pick a topic ");
                    System.out.println("-----------------------------");
                    vocabList.displayTopics();
                    int topicToInsertBefore = scn.nextInt();
                    System.out.println("Enter a topic name:");
                    scn.nextLine();
                    String newTopic = scn.nextLine();
                    Vocab newTopicToAddBefore= new Vocab(newTopic);
                    vocabList.addTopicBefore(newTopicToAddBefore,topicToInsertBefore);
                    vocabList.displayTopics();
                    break;

                    case 3:
                    System.out.println("-----------------------------");
                    System.out.println("Pick a topic ");
                    System.out.println("-----------------------------");
                    vocabList.displayTopics();
                    int topicToInsertAfter = scn.nextInt();
                    System.out.println("Enter a topic name:");
                    scn.nextLine();
                    String newTopicAfter = scn.nextLine();
                    Vocab newTopicToAddAfter= new Vocab(newTopicAfter);
                    vocabList.addTopicAfter(newTopicToAddAfter,topicToInsertAfter);
                    vocabList.displayTopics();
                    break;

                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("Pick a topic to remove: ");
                    System.out.println("-----------------------------");
                    vocabList.displayTopics();
                    int topicToRemove = scn.nextInt();
                    vocabList.removeTopic(topicToRemove);
                    vocabList.displayTopics();
                    break;

                case 5:
                    System.out.println("-----------------------------");
                    System.out.println("Pick a topic to modify: ");
                    System.out.println("-----------------------------");
                    vocabList.displayTopics();
                    int topicToModify = scn.nextInt();
                    vocabList.modifyTopic(topicToModify);
                    break;


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
            Enter your choice:""");
}
}

