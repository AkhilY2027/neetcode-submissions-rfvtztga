class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Three options:
            // For $5, transaction is done as is
            // For $10, need a $5 to complete
            // For $20, need a $5 and a $10 or three $5
                // Always better to use a five or a ten than 3 fives since tens won't be used otherwise + less 5s
                // Twenties are useless because they can never be used for changed – don't need to record receiving them
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5)
                fives++;
            else if (bill == 10) {
                fives--;
                tens++;
            }
            else { // $20
                if (tens > 0) {
                    fives--;
                    tens--;
                }
                else
                    fives -= 3;
            }
            if (fives < 0)
                return false;
        }
        return true;
    }
}