import java.util.HashSet;
import java.util.Set;
/**
*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
class LongestConsecutive{

	public static int longestConsecutiveLength(int[] nums){
		Set<Integer> numSet = new HashSet<>();
		for(int num: nums){
			numSet.add(num);
		}
		//num-1, num, num+1
		int longestStreak = 0;
		for(int num: numSet){
			if(!numSet.contains(num-1)){
				int currentNum = num;
				int currentStreak = 1;
				while(numSet.contains(currentNum+1)){
					currentNum++;
					currentStreak++;
				}
				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		return longestStreak;
	}

	public static void main(String[] args){
		int[] nums= {1, 3, 100, 200, 4, 2};

		System.out.println(longestConsecutiveLength(nums));
	}
}