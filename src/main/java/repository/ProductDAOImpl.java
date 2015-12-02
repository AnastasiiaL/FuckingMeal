package repository;

import model.Product;
import org.springframework.stereotype.Repository;

/**
 * Created by Anastasia on 01.12.2015.
 */
@Repository
public class ProductDAOImpl extends AbstractDAO<Product> implements IProductRepository{

    @Override
    protected String getEntityName() {
        return "Product";
    }

    @Override
    protected Class<Product> getaClass() {
        return Product.class;
    }

}
