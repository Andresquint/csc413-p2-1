package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    private int levelsToPop;

    @Override
    public void initCode(ArrayList args) {
        try {
            levelsToPop = Integer.parseInt((String) args.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if (levelsToPop < virtualMachine.runStack.size())
            for (int i = 0; i < levelsToPop; i++) {
                virtualMachine.runStack.pop();
            }

        if (virtualMachine.isDumping) {
            System.out.println("POP" + " " + levelsToPop);
        }
    }
}
