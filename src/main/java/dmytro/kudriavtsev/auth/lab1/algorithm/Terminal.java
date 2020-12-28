package dmytro.kudriavtsev.auth.lab1.algorithm;

import java.util.Random;

public class Terminal {
    private int number;
    private Random random = new Random();

    public Terminal() {
        this.number = random.nextInt();
    }

    public int numberModGen(int g, int p) {
        return (int) (Math.pow(g, number) % p);
    }

    public int finalNumberGen(int number, int p) {
        return (int) (Math.pow(number, this.number) % p);
    }
}
