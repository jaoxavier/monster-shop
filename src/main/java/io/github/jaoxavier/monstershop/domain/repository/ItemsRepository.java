package io.github.jaoxavier.monstershop.domain.repository;

import io.github.jaoxavier.monstershop.domain.entity.Items;
import io.github.jaoxavier.monstershop.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

    public List<Items> findByOrder(Order order);
}
