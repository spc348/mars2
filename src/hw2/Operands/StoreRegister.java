package hw2.Operands;

import hw2.RegisterLookup;

public class StoreRegister extends Store {


    public StoreRegister(String source1) {
        super(source1);
    }

    @Override
    public int action() {
        return source1;
    }

    @Override
    public boolean usesConstants() {
        return false;
    }

}
