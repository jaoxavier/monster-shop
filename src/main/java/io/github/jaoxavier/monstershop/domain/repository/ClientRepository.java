package io.github.jaoxavier.monstershop.domain.repository;

import io.github.jaoxavier.monstershop.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
