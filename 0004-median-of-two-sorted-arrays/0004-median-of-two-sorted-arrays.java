class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallestArray;
        int[] biggestArray;

        if (nums1.length < nums2.length){
            smallestArray = nums1;
            biggestArray = nums2;
        } else {
            smallestArray = nums2;
            biggestArray = nums1;
        }
        
        int totalLength = smallestArray.length+biggestArray.length;
        int halfTotalLength =  totalLength / 2;

        int leftBinaryBoundary = 0;
        int rightBinaryBoundary = smallestArray.length -1;

        while (true) {
            int i = Math.floorDiv(leftBinaryBoundary + rightBinaryBoundary, 2);
            int j = halfTotalLength - i - 2; 

            int Aleft;
            int Aright;
            int Bleft;
            int Bright;

            if (i >= 0) Aleft = smallestArray[i];
            else Aleft = Integer.MIN_VALUE;

            if (i + 1 < smallestArray.length) Aright = smallestArray[i + 1];
            else Aright = Integer.MAX_VALUE;

            if (j >= 0) Bleft = biggestArray[j];
            else Bleft = Integer.MIN_VALUE;

            if (j + 1 < biggestArray.length) Bright = biggestArray[j + 1];
            else Bright = Integer.MAX_VALUE;


            if (Aleft <= Bright && Bleft <= Aright) {
                if (totalLength % 2 != 0) {
                    return Math.min(Aright, Bright);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                rightBinaryBoundary = i - 1;
            } else {
                leftBinaryBoundary = i + 1;
            }
        }
    }
    //как люди это запоминают, пиздец
}