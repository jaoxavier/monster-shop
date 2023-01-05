package io.github.jaoxavier.monstershop.rest.controller;

import io.github.jaoxavier.monstershop.domain.entity.Monster;
import io.github.jaoxavier.monstershop.domain.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monster")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MonsterController {
    private final MonsterRepository monsterRepository;

    @GetMapping("/all")
    public List<Monster> listAll(){
        return monsterRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Monster> listByCategory(@PathVariable String category){
        return monsterRepository.findByCategory(category);
    }
}
