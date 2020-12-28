package dmytro.kudriavtsev.auth.lab1.algorithm;

import java.util.Random;

public class DiffieHellman {
    private int b;
    private Random random = new Random();

    public DiffieHellman() {
        this.b = random.nextInt(100);
    }

    public int keyGen(int g, int p, int numberMod) {
        int serverNumMod = numberModGen(g, p);

        int key = (int) (Math.pow(numberMod, this.b) % p);
        System.out.println("KEY: " + key);

        return serverNumMod;
    }

    private int numberModGen(int g, int p) {
        return (int) (Math.pow(g, this.b) % p);
    }
}
