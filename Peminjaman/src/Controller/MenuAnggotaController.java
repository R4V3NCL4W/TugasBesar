/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import View.MenuAnggotaView;
import View.MenuPetugasView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Brian
 */
public class MenuAnggotaController implements ActionListener{
    
    Aplikasi model;
    MenuAnggotaView view;
    
    public MenuAnggotaController(Aplikasi model){
      this.model = model;
      view = new MenuAnggotaView();
      view.setVisible(true);
      view.addListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source.equals(view.getBtnDataBarang())){
            new DataBarangPinjamanAnggotaController(model);
            view.dispose();
        }else if (source.equals(view.getBtnDataPeminjaman()){
            new DataPeminjamanAnggotaController(model);
            view.dispose();
        }
    }
    
}
