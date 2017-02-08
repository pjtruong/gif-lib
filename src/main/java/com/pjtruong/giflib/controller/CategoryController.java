package com.pjtruong.giflib.controller;

import com.pjtruong.giflib.data.CategoryRepository;
import com.pjtruong.giflib.data.GifRepository;
import com.pjtruong.giflib.model.Category;
import com.pjtruong.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by pjtruong on 2/7/17.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository catRepository;

    @Autowired
    private GifRepository gifRepository;


    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap)
    {
        List<Category> categories = catRepository.getAllCats();
        modelMap.put("categories", categories);
        return "categories";
    }


    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id,  ModelMap modelMap)
    {
        Category category = catRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);


        return "category";
    }


}
