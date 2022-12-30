package io.github.jaoxavier.monstershop.domain.dto;

import io.github.jaoxavier.monstershop.domain.entity.Items;
import lombok.Data;

import java.util.List;

@Data
public class OrderInfoDTO {
    private Integer idProject;
    private Integer idClient;
    private List<Items> items;
    private Double total;
}
