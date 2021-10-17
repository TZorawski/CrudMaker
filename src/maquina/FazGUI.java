package maquina;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class FazGUI {
    private String entidade;
    public FazGUI(String entidade){
        this.entidade= entidade;
    }
    public String criaGui(){
        STRS strs= new STRS();
        String entidadeG= strs.primeiraLetraMaiuscula(entidade);
        List<String> lista = new ArrayList<>();
        List<String> c = new ArrayList<>();
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        lista = manipulaArquivo.abrirArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\entidades\\"+entidadeG+".txt");
        
        String[] primaryKey= lista.get(0).split(";");
        String pkG= strs.primeiraLetraMaiuscula(primaryKey[0]);
        
        String[] segundoCampo = lista.get(1).split(";");
        
//        for (String s : lista) {
//            System.out.println(s);
//        }
        
        c.add("package xxxxxxxx;");
        c.add("public class "+entidadeG+"GUI extends JFrame {");
        
        c.add("ImageIcon iconeCreate;\n" +
"    ImageIcon iconeRetrieve;\n" +
"    ImageIcon iconeUpdate;\n" +
"    ImageIcon iconeDelete;\n" +
"    ImageIcon iconeSave;\n" +
"    ImageIcon iconeCancel;\n" +
"    ImageIcon iconeListar;\n" +
"\n" +
"    JButton btnCreate;\n" +
"    JButton btnRetrieve;\n" +
"    JButton btnUpdate;\n" +
"    JButton btnDelete;\n" +
"    JButton btnSave;\n" +
"    JButton btnCancel;\n" +
"    JButton btnList;");
        
        c.add("");
        
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss = "   JLabel label" + strs.primeiraLetraMaiuscula(aux[0]) + "= new JLabel(\""+ strs.primeiraLetraMaiuscula(aux[0]) +"\");";
            c.add(ss);
        }
        
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss = "   JTextField textField" + strs.primeiraLetraMaiuscula(aux[0]) + "= new JTextField(\""+ aux[2] +"\");";
            c.add(ss);
        }
        
        String ss= "JPanel aviso = new JPanel();\n" +
"    JLabel labelAviso = new JLabel(\"\");\n" +
"    String acao = \"\";//variavel para facilitar insert e update\n" +
"    "+entidadeG+"ControlaLista cl = new "+entidadeG+"ControlaLista();\n" +
"    "+entidadeG+" "+entidade+" = new "+entidadeG+"();\n";
        
        c.add(ss);
        
        ss= "private void atvBotoes(boolean c, boolean r, boolean u, boolean d) {\n" +
"        btnCreate.setEnabled(c);\n" +
"        btnRetrieve.setEnabled(r);\n" +
"        btnUpdate.setEnabled(u);\n" +
"        btnDelete.setEnabled(d);\n" +
"        btnList.setEnabled(r);\n" +
"    }\n";
        
        c.add(ss);
        
        ss= "public void mostrarBotoes(boolean visivel) {\n" +
"        btnCreate.setVisible(visivel);\n" +
"        btnRetrieve.setVisible(visivel);\n" +
"        btnUpdate.setVisible(visivel);\n" +
"        btnDelete.setVisible(visivel);\n" +
"        btnList.setVisible(visivel);\n" +
"        btnSave.setVisible(!visivel);\n" +
"        btnCancel.setVisible(!visivel);\n" +
"    }\n";
        
        c.add(ss);
        
        ss= "   private void habilitarAtributos(";
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            ss= ss + " boolean " + aux[0];
            if (i!=lista.size()-1) {
                ss= ss+",";
            }
        }
        
        
        ss= ss+"){\n"
                + "if ("+primaryKey[0]+"){\n"
                + "textField"+pkG+".requestFocus();\n"
                + "textField"+pkG+".selectAll();\n}\n"
                + "textField"+pkG+".setEnabled("+primaryKey[0]+");\n"
                + "textField"+pkG+".setEditable("+primaryKey[0]+");\n";
        
        for (int i = 1; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            ss= ss + "textField"+strs.primeiraLetraMaiuscula(aux[0])+".setEditable("+aux[0]+");\n";
        }
        
        ss= ss+"}\n";
        
        
        c.add(ss);
        
        ss= "public void zerarAtributos() {\n";
        
        for (int i = 1; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss2 = "textField"+strs.primeiraLetraMaiuscula(aux[0])+".setText(\"\");\n";
            ss= ss+ ss2;
        }
        
        ss= ss+ "}\n";
        
        c.add(ss);
        
        ss="";
        
        
        
        
        
        //**************************
        //AGORA COMEÇA A PARTE DO PUBLIC GUI(){}
        //**************************
        
        
        ss= "public "+entidadeG+"GUI() {\n" +
