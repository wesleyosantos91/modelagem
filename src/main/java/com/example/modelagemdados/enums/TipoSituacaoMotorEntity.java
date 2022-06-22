package com.example.modelagemdados.enums;

import static java.text.MessageFormat.format;

import java.util.Arrays;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.Getter;

@Getter
public enum TipoSituacaoMotorEntity {

    ATIVO("S"),
    INATIVO("N");

    private final String value;

    TipoSituacaoMotorEntity(String value){
        this.value = value;
    }

    public static TipoSituacaoMotorEntity valueOfByName(String value){
        return Arrays.stream(values())
                .filter(tipoSituacaoMotorEntity -> value.equalsIgnoreCase(tipoSituacaoMotorEntity.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("Enumeration not found {0}", value)));
    }
    @Converter(autoApply = true)
    public static class Mapeador implements AttributeConverter<TipoSituacaoMotorEntity, String> {

        @Override
        public String convertToDatabaseColumn(TipoSituacaoMotorEntity situacaoMotor) {
            return String.valueOf(situacaoMotor.getValue());
        }

        @Override
        public TipoSituacaoMotorEntity convertToEntityAttribute(String value) {
            if (value == null) return null;
            if ("S".equals(value)) return ATIVO;
            if ("N".equals(value)) return INATIVO;
            throw new IllegalStateException("Valor inválido: " + value);
        }
    }

}
