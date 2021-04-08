package reverseuml.service;

import reverseuml.model.CustomClass;
import st4hidden.org.antlr.runtime.ANTLRStringStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import antlr.Java8Lexer;
import antlr.Java8Parser;

@Service
public class FileService {
    public String getFileType(MultipartFile file) {
        String[] filenameParts = file.getOriginalFilename().split("\\.");
        return filenameParts[filenameParts.length - 1];
    }

    public List<CustomClass> parseFileForLanguage(CharStream stream, Lexer lexer, Parser parser, ParseTreeListener listener) {
        

        return new ArrayList<CustomClass>();
    }

    public List<CustomClass> generateClassesFromFile(MultipartFile file) throws IOException {
        List<CustomClass> customClasses = new ArrayList<CustomClass>();
        String fileType = getFileType(file);
        
        ANTLRInputStream stream = new ANTLRInputStream(file.getInputStream());

        switch(fileType) {
            case "java":
                Java8Lexer lexer = new Java8Lexer(stream);
                
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                Java8Parser parser = new Java8Parser(tokens);
                
                ParseTree tree = parser.compilationUnit();
                ParseTreeWalker walker = new ParseTreeWalker();

                JavaListener listener = new JavaListener();

                walker.walk(listener, tree);

                List<CustomClass> classes = listener.classes;
                
                if (classes.size() > 0)
                    customClasses.add(listener.classes.get(0));

                break;
            case "js":
                // Send file to js parsing class
                break;
            default:
                break;
        }

        return customClasses;
    }
}
