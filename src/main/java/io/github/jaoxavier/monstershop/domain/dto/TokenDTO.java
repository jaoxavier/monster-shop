package io.github.jaoxavier.monstershop.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {
    private Integer id;
    private String username;
    private String token;
}
