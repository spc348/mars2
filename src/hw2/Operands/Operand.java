package hw2.Operands;

/**
 *
 * @author cahn
 */
public abstract class Operand {

    private byte opcode;
    protected int source1;
    protected int source2;

    public int getSource1() {
        return source1;
    }

    public int getSource2() {
        return source2;
    }

    public void setSource1(int source1) {
        this.source1 = source1;
    }

    public void setSource2(int source2) {
        this.source2 = source2;
    }

    public abstract int action();

    public abstract byte getOpcode();

    public abstract boolean usesConstants();

    public abstract boolean hasOneSource();
    
    public abstract boolean isWriteOperation();

}
