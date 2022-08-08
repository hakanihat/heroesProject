package com.tinqin.project.api.generics;

import io.vavr.control.Either;
import org.springframework.http.HttpStatus;

public interface OperationProcessor  <I extends OperationInput, R extends OperationResult>{
    Either<Error,R>   processFind(I input);
    Either<Error,R> processById(Long id);
    HttpStatus processDelete(Long id);
}
