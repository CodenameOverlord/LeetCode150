# Algorithm notes:
### Rotate Array solution using ReverseArray:
    Reverse the entire array
    Reverse 0->k-1
    Reverse k-1->n
    
###	Moore's Voting algorithm for selecting majority element in the array where majority strength>n/2
    take any arbitary element and strength_of_candidate (initially set to 0),
    call it candidate and iterate array from 0->n
    For each time a different candidate is encountered, 
    set the strength_of_candidate = strength_of_candidate-1
    else for same candidate strength_of_candidate = strength_of_candidate+1
    When candidate count is zero, update candidate to current element
		
###	Floyd Warshall finding point of LinkedList Cycle
    There will be cycle in the linked list if slow pointer and start pointer collides,
    now when collision is encountered set 
    fast pointer speed = slow pointer speed = 1, 
    now start slow pointer from the beginning when the slow pointer meets the start
    pointer, that will be the point of collision.


### Container with Most water
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:
    
    Input: height = [1,1]
    Output: 1
#### Solution:

    take a start pointer and and end pointer, make start pointer =0; 
    end pointer = last element, 
    Now, set an ans variable initialized to zero
    ans = Math.max(ans, min(height[start], height [end])*(end-start));
    
    Now, 
    when height of start is more than that of end, there is a chance that 
    height of start pointer would be the max container's boundery on the lhs
    therfore decrement end;
    if height[end]>start, increment start
    Do this till start = end

### Calculating the number of trailing zeroes in a factorial
    This will be determined by the number of factors of 5 present
    
#### Solution
    n/5+n/5^2+n/5^3+n/5^4+....

### 3 sum
    In a given sorted array, we are to give a[i],a[j],a[k] where a[i]+a[j]+a[k]=0
    such that a[i],a[j],a[k] combinations are unique

#### Solution
    Sort the array.
    select arbitrary element a[i] such that a[j]+a[k] = a[i];
    now iterate i over the array.
    Since i is selected we need to use 2 pointer approach to calculate the
    elements, if a[k]+a[j]> - a[i], decrement k, 
    if greater increment j, else note the current solution and increment 
    j and decrement k to figure out other solutions.
    Note that since we are only taking unique elements, we are taking
    the value of a[i] non repeated, same with a[j] and a[k]

#### java solution
        public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> soln  = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; ++i){
            int currElement = nums[i];
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            addDistinctElementSol2Sum(nums, i, j, k, -1*currElement, soln);
        }

        return soln;
    }

    private static void addDistinctElementSol2Sum(int [] sortedArr, int currIndex, int startIndex, int endIndex, int target, List<List<Integer>> ansTillNow){
        int j = startIndex; int k = endIndex;
        while(j<k){
            int currentSum = sortedArr[j]+ sortedArr[k];
            if(currentSum==target){
                List<Integer> solList = new ArrayList<>();
                solList.add(sortedArr[currIndex]);
                solList.add(sortedArr[j]);
                solList.add(sortedArr[k]);
                ansTillNow.add(solList);
                while(j<k && sortedArr[j]==sortedArr[j+1]){
                    j++;
                }
                while(j<k && sortedArr[k]==sortedArr[k-1]){
                    k--;
                }
                j++;k--;
            }
            else if(currentSum> target){
                k--;
            }
            else{
                j++;
            }
        }

    }

	