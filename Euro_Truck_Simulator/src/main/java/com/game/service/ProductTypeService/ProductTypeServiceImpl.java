package com.game.service.ProductTypeService;

import com.game.dao.ProductTypeRepository;
import com.game.model.ProductType;
import com.game.model.Request;
import com.game.service.TxtFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService
{
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private TxtFileReader txtFileReader;

    @Override
    public void save(ProductType productType) { productTypeRepository.save(productType); }

    @Override
    public int[] saveProductTypesList(List<ProductType> productTypes) {
        productTypeRepository.saveAll(productTypes);
        return new int[0];
    }

    @Override
    public void update(ProductType productType) { productTypeRepository.save(productType); }

    @Override
    public void delete(ProductType productType) { productTypeRepository.delete(productType); }

    @Override
    public void deleteAll() { productTypeRepository.deleteAll(); }

    @Override
    public List<ProductType> findAll() { return productTypeRepository.findAll(); }

    @Override
    public boolean existsByName(String name) { return productTypeRepository.existsByName(name); }

    @Override
    public void initializeProductTypes() throws IOException {
        List<ProductType> existingProductTypes = productTypeRepository.findAll();
        if (existingProductTypes.isEmpty()) {
            List<String> productTypesName = txtFileReader.readFile("src/main/resources/product_types.txt");
            for (String productTypeName : productTypesName){
                if (!productTypeRepository.existsByName(productTypeName)) {
                    ProductType productType = new ProductType(productTypeName);
                    productTypeRepository.save(productType);
                }
            }
        }
    }
}
