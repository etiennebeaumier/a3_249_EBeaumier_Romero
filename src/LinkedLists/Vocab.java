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
public class Vocab {
    private DNode head, tail;
    private int size = 0;

    /**
     * This inner class represents a node in the doubly linked list.
     */
    private class DNode {
        VocabSLL vocabSLL;
        DNode next, prev;

        DNode(VocabSLL vocabSLL) {
            this.vocabSLL = vocabSLL;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Method to add a topic to the doubly linked list.
     *
     * @param topicName The topic to add.
     */
    public void addTopic(String topicName) {
        VocabSLL newVocabSLL = new VocabSLL(topicName);
        DNode newDNode = new DNode(newVocabSLL);
        if (head == null) {
            head = tail = newDNode;
        } else {
            tail.next = newDNode;
            newDNode.prev = tail;
            tail = newDNode;
        }
        size++;
    }

    /**
     * Remove the last topic from the doubly linked list.
     * @return removedVocabSLL The removed list of words.
     */
    public VocabSLL removeEnd() {
        if (head == null) {
            return null;
        }
        VocabSLL removedVocabSLL = tail.vocabSLL;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removedVocabSLL;
    }

    /**
     * Remove the topic after the specified topicName.
     * @param topicName The topic after which to remove.
     * @return removedVocabSLL The removed list of words.
     */
    public VocabSLL removeAfter(String topicName) {
        DNode current = head;
        while (current != null && !current.vocabSLL.getWords().equals(topicName)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return null;
        }
        VocabSLL removedVocabSLL = current.next.vocabSLL;
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;
        if (current.next != null) {
            current.next.prev = current;
        }
        size--;
        return removedVocabSLL;
    }

    /**
     * Remove the topic with the specified topicName.
     * @param topicName The topic to remove.
     * @return removedVocabSLL The removed list of words.
     */
    public boolean removeNode(String topicName) {
        // If the list is empty or topicName is null
        if (head == null || topicName == null) {
            return false;
        }

        // If the head needs to be removed
        if (head.vocabSLL.getWords().equals(topicName)) {
            // If there's only one item in the list
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return true;
        }

        DNode current = head;

        // Traverse the list to find the node that matches the topicName
        while (current != null && !current.vocabSLL.getWords().equals(topicName)) {
            current = current.next;
        }

        // If the node wasn't found
        if (current == null) {
            return false;
        }

        // If the tail needs to be removed
        if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else { // Node is in the middle
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return true;
    }


    /**
     * Method to display the topics in the doubly linked list, as well as the words in each topic.
     */
    public void displayTopics() {
        DNode current = head;
        while (current != null) {
            System.out.println("Topic: " + current.vocabSLL.getWords());
            current.vocabSLL.displayWords();
            current = current.next;
        }
    }
}

