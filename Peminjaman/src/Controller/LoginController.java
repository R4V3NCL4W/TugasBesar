/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Aplikasi;
import Model.Login;
import View.LoginView;
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
public class LoginController implements ActionListener{
    
    Aplikasi model;
    LoginView view;
    
    public LoginController(Aplikasi model){
      this.model = model;
      view = new LoginView();
      view.setVisible(true);
      view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source.equals(view.getBtnMasuk())){
            String username = view.getUsername();
            String password = view.getPassword();
            if (model.loginAnggota(username, password) != null){
                new MenuPetugasController(model);
                view.dispose();
            } else if (model.loginPetugas(username, password) != null){
                new MenuAnggotaController(model);
                view.dispose();
            }
        }
    }
    
}
