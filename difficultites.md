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
    

#### Binary Tree Right Side View
##### Solution
##### Naive
    We can use level order traversal to find the level
    of a tree and based on the same we can caluclate the 
    right side of the tree view.
##### Alternate


#### H-index
    Given an array of citations of the research papers by students
    we are to find the hIndex of the array,
    Hindex-defination:  The h-index is defined as the maximum value of h 
    such that the given researcher has published at least h papers that have each been cited at least h times.
##### Solution
###### Naive
    We will sort the array 0,9, 2,3,4
    0 2 3 4 9
    so if n-i>=a[i] then we update the hIndex
    Now, handle edge cases
    0 0 0 0 11 12, here we have atleast 2 papers with more than 2 citations
    if(citation[i]>n-i){
        // we update the hIndex as 
        hIndex = Math.max(hIndex, n-i);
    }

    Hence code:
    Arrays.sort(citations);
    int n = citations.length;
    int h =0;
    for(int i = 0; i< n;++i){
        int curr = citations[i];
        if(n-i>=curr){
            h=curr;
        }
        if(curr>n-i){
            h= Math.max(h, n-i);
        }
    }

#### Find Peak Element
    We are to return the index of the element such that
    a[i]>a[i-1] && a[i]>a[i+1]

##### Solution
    if((mid>0 && mid<n && nums[mid]> nums[mid-1] && nums[mid]>nums[mid+1] ) || 
    (mid==0 && nums[mid]>nums[mid+1] || (mid==n && nums[mid]>nums[mid-1]) )){
        {return mid;}
        // if the mid is the peak element or the mid is the start of array and
        the second element is less than zeroth index
        or mid is the last element and the last second element is less than the mid
        element return mid

    }    if (arr[i]<arr[i+1]) { check on the right side of the array;}
    else{ check the left side of the array}

#### Minstack
    we are to design a stack with the basic functionalities of the stack. In addition to it
    it must return the min element every time we hit getMin()
##### Solution
    We take 2 stacks into consideration, one stack would always store the min element such
    that if there is any element less than the min element of the stack, in that case,
    we would append the current min, else push the existing min, When we pop elements
    from the stack, we also pop the minStack


#### Gas Station
    we are provided with gas [] which contains the gas available at each
    station, and cost[] which contains the gas required for moving from
    one station to other station.
    constraint: there is either one unique solution or no solution.
    if no solution, return -1
    else return the unique soln



##### Solution
        Simply put, we are to check if
        1. the total gas in the gas station >= total cost of gas
        2. iterate over the element to calculate the diff of cost and 
            current gas present, if the difference is less than zero, 
            we are going to reset total to 0, and take current index
            being consider as i+1
##### Code 
        long gasSum = getSumOfElements(gas);
        long costSum = getSumOfElements(cost);
        if(gasSum<costSum)
            return -1;
        int total = 0; int index = 0;
        for(int i =0; i< gas.length; ++i){
            total+=(gas[i]-cost[i]);
            if(total<0){
                total = 0;
                index = i+1;
            }
        }
        return index;

#### Min-Abs_difference in binary tree
    we are to determine the min abs difference between two nodes in a binary tree

##### Solution
    The inorder traversal of a binary tree gives the value of the nodes in ascending
    order

##### Code
    The min difference is always possible between two adjacent numbers when
    they are sorted in ascending order
    determine ans and prev global variable and update the prev 

    class Solution {
        int prev = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            inorder(root);
            return ans;
        }

        public void inorder(TreeNode root){
            if(root==null){
            return;
            }
            inorder(root.left);
            if(prev!=Integer.MAX_VALUE){
                ans = Math.min(ans, root.val-prev);
            }
            prev = root.val;
            inorder(root.right);
        }
    }
#### ReverseBits
    We are to give the reverse of the bits n
    Example 1:

    Input: n = 00000010100101000001111010011100
    Output:    964176192 (00111001011110000010100101000000)
    Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
    Example 2:
    
    Input: n = 11111111111111111111111111111101
    Output:   3221225471 (10111111111111111111111111111111)
    Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
    
##### Solutions
    Note that we are to reverse the bits, so we will start from 31 end to 0 if 
    currentNum = (1<<i & num)>0 in that case we are appending 1<<(31-i)
    Since negetive numbers are represented by 2's compliment:
    we are checking whether the first bit is set or unset,
    if the first bit is set, we are adding 1 to it


#### PartitionList
    we are to partition list L in such a way that all nodes with value less than K are stored in front
    of ListNode with values greater than K
##### Solution
    The idea is to have 2 superNodes = with value zero, ie, superNodeL denoting listNode with values
    less than K and superNodeG with values >=k

    superNodeL->1->2->3
    superNodeG->4-7->7->5

    keep a pointer tempL and tempG denoting the lastNode of L and G so that addition of new nodes
    take o(1)
    
    once done, put tempL.next = superNodeG.next;
    return superNodeL.next;

