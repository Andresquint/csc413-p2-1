package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    private char id;

    @Override
    public void initCode(ArrayList args) {
        try {
            offset = Integer.parseInt((String) args.get(1));
            if (args.size() == 3)
             id = ((String)args.get(2)).charAt(0);
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }
}
