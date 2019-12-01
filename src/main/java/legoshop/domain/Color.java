package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * Entity цветов деталей
 */

@Entity
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "eng_name")
    @NotEmpty
    @Pattern(regexp = "^[^#$%^&*()']*$")
    private String engName;

    @Column(name = "rus_name")
    @NotEmpty
    @Pattern(regexp = "^[^#$%^&*()']*$")
    private String rusName;

    @OneToMany(mappedBy = "color", cascade = CascadeType.REMOVE)
    private Set<Part> parts;


    public Color(Long id, @NotEmpty @Pattern(regexp = "^[^#$%^&*()']*$") String engName, @NotEmpty @Pattern(regexp = "^[^#$%^&*()']*$") String rusName) {
        this.id = id;
        this.engName = engName;
        this.rusName = rusName;
    }

    public Color() {

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
}
