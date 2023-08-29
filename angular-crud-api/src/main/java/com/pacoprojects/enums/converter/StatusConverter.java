package com.pacoprojects.enums.converter;

import com.pacoprojects.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

        @Override
        public String convertToDatabaseColumn(Status status) {
            if (status == null) {
                return null;
            }
            return status.getDescription();
        }

        @Override
        public Status convertToEntityAttribute(String description) {
            if (description == null) {
                return null;
            }
            return Stream.of(Status.values())
                    .filter(c -> c.getDescription().equals(description))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + description));
        }
}
