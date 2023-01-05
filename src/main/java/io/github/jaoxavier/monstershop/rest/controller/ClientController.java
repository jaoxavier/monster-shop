package io.github.jaoxavier.monstershop.rest.controller;

import antlr.Token;
import io.github.jaoxavier.monstershop.domain.dto.CredenciaisDTO;
import io.github.jaoxavier.monstershop.domain.dto.TokenDTO;
import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.github.jaoxavier.monstershop.domain.repository.ClientRepository;
import io.github.jaoxavier.monstershop.service.application.ClientService;
import io.github.jaoxavier.monstershop.service.jwt.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientService clientService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveNewClient(@RequestBody Client client){
        String encryptedPassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(encryptedPassword);
        return clientService.save(client);
    }

    @PostMapping("/auth")
    public TokenDTO authentication(@RequestBody CredenciaisDTO dto){
        try{
            Client client = Client
                    .builder()
                    .id(clientRepository.findByUsername(dto.getUsername()).get().getId())
                    .username(dto.getUsername())
                    .password(dto.getPassword())
                    .build();
            UserDetails authenticatedUser = clientService.authentication(client);
            String token = jwtService.generateToken(client);
            return new TokenDTO(client.getId(), client.getUsername(), token);
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
