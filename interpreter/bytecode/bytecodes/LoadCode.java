package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int loadValue;
    private char id;

    @Override
    public void initCode(ArrayList args) {
        try {
            loadValue = Integer.parseInt((String) args.get(1));
            if (args.size() == 3)
            id = ((String)args.get(2)).charAt(0);
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }
}
