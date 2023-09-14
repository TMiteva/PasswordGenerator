import java.util.Scanner;

public class Generator {
    private static Scanner keyboard;
    Alphabet alphabet;

    public Generator(){

    }
    public Generator(Scanner keyboard){
        Generator.keyboard = keyboard;
    }

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNumber, boolean includeSymbol) {
        alphabet = new Alphabet(includeUpper, includeLower, includeNumber, includeSymbol);
    }


    public void checkPassword() {
        String input;

        System.out.println("Enter your password");
        input = keyboard.next();
        Password p = new Password(input);

        System.out.println(p.claculatedScore());
    }

    public void requestPassword() {
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNumber = false;
        boolean includeSymbol = false;
        boolean correctParameters = false;

        System.out.println("Please answer the following questions with yes or no");
        do{
            String input;

            System.out.println("Do you want Lowercase letters abcd... to be used?");
            input = keyboard.next();
            if(input.equalsIgnoreCase("yes"))
                includeLower = true;

            System.out.println("Do you want Uppercase letters ABCD... to be used? ");
            input = keyboard.next();
            if(input.equalsIgnoreCase("yes"))
                includeUpper = true;

            System.out.println("Do you want Numbers 1234... to be used?");
            input = keyboard.next();
            if(input.equalsIgnoreCase("yes"))
                includeNumber = true;

            System.out.println("Do you want Symbols !@#$... to be used?");
            input = keyboard.next();
            if(input.equalsIgnoreCase("yes"))
                includeSymbol = true;

            if(!includeLower && !includeUpper && !includeNumber && !includeSymbol){
                System.out.println("You have selected no characters to generate your password, at least one of your answers should be Yes");
                correctParameters = true;
            }
        }while(correctParameters);

        System.out.println("Great! Now enter the length of your password");
        int length = keyboard.nextInt();

        Generator generator = new Generator(includeUpper, includeLower, includeNumber, includeSymbol);
        Password password = generator.generatePassword(length);

        System.out.println(password.toString());
    }

    private Password generatePassword(int length) {
        StringBuilder pass = new StringBuilder("");
        int alphabetLength = alphabet.getAlphabet().length();
        int max = alphabetLength-1;
        int min=0;
        int range=max-min-1;

        for(int i=0; i<length; i++){
            int index = (int) (Math.random()*range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }
}
