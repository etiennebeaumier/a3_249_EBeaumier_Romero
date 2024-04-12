/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class represents a doubly linked list of topics. Each topic has a singly linked list of words.
 */
public class DoublyLinkedList {
    private DNode head, tail;
    private int size = 0;

    /**
     * This inner class represents a node in the doubly linked list.
     */
    private class DNode {
        Vocab vocab;
        DNode next, prev;

        DNode(Vocab vocab) {
            this.vocab = vocab;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Constructor to initialize the doubly linked list.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addTopic(Vocab newVocab) {
        DNode newNode = new DNode(newVocab);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    /**
     * Adds a new topic after a specific topic in the list.
     *
     * @param newVocab the topic and list of words to add
     * @param topic the topic after which the new topic should be added in the list
     */
    public void addTopicAfter(Vocab newVocab, int topic) {
        int index=1;
        if (newVocab == null) {
            throw new NullPointerException("newVocab cannot be null.");
        }
        DNode newNode = new DNode(newVocab);
        if (head == null) {
            // If the list is empty, the new topic becomes the head and tail.
            head =tail= newNode;

        } else {
            DNode current=head;
            while (current!=null){
                if(index== topic){
                    // Found the topic after which to add the new topic.
                    newNode.next=current.next;
                    newNode.prev=current;
                    if(current.next!=null){
                        // If current is not the last node, adjust the next node's prev pointer.
                        current.next.prev=newNode;
                    }
                    else{
                        // If current is the last node, new node becomes the new tail.
                        tail=newNode;
                    }
                    current.next=newNode;
                    size++;
                    return;
                }
                current=current.next;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

    }
/**
     * Adds a new topic before a specific topic in the list.
     *
     * @param newVocab the topic and list of words to add
     * @param topic the topic before which the new topic should be added in the list
     */
    public void addTopicBefore(Vocab newVocab, int topic){
        int index = 1;
        if (newVocab == null) {
            throw new NullPointerException("newVocab cannot be null.");
        }
        DNode newNode=new DNode(newVocab);
        if(head==null){
            // If the list is empty, the new topic becomes the head and tail.
            head=tail=newNode;
        }
        else {
            DNode current=head;
            while (current!=null) {
                if (index== topic) {
                    // Found the topic after which to add the new topic.
                    newNode.prev = current.prev;
                    newNode.next = current;

                    if (current.prev != null) {
                        // If current is not the first node, adjust the previous node's next pointer.
                        current.prev.next = newNode;
                    } else {
                        // If current is the first node, new node becomes the new head.
                        head = newNode;
                    }
                    current.prev = newNode;
                    size++;
                    return;
                }
                current = current.next;
                index++;
            }
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }

    }

    /**
     * Modify a topic by adding, removing, or changing words.
     * @param topicToModify the index of the topic to modify
     */
    public void modifyTopic(int topicToModify) {
        DNode current = head;
        int index = 1;
        while (current != null) {
            if (index==topicToModify) {
                break; // Found the topic, break the loop
            }
            current = current.next; // Otherwise, move to the next node
            index++;
        }

        if (current == null) {
            System.out.println("There is no topic of this name");
            return;
        } else {
            Scanner keyboard = new Scanner(System.in);
            String choice;
            do {
                displayToModifyMenu();
                choice = keyboard.nextLine();
                switch (choice) {
                    case "a":
                        System.out.println("Enter the word to add: ");
                        String wordToAdd = keyboard.nextLine();
                        current.vocab.addWord(wordToAdd);
                        break;
                    case "b":
                        System.out.println("Enter the word to remove: ");
                        String wordToRemove = keyboard.nextLine();
                        current.vocab.removeWord(wordToRemove);
                        break;
                    case "c":
                        System.out.println("Enter the word to change: ");
                        String wordToChange = keyboard.nextLine();
                        System.out.println("Enter the new word: ");
                        String newWord = keyboard.nextLine();
                        current.vocab.changeWord(wordToChange, newWord);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (!"0".equals(choice));

        }
        System.out.println("Topic modified successfully");
    }



    public void displayToModifyMenu(){
        System.out.println("-----------------------------");
        System.out.println("Modify Topics Menu");
        System.out.println("-----------------------------");
        System.out.println("a. Add a word to the topic");
        System.out.println("b. Remove a word from the topic");
        System.out.println("c. Change a word in the topic");
        System.out.println("0. Exit");
        System.out.println("-----------------------------");
        System.out.println("Enter your choice: ");
    }
    /**
     * Remove the last topic from the list.
     */
    public void removeEnd(){
        if (tail != null) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                head = null;
                tail = null;
            }
            size--;
        }
    }

    /**
     * Remove the topic that comes after the specified topic
     * @param topicName name of the topic
     */
    public void removeAfterTopic(String topicName) {
        DNode current = head;
        while (current != null && !current.vocab.topic.equals(topicName)) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            DNode toRemove = current.next;
            current.next = toRemove.next;
            if (toRemove.next != null) {
                toRemove.next.prev = current;
            } else {
                tail = current;
            }
            size--;
        }
    }

    /**
     * Remove the specified topic
     * @param topicToRemove name of the topic
     */

    public void removeTopic(int topicToRemove) {
        int index=1;
        DNode current = head;
        while (current != null && index!=topicToRemove) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            size--;
        }
    }

    /**
     * Display all topics in the list.
     */
    public void displayTopics() {
        int index = 1;
        DNode current = head;
        while (current != null) {
            System.out.println(index+". "+current.vocab.topic);
            current = current.next;
            index++;
        }
    }

    public String displayTopic(int index) {
        int i = 1;
        DNode current = head;
        while (current != null) {
            if (i == index) {
                return current.vocab.topic;
            }
            current = current.next;
            i++;
        }
        return "Topic not found.";
    }

    /**
     * Display all words in a topic.
     * @param topicName name of the topic
     */
    public void displayWords(String topicName) {
        DNode current = head;
        while (current != null) {
            if (current.vocab.topic.equals(topicName)) {
                current.vocab.displayWords();
                return;
            }
            current = current.next;
        }
        System.out.println("Topic not found.");
    }

    public String searchWord(String word){
        DNode current = head;
        while (current != null) {
            if (current.vocab.words.contains(word)) {
                return current.vocab.topic;
            }
            current = current.next;
        }
        return "Word not found.";
    }

    public void displayWordsStartingWith(String letter){
        DNode current = head;
        while (current != null) {
            current.vocab.displayWordsStartingWith(letter);
            current = current.next;
        }
    }

    public boolean saveToFile(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(filename));
            DNode current = head;
            while (current != null) {
                writer.println("# " + current.vocab.topic);
                current.vocab.saveToFile(writer);
                current = current.next;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}

