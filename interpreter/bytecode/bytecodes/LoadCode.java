package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int loadValue;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            loadValue = Integer.parseInt((String) args.get(0));
            if (args.size() > 1)
                id = (String) args.get(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.runStack.load(loadValue);

        if (virtualMachine.isDumping) {
            String o = "LOAD " + loadValue + " " + id;
            if (!id.equals(""))
                o = o + "     <load " + id + ">";
            System.out.println(o);
        }
    }
}
