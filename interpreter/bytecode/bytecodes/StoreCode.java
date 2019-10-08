package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            offset = Integer.parseInt((String) args.get(1));
            if (args.size() == 3)
             id = (String)args.get(2);
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }
}
