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
public class AddRegisters extends Add {
   
   public String register1;
   public String register2;
    
    public AddRegisters(String source1, String source2) {
        super(source1, source2);
        register1 = source1;
        register2 = source2;
    }
    
    @Override
    public int action(){
       return source1 + source2;
       
    }
    
    @Override
    public boolean usesConstants() {
        return false;
    }
    
    @Override
    public byte getOpcode()
    {
        return new Byte("2");
    }
    
}
