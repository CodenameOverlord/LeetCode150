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

#### SubString with concatenation of all words
    The idea is to enlist all the words freq in a Map
    Now, iterate over the string to find the words using 
    wordLength,
    Now while iterating, if we are able to match the wordMap
    formed earlier, we note the startIndex, else we proceed 
    on from the next character with the same logic
    
##### Code:  
        // iterator 
        for(int i =0; i< stringLen- totalWords*wordLen+1; ++i){
            Map<String, Integer> currentMap = new HashMap<>();
            int j =0;
    
            // forming window
    
            while(j< totalWords){
    
                //creating word
                String currentWord = s.substring(i+j*wordLen, i+(j+1)*wordLen);
                
                //validating whether word is present in the wordMap
                if(!(wordMap.containsKey(currentWord))
                        || wordMap.get(currentWord)<
                        currentMap.getOrDefault(currentWord, 0)+1){
                    break;
                }
                else{
                    currentMap.put(currentWord, currentMap.getOrDefault(currentWord, 0)+1);
                }
                j++;
            }
    
            //if all words are present, note the starting index
            if(j==totalWords){
                indexes.add(i);
            }

        }

### Jump Game 2
    we are to return the min jumps required to reach the endIndex
    where the value on the array determines the max index jump we can make
    for instance:
        arr[x]= 3, means we can jump max three indexes from the current index
    Given that it is always possible to reach the endIndex

#### Solution

##### naive & Dynamic:
    Taking an extra array, minToReach, which gives the min jump
    required to reach end index, we assume that we have reached the
    end Index, now, from there we traverse back such that we are able to reach
    the end from current index in single jump, then minToReach[currentIndex] = 1
    else
    we minReach would be min of 1+minToReach[j]
    where j ranges from i+1->i+jump
##### code:
    for(int i = n; i>=0; --i){
        if(nums[i] >= n-i){
            minToReach[i]=1;
        }
        else{
            int jumpVal = nums[i];
            int minVal = Integer.MAX_VALUE;
            for(int j =i+1; j<=i+jumpVal;++j){
                if(minToReach[j]!=Integer.MAX_VALUE)
                minVal = Math.min(minVal, minToReach[j]+1);
            }
            // if(minVal != Integer.MAX_VALUE)
            minToReach[i]= minVal;
        }
    }
    return minToReach[0];

##### Greedy implicit bfs:
    starting from the start flag, for any current Index
    we will note the farthest that we can travel using the
    value at the current index that we have
    If the coverage, ie, (i+ nums[i]) exceeds our current window
    we update the value of the coverage.
    If the value at the current window is less than the 
    max of coverage we don't need to update
    
    coverage = Math.max(coverage, i + nums[i]);

    lastJumpIndex will store the max distance covered in the last Jump,
    initialized to zero, we will update it to coverage when 
    currentIndex or i == lastJumpIndex, and we will increment jumpsMade

    when coverage exceeds destination, we return jumpsMade

    Also, when we are updating the farthest distance, we increment jump
    initailly, jump =0
    we update jump when we cover the farthestWindow
    int nums[]= new int {2, 4, 1, 2, 3, 1, 1, 2}
     0, 1, 2, 3, 4, 5, 6, 7
    {2, 4, 1, 2, 3, 1, 1, 2}

    2-> we can cover 
    [4, 1] // first jump window, farthest point = 2

    4-> we can cover
    [1, 2, 3, 1] // second jump window, farthest point = 5
    
    1-> we can cover
    [2] // farthest point is farther than i = 3, no need to update

    2-> we can cover
    [3, 1] // farthest point is still = 4

    3-> we can cover 
    [1, 1, 2] // farthest point = 7, end of index we update farthest point and note the jump
    
##### Talk is cheap, here is the code
    
     public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int coverage = 0; 
        int destination = nums.length-1;
        int jumpsMade = 0;
        int lastJumpIndex = 0;
        for(int i = 0; i< nums.length; ++i){
            coverage = Math.max(coverage, i+nums[i]);
            if(coverage>=destination){
                jumpsMade++;
                break;
            }
            if(i==lastJumpIndex){
                jumpsMade++;
                lastJumpIndex = coverage;
            }
        }
        return jumpsMade;
    }
### Least Common Ancestor
    We are to find the least common ancestor of 2 nodes in a tree

#### Solution
##### Naive
    check whether the 2 nodes are present in the left subtree or the right subtree
    if both are present on the left or right, move to the left or right subtree
    respectively. If Node p is present in the left subtree and node q is present in
    the right subtree then root is the Least common ancestor

#### Optimised code
    Since we are to return whichever node is the parent of the nodes we can use null
    for this, so if lca(root.left, p, q)!=null  means either p or q is present in the
    left subtree similarly, lca(root.right, p, q)!=null means either p or q is 
    present in the right subtree. if both of them is not null means that current root
    is the lca of both p and q

#### Code 
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root == p || root == q){
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca (root.right, p, q);
        if(left!=null && right != null){
            return root;
        }
        if(left==null){
            return left;
        }
        else return right;
    }
    