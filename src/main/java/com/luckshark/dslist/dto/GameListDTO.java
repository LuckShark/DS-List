package com.luckshark.dslist.dto;

import com.luckshark.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {
    }

    //Com o DTO, eu não quero um construtor que receba os campos separados
    //Eu quero um que receba a entidade
    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    //Como não usei o BeanUtils, posso implementar só os Gets

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
