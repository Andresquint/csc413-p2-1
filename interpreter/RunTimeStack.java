package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {

    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public int pop() {
        int i = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return i;
    }

    public int store(int offset) {
        int i = this.pop();
        runTimeStack.set(framePointer.peek() + offset, i);
        return i;
    }

    public int load(int offset) {
        int i = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {
        framePointer.push(this.runTimeStack.size() - offset);
    }

    public void popFrame() {
        //get the first value on the frame
        int topValue = this.peek();
        //pop this item off the frame pointer
        int secondValue = framePointer.pop();
        //run decrementing loop to run from the top of the stack
        //and run until the desired frame size is reached
        for (int i = runTimeStack.size() - 1; i >= secondValue; i--)
            this.pop();
        //place the old value onto the top of the stack without the previous frame
        this.push(topValue);
    }

    public int size() {
        return runTimeStack.size();
    }
}
