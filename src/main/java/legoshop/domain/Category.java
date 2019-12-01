package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * Entity категории деталей
 */

@Entity
@Table(name = "part_category")
public class Category extends AbstractEntityWithImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "eng_name", nullable = false)
    @NotEmpty
    @Pattern(regexp = "^[^#$%^&*()']*$")
    private String engName;

    @Column(name = "rus_name", nullable = false)
    @NotEmpty
    @Pattern(regexp = "^[^#$%^&*()']*$")
    private String rusName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private Set<Part> parts;



    public Category(Long id, @NotEmpty @Pattern(regexp = "^[^#$%^&*()']*$") String engName, @NotEmpty @Pattern(regexp = "^[^#$%^&*()']*$") String rusName, byte[] image) {
        this.id = id;
        this.engName = engName;
        this.rusName = rusName;
        super.setImage(image);
    }

    public Category() {

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

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
