package hw2.Operands;

import hw2.RegisterLookup;

/**
 *
 * @author cahn
 */
public class LoadMemory extends Load {

   private final int addressToRead;
   private final short offset;

   public LoadMemory(String source1) {
      super("0");

      String parts[] = source1.split("[(]");
      for (int i = 0; i < parts.length; i++) {
         parts[i] = parts[i].replace("(", "");
         parts[i] = parts[i].replace(")", "");
      }
      this.addressToRead = new RegisterLookup(parts[1]).getRegisterNumber();
      this.offset = twosComplement(parts[0]);
      
      super.setSource1(addressToRead + offset);
      source1Reg = addressToRead;
      source2Reg = -1;
   }

   public int getOffset() {
      return offset;
   }
   
   public int getRegWithAddress(){
       return addressToRead;
   }

   private short twosComplement(String number) {
      return (Short.parseShort(number));
   }

   @Override
   public boolean loadsMemory() {
      return true;
   }
   
   @Override
   public boolean usesConstants(){
       return false;
   }

}
