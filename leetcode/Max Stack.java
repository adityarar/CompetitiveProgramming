class MaxStack {
    Stack<Integer> regularStack;
    Stack<Integer> maxStack;
    public MaxStack() {
        regularStack = new Stack();
        maxStack = new Stack();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */    
    public void push(int x) {
        // write your code here
        if(maxStack.isEmpty()) {
            maxStack.push(x);
        }
        else {
            maxStack.push(Math.max(x, maxStack.peek()));
        }
        regularStack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return regularStack.pop();
    }

    /*
     * @return: An integer
     */    
    public int top() {
        return regularStack.peek();
    }

    /*
     * @return: An integer
     */    
    public int peekMax() {
        return maxStack.peek();
    }

    /*
     * @return: An integer
     */    
    public int popMax() {
        // write your code here
        Stack<Integer> temp = new Stack();
        while(!regularStack.peek().equals(maxStack.peek())) {
            maxStack.pop();
            temp.push(regularStack.pop());
        }
        int poppedMax = maxStack.pop();
        regularStack.pop();
        while(!temp.isEmpty()) {
            this.push(temp.pop());
        }

        return poppedMax;
        
    }
}
