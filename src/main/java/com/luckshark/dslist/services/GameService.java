package com.luckshark.dslist.services;

import com.luckshark.dslist.dto.GameMinDTO;
import com.luckshark.dslist.entities.Game;
import com.luckshark.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//Eu preciso registrar esse componente, diferente do Repository (poderia usar @Component tbm)
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //Respeita a arquitetura: esse service devolve um DTO
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //gera uma consulta no banco que busca todos os games, e é convertida em uma lista de games que cai numa variável (result)
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
