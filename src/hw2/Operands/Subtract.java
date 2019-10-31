package hw2.Operands;

public class Subtract extends Operand<Integer> {

   @Override
   public Integer action() {
      return source1 - source2;
   }

   @Override
   public byte getOpcode() {
      return new Byte("5");
   }

   @Override
   public boolean usesConstants() {
      return true;
   }

   @Override
   public boolean hasOneSource() {
      return false;
   }

   @Override
   public boolean isWriteOperation() {
      return false;
   }

   @Override
   public boolean loadsMemory() {
      return false;
   }
}
