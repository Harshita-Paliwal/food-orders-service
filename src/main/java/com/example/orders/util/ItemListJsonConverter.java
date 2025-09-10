package com.example.orders.util;

import com.example.orders.dto.ItemDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.List;

@Converter
public class ItemListJsonConverter implements AttributeConverter<List<ItemDto>, String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<ItemDto> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize items to JSON", e);
        }
    }

    @Override
    public List<ItemDto> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, new TypeReference<List<ItemDto>>(){});
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize items JSON", e);
        }
    }
}
