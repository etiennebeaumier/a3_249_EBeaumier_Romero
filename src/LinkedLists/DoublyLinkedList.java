/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

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

    /**
     * Adds a new topic to the list.
     *
     * @param topicName The name of the topic to add.
     */
    public void addTopic(String topicName) {
        Vocab newVocab = new Vocab(topicName);
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
     * Remove the last topic from the list.
     */
    public void removeEnd() {
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
     * @param topicName name of the topic
     */

    public void removeTopic(String topicName) {
        DNode current = head;
        while (current != null && !current.vocab.topic.equals(topicName)) {
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
        DNode current = head;
        while (current != null) {
            System.out.println(current.vocab.topic);
            current = current.next;
        }
    }

}

