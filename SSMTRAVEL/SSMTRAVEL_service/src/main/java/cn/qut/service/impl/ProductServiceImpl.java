package cn.qut.service.impl;

import cn.qut.dao.IProductDao;
import cn.qut.domain.Product;
import cn.qut.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
   @Autowired
   private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {

        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
