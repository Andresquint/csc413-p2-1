package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    private int callAddress;
    private String id;
    private int topValue;

    @Override
    public void initCode(ArrayList args) {
        try {
            id = (String) args.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //push the value first into returnaddrs to keep the place
        virtualMachine.returnAddrs.push(virtualMachine.pc);
        //change the program counter to a new location
        virtualMachine.pc = callAddress;
        //get the top value from runstack for dumping
        topValue = virtualMachine.runStack.peek();

        if (virtualMachine.isDumping) {
            String o;
            String functionLabel;

            if(!id.contains("<")){
                functionLabel = id;
            }else{
                functionLabel = id.substring(0, id.indexOf("<"));
            }
            o = "CALL " + id + "    " + functionLabel + "(" + topValue + ")";
            System.out.println(o);
        }
    }

    public String getLabel() {
        return id;
    }

    public void setNumber(int addr) {
        callAddress = addr;
    }
}
