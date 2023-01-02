package io.github.jaoxavier.monstershop.service.application;

import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.github.jaoxavier.monstershop.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService implements UserDetailsService {

    private final PasswordEncoder encoder;
    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }

    public UserDetails authentication(Client client){
        UserDetails user = loadUserByUsername(client.getUsername());
        boolean isPasswordCorrect = encoder.matches(client.getPassword(), user.getPassword());

        if(isPasswordCorrect){
            return user;
        }
        throw new RuntimeException("Password or Username don't match");
    }

    @Override
    public UserDetails loadUserByUsername(String loginClient) {
        Client client = clientRepository.findByUsername(loginClient).orElseThrow(
                () -> new RuntimeException("Client not found")
        );

        String[] roles = client.isAdmin() ?
                new String[]{"ADMIN", "USER"} :
                new String[]{"USER"};

        return User
                .builder()
                .username(client.getUsername())
                .password(client.getPassword())
                .roles(roles)
                .build();
    }
}
