package maquina;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class FazMain {
    private String entidade;
    
    public FazMain(String entidade){
        this.entidade= entidade;
    }
    
    public String criaMain(){
        STRS strs= new STRS();
        String entidadeG= strs.primeiraLetraMaiuscula(entidade);
        List<String> lista = new ArrayList<>();
        List<String> c = new ArrayList<>();
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        lista = manipulaArquivo.abrirArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\entidades\\"+entidadeG+".txt");
        
        String ss= "package xxxxxxxxxx;\n" +
"\n" +
"public class "+entidadeG+"Main {\n" +
"    public static void main(String[] args) {"
                + entidadeG + "GUI " + entidade + "GUI = new " + entidadeG + "GUI ();"
                + "}\n" +
"}\n" +
"\n" +
"";
        c.add(ss);
        
        //manipulaArquivo.salvarArquivo("/home/todos/alunos/cm/a1511556/Área de Trabalho/maquina/src/maquina/finished/"+entidadeG+"Main.java", c);
        manipulaArquivo.salvarArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\" + entidadeG+"Main.java", c);
        return "C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"Main.java";
    }
}
