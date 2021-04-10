package reverseuml.service;

import reverseuml.model.Argument;
import reverseuml.model.Attribute;
import reverseuml.model.CustomClass;
import reverseuml.model.Method;

import java.util.ArrayList;
import java.util.Stack;

import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.Java8BaseListener;
import antlr.Java8Parser;
import antlr.Java8Parser.FieldModifierContext;
import antlr.Java8Parser.FormalParameterContext;
import antlr.Java8Parser.MethodHeaderContext;
import antlr.Java8Parser.MethodModifierContext;
import antlr.Java8Parser.ClassModifierContext;
import antlr.Java8Parser.NormalClassDeclarationContext;
import lombok.Getter;

public class JavaListener extends Java8BaseListener {
    @Getter
    private ArrayList<CustomClass> classes = new ArrayList<CustomClass>();
    private Stack<CustomClass> stack = new Stack<CustomClass>();

    @Override 
    public void enterClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        CustomClass customClass = new CustomClass();

        NormalClassDeclarationContext classContext = ctx.normalClassDeclaration();
        TerminalNode node = classContext.Identifier();
        customClass.setName(node.getText());

        for (ClassModifierContext modifier : classContext.classModifier()) {
            String modifierName = modifier.getText();

            switch(modifierName) {
                case "public":
                case "private":
                case "protected":
                    customClass.setVisibility(modifierName);
                    break;
                case "static":
                    customClass.setStatic(true);
                    break;
            }
        }

        stack.push(customClass);
    }

    @Override public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) { 
        Attribute field = new Attribute();

        String name = ctx.getChild(ctx.getChildCount() - 2).getText();;
        field.setName(name);

        field.setType(ctx.unannType().getText());

        for (FieldModifierContext modifier : ctx.fieldModifier()) {
            String modifierName = modifier.getText();

            switch(modifierName) {
                case "public":
                case "private":
                case "protected":
                    field.setVisibility(modifierName);
                    break;
                case "static":
                    field.setStatic(true);
                    break;
            }
        }

        stack.peek().addAttribute(field);
    }

    @Override 
    public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        Method method = new Method();
        MethodHeaderContext header = ctx.methodHeader();

        method.setName(header.methodDeclarator().Identifier().getText());
        method.setReturnType(header.result().getText());
       
        if (header.methodDeclarator().formalParameterList() != null) {

            if (header.methodDeclarator().formalParameterList().formalParameters() != null)
                for (FormalParameterContext parameter : header.methodDeclarator().formalParameterList().formalParameters().formalParameter()) {
                    Argument argument = new Argument();
                    
                    argument.setName(parameter.variableDeclaratorId().getText());
                    argument.setType(parameter.unannType().getText());

                    method.addArgument(argument);
                }

            if (header.methodDeclarator().formalParameterList().lastFormalParameter() != null) {
                FormalParameterContext parameter = header.methodDeclarator().formalParameterList().lastFormalParameter().formalParameter();
                
                Argument argument = new Argument();
                    
                argument.setName(parameter.variableDeclaratorId().getText());
                argument.setType(parameter.unannType().getText());

                method.addArgument(argument);
            }
        }    

        for (MethodModifierContext modifier : ctx.methodModifier()) {
            String modifierName = modifier.getText();

            switch(modifierName) {
                case "public":
                case "private":
                case "protected":
                    method.setVisibility(modifierName);
                    break;
                case "static":
                    method.setStatic(true);
                    break;
            }
        }

        stack.peek().addMethod(method);
    }

    @Override 
    public void exitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        classes.add(stack.pop());
    }
}
