package dmytro.kudriavtsev.auth.lab1.controllers.rest;

import dmytro.kudriavtsev.auth.lab1.dtos.DiffieHellmanDto;
import dmytro.kudriavtsev.auth.lab1.dtos.LoginDto;
import dmytro.kudriavtsev.auth.lab1.services.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dh")
public class KeyController {
    @Autowired
    private KeyService keyService;

    @GetMapping
    public ResponseEntity<?> getNumber(@ModelAttribute DiffieHellmanDto diffieHellmanDto) {
        int number = keyService.numberModGen(diffieHellmanDto);

        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