"\n" +
"        //carregar imagens para os botões\n" +
"        try {\n" +
"            iconeCreate = new ImageIcon(getClass().getResource(\"/icones/create.png\"));\n" +
"            iconeRetrieve = new ImageIcon(getClass().getResource(\"/icones/retrieve.png\"));\n" +
"            iconeUpdate = new ImageIcon(getClass().getResource(\"/icones/update.png\"));\n" +
"            iconeDelete = new ImageIcon(getClass().getResource(\"/icones/delete.png\"));\n" +
"            iconeSave = new ImageIcon(getClass().getResource(\"/icones/save.png\"));\n" +
"            iconeCancel = new ImageIcon(getClass().getResource(\"/icones/cancel.png\"));\n" +
"            iconeListar = new ImageIcon(getClass().getResource(\"/icones/list.png\"));\n" +
"\n" +
"            btnCreate = new JButton(iconeCreate);\n" +
"            btnRetrieve = new JButton(iconeRetrieve);\n" +
"            btnUpdate = new JButton(iconeUpdate);\n" +
"            btnDelete = new JButton(iconeDelete);\n" +
"            btnSave = new JButton(iconeSave);\n" +
"            btnCancel = new JButton(iconeCancel);\n" +
"            btnList = new JButton(iconeListar);\n" +
"        } catch (Exception e) {\n" +
"            System.out.println(\"Não achou alguma imagem para os botões, confira o caminho e se existe a package icones\");\n" +
"        }\n" +
"\n" +
"        setTitle(\"Cadastro de "+entidadeG+"\");\n" +
"        try {\n" +
"            File arq = new File(\""+entidadeG+".dat\"); //tenta abrir o arquivo\n" +
"            if (arq.exists()) { //se o arquivo já existe, abre e lê os dados\n" +
"                cl.desSerializaLista(\""+entidadeG+".dat\");\n" +
"            }\n" +
"        } catch (Exception e) {\n" +
"            System.out.println(\"arquivo não encontrado\");\n" +
"        }\n" +
"\n" +
"        setSize(800, 600);//tamanho da janela\n" +
"        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado\n" +
"        setBackground(Color.CYAN);//cor do fundo da janela\n" +
"        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes\n" +
"\n" +
"        atvBotoes(false, true, false, false);\n"+
"        habilitarAtributos(true,";
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " false";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        ss= ss + "); \n" +
"        btnCreate.setToolTipText(\"Inserir novo registro\");\n" +
"        btnRetrieve.setToolTipText(\"Pesquisar por chave\");\n" +
"        btnUpdate.setToolTipText(\"Alterar\");\n" +
"        btnDelete.setToolTipText(\"Excluir\");\n" +
"        btnList.setToolTipText(\"Listar todos\");\n" +
"        btnSave.setToolTipText(\"Salvar\");\n" +
"        btnCancel.setToolTipText(\"Cancelar\");\n" +
"        JToolBar Toolbar1 = new JToolBar();\n" +
"        Toolbar1.add(label"+pkG+");\n" +
"        Toolbar1.add(textField"+pkG+");\n" +
"        Toolbar1.add(btnRetrieve);\n" +
"        Toolbar1.add(btnCreate);\n" +
"        Toolbar1.add(btnUpdate);\n" +
"        Toolbar1.add(btnDelete);\n" +
"        Toolbar1.add(btnSave);\n" +
"        Toolbar1.add(btnCancel);\n" +
"        Toolbar1.add(btnList);\n" +
"        btnSave.setVisible(false);\n" +
"        btnCancel.setVisible(false);  //atributos\n" +
"        JPanel centro = new JPanel();\n" +
"        centro.setLayout(new GridLayout("+lista.size()+", 2));\n";
        
        
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss2 = "centro.add(label"+strs.primeiraLetraMaiuscula(aux[0])+");\n";
            String ss3 = "centro.add(textField"+strs.primeiraLetraMaiuscula(aux[0])+");\n";
            ss= ss + ss2 + ss3;
        }
        
        
        ss= ss + "aviso.add(labelAviso);\n" +
