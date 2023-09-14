public class Alphabet {
    public String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    public String numbers = "1234567890";
    public String symbols = "!@#$%^&*()-_=+\\/~?";
    private StringBuilder pool;

    public Alphabet(boolean includeUpper, boolean includeLower, boolean includeNumber, boolean includeSymbol) {
        pool = new StringBuilder();
        if(includeUpper)
            pool.append(upperCaseLetters);
        if(includeLower)
            pool.append(lowerCaseLetters);
        if(includeNumber)
            pool.append(numbers);
        if(includeSymbol)
            pool.append(symbols);
    }

    public String getAlphabet() {
        return pool.toString();
    }
}
