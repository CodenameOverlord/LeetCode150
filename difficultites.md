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

	