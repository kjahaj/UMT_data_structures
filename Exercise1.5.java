import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] list = {3, 2, 3, 5, 4, 8,
                9, 10};
        ArrayList<Integer> list1 = new ArrayList<>();
        for(Integer i : list){
            list1.add(i);
        }

        List<Integer> l1;
        l1 = LS(list1);
        System.out.println("The longest subsequence = ");
        System.out.print(" "+l1);
    }



    /*5. Write a Java program that takes a list of integers as input and returns the longest subsequence of consecutive integers in the list. For example, if the input list is [3, 2, 3, 5, 4, 8,
    9, 10], the program should return [8, 9, 10].*/
    public static List<Integer> LS(ArrayList<Integer> list){
    int[] LS = new int[list.size()];
    Arrays.fill(LS,1);

        for(int i = 1 ; i< LS.length; i++){
            for(int j = i-1 ; j<i ; j++){
                if(list.get(i)==(list.get(j)+1))
                    LS[i]=LS[j]+1;
            }
        }

        //Displaying that array
        int max = maxOfArray(LS);
        int position=0;
        for(int i=0;i< LS.length;i++) {
            if(LS[i]==max){
                position = i;
            }
        }

        List<Integer> newList = new ArrayList<>();
        newList.add(list.get(position));
        int temp = position;

        for (int i = temp; i > 0; i--){
            if((LS[position]-1)==LS[i-1]){
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
/* Output : The longest subsequence = [8, 9, 10] */
