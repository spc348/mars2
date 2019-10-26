package hw2;

public class RegisterLookup {

    RegisterEnum register;
    int registerNumber;

    public RegisterLookup(String register) {
        register = register.toUpperCase();
        switch (register) {
            case "V0":
                registerNumber = 0;
                break;
            case "V1":
                registerNumber = 1;
                break;
            case "V2":
                registerNumber = 2;
                break;
            case "V3":
                registerNumber = 3;
                break;
            case "V4":
                registerNumber = 4;
                break;
            case "V5":
                registerNumber = 5;
                break;
            default:
                throw new AssertionError(register);
        }
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

}
