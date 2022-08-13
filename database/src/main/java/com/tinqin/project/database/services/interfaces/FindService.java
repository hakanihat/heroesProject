package com.tinqin.project.database.services.interfaces;

import com.tinqin.project.api.generics.OperationInput;
import com.tinqin.project.api.generics.OperationResult;

import java.util.List;

public interface FindService <I extends OperationInput, R extends OperationResult> {
    List<R> find (I request);
}
