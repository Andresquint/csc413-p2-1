package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator location = framePointer.iterator();
        int next;
        int current = (int) location.next();

        for (int i = 0; i < framePointer.size(); i++) {
            System.out.print("[");
            next = location.hasNext() ? (int) location.next() : runTimeStack.size();

            int j = current;
            if (j < next) do {
                System.out.print(runTimeStack.get(j));
                if (j != next - 1) {
                    System.out.print(",");
                }
                j++;
            } while (j < next);
            System.out.print("]");
            current = next;
        }
        System.out.println();
    }

    public int peek() {
        if (!runTimeStack.isEmpty())
            return runTimeStack.get(runTimeStack.size() - 1);
        else return 0;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public int pop() {
        if (!runTimeStack.isEmpty()) {
            int i = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
            return i;
        } else return 0;
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
