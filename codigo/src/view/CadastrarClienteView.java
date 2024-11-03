package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.*;
import model.*;

public class CadastrarClienteView extends JFrame {
    public CadastrarClienteView() {
        setTitle("Cadastrar Cliente");
        setSize(300, 150);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 25);
        add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 10, 160, 25);
        add(txtNome);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 50, 100, 25);
        add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                Cliente cliente = ClienteController.cadastrarCliente(nome);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! ID: " + cliente.getIdCliente());
                dispose();
            }
        });

        setVisible(true);
    }
}
