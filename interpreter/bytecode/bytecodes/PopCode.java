package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    private int levelsToPop;

    @Override
    public void initCode(ArrayList args) {
        try {
            levelsToPop = Integer.parseInt((String) args.get(1));
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }
}
