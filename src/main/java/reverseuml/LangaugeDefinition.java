package reverseuml;

public class LangaugeDefinition {
    private String languageName;
    private String languageFileExtension;
    private String classToken;
    private String attributeToken;
    private String methodToken;

    public LangaugeDefinition(String langName, String languageFileExtension, String classToken, String attribToken, String methodToken){
        this.languageName = langName;
        this.languageFileExtension = languageFileExtension;
        this.classToken = classToken;
        this.attributeToken = attribToken;
        this.methodToken = methodToken;
    }

    public String getLanguageName(){
        return this.languageName;
    }

    public void setLanguageName(String langName){
        this.languageName = langName;
    }

    public String getLanguageFileExtension(){
        return this.languageFileExtension;
    }

    public void setLanguageFileExtension(String languageFileExtension){
        this.languageFileExtension = languageFileExtension;
    }

    public String getClassToken(){
        return this.classToken;
    }

    public void setClassToken(String classToken){
        this.classToken = classToken;
    }

    public String getAttributeToken(){
        return this.attributeToken;
    }

    public void setAttributeToken(String attributeToken){
        this.attributeToken = attributeToken;
    }

    public String getMethodToken(){
        return this.methodToken;
    }

    public void setMethodToken(String methodToken){
        this.methodToken = methodToken;
    }
}
