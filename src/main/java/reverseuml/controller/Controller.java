package reverseuml.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reverseuml.model.CustomClass;
import reverseuml.service.FileService;

@CrossOrigin
@RestController
@RequestMapping("/reverse-uml/v1")
public class Controller {
    @Autowired FileService fileService;

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleIOException(IOException e) {}

    @PostMapping("/single")
    public List<CustomClass> generateClassesFromSingleFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.generateClassesFromFile(file);
    }

    @PostMapping("/multiple")
    public List<CustomClass> generateClassesFromMultipleFiles(@RequestParam("files") List<MultipartFile> files) throws IOException {
        ArrayList<CustomClass> classes = new ArrayList<>();

        for (MultipartFile file : files) {
            List<CustomClass> customClasses = fileService.generateClassesFromFile(file);

            classes.addAll(customClasses);
        }

        return classes;
    }
}
