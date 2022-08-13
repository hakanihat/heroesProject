package com.tinqin.project.database.services.interfaces;

import com.tinqin.project.api.generics.OperationInput;

public interface AddService <I extends OperationInput> {

    Long add(I request);
}
