package MergeTwoSortedArray;

public class Main {
    public static void main(String[] args) {

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i =0; int j =0; int count =0;
        int newArr [] = new int [m+n];
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                newArr[count]= nums1[i];
                count++; i++;
            }
            else{
                newArr[count]= nums2[j]; j++; count++;
            }
        }
        while(i<m){
            newArr[count]= nums1[i];i++;count++;
        }
        while(j<n){
            newArr[count]= nums2[j];j++; count++;
        }

        for(int k=0; k<newArr.length; ++k){
            nums1[k]=newArr[k];
        }

    }
}
