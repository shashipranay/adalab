
// import java.util.Arrays;
// import java.util.*;
// import java.lang.*;
// import java.io.*;
// // package Algorithms;

// class Job {
//     int id;
//     int profit;
//     int dead;

//     public Job(int id,int profit,int dead) {
//         this.id=id;
//         this.profit=profit;
//         this.dead=dead;
//     }
    
// }

// class Solve{
//     int[] jobSchedule(Job[] ar,int n){
//         Arrays.sort(ar,(a,b)->(b.profit-a.profit));
//         int max=0;
//         for(int i=0;i<n;i++){
//             if(ar[i].dead>max){
//                 max=ar[i].dead;
//             }
//         }
//         int res[]=new int[max+1];
//         for(int i=1;i<=max;i++){
//             res[i]=-1;
//         }
//         int cnt=0;int maxProf=0;
//         for(int i=0;i<n;i++)
//         {
//             for(int j=ar[i].dead;j>0;j--){
//                 if(res[j]==-1){
//                     res[j]=i;
//                     cnt++;
//                     maxProf+=ar[i].profit;
//                     break;
//                 }

//             }
//         }
//         res[0]=cnt;
//         res[1]=maxProf;
//         return res;


//     }

// }


// public class JobSequencing{
    
//     public static void main(String[] args) {
//         Job[] ar=new Job[4];
//         ar[0]=new Job(1,20,4);
//         ar[1]=new Job(2,10,1);
//         ar[2]=new Job(3,40,2);
//         ar[3]=new Job(4,30,2);
//         Solve ob=new Solve();
//         int res[]=ob.jobSchedule(ar,4);
//         System.out.println(res[0]+"  "+res[1]);



//     }
// }


import java.io.IOException;
import java.util.Arrays;

class Job {
   int id, profit, deadline;
   Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
   }
}

class solve {
   // return an array of size 2 having the 0th element equal to the count
   // and 1st element equal to the maximum profit
   int[] JobScheduling(Job arr[], int n) {
      Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

      int maxi = 0;
      for (int i = 0; i < n; i++) {
         if (arr[i].deadline > maxi) {
            maxi = arr[i].deadline;
         }
      }

      int result[] = new int[maxi + 1];

      for (int i = 1; i <= maxi; i++) {
         result[i] = -1;
      }

      int countJobs = 0, jobProfit = 0;

      for (int i = 0; i < n; i++) {

         for (int j = arr[i].deadline; j > 0; j--) {

            // Free slot found 
            if (result[j] == -1) {
               result[j] = i;
               countJobs++;
               jobProfit += arr[i].profit;
               break;
            }
         }
      }

      int ans[] = new int[2];
      ans[0] = countJobs;
      ans[1] = jobProfit;
      return ans;

   }
}
class Main {
   public static void main(String[] args) throws IOException {

      //size of array
      Job[] arr = new Job[4];
      arr[0] = new Job(1, 4, 20);
      arr[1] = new Job(2, 1, 10);
      arr[2] = new Job(3, 2, 40);
      arr[3] = new Job(4, 2, 30);

      solve ob = new solve();

      //function call
      int[] res = ob.JobScheduling(arr, 4);
      System.out.println(res[0] + " " + res[1]);

   }
}
