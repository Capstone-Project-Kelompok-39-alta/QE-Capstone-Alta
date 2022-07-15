package Utils;

import java.util.Random;

public class General {

    static Random rand = new Random();

    public String randomUsername() {
        return "imamrayhanekadinata" + +rand.nextInt(1000);
    }

    public String randomNips() {
        return "1233212244" + +rand.nextInt(1000);
    }

    public String randomEmails() {
        return "imamrayhane" + +rand.nextInt(1000) + "@gmail.com";
    }

    public String randomPasswords() {
        return "rayhangantenk" + +rand.nextInt(1000);
    }
}