##### Code

    public ListNode partition(ListNode head, int x) {
        ListNode superHeadG = new ListNode(0);
        ListNode superHeadL = new ListNode(0);

        ListNode tempG = superHeadG; ListNode tempL= superHeadL;
        ListNode temp =head;
        while(temp!=null){
            if(temp.val <x){
                tempL.next = temp;
                tempL = temp;
                temp = temp.next;
                tempL.next = null;
            }
            else{
                tempG.next = temp;
                tempG = temp;
                temp = temp.next;
                tempG.next = null;
            }
        }
        tempL.next = superHeadG.next;
        return superHeadL.next;

    }

#### SingleNumber2
    All but one number has been repeated 3 times, we are to evaluate which number is
    single.
##### Solution
    The idea is for each bit 0-31 find all the numbers in the arrayList with setBit and
    add them, if the number is not divisible by 3, add that to ans.
    return ans;

    One imp logic
    while evaluating setBit be careful to do this
        nums[i]&currBit !=0 (gives proper ans)
    instead of this:
        nums[i]&currBit >=1 (gives wrong ans)

##### Code
    public int singleNumber(int[] nums) {
    int ans = 0;
    int curr = 1;
    int pos = 0;
    
    while(pos<32){
        int numSet = 0;
        for(int i =0; i<nums.length;++i){
            if((nums[i]&curr)!=0){
                numSet++;
            }
        }
        if(numSet%3!=0){
            ans+=curr;
        }
        curr = curr<<1; pos++;
    }

    return ans;
    }


#### Bitwise And of Number Range
    We are given a range of number [left, right] both inclusive
    we are to find the bitwise and of number range.


###### Solution1
    Take the first number as right, perform right& (right-1), our new right will be
    equal to right& (right-1)
    Continue doing this until left<right

    public int rangeBitwiseAnd(int left, int right) {
        while(right>left){
            right=(right&(right-1));
        }
        return right;
    }

##### Solution2
    Kind of non intuitive but we are going to note the number of shifts 
    required to make left == right, once left == right, then we 
    return left<<totalNumberOfShifts


#### Construct a binary tree from inorder and preorder traversal
    Given an array of preorder and inorder traversal, we are to create
    a binary tree with the above data
#### Solution
    a-> the first element in preorder traversal of a binary tree is always root

    b-> we can find the position of current root in the inorder traversal
    of the tree, in the nodes present on LHS we will have the left sub tree
    
    c-> in the nodes on the right hand side of the current position of root
    we will have the rst

    d-> we can calculate the nodes present in the leftSubtree using the
    above data, let the same be called NodesInLst

    e-> on preOrder traversal we first travel root, then left subtree
    and then right subtree
    therefore, 

    Inorder =  |<---x no of nodes--->|Root|<----y no of nodes---->|
    preorder = ||Root|<---x no of nodes---><----y no of nodes---->|
    
    f-> our stopping condition would be the time when leftNodes or rightNodes
    becomes less than zero

    g-> to optimise the time complexity, we will store the element position of 
    inorder traversal in a map

#### Code
###### Parent method
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i =0; i< inorder.length;++i){
            inorderMap.put(inorder[i], i);
        }
        int preLeft = 0;
        int preRight = preorder.length-1;
        int inLeft = 0;
        int inRight = inorder.length-1;
        return buildTree(preorder, preLeft, preRight, inorder, inLeft, inRight, inorderMap);
    }

###### Child Method
    buildTree(int [] preOrder, int preLeft, int preRight,
                int [] inOrder, int inLeft, int inRight,
                Map<Integer, Integer> inorderPos){
        
        if(inLeft>inRight || preLeft>preRight){
            return null;
        }
        TreeNode root  = new TreeNode(preOrder[preLeft]);
        int inorderRootPos = inorderPos.get(root.val);
        int noOfElementInLST = inorderRootPos-inorderLeft;
        
        root.left = buildTree(preOrder, preLeft+1, preLeft+noOfElementInLST
                                inOrder, inLeft, inorderRootPos-1);
        root.right = buildTree(preOrder, preLeft+noOfElementInLST+1, preRight,
                                inOrder, inorderRootPos+1, inRight);
        return root;
    }


#### Surrounded Region
    we are given a char [] [] board, the board is filled with 'O' and 'X'
    we are to return the conquered board such that any cells marked X is 
    already conquered and the cells marked with 0 are yet to be conquered
    
    Our motive is to devise strategy such that the cells with 'O' that are 
    on the edge of the board and their connected cells cannot be conquered

##### Solution:
    if we have x+y and we want x that means we don't want y
    Perform dfs on the edge of the board, marking it T temporarily,
    all elements connected to the edge will therefore by default be marked as
    T,
    Once done, replace the board such that area marked T is 'O' and everything else
    is conquered that is 'X'


#### Number of 1 bits
    we are to find the number of set bits in a given integer
##### Solution
    keep on left shifting 1 and bitwise and the number to find the number of 1 bits