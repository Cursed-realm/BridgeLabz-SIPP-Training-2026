public class CallStackTracker {
    private static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top = null;

    public static void main(String[] args) {
        CallStackTracker callStack = new CallStackTracker();
        callStack.push("main");
        callStack.push("processOrder");
        callStack.push("validateInput");
        System.out.println(callStack.peek());
        System.out.println(callStack.pop());
        System.out.println(callStack.pop());
        System.out.println(callStack.isEmpty());
    }

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to return from");
        }
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("No active call to inspect");
        }
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
