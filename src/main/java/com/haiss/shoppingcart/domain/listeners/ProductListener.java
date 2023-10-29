package com.haiss.shoppingcart.domain.listeners;

import com.haiss.shoppingcart.domain.entity.Product;
import com.haiss.shoppingcart.domain.enums.ProductStatus;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class ProductListener {

    @PrePersist
    @PreUpdate
    private void updateStatus(Product product) {
        if (product.getStatus().equals(ProductStatus.DELETED)) return;
        else if (product.getQty() == 0) product.setStatus(ProductStatus.UNAVAILABLE);
        else if (product.getQty() > 1 && product.getStatus().equals(ProductStatus.UNAVAILABLE))
            product.setStatus(ProductStatus.AVAILABLE);
    }

}
