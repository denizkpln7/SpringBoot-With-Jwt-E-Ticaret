package com.works.securityjwt.restcontrollers;


import com.works.securityjwt.entities.Category;
import com.works.securityjwt.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    final CategoryService cService;

    public CategoryRestController(CategoryService cService) {
        this.cService = cService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category){
        return  cService.save(category);
    }

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return  cService.getCategory();
    }

    @GetMapping("/getbyid")
    public ResponseEntity getByid(@RequestParam Long id){
        return  cService.getByıd(id);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Category category){
        return  cService.updateCate(category);
    }

    @GetMapping("/delete")
    public ResponseEntity deleteCate(@RequestParam Long id){
        return  cService.delete(id);
    }

}
