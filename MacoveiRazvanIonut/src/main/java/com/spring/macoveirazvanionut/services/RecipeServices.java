package com.spring.macoveirazvanionut.services;

import com.spring.macoveirazvanionut.entities.Recipe;
import com.spring.macoveirazvanionut.entities.User;
import com.spring.macoveirazvanionut.repositories.RecipeRepository;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServices {
    @Autowired
    private RecipeRepository recipeRepository;


    public List<Recipe> listAll()
    {
        return (List<Recipe>) recipeRepository.findAll();
    }

    public Recipe get(Integer id){
        Optional<Recipe> result=recipeRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
return null;
    }

    public Collection<Recipe> listAllIncludingCategory()
    {
        return (Collection<Recipe>) recipeRepository.findAllRecipes();
    }

    public void save(Recipe recipe)  {
        recipeRepository.save(recipe);
    }

    public void saveImage(MultipartFile imageFile,String userFolder) throws IOException {

        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(userFolder + imageFile.getOriginalFilename());
        Files.createDirectories(Paths.get(userFolder));

        Files.write(path,bytes);
    }
}
