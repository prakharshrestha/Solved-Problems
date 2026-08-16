class Solution {

     public int minProd(int[] arr) {

         return solve(arr, 0, 1, false);
     }

     private int solve(int[] arr, int index,int product, boolean selected) {

         if (index == arr.length) {

             if (!selected) {
                 return Integer.MAX_VALUE;
             }
             return product;
         }

         int take = solve(arr,index + 1,product * arr[index],true);
         int skip = solve(arr,index + 1,product,selected);

         return Math.min(take, skip);
     }
 }