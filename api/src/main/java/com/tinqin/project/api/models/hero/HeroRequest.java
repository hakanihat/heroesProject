package com.tinqin.project.api.models.hero;

import com.tinqin.project.api.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroRequest implements OperationInput {
    private Long heroId;
}
