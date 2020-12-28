package dmytro.kudriavtsev.auth.lab1.dtos;

public class DiffieHellmanDto {
    private int g;
    private int p;
    private int numberMod;

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getNumberMod() {
        return numberMod;
    }

    public void setNumberMod(int numberMod) {
        this.numberMod = numberMod;
    }
}
