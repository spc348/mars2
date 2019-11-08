package hw2.Operands;

/**
 *
 * @author cahn
 */
public abstract class Operand<T> {

    private byte opcode;
    protected T source1;
    protected T source2;

    public T getSource1() {
        return source1;
    }

    public T getSource2() {
        return source2;
    }

    public void setSource1(T source1) {
        this.source1 = source1;
    }

    public void setSource2(T source2) {
        this.source2 = source2;
    }

    public abstract T action();

    public abstract byte getOpcode();

    public abstract boolean usesConstants();

    public abstract boolean hasOneSource();
    
    public abstract boolean isWriteOperation();
    
    public abstract boolean loadsMemory();

    public abstract boolean isBounce();

}
