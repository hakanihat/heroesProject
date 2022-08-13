package com.tinqin.project.database.services.interfaces;

import com.tinqin.project.api.generics.OperationResult;

public interface GetService <R extends OperationResult> {

    R getById (Long id);
}
