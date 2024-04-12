/* -----------------------------------------------------
         //Assignment 2
         //Question: Main Class
        // Written by: Étienne Beaumier, 40211362
                       Romero FAUSTIN,   40234898
// -----------------------------------------------------
*/

package LinkedLists;

import java.io.PrintWriter;

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
     * Method to remove the last word from the Vocab's topic.
     * @return String The topic contained in the vocab.
     */
    public String getTopic(){
        return this.topic;
    }

    /**
     * Method to add a word to the Vocab's word list.
     *
     * @param word The word to add.
     */
    public void addWord(String word) {
        if(words.contains(word)){
            System.out.println("The word you are trying to add already exists in the list.");
        }
        else{
            words.addWord(word);
        }
    }

    /**
     * Method to change a word in the Vocab's word list.
     *
     * @param word The word to change.
     * @param newWord The new word to replace the old word.
     */
    public void changeWord(String word, String newWord) {
        if(words.contains(word)){
        words.changeWord(word, newWord);
    }
        else {
            System.out.println("The word you are trying to change does not exist in the list.");
        }
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
        if(!words.contains(word)){
            System.out.println("The word you are trying to remove does not exist in the list.");
            return false;
        }
        else{
            return words.removeWord(word);
        }
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
        words.displayWords();
    }
    public void displayWordsStartingWith(String letter){
         words.displayWordsStartingWith(letter);
    }

    public void saveToFile(PrintWriter writer) {
        words.saveToFile(writer);
    }
}
