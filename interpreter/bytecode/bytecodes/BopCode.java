package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private char operator;
    @Override
    public void initCode(ArrayList args) {
        operator = ((String)args.get(1)).charAt(0);
    }

    @Override
    public void execute() {

    }
}
