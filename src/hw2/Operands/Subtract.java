package hw2.Operands;

public class Subtract extends Operand<Integer> {

    public Subtract(String individualWord, String individualWord0) {
        super.setSource1(Integer.parseInt(individualWord));
        super.setSource2(Integer.parseInt(individualWord0));
    }

    @Override
    public Integer action() {
        return source1 - source2;
    }

    @Override
    public byte getOpcode() {
        return 5;
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
