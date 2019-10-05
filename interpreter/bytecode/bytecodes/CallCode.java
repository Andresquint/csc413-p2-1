package interpreter.bytecode.bytecodes;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class CallCode extends LabelCode {
    private int callValue;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            id = (String)args.get(1);
            if (args.size() == 3)
                callValue = Integer.parseInt((String) args.get(2));
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }

    @Override
    public String getLabel() {
        return id;
    }
    public void setNumber(int addr){
        callValue = addr;
    }
    @Override
    public int getNumber() {
        return callValue;
    }
}
