package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.bytecodes.CallCode;
import interpreter.bytecode.bytecodes.FalseBranchCode;
import interpreter.bytecode.bytecodes.GotoCode;
import interpreter.bytecode.bytecodes.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {

    private ArrayList<ByteCode> program;

    //stores the index (line number)  for each LABEL code
    private static HashMap<String, Integer> h = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    public ByteCode getCode(int pc) {
        return program.get(pc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {
        for (int i = 0; i < program.size(); i++) {
            //this variable isn't really needed,
            //but i used it for readability with each get function
            Integer r;

            if (program.get(i) instanceof FalseBranchCode) {
                FalseBranchCode fbc = (FalseBranchCode) program.get(i);
                r = h.get(fbc.getLabel());
                fbc.setNumber(r);
            } else if (program.get(i) instanceof GotoCode) {
                GotoCode gtc = (GotoCode) program.get(i);
                r = h.get(gtc.getLabel());
                gtc.setNumber(r);
            } else if (program.get(i) instanceof CallCode) {
                CallCode cc = (CallCode) program.get(i);
                r = h.get(cc.getLabel());
                cc.setNumber(r);
            }
        }
    }

    //this should store a fully initialized bytecode instance
    public void setCode(ByteCode code) {
        //check if code is a label so we can add it to the hashmap
        if (code instanceof LabelCode) {
            LabelCode l = (LabelCode) code;
            h.put(l.getLabel(), program.size());
        }
        program.add(code);
    }
}
