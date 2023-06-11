public class MergeSort {

    public static void conquer(int [] arr , int start, int mid , int end){
        int [] mergedArray = new int[end-start+1];
         int idx1= start;
         int idx2= mid+1;

         int idxOfMergedArray = 0;
         while (idx1<=mid && idx2<=end){
             if(arr[idx1]<=arr[idx2]){
                 mergedArray[idxOfMergedArray]=arr[idx1];
                 idxOfMergedArray++;
                 idx1++;
             }else {
                 mergedArray[idxOfMergedArray]=arr[idx2];
                 idxOfMergedArray++;
                 idx2++;
             }
         }
         while (idx1 <= mid){
             mergedArray[idxOfMergedArray++]=arr[idx1++];
         }

        while (idx2 <= end){
            mergedArray[idxOfMergedArray++]=arr[idx2++];
        }

        for (int i = 0, j=start; i < mergedArray.length; i++,j++) {
            arr[j]=mergedArray[i];
        }
    }

    public static void divide(int [] arr,  int start, int end){
        if(start>=end){
            return;
        }

        int mid = start+(end-start)/2;
        //first half of array
        divide(arr, start, mid);
        //second hal of array
        divide(arr, mid+1, end);

        //conquer: adding all the arrays into one sorted array
        conquer(arr,start,mid,end);
    }

    public static void main(String[] args) {
        int arr[]={6, 3, 9, 5, 2, 8};
        divide(arr,0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
