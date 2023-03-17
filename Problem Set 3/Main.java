import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    int[] num = {9,5,7,2,1};
    int[] num1 = {4,1,4};
    System.out.println(maxDifference(num));
    int[] num3 = commonElements(num,num1);

    for (int i = 0 ; i<num3.length ; i++){
        System.out.print(num3[i]+" ");
    }
    System.out.println();
    int[] merged = mergeSorted(num,num1);
        for (int i = 0 ; i<merged.length ; i++){
            System.out.print(merged[i]+" ");
        }
    }


//    1. Write a program that takes an array of integers as input and returns the maximum difference
//    between any two elements in the array, such that the larger element appears after the smaller element.
    public static int maxDifference(int[] arr){
        int[] maxDiff = new int[arr.length];
        Arrays.fill(maxDiff,0);

        for(int i=1; i<arr.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j])
                    if(max<arr[i]-arr[j]){
                        max = arr[i]-arr[j];
                        maxDiff[i]=max;
                    }
            }
        }
        return Arrays.stream(maxDiff).max().getAsInt();
    }


//    2. Write a program that takes two arrays of integers as input and returns a new array that
//    contains only the elements that appear in both arrays, in the order that they appear in
//    the first array. For example, given the arrays [1, 2, 3, 4, 5] and [3, 5, 7, 9], the program
//    should return the array [3, 5].
    public static int[] commonElements(int[] arr,int[] arr1){
        int maxOcc=0;
        for(int i = 0;i< arr.length;i++){
            for(int j = 0; j<arr1.length;j++){
                if(arr[i]==arr1[j]){
                    maxOcc++;
                    break;
                }
            }
        }
        int check=0;
        int[] newArr = new int[maxOcc];
        for(int i = 0;i< arr.length;i++){
            for(int j = 0; j<arr1.length;j++){
                if(arr[i]==arr1[j]){
                    newArr[check]=arr[i];
                    check++;
                    break;
                }
            }
        }
        return newArr;
    }



//    3. Write a program that takes two sorted arrays of
//    integers as input and merges them into a single sorted array.
    public static int[] mergeSorted(int[] arr,int[] arr1){
        int[] merged = new int[arr.length+arr1.length];

        System.arraycopy(arr, 0, merged, 0, arr.length);

        for (int i = 0; i<arr1.length;i++){
            merged[arr.length+i]=arr1[i];
        }
        Arrays.sort(merged);
        return merged;
    }
}