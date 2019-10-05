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
    private HashMap<String, Integer> h = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    public ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {
        //loop through all lines and collect LABELs and their respective line numbers
        //place label concatenated with number as key and line number as value
        for(int i = 1; i <= program.size() - 1; i++)
        {
            if (program.get(i) instanceof LabelCode)
            {
                h.put(((LabelCode) program.get(i)).getLabel() + ((LabelCode) program.get(i)).getNumber(), i);
            }
        }
        //replace the previous numbers with line numbers from hashmap
        for(int i = 1; i <= program.size() - 1; i++)
        {
            if(program.get(i) instanceof FalseBranchCode)
            {
                FalseBranchCode fbc = (FalseBranchCode) program.get(i);
                if(h.containsKey(fbc.getLabel() + fbc.getNumber()))
                {
                    fbc.setNumber(h.get(fbc.getLabel() + fbc.getNumber()));
                }
            }
            else if(program.get(i) instanceof GotoCode)
            {
                GotoCode gtc = (GotoCode) program.get(i);
                if(h.containsKey(gtc.getLabel() + gtc.getNumber()))
                {
                    gtc.setNumber(h.get(gtc.getLabel() + gtc.getNumber()));
                }
            }
            else if (program.get(i) instanceof CallCode)
            {
                CallCode cc = (CallCode) program.get(i);
                if(h.containsKey(cc.getLabel() + cc.getNumber()))
                {
                    cc.setNumber(h.get(cc.getLabel() + cc.getNumber()));
                }
            }
        }
    }

    //this should store a fully initialized bytecode instance
    public void setCode(ByteCode code){
        program.add(code);
    }
}
