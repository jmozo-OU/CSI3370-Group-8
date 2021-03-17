package reverseuml.service;

import reverseuml.model.Class;

import org.springframework.web.multipart.MultipartFile;

public class FileService {
    public String getFileType(MultipartFile file) {
        String[] filenameParts = file.getOriginalFilename().split("\\.");
        return filenameParts[filenameParts.length - 1];
    }

    public Class generateClassFromFile(MultipartFile file) {
        Class customClass = null;
        String fileType = getFileType(file);
            
        switch(fileType) {
            case "java":
                // Send file to java parsing class
                break;
            case "js":
                // Send file to js parsing class
                break;
            default:
                break;
        }

        return customClass;
    }
}
