package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private int callValue;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            id = (String)args.get(1);
            if (args.size() == 3)
                callValue = Integer.parseInt((String) args.get(2));
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }

    public String getLabel() {
        return id;
    }
    public void setNumber(int addr){
        callValue = addr;
    }
    public int getNumber() {
        return callValue;
    }
}
