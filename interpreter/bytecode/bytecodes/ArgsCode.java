package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int numArgs;

    @Override
    public void initCode(ArrayList args) {
        try {
            numArgs = Integer.parseInt((String) args.get(1));
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }
}
