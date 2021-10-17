package maquina;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class FazClasseEntidade {

    private String entidade;

    public FazClasseEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String criaClasseEntidade() {
        List<String> lista = new ArrayList<>();
        List<String> c = new ArrayList<>();
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        STRS strs= new STRS();
        String entidadeG= strs.primeiraLetraMaiuscula(entidade);
        
        
        lista = manipulaArquivo.abrirArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\entidades\\" + entidadeG + ".txt");
//        for (String s : lista) {
//            System.out.println(s);
//        }

        c.add(
                "package xxxxxxxx;");
        c.add(
                "public class " + entidadeG + " implements java.io.Serializable {");
        for (int i = 0;
                i < lista.size();
                i++) {
            String[] aux = lista.get(i).split(";");
            String ss = "private " + aux[1] + " " + aux[0] + ";";
            c.add(ss);
        }

        c.add(
                "");
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss = "public void set" + strs.primeiraLetraMaiuscula(aux[0]) + "(" + aux[1]
                    + " " + aux[0] + "){\n" + "this." + aux[0] + "="
                    + aux[0] + ";\n}\n";
            c.add(ss);
        }

        c.add(
                "");
//        for (String s : c) {
//            System.out.println(s);
//        }

        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss = "public " + aux[1] + " get" + strs.primeiraLetraMaiuscula(aux[0]) + "(){\n" + "return this." + aux[0] + ";\n}\n";
            c.add(ss);
        }

        String substring = "";
        substring = substring + "@Override\n"
                + "    public String toString() {\n"
                + "        return \"\"\n";
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            substring = substring + "+ \" - \" + " + aux[0];
        }
        substring += ";\n}";

        
        c.add(substring);
        
        c.add(
                "}");
        
        manipulaArquivo.salvarArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\" + entidadeG + ".java", c);
        return "C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\" + entidade + ".java";
    }
    
    
}


