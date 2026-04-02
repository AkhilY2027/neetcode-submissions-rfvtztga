class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // int num1 = 0, num2 = 1, num3 = 1;
        // int i = 2;
        // while (i < n) {
        //     int temp = num3 + num2 + num1;
        //     num1 = num2;
        //     num2 = num3;
        //     num3 = temp;
        //     i++;
        // }
        // return num3;

        // Even better space optimization for memory
        int[] ts = new int[] {0, 1, 1};
        for (int i = 3; i <= n; i++) {
            ts[i % 3] = ts[0] + ts[1] + ts[2];
        }
        return ts[n % 3];
    }
}