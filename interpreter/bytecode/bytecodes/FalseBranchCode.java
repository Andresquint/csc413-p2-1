package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
   private int labelNumber;
   private String labelName;
    @Override
    public void initCode(ArrayList args) {
        try {
            labelNumber = Integer.parseInt((String) args.get(2));
            labelName = (String) args.get(1);
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }
}
