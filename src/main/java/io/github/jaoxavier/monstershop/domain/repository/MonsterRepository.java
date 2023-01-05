package io.github.jaoxavier.monstershop.domain.repository;

import io.github.jaoxavier.monstershop.domain.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonsterRepository extends JpaRepository<Monster, Integer> {

    public List<Monster> findByCategory(String category);
}
