import java.util.Random;
import java.util.*;
public class Main {
    public static final int size = 100000;
    public static final int nrOfTests = 100;
    public static final int length = 10;
    public static void main(String[] args) {


        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i<size; i++){
            String rand = randomString(length,random);
            linkedList.add(rand);
            arrayList.add(rand);
        }

        long linkedListTime = 0;
        long arrayListTime = 0;

        for (int i = 0; i < nrOfTests; i++) {
            String target = randomString(10,random);

            long startTime = System.nanoTime();
            int index = linkedList.indexOf(target);
            long endTime = System.nanoTime();
            linkedListTime += (endTime - startTime);

            // Search ArrayList
            startTime = System.nanoTime();
            index = arrayList.indexOf(target);
            endTime = System.nanoTime();
            arrayListTime += (endTime - startTime);
        }
        double avgLinkedListTime = (double) linkedListTime / 100;
        double avgArrayListTime = (double) arrayListTime / 100;

        System.out.println("Time approximate in milliseconds to search in the Linked List : "+avgLinkedListTime/1000000);
        System.out.println("Time approximate in milliseconds to search in the Array List : "+avgArrayListTime/1000000);

    }
    private static String randomString(int lengthy, Random random) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(lengthy);
        for (int i = 0; i < lengthy; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

}
/*
First run:
Time approximate in milliseconds to search in the Linked List : 2.084782
Time approximate in milliseconds to search in the Array List : 1.80603

Second run:
Time approximate in milliseconds to search in the Linked List : 2.127372
Time approximate in milliseconds to search in the Array List : 1.907307

Array Lists are faster I guess
 */