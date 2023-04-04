import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Main {
    public static void main(String[] args) {
        try {
            File file = new File("longText.txt");
            Scanner scanner = new Scanner(file);
            LinkedList<WordOccurrence> wordList = new LinkedList<>();
            while(scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z ]", "");
                WordOccurrence wordOccurrence = findWordOccurrence(wordList, word);
                    if (!Objects.equals(wordOccurrence, null)) {
                        wordOccurrence.occurrence++;
                    } else {
                        wordList.add(new WordOccurrence(word, 1));
                    }
            }
            Collections.sort(wordList);
            for (WordOccurrence node : wordList) {
                System.out.println(node.word + ": " + node.occurrence);
            }
        }catch (FileNotFoundException exception){
            System.out.println(exception.getMessage());
        }
    }
    public static WordOccurrence findWordOccurrence(LinkedList<WordOccurrence> wordList, String word) {
        for (WordOccurrence node : wordList) {
            if (node.word.contains(word)) {
                return node;
            }
        }
        return null;
    }
}



