package dmytro.kudriavtsev.auth.lab1.services;

import dmytro.kudriavtsev.auth.lab1.algorithm.DiffieHellman;
import dmytro.kudriavtsev.auth.lab1.dtos.DiffieHellmanDto;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    private DiffieHellman diffieHellman;

    public int numberModGen(DiffieHellmanDto diffieHellmanDto) {
        diffieHellman = new DiffieHellman();

        int numberMod = diffieHellman.keyGen(diffieHellmanDto.getG(), diffieHellmanDto.getP(), diffieHellmanDto.getNumberMod());
        return numberMod;
    }
}
