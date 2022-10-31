package com.works.securityjwt.services;


import com.works.securityjwt.entities.Product;
import com.works.securityjwt.entities.User;
import com.works.securityjwt.repositories.CateProductRepository;
import com.works.securityjwt.repositories.ProductRepository;
import com.works.securityjwt.repositories.UserRepository;
import com.works.securityjwt.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    final ProductRepository pRepo;
    final CateProductRepository caProRepo;

    final UserRepository userRepository;

    public ProductService(ProductRepository pRepo, CateProductRepository caProRepo, UserRepository userRepository) {
        this.pRepo = pRepo;
        this.caProRepo = caProRepo;
        this.userRepository = userRepository;
    }


    public ResponseEntity save(Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        boolean exist=pRepo.existsByName(product.getName());
        if(exist){
            hm.put("status", true);
            hm.put("result","Aynı üründen var" );
        }else{
            pRepo.save(product);
            hm.put("status", true);
            hm.put("result",product );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getPro() {
        Map<String, Object> hm = new LinkedHashMap<>();
            hm.put("status", true);
            hm.put("result",pRepo.findAll() );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity deletePro(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        pRepo.deleteById(id);
        hm.put("status", true);
        hm.put("result","İşlem Başarılı" );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getByid(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<Product> isPro=pRepo.findById(id);
        if(isPro.isPresent()){
            hm.put("status", true);
            hm.put("result",isPro.get() );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity updatePro(Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<Product> isPro=pRepo.findById(product.getId());
        if (isPro.isPresent()){
            isPro.get().setName(product.getName());
            isPro.get().setPrice(product.getPrice());
            isPro.get().setText(product.getText());
            pRepo.save(isPro.get());
            hm.put("status", true);
            hm.put("result",product );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    /* Categori ile Productları getiewn fonk*/
    public ResponseEntity getCatPro(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", caProRepo.cateProductList(id));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getByCatId(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", caProRepo.cateProductByıd(id));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getUser(String email) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        Optional<User> user=userRepository.findByEmailContains(email);
        hm.put(REnum.status, true);
        hm.put(REnum.result, user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
