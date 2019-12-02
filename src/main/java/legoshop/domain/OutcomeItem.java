package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Entity продукта, который отгружается. Хранит себе id продукта, его количество в рамках отгрузки
 *
 */

@Entity
@Table(name="outcome_item")
public class OutcomeItem {

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


//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;


    @Column(name = "quantity")
    @NotNull
    private Integer quantity;

    @Column(name = "comment")
    private String comment;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutcomeItem that = (OutcomeItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(item_id, that.item_id) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item_id, quantity, comment);
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
