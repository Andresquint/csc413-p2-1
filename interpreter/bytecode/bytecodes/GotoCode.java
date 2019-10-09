package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
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
        virtualMachine.pc = labelNumber;
    }

    public String getLabel() {
        return labelName;
    }

    public int getNumber() {
        return labelNumber;
    }

    public void setNumber(int addr) {
        labelNumber = addr;
    }
}
