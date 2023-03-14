import java.util.*;
public class Main {
    public static void main(String[] args) {


    }



    /*Write a function (findUnique) that takes a list of strings as input and returns a new list
     containing only the unique strings from the original list, in the order they first appear*/
    public static ArrayList<String> findUnique(ArrayList<String> fullList){
        ArrayList<String> newList = new ArrayList<>();
        for (String s : fullList) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        return newList;
    }



   /* 2. Write a function (findEven) that takes a list of integers as input and returns a new list
    containing only the even integers from the original list, in the order they first appear.*/
    public static ArrayList<Integer> findEven(ArrayList<Integer> fullArray){
        ArrayList<Integer> newArray = new ArrayList<>();
        for (Integer i : fullArray){
            if(i%2==0){
                newArray.add(i);
            }
        }
        return newArray;
    }



   /*3. Write a function (findKthSmallest) that takes a list of integers as input and returns the
    k-th smallest integer in the list, where k is an integer parameter passed to the function. */
   public static int findKthSmallest(List<Integer> list, int k) {
       ArrayList<Integer> KthSmallest = new ArrayList<>(list);
       Collections.sort(KthSmallest);
       return KthSmallest.get(k-1);
   }

}



