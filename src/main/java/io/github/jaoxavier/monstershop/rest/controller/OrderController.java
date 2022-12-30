package io.github.jaoxavier.monstershop.rest.controller;

import io.github.jaoxavier.monstershop.domain.dto.ItemsInfoDTO;
import io.github.jaoxavier.monstershop.domain.dto.OrderDTO;
import io.github.jaoxavier.monstershop.domain.dto.OrderInfoDTO;
import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.github.jaoxavier.monstershop.domain.entity.Items;
import io.github.jaoxavier.monstershop.domain.entity.Monster;
import io.github.jaoxavier.monstershop.domain.entity.Order;
import io.github.jaoxavier.monstershop.domain.repository.ClientRepository;
import io.github.jaoxavier.monstershop.domain.repository.ItemsRepository;
import io.github.jaoxavier.monstershop.domain.repository.MonsterRepository;
import io.github.jaoxavier.monstershop.domain.repository.OrderRepository;
import io.github.jaoxavier.monstershop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final ClientRepository clientRepository;
    private final MonsterRepository monsterRepository;
    private final ItemsRepository itemsRepository;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer saveNewOrder(@RequestBody OrderDTO dto){
        return orderService.save(dto).getId();
    }

    @GetMapping("/all")
    public List<Order> list(){
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrderInfoDTO listById(@PathVariable Integer id){
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order not found")
        );
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setIdProject(order.getId());
        orderInfoDTO.setIdClient(order.getClient().getId());
        orderInfoDTO.setItems(order.getItens());
        orderInfoDTO.setTotal(order.getTotalPrice());
        return orderInfoDTO;
    }


}
