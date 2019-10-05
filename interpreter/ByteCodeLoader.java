
package interpreter;

import interpreter.bytecode.ByteCode;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    private static final String DELIMITERS = "<> ";

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
        //while string.at(i) != space
        //push the bytecode into program arraylist

        StringTokenizer tokenizer;
        StringBuilder word = new StringBuilder();
        int token;
        ArrayList<String> a = new ArrayList<>();
        Program p = new Program();
        try {
            //gather all bytecodes and push
            while (((token = byteSource.read()) != -1)) {
                if ((char) token != '\n' && (char) token != '\r') {
                    //add each letter to build a bytecode
                    word.append((char) token);
                } else if (!(word.toString().equals(""))) {
                    tokenizer = new StringTokenizer(word.toString(), DELIMITERS, false);
                    String t;
                    while (tokenizer.hasMoreTokens()) {
                        t = tokenizer.nextToken();
                        a.add(t);
                    }
                    //word will not be "" here to forbid pushing empty string into stack and getting exception
                    //here we create a new instance of the correct bytecode and add it to the program object
                    if (a.size() > 0) {
                        String tempByteCode = a.get(0);
                        // String tempByteCode = word.toString();
                        String codeName = CodeTable.getClassName(tempByteCode);
                        try {
                            Class c = Class.forName("interpreter.bytecode.bytecodes." + codeName);
                            ByteCode code = (ByteCode) c.getDeclaredConstructor().newInstance();
                            code.initCode(a);
                            p.setCode(code);
                        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        //finished with current line
                        word.delete(0, word.length());
                        a.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tokenizer = new StringTokenizer(word.toString(), DELIMITERS, false);
        String t;
        while (tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            a.add(t);
        }
        //run one last time to push the last bytecode
        if (a.size() > 0) {
            String tempByteCode = a.get(0);
            String codeName = CodeTable.getClassName(tempByteCode);
            try {
                Class c = Class.forName("interpreter.bytecode.bytecodes." + codeName);
                ByteCode code = (ByteCode) c.getDeclaredConstructor().newInstance();
                code.initCode(a);
                p.setCode(code);
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        p.resolveAddrs();
        return p;
    }
}
