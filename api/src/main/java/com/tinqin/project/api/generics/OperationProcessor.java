package com.tinqin.project.api.generics;

import io.vavr.control.Either;
import org.springframework.http.HttpStatus;

public interface OperationProcessor  <I extends OperationInput, R extends OperationResult>{
    Either<Error,R>   process(I input);
}
