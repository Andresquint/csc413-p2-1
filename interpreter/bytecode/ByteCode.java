package interpreter.bytecode;

import java.util.ArrayList;

public abstract class ByteCode {
    public abstract void initCode(ArrayList args);
    public abstract void execute();
}
