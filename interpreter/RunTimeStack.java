package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public void dump(){

    }
    public int peek() {
        if(runTimeStack.size() >= 1)
            return runTimeStack.get(runTimeStack.size()-1);
        else return -1;
    }
    public int push(int i){
        runTimeStack.add(i);
        return i;
    }
    public int pop(){
        int i = -1;
        if (runTimeStack.size() > 0)
            i = runTimeStack.remove(runTimeStack.size());
        return i;
    }
    public int store(int offset){
        if(offset + framePointer.peek() > runTimeStack.size() - 1 || offset < 0)
        {
            return -1;
        }
        else {
            int p = pop();
            runTimeStack.set(p, framePointer.peek() + offset);
            return p;
        }
    }
    public int load(int offset){
       // if(framePointer.peek() + offset < runTimeStack.size())
        runTimeStack.add(runTimeStack.get(framePointer.peek() + offset));
        return runTimeStack.get(framePointer.peek() + offset);
    }
    public void newFrameAt(int offset){
        if(runTimeStack.size() - offset != runTimeStack.get(runTimeStack.size() - 1)){
            framePointer.add(runTimeStack.size() - offset);
        }
    }
    public void popFrame(){
        int topValue = runTimeStack.get(runTimeStack.size() - 1);

        runTimeStack.subList(framePointer.peek(), runTimeStack.size());

        if(framePointer.peek() != 0)
            framePointer.pop();

        runTimeStack.add(topValue);
    }
}
