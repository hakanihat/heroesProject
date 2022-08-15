package com.tinqin.project.models.hero;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroRequest implements OperationInput {
    private Long heroId;
}
