package hw2.Operands;

import hw2.RegisterEnum;
import hw2.RegisterLookup;

public class LoadRegister extends Load {
   
   protected String register;

   public LoadRegister(String source1) {
      super(source1);
      register = source1;
   }

   @Override
   public int action() {
      return new RegisterLookup(register.substring(1)).getRegisterNumber();
   }

   @Override
   public boolean usesConstants() {
      return false;
   }

}