"        aviso.setBackground(Color.yellow);\n" +
"        cp.add(Toolbar1, BorderLayout.NORTH);\n" +
"        cp.add(centro, BorderLayout.CENTER);\n" +
"        cp.add(aviso, BorderLayout.SOUTH);\n" +
"        textField"+pkG+".requestFocus();\n" +
"        textField"+pkG+".selectAll();\n" +
"        textField"+pkG+".setBackground(Color.GREEN);\n" +
"        labelAviso.setText(\"Digite uma placa e clic [Pesquisar]\");\n";
        
        
        c.add(ss);
        ss= "";
        
        //**************************
        //LISTENERS
        //**************************
        
        //btnRetrieve
        ss= "btnRetrieve.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"                "+entidade+" = new "+entidadeG+"();\n" +
"                "+entidade+".set"+pkG+"(textField"+pkG+".getText());\n" +
"                textField"+pkG+".setText(textField"+pkG+".getText().trim());//caso tenham sido digitados espaços\n" +
"                if (textField"+pkG+".getText().equals(\"\")) {\n" +
"                    JOptionPane.showMessageDialog(null, \"Deve ser informado um valor para esse campo\");\n" +
"                    textField"+pkG+".requestFocus();\n" +
"                    textField"+pkG+".selectAll();\n" +
"                } else {\n" +
"                    "+entidade+" = cl.retrieve("+entidade+");\n" +
"                    if ("+entidade+" != null) { //se encontrou na lista\n";
        
        
        for (int i = 1; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss2 = "";
            if (aux[1].equals("Date")) {
                ss2 = "textField"+strs.primeiraLetraMaiuscula(aux[0])+".setText(String.valueOf("+entidade+".get"+strs.primeiraLetraMaiuscula(aux[0])+"()));\n";
            } if (aux[1].equals("int") ){
                ss2= "textField"+strs.primeiraLetraMaiuscula(aux[0])+".setText(String.valueOf("+entidade+".get"+strs.primeiraLetraMaiuscula(aux[0])+"()));\n";
            }else{
                ss2= "textField"+strs.primeiraLetraMaiuscula(aux[0])+".setText("+entidade+".get"+strs.primeiraLetraMaiuscula(aux[0])+"());\n";
            }
            ss= ss + ss2;
        }
        
        ss= ss + "                        atvBotoes(false, true, true, true);\n" +
"                        habilitarAtributos(true,";
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " false";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        ss= ss + ");\n" +
"                        labelAviso.setText(\"Encontrou - clic [Pesquisar], [Alterar] ou [Excluir]\");\n" +
"                        acao = \"encontrou\";\n" +
"                    } else {\n" +
"                        atvBotoes(true, true, false, false);\n" +
"                        zerarAtributos();\n" +
"                        labelAviso.setText(\"Não cadastrado - clic [Inserir] ou digite outra placa [Pesquisar]\");\n" +
"                    }\n" +
"                }\n" +
"            }\n" +
"        });\n";
        
        c.add(ss);
        ss= "";
        
        
        //btnCreate
        
        ss= "btnCreate.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"                zerarAtributos();\n" +
