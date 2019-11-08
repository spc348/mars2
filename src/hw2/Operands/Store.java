package hw2.Operands;

import hw2.RegisterLookup;

/**
 *
 * @author cahn
 */
public class Store extends Operand<Byte> {

    protected int registerNumberToRead = 0;
    protected short offset = 0;
    protected int valueInRegister = 0;

    public Store(String source1) {
        String parts[] = source1.split("[(]");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("(", "");
            parts[i] = parts[i].replace(")", "");
        }
        this.registerNumberToRead = new RegisterLookup(parts[1]).getRegisterNumber();
        this.offset = twosComplement(parts[0]);
        
    }
    
    private short twosComplement(String number){
       return (short) (Short.parseShort(number));
    }

    public int getRegisterNumberToRead() {
        return registerNumberToRead;
    }

    public short getOffset() {
        return offset;
    }

    @Override
    public Byte action() {
        return source1;
    }

    @Override
    public byte getOpcode() {
        return 6;
    }

    @Override
    public boolean usesConstants() {
        return true;
    }

    @Override
    public boolean hasOneSource() {
        return true;
    }

    @Override
    public boolean isWriteOperation() {
        return true;
    }

   @Override
   public boolean loadsMemory() {
      return false;
   }

    @Override
    public boolean isBounce() {
        return false;
    }
}
