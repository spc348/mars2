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
public abstract class Operand {
    
    private byte opcode;
    protected int source1;
    protected int source2;

    public void setSource1(int source1) {
        this.source1 = source1;
    }

    public void setSource2(int source2) {
        this.source2 = source2;
    }    
    
    public abstract int action();
    
    public abstract byte getOpcode();
    
    public abstract boolean usesConstants();
    
    public abstract boolean oneSource();
    
}
