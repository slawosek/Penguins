package pl.swosek.sample.penguin.data.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.MediaType;
import pl.swosek.sample.penguin.data.repository.entity.converter.MediaTypeConverter;

import java.util.UUID;

/**
 * Image entity.
 */
@Entity
@Table(name = "penguin_images")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PenguinImage {

    /**
     * Uuid.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    /**
     * File name.
     */
    private String filename;

    /**
     * Mime type.
     */
    @Convert(converter = MediaTypeConverter.class)
    private MediaType mimeType;

    /**
     * Byte values of the file.
     */
    @Lob
    private byte[] bytes;

    /**
     * Observation card of given attachment.
     */
    @ManyToOne
    @JoinColumn(name = "penguin_taxon_key")
    private Penguin penguin;

}
