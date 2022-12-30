package io.github.jaoxavier.monstershop.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Integer client;
    private List<ItemsInfoDTO> items;
}
