package hw2;

public class RegisterLookup {
    int registerNumber = 0;
    String registerNumberBinary;

    public RegisterLookup(String register) {
        register = register.toLowerCase();
        for (int i = 0; i < MainDisplay.REGISTER_NAMES.length; i++) {
          if(register.equals(MainDisplay.REGISTER_NAMES[i])){
             registerNumber = i;
             break;
          }
       }
        if(registerNumber == 0){
            System.out.println("register not found");
        }
    }

    public int getRegisterNumber() {
        return registerNumber;
    }
    
}
