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
public class Add extends Operand {

    public Add(String source1, String source2) {
        super.setSource1(Integer.parseInt(source1));
        super.setSource2(Integer.parseInt(source2));
    }

    @Override
    public int action() {
        return super.source1 + super.source2;
    }

    @Override
    public byte getOpcode() {
        return new Byte("1");
    }

    @Override
    public boolean usesConstants() {
        return true;
    }

    @Override
    public boolean hasOneSource() {
       return false;
    }
    
}
