package reverseuml.service;

import reverseuml.model.Class;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.Java8BaseListener;
import antlr.Java8Parser;
import antlr.Java8Parser.FieldModifierContext;
import antlr.Java8Parser.ClassModifierContext;
import antlr.Java8Parser.NormalClassDeclarationContext;

public class JavaListener extends Java8BaseListener {
    ArrayList<Class> classes = new ArrayList<Class>();

    Stack<Object> stack = new Stack<Object>();

    @Override public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        Class customClass = new Class();
        NormalClassDeclarationContext classContext = ctx.normalClassDeclaration();

        TerminalNode node = classContext.Identifier();
        List<ClassModifierContext> modifiers = classContext.classModifier();

        customClass.setName(node.getText());
        
        System.out.println("Classname:" + node.getText());
        for (ClassModifierContext modifier : modifiers) {
            System.out.println("Class modifier: " + modifier.getText()); 
        }

    }

    /*
    @Override public void enterClassMemberDeclaration(Java8Parser.ClassMemberDeclarationContext ctx) {
        System.out.println("Class member declaration:" + ctx.getText());

        System.out.println("Field declaration:" + ctx.fieldDeclaration().getText());
    }
    */

    @Override public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) { 
        System.out.println("Field declaration:" + ctx.getText());

        List<FieldModifierContext> modifiers = ctx.fieldModifier();
        FieldModifierContext modifier = modifiers.get(0);

        System.out.println("Field modifier:"+ modifier.getText());

    }
}
