package com.works.securityjwt.restcontrollers;


import com.works.securityjwt.entities.Product;
import com.works.securityjwt.services.ProductService;
import org.hibernate.annotations.Loader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService pService;

    public ProductRestController(ProductService pService) {
        this.pService = pService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product){
        return pService.save(product);
    }

    @GetMapping("/getpro")
    public ResponseEntity getpro(){
        return pService.getPro();
    }

    @GetMapping("/getproid")
    public ResponseEntity getProByid(@RequestParam Long id){
         return  pService.getByid(id);
    }

    @GetMapping("/deletepro")
    public ResponseEntity deletePro(@RequestParam Long id){
        return  pService.deletePro(id);
    }

    @PostMapping("/update")
    public ResponseEntity updatePro(@RequestBody Product product){
        return pService.updatePro(product);
    }

    /* Kategori idsi ile beraber Productları getiren */
    @GetMapping("/getcatepro")
    public ResponseEntity getCatPro(@RequestParam Long id){
        return  pService.getCatPro(id);
    }

    /*Kategoriye göre product detayı getiren*/

    @GetMapping("/getbycatıd")
    public ResponseEntity getByCatId(@RequestParam Long id){
        return  pService.getByCatId(id);
    }

    @GetMapping("/getuser")
    public ResponseEntity getUser(@RequestParam String email){
        return  pService.getUser(email);
    }
}
