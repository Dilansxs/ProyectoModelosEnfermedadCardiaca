/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.machinez;


import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import frontend.MenuJFrame;

/**
 *
 * @author toapa
 */
public class MachineZ {

    public static void main(String[] args) {
        FlatMaterialLighterIJTheme.setup();
        MenuJFrame menu = new MenuJFrame();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
         
    }
    
    
}
