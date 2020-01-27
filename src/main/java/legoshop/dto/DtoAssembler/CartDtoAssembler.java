package legoshop.dto.DtoAssembler;

import org.springframework.stereotype.Component;
import legoshop.domain.Cart;
import legoshop.domain.CartItem;
import legoshop.domain.Part;
import legoshop.dto.CartDto;
import legoshop.dto.CartItemDto;
import java.util.LinkedList;
import java.util.List;

@Component
public class CartDtoAssembler {

    public CartDto toAnonymousResource(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        List<CartItemDto> cartItemDtos = new LinkedList<>();
        CartDto cartDto = new CartDto();

        for (CartItem cartItem : cartItems) {
            CartItemDto cartItemDto = new CartItemDto();
            Part part = cartItem.getPart();
            cartItemDto.setEngName(part.getEngName());
            cartItemDto.setImage(part.getImage());
            cartItemDto.setItemId(part.getId());
            cartItemDto.setPartNumber(part.getPartNumber());
            cartItemDto.setTotalItems(cartItem.getQuantity());
            cartItemDto.setPrice(part.getCurrentPrice());
            cartItemDtos.add(cartItemDto);
        }

        cartDto.setItems(cartItemDtos);
        cartDto.setTotalItems(cart.getTotalItems());
        cartDto.setTotalCost(cart.getProductsCost());

        return cartDto;
    }
}
