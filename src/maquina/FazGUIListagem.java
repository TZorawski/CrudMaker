package maquina;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class FazGUIListagem {
    private String entidade;
    
    public FazGUIListagem(String entidade){
        this.entidade= entidade;
    }
    
    public String criaGuiListagem(){
        STRS strs= new STRS();
        String entidadeG= strs.primeiraLetraMaiuscula(entidade);
        List<String> lista = new ArrayList<>();
        List<String> c = new ArrayList<>();
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        lista = manipulaArquivo.abrirArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\entidades\\"+entidadeG+".txt");
        
        String ss= "package xxxxxxxxx;\n"
                + "public class "+entidadeG+"GUIListagem extends JDialog {\n" +
"\n" +
"    JPanel painelTa = new JPanel();\n" +
"    ScrollPane scroll = new ScrollPane();\n" +
"    JTextArea ta = new JTextArea();\n" +
"\n" +
"    public "+ entidade +"GUIListagem(List<"+entidadeG+"> texto,int posX,int posY) {\n" +
"        setTitle(\"Listagem\");\n" +
"        setSize(500, 180);//tamanho da janela\n" +
"        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memória a classe\n" +
"        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado\n" +
"        setBackground(Color.CYAN);//cor do fundo da janela\n" +
"        setModal(true);\n" +
"        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes\n" +
"\n" +
"        JToolBar toolBar = new JToolBar();\n" +
"\n" +
"        ta.setText(\"\");\n" +
"        for (int i = 0; i < texto.size(); i++) {\n" +
"            ta.append(texto.get(i).toString()+ System.lineSeparator());\n" +
"        }\n" +
"\n" +
"        scroll.add(ta);\n" +
"        painelTa.add(scroll);\n" +
"\n" +
"        cp.add(toolBar, BorderLayout.NORTH);\n" +
"        cp.add(scroll, BorderLayout.CENTER);\n" +
"\n" +
"\n" +
"        setLocation(posX+20, posY+20);\n" +
"        setVisible(true);//faz a janela ficar visível        \n" +
"    }\n" +
"}";
        c.add(ss);
        
        //manipulaArquivo.salvarArquivo("/home/todos/alunos/cm/a1511556/Área de Trabalho/maquina/src/maquina/finished/"+entidadeG+"GUIListagem.java", c);
        manipulaArquivo.salvarArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"GUIListagem.java", c);
        return "C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"GUIListagem.java";
    }
}
