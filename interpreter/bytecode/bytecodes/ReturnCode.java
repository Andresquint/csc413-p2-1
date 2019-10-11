package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private int returnValue;
    private String id;

    @Override
    public void initCode(ArrayList args) {
        try {
            if (args.size() > 0)
                id = (String) args.get(0);
            else id = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //"undo" CALL
        //set program counter to the return address
        virtualMachine.pc = virtualMachine.returnAddrs.pop();
        //need to remove the frame created
        virtualMachine.runStack.popFrame();
        //get the return value from the stack
        returnValue = virtualMachine.runStack.peek();

        if (virtualMachine.isDumping) {
            String o;
            String functionLabel;

            if(!id.contains("<")){
                functionLabel = id;
            }else{
                functionLabel = id.substring(0, id.indexOf("<"));
            }
            o = "RETURN " + id + "   exit " + functionLabel + ": " + returnValue;
            System.out.println(o);
        }
    }
}
