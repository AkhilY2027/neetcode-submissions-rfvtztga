class Solution {
    public int majorityElement(int[] nums) {
        // Brute Force: HashMap – O(n) time and space

        // Optimization: Can sort array to find most frequent element (element at n / 2) spot – O(nlogn) time but O(1) space
        
        // I think it's some sort of eliminiation game?
            // Maybe if you search linearly and find two opposing elements, you take them out
            // How would you mark them as "absent" though – nums is only an int array
                // If we convert to a list, that would be O(n) space
            // Thinking about this the wrong way: Just store the amount of times we "find" an element
                // Essentially, can linearly go through array and keep track of count of first element we see
                // We also decrement this count whenever we see a different count element
                    // If this count element becomes negative, we know that there are an equal number of opposing elements to this element
                    // We can eliminate equal numbers of numbers since majority element will always stay
                // Thus, final number is our answer
        int count = 1;
        int curNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curNum == nums[i])
                count++;
            else
                count--;
            
            if (count < 0) {
                count = 1;
                curNum = nums[i];
            }
        }
        return curNum;
    }
}