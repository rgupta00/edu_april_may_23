package com.productapp.model.dao;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class ProductDaoImplHib implements ProductDao{

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImplHib(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Product> getAll() {
        return getSession()
                .createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    @Override
    public Product addProduct(Product product) {
         getSession().persist(product);
         return  product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate= getById(id);
        System.out.println("---------"+ productToUpdate.getPrice());
        productToUpdate.setPrice(product.getPrice());
        System.out.println("---------"+ productToUpdate.getPrice());
        getSession().merge(productToUpdate);

        return productToUpdate;
    }

    @Override
    public Product deleteProduct(int id) {
        Product productToDelete= getById(id);
        getSession().remove(productToDelete);
        return productToDelete;
    }

    @Override
    public Product getById(int id) {
        Product product=getSession().get(Product.class, id);
        if(product==null){
            throw  new ProductNotFoundException("product not found ex");
        }
        return product;
    }
}
