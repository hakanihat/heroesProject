package com.tinqin.project.api.models.hero_biography;

import com.tinqin.project.api.generics.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HeroBiographyResponse implements OperationResult {
    private String fullName;
    private String alterEgos;
    private List<String> aliases;
    private String placeOfBirth;
    private String firstAppearance;
}
