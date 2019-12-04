package legoshop.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Первичный ключ элемента корзины.
 */

@Embeddable
public class CartItemId implements Serializable {

    private Long cartId;
    private Long partId;

    public CartItemId() {

    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemId that = (CartItemId) o;
        return Objects.equals(cartId, that.cartId) &&
                Objects.equals(partId, that.partId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, partId);
    }
}
