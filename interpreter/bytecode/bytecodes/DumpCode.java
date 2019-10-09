package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private boolean state;

    @Override
    public void initCode(ArrayList args) {
        state = ((String) args.get(0)).toLowerCase().equals("on");
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        virtualMachine.isDumping = state;
    }
}
