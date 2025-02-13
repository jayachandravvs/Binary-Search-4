// o(log(min(m,n) || o(1) space
class Solution {

   public double findMedianSortedArrays(int[] x, int[] y) {

       int xLen = x.length, yLen = y.length;

       if (xLen > yLen) {

           // we want x to be the shorter one

           return findMedianSortedArrays(y, x);

       }

       int left = 0, right = xLen; // set limits for left and right

       int partitionX, partitionY; // corresponding indices for partition

       int maxLeftX; // max element in X on left side of partition

       int minRightX; // min element in X on right side of partition

       int maxLeftY; // max element in Y on left side of partition

       int minRightY; // min element in Y on righ side of partition

       while (left <= right) { // standard binary search

           partitionX = (left + right) / 2;

           partitionY = (xLen + yLen + 1) / 2 - partitionX;

           if (partitionX == 0) {

               maxLeftX = Integer.MIN_VALUE;

           } else {

               maxLeftX = x[partitionX - 1];

           }

           if (partitionX == xLen) {

               minRightX = Integer.MAX_VALUE;

           } else {

               minRightX = x[partitionX];

           }

           if (partitionY == 0) {

               maxLeftY = Integer.MIN_VALUE;

           } else {

               maxLeftY = y[partitionY - 1];

           }

           if (partitionY == yLen) {

               minRightY = Integer.MAX_VALUE;

           } else {

               minRightY = y[partitionY];

           }

           if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // correct partition found!

               if ((xLen + yLen) % 2 == 0) { // even case

                   return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;

               } else {

                   return Math.max(maxLeftX, maxLeftY);

               }

           } else if (maxLeftX > minRightY) { // reduce bounds

               right = partitionX - 1;

           } else {

               left = partitionX + 1;

           }

       }

       return 0.0;

   }

}
