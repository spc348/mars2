package hw2.Operands;

import hw2.RegisterLookup;

public class LoadRegister extends Load {

    public LoadRegister(String source1) {
        super(String.valueOf(new RegisterLookup(source1.substring(1)).getRegisterNumber()));
    }

    @Override
    public int action() {
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