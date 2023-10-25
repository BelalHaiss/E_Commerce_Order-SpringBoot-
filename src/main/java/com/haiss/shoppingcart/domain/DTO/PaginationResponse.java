package com.haiss.shoppingcart.domain.DTO;

import lombok.Data;

import java.util.List;
@Data
public class PaginationResponse<T> {
    private List<T> content;
    private int PageNo ;
    private int PageSize ;
    private int totalElments ;
    private int totalPages ;
    private boolean isLast ;

}



