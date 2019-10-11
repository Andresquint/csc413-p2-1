package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadCode extends ByteCode {
    @Override
    public void initCode(ArrayList args) {
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        try {
            System.out.print("Enter integer: ");
            BufferedReader inputString = new BufferedReader(new InputStreamReader(System.in));
            String wholeLine = inputString.readLine();
            virtualMachine.runStack.push(Integer.parseInt(wholeLine));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (virtualMachine.isDumping) {
            System.out.println("READ");
        }
    }
}
