import java.util.*;
public class Main {
    public static void main(String[] args) {
    int[] list = {3, 2, 3, 5, 4, 8,
                9, 10};
    ArrayList<Integer> list1 = new ArrayList<>();
      for(Integer i : list){
        list1.add(i);
      }

    List<Integer> l1;
      l1 = LCS(list1);
        System.out.println(l1);


    }


    /*Write a Java program that takes a list of integers as input and returns the longest subsequence of
    consecutive integers in the list. */
    public static List<Integer> LCS(ArrayList<Integer> list){
        int[] lcsSize = new int[list.size()];
        Arrays.fill(lcsSize,1);
        //Dynamic programming for finding the length of the LCS
        for(int i = 1; i<lcsSize.length; i++){
            for (int j = 0; j<i; j++){
                if(list.get(i)>list.get(j) && lcsSize[i]<=lcsSize[j]){
                    lcsSize[i]=lcsSize[j]+1;
                }
            }
        }
        //Displaying that array
        int max = maxOfArray(lcsSize);
        int position=0;
        for(int i=0;i< lcsSize.length;i++) {
             if(lcsSize[i]==max){
                position = i;
             }
        }

        List<Integer> newList = new ArrayList<>();
        newList.add(list.get(position));
        int temp = position;

        for (int i = temp; i > 0; i--){
            if((lcsSize[position]-1)==lcsSize[i-1]){
                newList.add(list.get(i-1));
                position=i-1;
            }
        }

        List<Integer> endList = new ArrayList<>();
        for (int i = newList.size() - 1; i >= 0; i--) {
            endList.add(newList.get(i));
        }

        return endList;
    }
    public static int maxOfArray(int[] arr){
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        Arrays.sort(temp);
        return temp[temp.length-1];
    }

}