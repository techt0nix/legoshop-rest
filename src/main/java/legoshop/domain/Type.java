package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Тип деталей
 */
@Entity
@Table(name = "part_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name="eng_name", nullable = false)
    @NotEmpty
    @Pattern(regexp = "^[^#$%^&*()']*$")
    private String engName;

    @Column(name="rus_name", nullable = false)
    @NotEmpty
    @Pattern(regexp = "^[^#$%^&*()']*$")
    private String rusName;

    @Lob
    private byte[] image;

    public Type(Long id, @NotEmpty @Pattern(regexp = "^[^#$%^&*()']*$") String engName, @NotEmpty @Pattern(regexp = "^[^#$%^&*()']*$") String rusName, byte[] image) {
        this.id = id;
        this.engName = engName;
        this.rusName = rusName;
        this.image = image;
    }

    public Type () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    public byte[] getImage() { return image; }

    public void setImage(byte[] image) { this.image = image; }
}
