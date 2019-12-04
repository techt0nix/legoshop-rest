package legoshop.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @EmbeddedId
    private CartItemId pk = new CartItemId();

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;

    @MapsId("cartId")
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    @ManyToOne
    private Cart cart;

    @MapsId("partId")
    @JoinColumn(name = "part_id", referencedColumnName = "id")
    @ManyToOne
    private Part part;

    public CartItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartItem that = (CartItem) o;
        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    public CartItemId getPk() {
        return pk;
    }

    public void setPk(CartItemId pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        getPk().setCartId(cart.getId());
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
        getPk().setPartId(part.getId());
    }
}
