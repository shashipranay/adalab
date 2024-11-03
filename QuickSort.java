// package Algorithms;
import java.util.Scanner;
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=5;
        int ar[]=new int[n];
        System.out.println("enter elem");
        for(int i=0;i<5;i++){
            ar[i]=sc.nextInt();
        }
        qs(ar,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(ar[i]+" ");
            
        }
        
    }

    public static void qs(int[] ar,int low,int high){
        if(low<high){
            int p=partition(ar,low,high);
            qs(ar,low,p-1);
            qs(ar,p+1,high);
            
        }
        
    }

    public static int partition(int[] ar,int low,int high){

        int i=low;
        int j=high;
        int pivot=ar[low];
        while(i<j){
            while(ar[i]<=pivot && i<=high){
                i++;
            }
            while(j>=low && ar[j]>pivot){
                j--;
            }
            if(i<j){
                change(ar,i,j);
            }
            else{
                change(ar,ar[low],ar[j]);
            }
        }
        return j;
    }

    public static void change(int[] ar,int i,int j){
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }
    
}
