/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina;

/**
 *
 * @author thais
 */
public class ExecuteAQUI {
    public static void main(String[] args) {
        FazClasseEntidade fazendo1 = new FazClasseEntidade("perfil");
        FazControlaLista fazendo2 = new FazControlaLista("perfil");
        FazGUI fazendo3 = new FazGUI("perfil");
        FazGUIListagem fazendo4 = new FazGUIListagem("perfil");
        FazMain fazendo5 = new FazMain("perfil");
        
        fazendo1.criaClasseEntidade();
        fazendo2.criaClasseControlaLista();
        fazendo3.criaGui();
        fazendo4.criaGuiListagem();
        fazendo5.criaMain();
        
    }
}

class STRS {

    public String primeiraLetraMaiuscula(String s) {
        String plmaiuscula = s.substring(0, 1).toUpperCase() + s.substring(1);
        return plmaiuscula;
    }
}