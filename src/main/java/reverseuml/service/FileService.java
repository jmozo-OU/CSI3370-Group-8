package reverseuml.service;

import reverseuml.model.Class;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.web.multipart.MultipartFile;

import antlr.Java8Lexer;
import antlr.Java8Parser;

public class FileService {
    public String getFileType(MultipartFile file) {
        String[] filenameParts = file.getOriginalFilename().split("\\.");
        return filenameParts[filenameParts.length - 1];
    }

    public Class generateClassFromFile(MultipartFile file) throws IOException {
        Class customClass = null;
        String fileType = getFileType(file);
            
        switch(fileType) {
            case "java":
                Java8Lexer lexer = new Java8Lexer((CharStream) file.getInputStream());
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                Java8Parser parser = new Java8Parser(tokens);
                
                ParseTree tree = parser.compilationUnit();
                ParseTreeWalker walker = new ParseTreeWalker();

                

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
