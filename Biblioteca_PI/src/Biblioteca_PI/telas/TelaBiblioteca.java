package Biblioteca_PI.telas;

import Biblioteca_PI.model.Listagem;
import Biblioteca_PI.model.Livros;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaBiblioteca extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> sorter;
    private final List<Livros> listaLivros = Listagem.ListarLivro();

    private final String[] tableColoumns = {"Livro", "Autor", "Gênero", "Ano", "Emprestado"};
    DefaultTableModel tableModel = new DefaultTableModel(tableColoumns, 0);

    public TelaBiblioteca() {
        initComponents();
        criarSorter();
        atualizarLista();

    }

    private void atualizarLista() {

        tableModel.setRowCount(0);

        if (!listaLivros.isEmpty()) {
            for (Livros livro : listaLivros) {
                String emprestado = livro.isEmprestado() ? "Sim" : "Não";
                String[] rowData = {
                    livro.getNome(),
                    livro.getAutor(),
                    livro.getGenero(),
                    String.valueOf(livro.getAno()),
                    emprestado
                };
                tableModel.addRow(rowData);
            }
        }
        tblLivros.setModel(tableModel);
    }

    private void criarSorter() {
        sorter = new TableRowSorter<>(tableModel);
        tblLivros.setRowSorter(sorter);
    }

    private void buscar() {
        String filtro = txtBuscarLivro.getText();
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + filtro);
        sorter.setRowFilter(rowFilter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraMenu = new javax.swing.JPanel();
        txtBuscarLivro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrarLivro = new javax.swing.JButton();
        btnCadastrarLivro1 = new javax.swing.JButton();
        BarraRodape = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelCelular = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        btnEmprestimo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Biblioteca");

        BarraMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/loupe.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Swis721 Hv BT", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/booksMenu.png"))); // NOI18N
        jLabel1.setText("Biblioteca Virtual ");

        btnCadastrarLivro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/register.png"))); // NOI18N
        btnCadastrarLivro.setText("Novo Livro");
        btnCadastrarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarLivroActionPerformed(evt);
            }
        });

        btnCadastrarLivro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/cadastrar.png"))); // NOI18N
        btnCadastrarLivro1.setText("Novo Cliente");
        btnCadastrarLivro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarLivro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraMenuLayout = new javax.swing.GroupLayout(BarraMenu);
        BarraMenu.setLayout(BarraMenuLayout);
        BarraMenuLayout.setHorizontalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(txtBuscarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarLivro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarLivro)
                .addContainerGap())
        );
        BarraMenuLayout.setVerticalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1)
                    .addComponent(btnCadastrarLivro)
                    .addComponent(btnCadastrarLivro1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        txtBuscarLivro.getAccessibleContext().setAccessibleName("txtBuscarLivro");
        txtBuscarLivro.getAccessibleContext().setAccessibleDescription("Digite o nome do Livro ou Cliente em minúsculo");
        btnBuscar.getAccessibleContext().setAccessibleDescription("Fazer uma busca de um determinado livro");
        btnCadastrarLivro.getAccessibleContext().setAccessibleDescription("Cadastar um novo Livro");
        btnCadastrarLivro1.getAccessibleContext().setAccessibleDescription("Cadastrar novo cliente");

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

        btnEmprestimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/bookRodape.png"))); // NOI18N
        btnEmprestimo.setText("Empréstimo");
        btnEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/lixeira.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Biblioteca_PI/imagens/logout.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
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
                .addComponent(btnEmprestimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair)
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
                    .addComponent(btnEmprestimo)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        labelCelular.getAccessibleContext().setAccessibleDescription("enviar uma menssagem para a biblioteca");
        labelEmail.getAccessibleContext().setAccessibleDescription("Enviar um emal para a biblioteca");
        btnEmprestimo.getAccessibleContext().setAccessibleDescription("Ir para a tela de emprestimo");
        btnExcluir.getAccessibleContext().setAccessibleDescription("Excluir uma linha da tabela de livros");
        btnSair.getAccessibleContext().setAccessibleDescription("Sair para a tela inicial");

        jScrollPane1.setBackground(new java.awt.Color(61, 122, 153));
        jScrollPane1.setBorder(null);

        tblLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Autor", "Gênero", "Ano ", "Emprestado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLivros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BarraRodape, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEmailMouseClicked
        JOptionPane.showInputDialog(null, "Enviar E-mail com o seguinte conteúdo:", "Enviar E-mail para **biblioteca@hotmail.com**", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelEmailMouseClicked

    private void labelCelularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCelularMouseClicked
        JOptionPane.showInputDialog(null, "Enviar menssagem com o seguinte texto:", "Enviar menssagem para **(21) 98765-4321**", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelCelularMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
        txtBuscarLivro.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCadastrarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarLivroActionPerformed
        TelaCadastroLivro tela = new TelaCadastroLivro();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastrarLivroActionPerformed

    private void btnEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimoActionPerformed
        TelaEmprestimo tela = new TelaEmprestimo();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEmprestimoActionPerformed

    private void btnCadastrarLivro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarLivro1ActionPerformed
        TelaCadastroCliente tela = new TelaCadastroCliente();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastrarLivro1ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tblLivros.getSelectedRow();

        if (linhaSelecionada != -1) {

            DefaultTableModel modelo = (DefaultTableModel) tblLivros.getModel();
            modelo.removeRow(linhaSelecionada);
            listaLivros.remove(linhaSelecionada);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu;
    private javax.swing.JPanel BarraRodape;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrarLivro;
    private javax.swing.JButton btnCadastrarLivro1;
    private javax.swing.JButton btnEmprestimo;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCelular;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JTable tblLivros;
    private javax.swing.JTextField txtBuscarLivro;
    // End of variables declaration//GEN-END:variables
}
