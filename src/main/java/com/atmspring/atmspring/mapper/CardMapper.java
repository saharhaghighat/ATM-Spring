package com.atmspring.atmspring.mapper;

import com.atmspring.atmspring.dto.CardDTO;
import com.atmspring.atmspring.model.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends GenericMapper<Card, CardDTO> {
}
