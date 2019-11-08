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
public class Bounce extends Operand<Integer> {
    
    public Bounce(String val){
        super.setSource1(Integer.parseInt(val));
    }

    @Override
    public byte getOpcode() {
        return 13;
    }

    @Override
    public boolean usesConstants() {
        return false;
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
    public Integer action() {
        return source1;
    }

    @Override
    public boolean isBounce() {
        return true;
    }
    
    public int getBounceLocation(){
        return source1;
    }

}
