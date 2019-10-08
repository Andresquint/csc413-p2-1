package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String idName;
    private int idNumber = 0;

    @Override
    public void initCode(ArrayList args) {
        idName = (String) args.get(1);
        if(args.size() == 3)
            idNumber = Integer.parseInt((String)args.get(2));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

    }
    public String getLabel() {
        return idName;
    }
    public int getNumber() {
        return idNumber;
    }
}
