/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero  FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

import java.io.PrintWriter;

/**
 * This class represents a singly linked list of words.
 */
public class SinglyLinkedList {

    private SNode head;
    private int size = 0;



    /**
     * This inner class represents a node in the singly linked list.
     */
    private class SNode {
        String word;
        SNode next;

        SNode(String word) {
            this.word = word;
            this.next = null;
        }
    }

    /**
     * Constructor to initialize the list of words.
     *
     */
    public SinglyLinkedList() {
        size = 0;
        this.head = null;
    }

    /**
     * Method to add a word to the singly linked list.
     *
     * @param word The word to add.
     */
    public void addWord(String word) {
        SNode newSNode = new SNode(word);
        if (head == null || head.word.compareTo(word) > 0) {
            newSNode.next = head;
            head = newSNode;
        } else {
            SNode current = head;
            while (current.next != null && current.next.word.compareTo(word) < 0) {
                current = current.next;
            }
            newSNode.next = current.next;
            current.next = newSNode;
        }
        size++;
    }

/**
     * Method to verify if the topic contains a given word.
     *
     * @param word to check for.
     * @return True if the word is in the topic, false otherwise.
     */
    public boolean contains(String word){
        SNode current = head;
        while(current!=null){
            if(current.word.equalsIgnoreCase(word)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /**
     * Method to change a given word.
     *
     * @param wordToChange The word to replace by the new word.
     * @param newWord The new word to add.
     */
    public void changeWord(String wordToChange, String newWord) {
        SNode current = head;
        if(head.word.equals(wordToChange)){
            head.word = newWord;
        }
        while(current!=null){
            if(current.word.equals(wordToChange)){
                current.word = newWord;
                break;
            }
            current = current.next;

        }

    }

    /**
     * Method to remove the last word from the singly linked list.
     *
     * @return The last word removed.
     */
    public String removeLastWord() {
        if (head == null) {
            return null;
        }
        if (size == 1) {
            String word = head.word;
            head = null;
            size = 0;
            return word;
        }
        SNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        String word = current.next.word;
        current.next = null;
        size--;
        return word;
    }


    /**
     * Method to remove the word after a given word.
     *
     * @param word The word after which to remove the next word.
     * @return The word removed.
     */
    public String removeWordAfter(String word) {
        if (head == null || head.next == null) {
            return null;
        }
        SNode current = head;
        while (current != null && !current.word.equals(word)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return null;
        }
        String removedWord = current.next.word;
        current.next = current.next.next;
        size--;
        return removedWord;
    }


    /**
     * Method to remove a word from the singly linked list.
     *
     * @param word The word to remove.
     * @return True if the word was removed, false otherwise.
     */
    public boolean removeWord(String word) {
        // Case when list is empty or word is null
        if (head == null || word == null) {
            return false;
        }

        // Case when the head is the node to be removed
        if (head.word.equals(word)) {
            head = head.next;
            size--;
            return true;
        }

        SNode current = head;
        SNode previous = null;

        // Traverse the list to find the node to remove
        while (current != null && !current.word.equals(word)) {
            previous = current;
            current = current.next;
        }

        // If the word was not found in the list
        if (current == null) {
            return false;
        }

        // Skip over the node to remove it
        previous.next = current.next;
        size--;
        return true;
    }


    /**
     * Method to display the words in the singly linked list.
     */
    public void displayWords() {
        SNode current = head;
        int counter =0;
        while (current != null) {
            if(counter%4==0){
                System.out.println();
            }
            counter++;
            System.out.print(counter + ": " +current.word + "\t\t ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayWordsStartingWith(String letter){
        SNode current = head;
        while(current!=null){
            if(current.word.startsWith(letter)){
                System.out.println(current.word);
            }
            current = current.next;
        }
    }

    public void saveToFile(PrintWriter writer) {
        SNode current = head;
        while (current != null) {
            writer.println(current.word);
            current = current.next;
        }
    }

}

