package interpreter.bytecode.bytecodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;

    @Override
    public void initCode(ArrayList args) {
        operator = ((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        //we need two operands to make a calculation
        //so we get the two values from the top of the stack
        int firstValue = virtualMachine.runStack.pop();
        int secondValue = virtualMachine.runStack.pop();

        //use switch for efficiency since we have so many operations
        switch (operator) {
            case "+":
                virtualMachine.runStack.push(secondValue + firstValue);
                break;
            case "-":
                virtualMachine.runStack.push(secondValue - firstValue);
                break;
            case "*":
                virtualMachine.runStack.push(secondValue * firstValue);
                break;
            case "/":
                virtualMachine.runStack.push(secondValue / firstValue);
                break;
            case "==":
                virtualMachine.runStack.push((secondValue == firstValue) ? 1 : 0);
                break;
            case "!=":
                virtualMachine.runStack.push((secondValue != firstValue) ? 1 : 0);
                break;
            case "<=":
                virtualMachine.runStack.push((secondValue <= firstValue) ? 1 : 0);
                break;
            case "<":
                virtualMachine.runStack.push((secondValue < firstValue) ? 1 : 0);
                break;
            case ">=":
                virtualMachine.runStack.push((secondValue >= firstValue) ? 1 : 0);
                break;
            case ">":
                virtualMachine.runStack.push((secondValue > firstValue) ? 1 : 0);
                break;
            case "|":
                if (secondValue == 0 && firstValue == 0)
                    virtualMachine.runStack.push(0);
                else virtualMachine.runStack.push(1);
                break;
            case "&":
                if (secondValue == 1 && firstValue == 1)
                    virtualMachine.runStack.push(1);
                else virtualMachine.runStack.push(0);
                break;
        }
        if (virtualMachine.isDumping) {
            System.out.println("BOP" + " " + operator);
        }
    }
}
