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
                case 1:
                    while (true) {
                        System.out.println("-----------------------------");
                        System.out.println("Pick a topic ");
                        System.out.println("-----------------------------");
                        vocabList.displayTopics();
                        System.out.println("0. Exit");

                        System.out.println("-----------------------------");
                        System.out.print("Enter your choice: ");
                        int topicToBrowse = scn.nextInt();
                        if (topicToBrowse == 0) {
                            break;
                        }
                        String topic = vocabList.displayTopic(topicToBrowse);
                        System.out.println("Topic: " + topic);
                        vocabList.displayWords(topic);
                    }
                    break;
                case 2:
                    System.out.println("-----------------------------");
                    System.out.println("Pick a topic ");
                    System.out.println("-----------------------------");
                    vocabList.displayTopics();
                    System.out.println("0. Exit");
                    int topicToInsertBefore = scn.nextInt();
                    if (topicToInsertBefore == 0) {
                        break;
                    }
                    System.out.println("Enter a topic name:");
                    scn.nextLine();
                    String newTopic = scn.nextLine();
                    Vocab newTopicToAddBefore = new Vocab(newTopic);
                    vocabList.addTopicBefore(newTopicToAddBefore, topicToInsertBefore);
                    vocabList.displayTopics();
                    break;

                case 3:
                    System.out.println("-----------------------------");
                    System.out.println("Pick a topic ");
                    System.out.println("-----------------------------");
                    vocabList.displayTopics();
                    System.out.println("0. Exit");
                    int topicToInsertAfter = scn.nextInt();
                    if (topicToInsertAfter == 0) {
                        break;
                    }
                    System.out.println("Enter a topic name:");
                    scn.nextLine();
                    String newTopicAfter = scn.nextLine();
                    Vocab newTopicToAddAfter = new Vocab(newTopicAfter);
                    vocabList.addTopicAfter(newTopicToAddAfter, topicToInsertAfter);
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
                case 6:
                    System.out.println("Enter a word to search for: ");
                    String word = scn.nextLine();
                    if (!vocabList.searchWord(word).equals("Word not found.")) {
                        System.out.println("The word " + word + " can be found in the topic "
                                + vocabList.searchWord(word));
                    } else {
                        System.out.println("The word " + word + " was not found in any topic.");

                    }
                    break;

                case 7:
                    System.out.println("Enter the name of the file to load from: ");
                    String filename = scn.nextLine();
                    vocabList = loader.loadVocabFromFile("resources/" + filename);
                    break;

                case 8:
                    System.out.println("Enter a letter: ");
                    String letter = scn.nextLine();
                    while (letter.length() != 1) {
                        System.out.println("Invalid input. Please enter a single letter.");
                        letter = scn.nextLine();
                    }
                    System.out.println(vocabList.displayWordsStartingWith(letter));
                    break;

                case 9:
                    System.out.println("Enter the name of the file to save to: ");
                    String saveFilename = scn.nextLine();
                    vocabList.saveToFile("resources/" + saveFilename);

                    break;

                    case 10:
                        System.out.println("Enter a word ");
                        String tocheck = scn.nextLine();
                        vocabList.displayWordsStartingWith(tocheck);
                case 0:
                    System.out.println("Exiting...");
                    scn.close();
                    System.exit(0);
                    break;
            }
        }


    }

    /**
     * Method to display the menu of options for the user.
     */
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

