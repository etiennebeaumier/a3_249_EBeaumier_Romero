import LinkedLists.DoublyLinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InitialVocab loader = new InitialVocab();
        DoublyLinkedList vocabList = loader.loadVocabFromFile("resources/A3_input_file.txt");

        if (vocabList != null) {
            vocabList.displayTopics();
        }
    }
}

