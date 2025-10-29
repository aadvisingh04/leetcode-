class Solution {
    public int smallestNumber(int n) {
        while (!hasAllSetBits(n)) {
            n++;
        }
        return n;
    }

    private static boolean hasAllSetBits(int num) {
        int temp = num;
        while (temp > 0) {
            if ((temp & 1) == 0) { 
                return false;
            }
            temp >>= 1; 
        }
        return true;
    
    }
}