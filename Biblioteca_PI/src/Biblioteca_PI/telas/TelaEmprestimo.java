package Biblioteca_PI.telas;

import Biblioteca_PI.model.Emprestimo;
import Biblioteca_PI.model.Listagem;
import Biblioteca_PI.model.Livros;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaEmprestimo extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> sorter;
    private DefaultTableModel tableModel;
    List<Emprestimo> listaEmprestimo = Listagem.ListarEmprestimo();

    public TelaEmprestimo() {
        initComponents();
        tableModel = (DefaultTableModel) tblEmprestimo.getModel();
        criarSorter();
        atualizarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraMenu = new javax.swing.JPanel();
        txtBuscarEmprestimo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        logoBiblioteca = new javax.swing.JLabel();
        btnEmprestarLivro = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmprestimo = new javax.swing.JTable();
        BarraRodape = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelCelular = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empréstimo");
        setPreferredSize(new java.awt.Dimension(800, 440));

        BarraMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/loupe.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        logoBiblioteca.setFont(new java.awt.Font("Swis721 Hv BT", 0, 12)); // NOI18N
        logoBiblioteca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/booksMenu.png"))); // NOI18N
        logoBiblioteca.setText("Biblioteca Virtual ");
        logoBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoBibliotecaMouseClicked(evt);
            }
        });

        btnEmprestarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/bookRodape.png"))); // NOI18N
        btnEmprestarLivro.setText("Emprestar Livro");
        btnEmprestarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestarLivroActionPerformed(evt);
            }
        });

        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/guardar.png"))); // NOI18N
        btnDevolver.setText("Devolver Livro");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraMenuLayout = new javax.swing.GroupLayout(BarraMenu);
        BarraMenu.setLayout(BarraMenuLayout);
        BarraMenuLayout.setHorizontalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoBiblioteca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(txtBuscarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmprestarLivro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDevolver)
                .addContainerGap())
        );
        BarraMenuLayout.setVerticalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(logoBiblioteca)
                    .addComponent(btnEmprestarLivro)
                    .addComponent(btnDevolver))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        txtBuscarEmprestimo.getAccessibleContext().setAccessibleName("txtBuscarLivro");
        txtBuscarEmprestimo.getAccessibleContext().setAccessibleDescription("Digite o nome do Livro ou Cliente em minúsculo");
        btnBuscar.getAccessibleContext().setAccessibleDescription("Fazer a busca dentro da tabela/lista de empréstimo");
        btnEmprestarLivro.getAccessibleContext().setAccessibleDescription("Fazer o cadastro de empréstimo");

        tblEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Cliente", "Data", "Devolvido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmprestimo);

        BarraRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BarraRodape.setPreferredSize(new java.awt.Dimension(0, 40));

        jLabel2.setText("Contatos:");

        labelCelular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/whatsapp.png"))); // NOI18N
        labelCelular.setText("(21) 98765-4321");
        labelCelular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCelularMouseClicked(evt);
            }
        });

        labelEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/message.png"))); // NOI18N
        labelEmail.setText("biblioteca@hotmail.com");
        labelEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEmailMouseClicked(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/back.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/lixeira.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraRodapeLayout = new javax.swing.GroupLayout(BarraRodape);
        BarraRodape.setLayout(BarraRodapeLayout);
        BarraRodapeLayout.setHorizontalGroup(
            BarraRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVoltar)
                .addContainerGap())
        );
        BarraRodapeLayout.setVerticalGroup(
            BarraRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BarraRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(labelCelular)
                    .addComponent(labelEmail)
                    .addComponent(btnVoltar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        btnVoltar.getAccessibleContext().setAccessibleDescription("Voltar a tela da biblioteca");
        btnExcluir.getAccessibleContext().setAccessibleDescription("Excluir uma linha da tabela de empréstimo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BarraRodape, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
        txtBuscarEmprestimo.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void criarSorter() {
        sorter = new TableRowSorter<>(tableModel);
        tblEmprestimo.setRowSorter(sorter);
    }

    public void atualizarLista() {
        tableModel.setRowCount(0);

        for (Emprestimo emprestimo : listaEmprestimo) {
            String nomeLivro = "";
            String nomeCliente = "";
            String data = emprestimo.getData();
            String devolvido = emprestimo.isDevolvido() ? "Sim" : "Não";

            if (emprestimo.getLivro() != null) {
                nomeLivro = emprestimo.getLivro().getNome();
            }

            if (emprestimo.getCliente() != null) {
                nomeCliente = emprestimo.getCliente().getNome();
            }

            Object[] rowData = {nomeLivro, nomeCliente, data, devolvido};
            tableModel.addRow(rowData);
        }
    }

    private void buscar() {
        String filtro = txtBuscarEmprestimo.getText();
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + filtro);
        sorter.setRowFilter(rowFilter);
    }

    private void labelCelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCelularMouseClicked
        JOptionPane.showInputDialog(null, "Enviar menssagem com o seguinte texto:", "Enviar menssagem para **(21) 98765-4321**", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelCelularMouseClicked

    private void labelEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEmailMouseClicked
        JOptionPane.showInputDialog(null, "Enviar E-mail com o seguinte conteúdo:", "Enviar E-mail para **biblioteca@hotmail.com**", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelEmailMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaBiblioteca tela = new TelaBiblioteca();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEmprestarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestarLivroActionPerformed
        TelaEmprestarLivro tela = new TelaEmprestarLivro();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEmprestarLivroActionPerformed

    private void logoBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoBibliotecaMouseClicked
        TelaBiblioteca tela = new TelaBiblioteca();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoBibliotecaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tblEmprestimo.getSelectedRow();

        if (linhaSelecionada != -1) {

            DefaultTableModel modelo = (DefaultTableModel) tblEmprestimo.getModel();
            modelo.removeRow(linhaSelecionada);
            listaEmprestimo.remove(linhaSelecionada);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        int linhaSelecionada = tblEmprestimo.getSelectedRow();
        Livros livro = null;
        

        if (linhaSelecionada != -1) {
            List<Emprestimo> listaEmprestimos = Listagem.ListarEmprestimo();

            Emprestimo emprestimo = listaEmprestimos.get(linhaSelecionada);
            livro = emprestimo.getLivro();

            emprestimo.setDevolvido(true);
            livro.setEmprestado(false);

            atualizarLista();

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um livro para devolver.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnDevolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu;
    private javax.swing.JPanel BarraRodape;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEmprestarLivro;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel logoBiblioteca;
    private javax.swing.JTable tblEmprestimo;
    private javax.swing.JTextField txtBuscarEmprestimo;
    // End of variables declaration//GEN-END:variables
}
