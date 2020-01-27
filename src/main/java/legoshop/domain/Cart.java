package legoshop.domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, insertable = false, updatable = false, nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true,
    targetEntity = CartItem.class, mappedBy = "cart")
    private List<CartItem> cartItems;

    @Column(name = "total_items")
    private Integer totalItems;

    @Column(name = "products_cost")
    private Integer productsCost;

    public Cart() {
        this.totalItems = 0;
        this.productsCost = 0;
        this.cartItems = new LinkedList<>();
    }


    public boolean isEmpty() {
        return (totalItems == 0);
    }

    public void update(Part part, int quantity) {
        CartItem newItem = new CartItem(this, part, quantity);
        newItem.setPk(new CartItemId(this.getId(), part.getId()));
        List<CartItem> items = getCartItems();

        if (quantity > 0) {
            if (items.contains(newItem)) {
                int index = items.indexOf(newItem);
                CartItem cartItem = items.get(index);
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
            } else {
                items.add(newItem);
            }
        }

        revalidateCartMetrics();
    }

    public void clear() {
        getCartItems().clear();
        revalidateCartMetrics();
    }

    private void revalidateCartMetrics() {
        int total = 0;

        for (CartItem item : getCartItems()) {
            total += item.getQuantity();
        }
        setTotalItems(total);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getProductsCost() {
        return productsCost;
    }

    public void setProductsCost(Integer productsCost) {
        this.productsCost = productsCost;
    }
}
