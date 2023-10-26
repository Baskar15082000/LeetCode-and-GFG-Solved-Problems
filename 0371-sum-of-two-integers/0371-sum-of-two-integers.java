class Solution {
    public int getSum(int a, int b) {
         while (b != 0) {
        int carry = a & b;  // Calculate the carry bit
        a = a ^ b;         // Add without carry
        b = carry << 1;    // Shift the carry to the left
    }
    return a;
    }
}