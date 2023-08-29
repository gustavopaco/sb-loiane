package com.pacoprojects.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("Ativo"), DELETED("Deletado");

    private final String description;

    @Override
    public String toString() {
        return this.description;
    }
}
