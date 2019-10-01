package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String idName;
    private int idNumber;

    @Override
    public void initCode(ArrayList args) {
        idName = (String) args.get(1);
        if(args.size() == 3)
            idNumber = (int) args.get(2);
    }

    @Override
    public void execute() {

    }
}
