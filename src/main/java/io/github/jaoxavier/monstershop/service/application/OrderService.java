package io.github.jaoxavier.monstershop.service.application;

import io.github.jaoxavier.monstershop.domain.dto.ItemsInfoDTO;
import io.github.jaoxavier.monstershop.domain.dto.OrderDTO;
import io.github.jaoxavier.monstershop.domain.entity.Client;
import io.github.jaoxavier.monstershop.domain.entity.Items;
import io.github.jaoxavier.monstershop.domain.entity.Monster;
import io.github.jaoxavier.monstershop.domain.entity.Order;
import io.github.jaoxavier.monstershop.domain.repository.ClientRepository;
import io.github.jaoxavier.monstershop.domain.repository.ItemsRepository;
import io.github.jaoxavier.monstershop.domain.repository.MonsterRepository;
import io.github.jaoxavier.monstershop.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;
    private final ItemsRepository itemsRepository;
    private final MonsterRepository monsterRepository;
    @Transactional
    public Order save(OrderDTO dto){
        Order order = new Order();
        order.setClient(clientRepository.findById(dto.getClient()).orElseThrow(
                () -> new RuntimeException("Client not found newOrder")
        ));

        order.setId(orderRepository.save(order).getId());

        List<Items> items = convertItems(dto.getItems(), order);
        order.setItens(items);

        var totalPrice = 0d;
        for (Items _item: items) {
            totalPrice = totalPrice + _item.getTotal();
        }
        order.setTotalPrice(totalPrice);

        itemsRepository.saveAll(items);
        order.setItens(items);
        return orderRepository.save(order);
    }

    public List<Items> convertItems(List<ItemsInfoDTO> items, Order order){
        if(items.isEmpty()){
            throw new RuntimeException("No items found");
        }

        return items.stream()
                .map(dto ->{
                    Items _item = new Items();
                    Monster monster = monsterRepository.findById(dto.getMonster()).orElseThrow(
                            () -> new RuntimeException("Monster not found")
                    );

                    monster.setStock(monster.getStock() - dto.getQuantity());
                    monsterRepository.save(monster);

                    _item.setQuantity(dto.getQuantity());
                    _item.setTotal(dto.getQuantity() * monster.getPrice());
                    _item.setMonster(monster.getId());
                    _item.setOrder(order);
                    return _item;
                }).collect(Collectors.toList());
    }
}
