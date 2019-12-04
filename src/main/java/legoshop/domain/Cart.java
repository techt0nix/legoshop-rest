package legoshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, insertable = false, updatable = false, nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true,
    targetEntity = CartItem.class, mappedBy = "cart")
    private Set<CartItem> cartItems;

    @Column(name = "total_items")
    private int totalItems;

    @Column(name = "products_cost")
    private int productsCost;

    public Cart() {
        this.totalItems = 0;
        this.productsCost = 0;
        this.cartItems = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getProductsCost() {
        return productsCost;
    }

    public void setProductsCost(int productsCost) {
        this.productsCost = productsCost;
    }
}
