package legoshop.domain;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntityWithImage {

    @Lob
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
