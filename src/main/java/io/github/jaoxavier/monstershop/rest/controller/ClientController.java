package io.github.jaoxavier.monstershop.rest.controller;

import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.github.jaoxavier.monstershop.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;

    @PostMapping
    public Client saveNewClient(@RequestBody Client client){
        return clientRepository.save(client);
    }
}
