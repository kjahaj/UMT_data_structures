public class WordOccurrence implements Comparable<WordOccurrence>  {
    int occurrence;
    String word;
    public WordOccurrence(String word,int occurrence) {
        this.occurrence = occurrence;
        this.word = word;
    }
    public int getOccurrence() {
        return occurrence;
    }
     @Override
    public int compareTo(WordOccurrence o) {
        if(this.occurrence>o.getOccurrence()){
            return -1;
        } else if (this.occurrence<o.getOccurrence()){
            return 1;
        }
        else return 0;
    }
}