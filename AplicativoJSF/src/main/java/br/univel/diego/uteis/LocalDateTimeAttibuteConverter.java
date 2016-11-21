package br.univel.diego.uteis;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Diego Rhoden
 *conversor de data para o java8
 * 21 de nov de 2016 às 00:44:58
 */
@Converter(autoApply=true)
public class LocalDateTimeAttibuteConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	//TRANSFORMA EM Timestamp NA HORA DE PERSISTIR NO BANCO DE DADOS
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {

		if(localDateTime != null)
			return Timestamp.valueOf(localDateTime);

		return null;

	}

	//TRANSFORMA UM Timestamp EM LocalDateTime QUANDO RETORNAR DO BANCO PARA ENTIDADE
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {

		if(timestamp != null)
			return timestamp.toLocalDateTime();

		return null;
	}	
}