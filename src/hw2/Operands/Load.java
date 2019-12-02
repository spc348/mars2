package hw2.Operands;

public class Load extends Operand<Integer> {

    Load(String source1) {
        super.setSource1(Integer.parseInt(source1));
        super.source1Reg = -1;
        super.source2Reg = -1;
    }

    @Override
    public Integer action() {
        return super.source1;
    }

    @Override
    public byte getOpcode() {
        return 3;
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
