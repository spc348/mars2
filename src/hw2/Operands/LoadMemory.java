package hw2.Operands;

import hw2.RegisterLookup;

/**
 *
 * @author cahn
 */
public class LoadMemory extends Load {

   int registerNumberToWrite;
   short offset;

   public LoadMemory(String source1) {
      super("0");

      String parts[] = source1.split("[(]");
      for (int i = 0; i < parts.length; i++) {
         parts[i] = parts[i].replace("(", "");
         parts[i] = parts[i].replace(")", "");
      }
      this.registerNumberToWrite = new RegisterLookup(parts[1]).getRegisterNumber();
      this.offset = twosComplement(parts[0]);
      
      super.setSource1(registerNumberToWrite + offset);
   }

   public int getRegisterNumberToWrite() {
      return registerNumberToWrite + offset;
   }

   private short twosComplement(String number) {
      return (short) ~(Short.parseShort(number));
   }

   @Override
   public boolean loadsMemory() {
      return true;
   }

}
