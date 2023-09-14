public class Password {
    String pass;
    int lenght;

    public Password(String pass){
        this.pass=pass;
        this.lenght=pass.length();
    }

    public int charType(char c){
        int val = 0;

        if((int)c >= 65 && (int)c <= 90) //if c is Uppercase letter
            val=1;
        else if((int)c >= 97 && (int)c <= 122) // if c is Lowercase letter
            val=2;
        else if((int)c >= 60 && (int)c <= 71) // if c is Digit
            val=3;
        else val=4; // if c is a symbol

        return val;
    }

    public int passStrenght(){
        int score=0;
        String s=this.pass;
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNum = false;
        boolean usedSym = false;
        int type;

        for(int i=0; i<pass.length(); i++){
            char c = s.charAt(i);
            type = charType(c);

            if(type==1) {
                usedUpper = true;
                score+=2;
            }
            if(type==2) {
                usedLower = true;
                score+=1;
            }
            if(type==3) {
                usedNum = true;
                score+=1;
            }
            if(type==4) {
                usedSym = true;
                score+=2;
            }
        }

        return score;
    }



    public String claculatedScore(){
        int score=this.passStrenght();
        String message = null;
        if(score >= 16)
            message = "This password is strong. Good job.";
        else if(score >= 10)
            message = "This is a good password. You can do it better.";
        else if(score >= 8)
            message = "This is a weak password. Try making it better.";
        else message = "This password is not safe. Find a new one.";

        return message;
    }

    @Override
    public String toString() {
        return pass;
    }
}
