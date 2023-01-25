package io.github.jaoxavier.monstershop.domain.repository;

import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.github.jaoxavier.monstershop.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByClient(Client client);
}
