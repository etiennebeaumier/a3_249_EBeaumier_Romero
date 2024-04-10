import LinkedLists.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is responsible for loading the initial vocabulary from a file.
 */
public class InitialVocab {

    /**
     * Load the initial vocabulary from a file.
     *
     * @param filename The name of the file to load the vocabulary from.
     * @return A DoublyLinkedList containing the initial vocabulary.
     */
    public DoublyLinkedList loadVocabFromFile(String filename) {
        DoublyLinkedList vocabList = new DoublyLinkedList();
        Scanner scn = null;

        try {
            scn = new Scanner(new FileInputStream(filename));

            Vocab currentVocab = null;

            while (scn.hasNextLine()) {
                String line = scn.nextLine().trim();
                if (line.isEmpty()) continue; // Skip empty lines

                if (line.startsWith("#")) {
                    // New topic
                    if (currentVocab != null) {
                        // Add the completed Vocab to the list
                        vocabList.addTopic(currentVocab);
                    }
                    // Start a new Vocab
                    String topicName = line.substring(1).trim(); // Remove the '#' and trim
                    currentVocab = new Vocab(topicName);

                } else {
                    // Word for the current topic
                    if (currentVocab != null) {
                        currentVocab.addWord(line);
                    }
                }
            }
            // Add the last Vocab if it hasn't been added yet
            if (currentVocab != null) {
                vocabList.addTopic(currentVocab);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null; // Return null to indicate that loading failed
        } finally {
            if (scn != null) {
                scn.close();
            }
        }

        return vocabList;
    }
}