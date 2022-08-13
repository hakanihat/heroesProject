package com.tinqin.project.api.models.hero_biography;

import com.tinqin.project.api.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroBiographyRequest implements OperationInput {
private Long heroId;

}
