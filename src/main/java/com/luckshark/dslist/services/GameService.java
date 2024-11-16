package com.luckshark.dslist.services;

import com.luckshark.dslist.dto.GameDTO;
import com.luckshark.dslist.dto.GameMinDTO;
import com.luckshark.dslist.entities.Game;
import com.luckshark.dslist.projections.GameMinProjection;
import com.luckshark.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Eu preciso registrar esse componente, diferente do Repository (poderia usar @Component tbm)
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //PASSO 2: Após criar um GameDTO, criar um get por ID
    @Transactional(readOnly = true) //Isso é pra assegurar que não terá escrita
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    //Respeita a arquitetura: esse service devolve um DTO
    //PASSO 1: Criou um get (todos)
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //gera uma consulta no banco que busca todos os games, e é convertida em uma lista de games que cai numa variável (result)
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    //Após criar o Projections
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
