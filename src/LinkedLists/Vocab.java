/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

import LinkedLists.SinglyLinkedList;

public class Vocab {
    String topic;
    SinglyLinkedList words;

    /**
     * Constructor to initialize the Vocab object.
     *
     * @param topicName The name of the topic.
     */
    public Vocab(String topicName) {
        this.topic = topicName;
        this.words = new SinglyLinkedList();
    }

    /**
     * Method to add a word to the Vocab's word list.
     *
     * @param word The word to add.
     */
    public void addWord(String word) {
        words.addWord(word);
    }

    /**
     * Method to remove the last word from the Vocab's word list.
     * @return String The word that was removed.
     */
    public String removeLastWord() {
        return words.removeLastWord();
    }

    /**
     * Method to remove a word from the Vocab's word list.
     *
     * @param word The word to remove.
     * @return boolean True if the word was removed, false otherwise.
     */
    public boolean removeWord(String word) {
        return words.removeWord(word);
    }

    /**
     * Method to remove the word after a given word in the Vocab's word list.
     *
     * @param previousWord The word before the word to remove.
     * @return String The word that was removed.
     */
    public String removeWordAfter(String previousWord) {
        return words.removeWordAfter(previousWord);
    }

    /**
     * Method print all the words in the Vocab's word list.
     */
    public void displayWords() {
        System.out.println("Topic: " + this.topic);
        words.displayWords();
    }
}
