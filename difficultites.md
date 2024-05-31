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

### Minimum-size-subarray-sum

#### context: 
    we are to give min subarray size where sum = target

#### Solution:
    Taking 2 pointer approach in this, we are using a startIndex and 
    endIndex, startIndex will point the initial starting point of our 
    subarray and the endIndex will be pointing to the end of subArray being considered
    Both start and endIndex will be initiated from zero
    Now, once we decide upon the startIndex, we are going to increment endIndex and keep 
    on adding arr[endIndex] to the tempVariable until currentAns>=target and update minLen of subArray

    Once currentAns>=temp, we will continue to increment the startIndex and decrement 
    currentAns = currentAns - arr[startIndex] till
    we find the pointer where either startIndex > endIndex 
    or currentAns< target and update min length of subarray accordingly.
    
    we wil do this till we find the min length of subArray

### Copy list with random pointer


#### structure of Node

    class Node {
    int val;
    Node next;
    Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


#### Solution:
    The idea is to create a duplicate identical node with the past node's data
    same as second node,

    Old List: A --> B --> C --> D 
    InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'

#### step 1: insert new Nodes in between

        Node temp = head;
        while(temp!=null){
            Node newNode = new Node (temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
#### step 2:  Now, for random pointer, we are going to point to the next pointer to 
    the original one
    
     while(temp!=null){
            if(temp.random == null){
                temp.next.random = null;
            }
            else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
    }

#### step 3: rearrange old and new nodes
        temp = head;
        Node newHead = temp.next;
        while(temp!=null){
            Node newNext = temp.next;
            temp.next = temp.next.next;
            if(newNext.next!=null)
                newNext.next = newNext.next.next;
            temp = temp.next;
        }

#### step 4: return newHead
        return newHead;

### JumpGame1
    can we reach to destination (last array index) if we are 
    starting from the first index where each element of the array
    determines the max jump towards the endIndex that we can make

#### Solution
    start from the second last index from the array, if we can't 
    reach to final element from that element, we are to skip that index,
    therefore: toReach +=1, else toReach = toReach.
    Initialize toReach with 1

### POW(x,n)
    the idea is that we use recursion, 
    if(n%2==0){
        ans = pow(x,n/2)
            return ans*ans;
    }
    else{
        //depending on n's value as positive or negetive, 
        //we provide the solution
    }

### Insert Intervals
    we are to insert interval i into an arranged intervals list
    and merge the same

#### Solution
    The naive approach:
        is to add the solution into the mergedSolution
        list by first inserting the interval at approapriate position in the 
        sorted array followed by which merging the new array so formed


### RotateImage
    Given a 2D array, we are to rotate the array 90 degrees and 
    give the outcome of the result, the operation should be done
    inplace
    
    question:
    1 2 3 4 
    5 6 7 8
    9 10 11 12
    13 14 15 16

#### Solution
    The idea is to 
        1. transpose of the given array   
            1 5 9 13 
            2 6 10 14
            3 7 11 15
            4 8 12 16
        2. reverse the columns
            13 9 5 1 
            14 10 6 2
            15 11 7 3
            16 12 8 4 

### Set matrix zeroes
    Given a matrix of size M*N, we are to set row and col of a cell (i,j) 0 if
    cell(i, j) =0


#### Solution
##### 1. Naive: 
    using o(MN) space where we note M and N in pairs and then
    iterating through the pairs, we can set individual rows and
    cols  = 0
##### 2. Better : 
    using o(M+N) space where we store only the rows and the
    cols of the matrix and then iterating through the rows,
    we can set all elements of the rows = 0
    Similarly, traversing through the cols, we can set all
    elements of the particular cols = 0
##### 3. Constant Space:
    if there is 0 val in 0th row or 0th col, mark zeroRow = true
    and zeroCol = true
    The idea is to neglecticng the zeroth row and zeroth col, 
    for every cell in the matrix, put corresponding row and col = 0
    ie, for (i,j), put i,0 and 0,j = 0, then excluding 0,0
    iterate the 0th row and 0th col and every time you have encountered 
    a 0 there, put the data inside the row and col = 0
    Once done, check zeroCol and zeroRow
    if zeroRow = true, mark the zeroth row = 0
    if zeroCol = true, mark the zeroth col = 0