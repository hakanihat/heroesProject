package com.tinqin.project.models.hero_biography;

import com.tinqin.project.generics.OperationInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeroBiographyRequest implements OperationInput {
private Long heroId;

}
