package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
   private boolean state;

    @Override
    public void initCode(ArrayList args) {
        state = ((String) args.get(1)).toLowerCase().equals("on");
    }

    @Override
    public void execute() {

    }
}