"                habilitarAtributos(false,";
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " true";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        
        
        ss= ss + ");\n" +
"                textField"+strs.primeiraLetraMaiuscula(segundoCampo[0])+".requestFocus();\n" +
"                mostrarBotoes(false);\n" +
"                labelAviso.setText(\"Preencha os campos e clic [Salvar] ou clic [Cancelar]\");\n" +
"                acao = \"insert\";\n" +
"            }\n" +
"        });";
        
        c.add(ss);
        ss= "";
        
        
        //btnSave
        
        ss= "btnSave.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"                if (acao.equals(\"insert\")) {\n" +
"                    "+entidade+" = new "+entidadeG+"();\n";
        
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss2= "";
            if (aux[1].equals("Date")) {
                ss2= entidade + ".set"+strs.primeiraLetraMaiuscula(aux[0])+"(Date.valueOf(textField"+strs.primeiraLetraMaiuscula(aux[0])+".getText()));\n";
            } if (aux[1].equals("int") ){
                ss2= entidade + ".set"+strs.primeiraLetraMaiuscula(aux[0])+"(Integer.valueOf(textField"+strs.primeiraLetraMaiuscula(aux[0])+".getText()));\n";
            }else{
                ss2= entidade + ".set"+strs.primeiraLetraMaiuscula(aux[0])+"(textField"+strs.primeiraLetraMaiuscula(aux[0])+".getText());\n";
            }
            ss= ss + ss2;
        }
        
        
        
        ss= ss + "                    cl.inserir("+entidade+");\n" +
"                    habilitarAtributos(true,";
        
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " false";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        ss= ss + ");\n" +
"                    mostrarBotoes(true);\n" +
"                    atvBotoes(false, true, false, false);\n" +
"                    labelAviso.setText(\"Registro inserido...\");\n" +
"                } else {  //acao = update\n" +
"                    "+entidadeG+" original = "+entidade+";\n" +
"                    "+entidade+".set"+pkG+"(textField"+pkG+".getText());\n";
        
        
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            String ss2 = "";
            if (aux[1].equals("Date")) {
                ss2= entidade + ".set"+strs.primeiraLetraMaiuscula(aux[0])+"(Date.valueOf(textField"+strs.primeiraLetraMaiuscula(aux[0])+".getText()));\n";
            }if (aux[1].equals("int") ){
                ss2= entidade + ".set"+strs.primeiraLetraMaiuscula(aux[0])+"(Integer.valueOf(textField"+strs.primeiraLetraMaiuscula(aux[0])+".getText()));\n";
            }else{
                ss2= entidade + ".set"+strs.primeiraLetraMaiuscula(aux[0])+"(textField"+strs.primeiraLetraMaiuscula(aux[0])+".getText());\n";
            }
            ss= ss + ss2;
        }
        
        ss= ss + "cl.atualizar(original, "+entidade+");\n" +
"                    mostrarBotoes(true);\n" +
"                    habilitarAtributos(true,";
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " false";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        ss= ss + ");\n" +
"                    atvBotoes(false, true, false, false);\n" +
"                    labelAviso.setText(\"Registro atualizado...\");\n" +
"                } \n" +
"            } \n" +
"        });";
        
        c.add(ss);
        ss= "";
        
        
        //btnCancel
        
        ss= "btnCancel.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"                zerarAtributos();\n" +
"                atvBotoes(false, true, false, false);\n" +
"                habilitarAtributos(true,";
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " false";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        ss= ss +");\n" +
"                mostrarBotoes(true);\n" +
"            }\n" +
"        });\n";
        
        c.add(ss);
        ss= "";
        
        
        //btnList
        
        ss= "btnList.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"\n" +
