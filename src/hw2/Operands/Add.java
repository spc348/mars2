package hw2.Operands;

public class Add extends Operand<Integer> {

    public Add(String source1, String source2) {
        super.setSource1(Integer.parseInt(source1));
        super.setSource2(Integer.parseInt(source2));
        super.source1Reg = -1;
        super.source2Reg = -1;
    }

    @Override
    public Integer action() {
        return (super.source1 + super.source2);
    }

    @Override
    public byte getOpcode() {
        return 1;
    }

    @Override
    public boolean usesConstants() {
        return true;
    }

    @Override
    public boolean hasOneSource() {
        return false;
    }

    @Override
    public boolean isWriteOperation() {
        return false;
    }

    @Override
    public boolean loadsMemory() {
        return false;
    }

    @Override
    public boolean isBounce() {
        return false;
    }
}
