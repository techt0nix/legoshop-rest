package legoshop.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

/**
 * Entity прихода (Income). Содержит в себе множество IncomeItem (продуктов).
 * Связан с IncomeItem черех @OneToMany.
 */

@Entity
@Table(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "income", cascade = CascadeType.ALL)
    private Set<IncomeItem> items;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<IncomeItem> getItems() {
        return items;
    }

    public void setItems(Set<IncomeItem> items) {
        this.items = items;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
