package com.works.securityjwt.services;

import com.works.securityjwt.entities.Category;
import com.works.securityjwt.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {

    final CategoryRepository cRepo;

    public CategoryService(CategoryRepository cRepo) {
        this.cRepo = cRepo;
    }

    public ResponseEntity save(Category category) {
        Map<String, Object> hm = new LinkedHashMap<>();
        boolean exist=cRepo.existsByAdEqualsIgnoreCase(category.getAd());
        if(exist){
            hm.put("status", false);
            hm.put("result", "Böyle bir kategor, var");
        }else{
            hm.put("status", true);
            cRepo.save(category);
            hm.put("result", category);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getCategory() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result",cRepo.findAll() );
        return new ResponseEntity(hm, HttpStatus.OK);
    }




    public ResponseEntity delete(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        cRepo.deleteById(id);
        hm.put("status", true);
        hm.put("result","İşlem başarılı");
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity updateCate(Category category) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<Category> isCate= Optional.of(cRepo.getReferenceById(category.getId()));
        if(isCate.isPresent()){
            isCate.get().setAd(category.getAd());
            cRepo.save(isCate.get());
            hm.put("status", true);
            hm.put("result","İşlem başarılı");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getByıd(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result",cRepo.findById(id));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
