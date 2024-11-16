package com.luckshark.dslist.repositories;

import com.luckshark.dslist.entities.Game;
import com.luckshark.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
