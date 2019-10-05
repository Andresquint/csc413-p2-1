package interpreter.bytecode.bytecodes;

import java.util.ArrayList;

public class FalseBranchCode extends LabelCode {
   private int labelNumber;
   private String labelName;
    @Override
    public void initCode(ArrayList args) {
        try {
            if(args.size() == 3)
            labelNumber = Integer.parseInt((String) args.get(2));
            labelName = (String) args.get(1);
        }
        catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void execute() {

    }

    @Override
    public String getLabel() {
        return labelName;
    }
    @Override
    public int getNumber() {
        return labelNumber;
    }
    public void setNumber(int addr){
        labelNumber = addr;
    }
}
