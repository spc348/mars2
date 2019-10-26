/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.Operands;

/**
 *
 * @author cahn
 */
public class Load extends Operand {

    Load(String source1) {
        super.setSource1(Integer.parseInt(source1));
    }

    /**
     *
     * @return
     */
    @Override
    public int action() {
        return super.source1;
    }

    @Override
    public byte getOpcode() {
        return new Byte("3");
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

}
