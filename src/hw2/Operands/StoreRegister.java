package hw2.Operands;

public class StoreRegister<Byte> extends Store {

   public StoreRegister(String source1) {
      super(source1);
   }

   @Override
   public Object action() {
      return source1;
   }

   @Override
   public boolean usesConstants() {
      return false;
   }

}
