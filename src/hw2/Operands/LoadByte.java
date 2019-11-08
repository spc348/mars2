package hw2.Operands;

public class LoadByte extends Operand<Integer> {

    public LoadByte(String source1) {
        super.setSource1(Integer.parseInt(source1,2));
    }

    @Override
    public byte getOpcode() {
        return 7;
    }

    @Override
    public Integer action() {
        return source1;
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
