package io.github.jaoxavier.monstershop.rest.controller;

import io.github.jaoxavier.monstershop.domain.entity.Monster;
import io.github.jaoxavier.monstershop.domain.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/monster")
@RequiredArgsConstructor
public class MonsterController {
    private final MonsterRepository monsterRepository;

    @GetMapping("/all")
    public List<Monster> listAll(){
        return monsterRepository.findAll();
    }
}
