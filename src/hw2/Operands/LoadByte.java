
package hw2.Operands;

/**
 *
 * @author cahn
 */


public class LoadByte extends Load{
   
   public LoadByte(String source1) {
      super(source1);
   }
   
       @Override
    public byte getOpcode() {
        return new Byte("7");
    }
   
}
