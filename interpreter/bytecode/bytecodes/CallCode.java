package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private int callAddress;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            id = (String) args.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //push the value first into returnaddrs to keep the place
        virtualMachine.returnAddrs.push(virtualMachine.pc);
        //change the program counter to a new location
        virtualMachine.pc = callAddress;

    }

    public String getLabel() {
        return id;
    }

    public void setNumber(int addr) {
        callAddress = addr;
    }
}
