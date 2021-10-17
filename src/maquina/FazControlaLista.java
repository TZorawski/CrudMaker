package maquina;

import java.util.ArrayList;
import java.util.List;
import maquina.STRS;

/**
 *
 * @author thais
 */
public class FazControlaLista {
    private String entidade;

    public FazControlaLista(String entidade) {
        this.entidade = entidade;
    }

    public String criaClasseControlaLista() {
        STRS strs= new STRS();
        String entidadeG= strs.primeiraLetraMaiuscula(entidade);
        List<String> lista = new ArrayList<>();
        List<String> c = new ArrayList<>();
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        String ss= new String();
        String auxChave= new String();
        
        lista = manipulaArquivo.abrirArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\entidades\\"+entidadeG+".txt");
//        for (String s : lista) {
//            System.out.println(s);
//        }
        
        c.add("package xxxxxxxx;");
        c.add("public class "+entidadeG+"ControlaLista implements java.io.Serializable {");
        
        String[] aux = lista.get(0).split(";");
        
        c.add("private List<"+entidadeG+"> lista= new ArrayList<"+entidadeG+">();");
        
        c.add("public void inserir("+entidadeG+" "+entidade+") {\n lista.add("+entidade+");\n }");
        ss= "";
        
        ss= "public "+entidadeG+" retrieve("+entidadeG+" "+entidade+") {\n" +
"        if (lista.size() > 0) {\n" +
"            for (int i = 0; i < lista.size(); i++) {\n" +
"                String chaveNaLista = lista.get(i).get" + strs.primeiraLetraMaiuscula(aux[0]) + "();\n" +
"                String chaveProcurada = "+entidade+".get" + strs.primeiraLetraMaiuscula(aux[0]) + "();\n";
        if (aux[1].equals("String")) {
            auxChave = "if (chaveNaLista.equals(chaveProcurada)) {\n";
        } else {
            auxChave= "  if (chaveNaLista == chaveProcurada) {\n";
        }
        
        
        ss= ss + auxChave +
"                    return lista.get(i);\n" +
"                }\n" +
"            }\n" +
"        }\n" +
"        return null;//não achou na lista\n" +
"        }";
        
        c.add(ss);
        
        c.add("public void atualizar("+entidadeG+" "+entidade+"Procurado, "+entidadeG+" "+entidade+"Alterado) {\n" +
"        lista.set(lista.indexOf("+entidade+"Procurado), "+entidade+"Alterado);\n" +
"    }");
        
        c.add("public void excluir("+entidadeG+" "+entidade+") {\n" +
"        lista.remove("+entidade+");\n" +
"    }");
        
        c.add("public void listarTodos() {\n" +
"        if (lista.size() == 0) {\n" +
"            System.out.println(\"Lista vazia\");\n" +
"        } else {\n"+
"            for  (int i= 0; i<lista.size(); i++){\n   "+
"                "+entidadeG+" "+entidade+"= lista.get(i);\n"+
"                System.out.println( i + "+entidade+".toString());\n}\n}\n}");
        
        
        c.add("public void desSerializaLista(String arquivo) {\n" +
"        FileInputStream arqLeitura = null;\n" +
"        ObjectInputStream in = null;\n" +
"        lista.clear();\n" +
"        try {\n" +
"            //arquivo onde estao os dados serializados\n" +
"            arqLeitura = new FileInputStream(arquivo);\n" +
"\n" +
"            //objeto que vai ler os dados do arquivo\n" +
"            in = new ObjectInputStream(arqLeitura);\n" +
"\n" +
"            //recupera os dados\n" +
"            lista = (ArrayList<"+entidadeG+">) in.readObject();\n" +
"\n" +
"        } catch (ClassNotFoundException ex) {\n" +
"            System.out.println(\"erro 1: \" + ex);\n" +
"        } catch (IOException ex) {\n" +
"            System.out.println(\"erro 2: \" + ex);\n" +
"        } finally {\n" +
"            try {\n" +
"                arqLeitura.close();\n" +
"                in.close();\n" +
"            } catch (IOException ex) {\n" +
"                System.out.println(\"erro 3: \" + ex);\n" +
"            }\n" +
"        }\n" +
"\n" +
"    }");
        
        c.add("public void serializaLista(String arquivo) {\n" +
"\n" +
"        FileOutputStream arq = null;\n" +
"        ObjectOutputStream out = null;\n" +
"        try {\n" +
"            //arquivo no qual os dados vao ser gravados\n" +
"            arq = new FileOutputStream(arquivo);\n" +
"\n" +
"            //objeto que vai escrever os dados\n" +
"            out = new ObjectOutputStream(arq);\n" +
"            out.writeObject(lista);\n" +
"        } catch (IOException ex) {\n" +
"            System.out.println(\"erro: \" + ex);\n" +
"        } finally {\n" +
"            try {\n" +
"                arq.close();\n" +
"                out.close();\n" +
"            } catch (IOException ex) {\n" +
"            }\n" +
"        }\n" +
"    }");

        c.add("public List<"+entidadeG+"> getLista() {\n" +
"        return lista;\n" +
"    }");
        
        c.add("}");
        
        //manipulaArquivo.salvarArquivo("/home/todos/alunos/cm/a1511556/Área de Trabalho/maquina/src/maquina/finished/"+entidadeG+"ControlaLista.java", c);
        manipulaArquivo.salvarArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"ControlaLista.java", c);
        return "C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"ControlaLista.java";
    }
}
