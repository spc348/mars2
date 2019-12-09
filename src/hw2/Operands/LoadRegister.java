package hw2.Operands;

import hw2.RegisterLookup;

public class LoadRegister extends Load {

    public LoadRegister(String source1) {
        super(String.valueOf(new RegisterLookup(source1).getRegisterNumber()));
        source1Reg = new RegisterLookup(source1).getRegisterNumber();
        source2Reg = -1;
    }

    @Override
    public Integer action() {
        return source1;
    }

    @Override
    public boolean usesConstants() {
        return false;
    }
    
    @Override
    public boolean hasOneSource()
    {
        return true;
    }

}
