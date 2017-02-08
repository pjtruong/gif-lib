package com.pjtruong.giflib.data;

import com.pjtruong.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by pjtruong on 2/7/17.
 */

@Component
public class CategoryRepository {


    private static final List<Category> ALL_CATS = Arrays.asList(
            new Category(1, "Funny"),
            new Category(2, "Crazy"),
            new Category(3, "Stupid")

    );

    public Category findById(int id)
    {
        for(Category cat : ALL_CATS)
        {
            if(cat.getId() == (id))
            {
                return cat;
            }
        }

        return null;
    }



    public List<Category> getAllCats()
    {

        return ALL_CATS;
    }



}
