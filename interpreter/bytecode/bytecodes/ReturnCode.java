package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private int returnValue;
    private char id;

    @Override
    public void initCode(ArrayList args) {
        try {
            id = ((String)args.get(1)).charAt(0);
            if (args.size() == 3)
                returnValue = Integer.parseInt((String) args.get(2));
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }
}
