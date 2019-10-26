package hw2.Operands;

/**
 *
 * @author cahn
 */
public class Store extends Operand {

    public Store(String source1) {
        super.setSource1(Integer.parseInt(source1));
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
