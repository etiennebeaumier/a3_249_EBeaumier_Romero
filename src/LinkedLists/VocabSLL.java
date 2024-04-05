/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

/**
 * This class represents a singly linked list of words.
 */
public class VocabSLL {
    private String words;
    private Node head;
    private int size = 0;

    /**
     * This inner class represents a node in the singly linked list.
     */
    private class Node {
        String word;
        Node next;

        Node(String word) {
            this.word = word;
            this.next = null;
        }
    }

    /**
     * Constructor to initialize the list of words.
     *
     * @param words The list of words.
     */
    public VocabSLL(String words) {
        this.words = words;
        this.head = null;
    }

    /**
     * Method to add a word to the singly linked list.
     *
     * @param word The word to add.
     */
    public void addWord(String word) {
        Node newNode = new Node(word);
        if (head == null || head.word.compareTo(word) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.word.compareTo(word) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

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
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        String word = current.next.word;
        current.next = null;
        size--;
        return word;
    }

    public String removeWordAfter(String word) {
        if (head == null || head.next == null) {
            return null;
        }
        Node current = head;
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

    public void displayWords() {
        Node current = head;
        while (current != null) {
            System.out.print(current.word + " ");
            current = current.next;
        }
        System.out.println();
    }

    public String getWords() {
        return words;
    }
}

