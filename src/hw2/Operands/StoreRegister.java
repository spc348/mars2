package hw2.Operands;

import hw2.RegisterLookup;

public class StoreRegister extends Store {

    private int registerNumberToWrite = 0;
    private int offset = 0;
    private int valueInRegister = 0;

    public StoreRegister(String source1) {
        super(source1);
        String parts[] = source1.split("(");
        for (String part : parts) {
            part = part.replace("(", "");
            part = part.replace(")", "");
        }
        this.registerNumberToWrite = new RegisterLookup(parts[1]).getRegisterNumber();
        this.offset = Integer.parseInt(parts[0]);
    }

    @Override
    public int action() {
        return source1;
    }

    public int getRegisterNumberToWrite() {
        return registerNumberToWrite;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public boolean usesConstants() {
        return false;
    }

}
