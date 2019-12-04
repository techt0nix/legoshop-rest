package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Entity детали
 */

@Entity
@Table(name="part")
public class Part extends AbstractEntityWithImage {

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private int version = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "part_number")
    private String partNumber;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Color color;

    @NotEmpty
    @Column(name = "eng_name")
    private String engName;

    @NotEmpty
    @Column(name = "rus_name")
    private String rusName;

    @Column(name = "comment")
    private String comment;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "quantity", columnDefinition = "integer DEFAULT 0", nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<IncomeItem> incomes;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OutcomeItem> outcomes;


    public Integer getTotalQuantity() {
        return quantity;
    }

    public void setTotalQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Set<IncomeItem> getIncomes() {
        return incomes;
    }

    public void setIncomes(Set<IncomeItem> incomes) {
        this.incomes = incomes;
    }

    public Set<OutcomeItem> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Set<OutcomeItem> outcomes) {
        this.outcomes = outcomes;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
