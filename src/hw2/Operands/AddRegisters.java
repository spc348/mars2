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
public class AddRegisters extends Add {

    public AddRegisters(String source1, String source2) {
        super(String.valueOf(new RegisterLookup(source1).getRegisterNumber()),
                String.valueOf(new RegisterLookup(source2).getRegisterNumber()));
        source1Reg = new RegisterLookup(source1).getRegisterNumber();
        source2Reg = new RegisterLookup(source2).getRegisterNumber();
    }

    @Override
    public Integer action() {
        return source1 + source2;

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
    public byte getOpcode() {
        return 2;
    }

    @Override
    public boolean isBounce() {
        return false;
    }

}
