package com.game.service.ProductTypeService;

import com.game.model.ProductType;
import com.game.model.Request;

import java.io.IOException;
import java.util.List;

public interface ProductTypeService
{
    void save(ProductType productType) ;

    int[] saveProductTypesList(List<ProductType> productTypes) ;

    void update(ProductType productType) ;

    void delete(ProductType productType) ;

    List<ProductType> findAll() ;

    void deleteAll() ;

    boolean existsByName(String name);

    void initializeProductTypes() throws IOException;
}
