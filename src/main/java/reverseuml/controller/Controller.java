package reverseuml.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reverseuml.model.Class;
import reverseuml.service.FileService;

@RestController
@RequestMapping("/reverse-uml/v1")
public class Controller {
    @Autowired FileService fileService;

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleIOException(IOException e) {}

    @PostMapping("/single")
    public void generateClassesFromSingleFile(@RequestParam("file") MultipartFile file) {
        
    }

    @PostMapping("/multiple")
    public List<Class> generateClassesFromMultipleFiles(@RequestParam("file") List<MultipartFile> files) throws IOException {
        ArrayList<Class> classes = new ArrayList<>();

        for (MultipartFile file : files) {
            Class customClass = fileService.generateClassFromFile(file);

            if (customClass != null)
                classes.add(customClass);
        }

        return classes;
    }
}
