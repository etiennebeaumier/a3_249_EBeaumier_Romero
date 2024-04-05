/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

public class Vocab {
    private Node head, tail;
    private int size = 0;

    private class Node {
        VocabSLL vocabSLL;
        Node next, prev;

        Node(VocabSLL vocabSLL) {
            this.vocabSLL = vocabSLL;
            this.next = null;
            this.prev = null;
        }
    }

    public void addTopic(String topicName) {
        VocabSLL newVocabSLL = new VocabSLL(topicName);
        Node newNode = new Node(newVocabSLL);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

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

    public VocabSLL removeAfter(String topicName) {
        Node current = head;
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

    public void displayTopics() {
        Node current = head;
        while (current != null) {
            System.out.println("Topic: " + current.vocabSLL.getWords());
            current.vocabSLL.displayWords();
            current = current.next;
        }
    }
}

