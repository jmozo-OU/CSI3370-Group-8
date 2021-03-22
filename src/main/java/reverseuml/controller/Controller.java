package reverseuml.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reverseuml.model.Class;
import reverseuml.service.FileService;

@RestController
@RequestMapping("/reverse-uml/v1")
public class Controller {
    @Autowired FileService fileService;

    @PostMapping("/single")
    public void generateClassesFromSingleFile(@RequestParam("file") MultipartFile file) {
        
    }

    @PostMapping("/multiple")
    public List<Class> generateClassesFromMultipleFiles(@RequestParam("file") List<MultipartFile> files) {
        ArrayList<Class> classes = new ArrayList<>();

        files.forEach(file -> {
            Class customClass = fileService.generateClassFromFile(file);

            if (customClass != null)
                classes.add(customClass);
        });

        return classes;
    }
}
