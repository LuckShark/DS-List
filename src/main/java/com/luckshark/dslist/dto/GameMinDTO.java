package com.luckshark.dslist.dto;


import com.luckshark.dslist.entities.Game;
import com.luckshark.dslist.projections.GameMinProjection;

public class GameMinDTO { //É uma versão do Game mas só com 5 dados

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) { //fazendo isso, eu copio o que está no game
        //na verdade, nem precisa do THIS, por que não tem ambiguidade
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    //DTO para Projections
    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    //No DTO, só precia de GETTERs

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
