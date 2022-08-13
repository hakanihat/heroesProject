package com.tinqin.project.api.models.create;

import com.tinqin.project.api.generics.OperationInput;

import java.time.LocalDate;

public class MovieCreateRequest implements OperationInput {

    private String movieName;
    private LocalDate releaseDate;
}
