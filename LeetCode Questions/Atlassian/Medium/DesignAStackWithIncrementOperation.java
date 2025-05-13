/*
    Design a stack that supports increment operations on its elements.

    Implement the CustomStack class -

    CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
    void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
    int pop() Pops and returns the top of the stack or -1 if the stack is empty.
    void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
    

    Example 1 -
    Input - 
        ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
        [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
    Output - 
        [null,null,null,2,null,null,null,null,null,103,202,201,-1]
        Explanation
        CustomStack stk = new CustomStack(3); // Stack is Empty []
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
        stk.increment(5, 100);                // stack becomes [101, 102, 103]
        stk.increment(2, 100);                // stack becomes [201, 202, 103]
        stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
        stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
        stk.pop();                            // return -1 --> Stack is empty return -1.
*/

public class DesignAStackWithIncrementOperation {
    /**
     * Your CustomStack object will be instantiated and called as such:
     * CustomStack obj = new CustomStack(maxSize);
     * obj.push(x);
     * int param_2 = obj.pop();
     * obj.increment(k,val);
     */
    private int[] stack;
    private int[] inc;
    private int top;
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.top = 0;
    }
    
    public void push(int x) {
        if(top < maxSize){
            stack[top] = x;
            // No pending increment on a freshly pushed element
            inc[top] = 0;
            top++;
        }
    }
    
    public int pop() {
        if(top == 0){
            return -1;
        }
        top--;
        // Take value + any increment pending on this position
        int res = stack[top] + inc[top];
        // Propagate this element’s pending increment to the next lower element
        if(top > 0){
            inc[top - 1] += inc[top];
        }
        // Clear the slot
        inc[top] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        // We only need to record that the bottom `limit - 1` slot gets “val” extra when popped (or when its children propagate).
        int limit = Math.min(k, top);
        if(limit > 0){
            // Defer applying val to all [0..limit-1] by doing it at index limit-1
            inc[limit - 1] += val;
        }
    }
}