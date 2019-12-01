package legoshop.domain;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 * Абстрактная entity, которое имеет картинку (image)
 */

@MappedSuperclass
public class AbstractEntityWithImage {

    @Lob
    private byte[] image;

    @Column(name = "img_name")
    @NotBlank
    private String imageName;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
