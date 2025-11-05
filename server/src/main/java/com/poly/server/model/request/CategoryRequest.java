package com.poly.server.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    private Long id;

    private String categoryCode;

    private String categoryName;

}
