package pl.swosek.sample.penguin.data.repository.entity.converter;

import jakarta.persistence.AttributeConverter;
import org.springframework.http.MediaType;

/**
 * JPA converter for {@link MediaType}.
 */
public class MediaTypeConverter implements AttributeConverter<MediaType, String> {
    
    @Override
    public String convertToDatabaseColumn(MediaType mediaType) {
        return mediaType.toString();
    }

    @Override
    public MediaType convertToEntityAttribute(String value) {
        return MediaType.valueOf(value);
    }

}
