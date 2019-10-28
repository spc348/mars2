package hw2.Operands;

import hw2.RegisterLookup;

/**
 *
 * @author cahn
 */
public class Store extends Operand {

    protected int registerNumberToWrite = 0;
    protected int offset = 0;
    protected int valueInRegister = 0;

    public Store(String source1) {
        String parts[] = source1.split("[(]");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("(", "");
            parts[i] = parts[i].replace(")", "");
        }
        this.registerNumberToWrite = new RegisterLookup(parts[1].substring(1)).getRegisterNumber();
        this.offset = Integer.parseInt(parts[0]);
    }

    public int getRegisterNumberToRead() {
        return registerNumberToWrite;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public int action() {
        return source1;
    }

    @Override
    public byte getOpcode() {
        return new Byte("6");
    }

    @Override
    public boolean usesConstants() {
        return true;
    }

    @Override
    public boolean hasOneSource() {
        return true;
    }

    @Override
    public boolean isWriteOperation() {
        return true;
    }
}
