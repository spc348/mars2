package hw2;

public class RegisterLookup {
    int registerNumber;

    public RegisterLookup(String register) {
        register = register.toLowerCase();
        for (int i = 0; i < MainDisplay.REGISTER_NAMES.length; i++) {
          if(register.equals(MainDisplay.REGISTER_NAMES[i])){
             registerNumber = i;
             break;
          }
       }
    }

    public int getRegisterNumber() {
        return registerNumber;
    }
    
    

}
