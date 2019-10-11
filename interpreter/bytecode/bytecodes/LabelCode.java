package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String idName;

    @Override
    public void initCode(ArrayList args) {
        idName = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (virtualMachine.isDumping) {
            System.out.println("LABEL" + " " + idName);
        }
    }

    public String getLabel() {
        return idName;
    }
}
