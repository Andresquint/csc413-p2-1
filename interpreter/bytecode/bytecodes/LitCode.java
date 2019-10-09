package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int litValue;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            litValue = Integer.parseInt((String) args.get(0));
            if (args.size() > 1)
                id = (String) args.get(1);
            else id = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if ("".equals(id)) {
            //push the value given if no id is given
            virtualMachine.runStack.push(litValue);
        } else {
            //push 0 when a variable name is given to initialize the new variable to 0
            virtualMachine.runStack.push(0);
        }

        if (virtualMachine.isDumping) {
            String o = "LIT " + litValue + " " + id;
            if (!id.equals(""))
                o = o + "   int " + id;
            System.out.println(o);
        }
    }
}
