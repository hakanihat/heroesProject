package com.tinqin.project.models.hero_biography;

import com.tinqin.project.generics.OperationResult;
import lombok.*;

import java.util.List;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class HeroBiographyResponse implements OperationResult {
    private String fullName;
    private String alterEgos;
    private String placeOfBirth;
    private String firstAppearance;
    private String publisher;
    private String alignment;
}
