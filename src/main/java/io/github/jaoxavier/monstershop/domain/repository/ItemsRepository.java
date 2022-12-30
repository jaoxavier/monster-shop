package io.github.jaoxavier.monstershop.domain.repository;

import io.github.jaoxavier.monstershop.domain.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
