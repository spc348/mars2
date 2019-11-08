/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.Operands;

import hw2.RegisterLookup;

/**
 *
 * @author cahn
 */
public class SubtractRegisters extends Operand<Integer> {

    public SubtractRegisters(String source1, String source2) {
        super.setSource1(new RegisterLookup(source1).getRegisterNumber());
        super.setSource2(new RegisterLookup(source2).getRegisterNumber());
    }

    @Override
    public boolean usesConstants() {
        return false;
    }

    @Override
    public boolean hasOneSource() {
        return false;
    }

    @Override
    public Integer action() {
        return source1 - source2;
    }

    @Override
    public byte getOpcode() {
        return 8;
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