"                acao = \"list\";\n" +
"                "+ entidadeG +"GUIListagem " + entidade + "guiListagem = new " + entidadeG + "GUIListagem(cl.getLista(), getBounds().x, getBounds().y);\n" +
"            }\n" +
"        });\n";
        
        c.add(ss);
        ss= "";
        
        
        //btnUpdate
        
        ss= "btnUpdate.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"                acao = \"update\";\n" +
"                mostrarBotoes(false);\n" +
"                habilitarAtributos(false,";
        
        for (int i = 1; i < lista.size(); i++) {
            ss= ss + " true";
            if (i!=lista.size()-1) {
                ss= ss + ",";
            }
        }
        
        ss= ss +");\n" +
"            }\n" +
"        });\n";
        
        c.add(ss);
        ss= "";
        
        
        //btnDelete
        
        ss= "btnDelete.addActionListener(new ActionListener() {\n" +
"            public void actionPerformed(java.awt.event.ActionEvent e) {\n" +
"                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,\n" +
"                        \"Confirma a exclusão do registro <ID = \" + "+entidade+".get"+pkG+"() + \">?\", \"Confirm\",\n" +
"                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {\n" +
"                    labelAviso.setText(\"Registro excluído...\");\n" +
"                    cl.excluir("+entidade+");\n" +
"                    zerarAtributos();\n" +
"                    textField"+pkG+".requestFocus();\n" +
"                    textField"+pkG+".selectAll();\n" +
"                }\n" +
"            }\n" +
"        });";
        
        c.add(ss);
        ss= "";
        
        
        //textFields Atributos
        
        ss= "textField"+pkG+".addFocusListener(new FocusListener() {\n" +
"            @Override\n" +
"            public void focusGained(FocusEvent fe) {\n" +
"                textField"+pkG+".setBackground(Color.GREEN);\n" +
"                if (acao != \"encontrou\") {\n" +
"                    labelAviso.setText(\"Digite uma "+entidadeG+" e clic [Pesquisar]\");\n" +
"                }\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void focusLost(FocusEvent fe) {\n" +
"                textField"+pkG+".setBackground(Color.white);\n" +
"            }\n" +
"        });";
        
        
        for (int i = 0; i < lista.size(); i++) {
            String[] aux = lista.get(i).split(";");
            ss= ss + "        textField"+strs.primeiraLetraMaiuscula(aux[0])+".addFocusListener(new FocusListener() { //ao receber o foco, fica verde\n" +
"            @Override\n" +
"            public void focusGained(FocusEvent fe) {\n" +
"                textField"+strs.primeiraLetraMaiuscula(aux[0])+".setBackground(Color.GREEN);\n" +
"            }\n" +
"\n" +
"            @Override\n" +
"            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco\n" +
"                textField"+strs.primeiraLetraMaiuscula(aux[0])+".setBackground(Color.white);\n" +
"            }\n" +
"        });\n";
            c.add(ss);
            ss= "";
        }
        
        ss= "setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //antes de sair do sistema, grava os dados da lista em disco\n" +
"        addWindowListener(new WindowAdapter() {\n" +
"            public void windowClosing(WindowEvent e) {\n" +
"                //antes de sair, salvar a lista em disco\n" +
"                cl.serializaLista(\""+entidadeG+".dat\");\n" +
"                // Sai do sistema  \n" +
"                System.exit(0);\n" +
"            }\n" +
"        });\n" +
"\n" +
"        setVisible(true);//faz a janela ficar visível\n" +
"        textField"+pkG+".requestFocus();\n}\n}";
        
        
        c.add(ss);
        
        
        //manipulaArquivo.salvarArquivo("/home/todos/alunos/cm/a1511556/Área de Trabalho/maquina/src/maquina/finished/"+entidadeG+"Gui.java", c);
        manipulaArquivo.salvarArquivo("C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"Gui.java", c);
        return "C:\\Users\\thais\\Documents\\LP2\\maquina\\src\\maquina\\finished\\"+entidadeG+"Gui.java";
        
    }
}
