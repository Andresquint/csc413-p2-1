package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    private int topOfStack;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            offset = Integer.parseInt((String) args.get(0));
            id = (String) args.get(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        topOfStack = virtualMachine.runStack.peek();
        virtualMachine.runStack.store(offset);
    }
}
