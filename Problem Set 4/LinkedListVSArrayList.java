import java.util.Random;
import java.util.*;
public class LinkedListVSArrayList {
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
            int randomIndex = random.nextInt(arrayList.size());
            String target = arrayList.get(randomIndex);

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
    private static String randomString(int length, Random random) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }

}
/*
First run:
Time approximate in milliseconds to search in the Linked List : 1.012019
Time approximate in milliseconds to search in the Array List : 0.908693

Second run:
Time approximate in milliseconds to search in the Linked List : 0.939477
Time approximate in milliseconds to search in the Array List : 0.862222

Array Lists are faster I guess
 */
