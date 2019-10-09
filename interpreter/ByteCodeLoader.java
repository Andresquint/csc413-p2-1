
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program p = new Program();
        //The Vector args holds the arguments associated with each bytecode (i.e. LIT 0, 0 is args[0])
        ArrayList<String> args = new ArrayList<>();
        //read first line of the program
        String line = null;
        try {
            line = byteSource.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line != null) {
            StringTokenizer tok = new StringTokenizer(line);
            args.clear(); //clear argument list on each iteration

            String codeClass = CodeTable.getClassName(tok.nextToken());
            while (tok.hasMoreTokens()) {
                args.add(tok.nextToken());
            }

            ByteCode byteCode = null;
            try {
                byteCode = (ByteCode) (Class.forName("interpreter.bytecode.bytecodes." + codeClass).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //initialize each bytecode and add it to the program object
            byteCode.initCode(args);
            p.setCode(byteCode);

            try {
                line = byteSource.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        p.resolveAddrs();
        return p;
    }
}
