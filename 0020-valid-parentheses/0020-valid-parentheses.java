class Solution {
    public boolean isValid(String s) {

        Stack myStack = new Stack();

        for (char c: s.toCharArray()){
            if (!isClosingBracket(c)){
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) return false;
            
                if (!isMatchingBracket(myStack.pop(), c)){
                    return false;
                }
            }
        }

        if (myStack.isEmpty()) return true;
        else return false;

    }

    private boolean isClosingBracket(char c){
        if (c==']' || c=='}' || c==')') return true;
        else return false;
    }

    private boolean isMatchingBracket(char open, char close) {
        return (open == '(' && close == ')') ||
            (open == '[' && close == ']') ||
            (open == '{' && close == '}');
    }

    //instead of using import java.util.Stack, I will try to understand the stack
    public class Stack{
        Node top;
        
        public class Node {
            private char current;
            private Node next;
    
            Node(char current, Node next) {
                this.current = current;
                this.next = next;
            }

            public char getChar(){
                return this.current;
            }

            public Node getNode(){
                return this.next;
            }
        }

        public void push(char c){
            Node node = new Node (c, top);
            this.top = node;
        }

        public boolean isEmpty(){
            return top == null;
        }

        public char pop(){
            char c = top.getChar();
            this.top = top.getNode();
            return c;
        }

        public Node getTop(){
            return this.top;
        }

    }
}