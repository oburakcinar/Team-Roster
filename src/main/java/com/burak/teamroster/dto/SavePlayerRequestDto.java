package com.burak.teamroster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePlayerRequestDto {

    //this class is used for transferring the player fields(except id field) to player entity.
    //id field is not needed since it will be automatically generated for player entity

    private String name;
    private String surname;
    private String playerPosition;


}
