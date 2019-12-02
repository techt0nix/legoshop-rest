package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Entity продукта, который идёт в приём. Хранит себе id продукта, его количество в рамках данного прихода
 * Привязан к определенному приходу (Income) через @ManyToOne
 */

@Entity
@Table(name = "income_item")
public class IncomeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    /**
     * поле для id самого продукта
     */
    @Column(name = "item_id")
    @NotNull
    private Long item_id;

    @ManyToOne
    @JoinColumn(name = "income_id")
    private Income income;

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;

    @Column(name = "comment")
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeItem that = (IncomeItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(item_id, that.item_id) &&
                Objects.equals(income, that.income) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item_id, income, quantity, comment);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
