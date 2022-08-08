package com.tinqin.project.api.generics;

import org.springframework.http.HttpStatus;

public interface Error {
    String getMessage();
    HttpStatus getCode();
}
