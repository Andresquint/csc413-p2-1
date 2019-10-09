package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    private int labelNumber;
    private String labelName;

    @Override
    public void initCode(ArrayList args) {
        try {
            labelName = (String) args.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //branch depending on the top value in runtimestack
        if (virtualMachine.runStack.pop() == 0) {
            virtualMachine.pc = labelNumber;
        }
    }

    public String getLabel() {
        return labelName;
    }

    public void setNumber(int addr) {
        labelNumber = addr;
    }
}
