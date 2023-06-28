package visao;

import controle.ExcelExporter;
import controle.MarcaControle;
import controle.ModeloControle;
import controle.PDFExporter;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelos.EnumTipoModelo;
import modelos.IMarcaCRUD;
import modelos.IModeloVeiculo;
import modelos.Marca;
import modelos.ModeloVeiculo;

public class TelaCadastroModelo extends javax.swing.JFrame {

    IMarcaCRUD marcas = null;
    IModeloVeiculo tiposModeloControle = null;
    File origemGlobal = null;
    ArrayList<Marca> listaDeMarcas = null;

    /**
     * Creates new form TelaCadastroProprietario
     */
    public TelaCadastroModelo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("SCGV - Sistema de Controle de Gastos Veicular - Cadastro de Modelos");
        this.setResizable(false);
        marcas = new MarcaControle();
        tiposModeloControle = new ModeloControle();
        preencherComboBoxMarcas();
        preencherComboBoxTiposDeVeiculos();
        mostrarModelos();
    }

    // Metodo para buscar e preencher proprietarios na jTable
    private void mostrarModelos() {
        try {
            ArrayList<ModeloVeiculo> listaDeModelos = tiposModeloControle.listagemDeModelos();
            DefaultTableModel model = (DefaultTableModel) jTable_Saida.getModel();

            model.setNumRows(0);
            if (listaDeModelos.isEmpty()) {
                return;
            }
            for (ModeloVeiculo i : listaDeModelos) {
                System.out.println("LINHA: 0--> " + i.saidaTabela());
                String[] linha = i.saidaTabela().split(";");
                model.addRow(linha);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }

    // Metodo privado para limpar capos apos inserçao
    private void limparCampos() {
        jComboBox_TipoVeiculo.setSelectedIndex(0);
        jComboBox_MarcaVeiculo.setSelectedIndex(0);
        jTextField_ID.setText(null);
        jTextField_Descricao.setText(null);
        origemGlobal = null;
    }

    //Metodo privado pra preencher combobox com Enum de Tipo de Veiculos
    private void preencherComboBoxTiposDeVeiculos() {
        EnumTipoModelo.TipoModeloVeiculo[] tipos = EnumTipoModelo.TipoModeloVeiculo.values();
        jComboBox_TipoVeiculo.removeAllItems();
        jComboBox_TipoVeiculo.addItem("Selecione o tipo.");
        for (EnumTipoModelo.TipoModeloVeiculo tipo : tipos) {
            jComboBox_TipoVeiculo.addItem(tipo.toString());
        }
    }

    //Metodo privado pra preencher combobox com todas as Marcas já cadastradas no sistema
    private void preencherComboBoxMarcas() {
        try {
            listaDeMarcas = marcas.listagemDeMarcas();
            jComboBox_MarcaVeiculo.removeAllItems();
            jComboBox_MarcaVeiculo.addItem("Selecione uma marca.");
            for (Marca i : listaDeMarcas) {
                jComboBox_MarcaVeiculo.addItem(i.getDescricao());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    //Metodo para mostrar a imagem da CNH quando for inserida ou selecionada na tabela
    private void setImagemModelo(String caminhoLogo) {
        ImageIcon icon = new ImageIcon(caminhoLogo);
        //definindo um tamanho limite para a imagem 
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(210, 190, java.awt.Image.SCALE_SMOOTH));
        jLabel_FotoVeiculo.setIcon(resizedIcon);
        jButton_Alterar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_Voltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField_ID = new javax.swing.JTextField();
        jTextField_Descricao = new javax.swing.JTextField();
        jLabel_Descricao = new javax.swing.JLabel();
        jLabel_ID = new javax.swing.JLabel();
        jComboBox_MarcaVeiculo = new javax.swing.JComboBox<>();
        jLabel_Descricao1 = new javax.swing.JLabel();
        jComboBox_TipoVeiculo = new javax.swing.JComboBox<>();
        jLabel_Descricao2 = new javax.swing.JLabel();
        jLabel_ID11 = new javax.swing.JLabel();
        jButton_SelecionarFoto = new javax.swing.JButton();
        jButton_Limpar = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Salvar = new javax.swing.JButton();
        jLabel_FotoVeiculo = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel_EmblemaGrupo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Saida = new javax.swing.JTable();
        jButton_exportarExcel = new javax.swing.JButton();
        jButton_exportarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jButton_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/voltar-24.png"))); // NOI18N
        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo Cadastro de Modelo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jTextField_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDKeyTyped(evt);
            }
        });

        jLabel_Descricao.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_Descricao.setText("Descrição:");

        jLabel_ID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID.setText("ID:");

        jComboBox_MarcaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel_Descricao1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_Descricao1.setText("Marca:");

        jComboBox_TipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel_Descricao2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_Descricao2.setText("Tipo:");

        jLabel_ID11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID11.setText("Foto:");

        jButton_SelecionarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/selecionar-24.png"))); // NOI18N
        jButton_SelecionarFoto.setText("Selecionar");
        jButton_SelecionarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelecionarFotoActionPerformed(evt);
            }
        });

        jButton_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar-24.png"))); // NOI18N
        jButton_Limpar.setText("Limpar");
        jButton_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimparActionPerformed(evt);
            }
        });

        jButton_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/alterar-24.png"))); // NOI18N
        jButton_Alterar.setText("Alterar");
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });

        jButton_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar-24.png"))); // NOI18N
        jButton_Salvar.setText("Salvar");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalvarActionPerformed(evt);
            }
        });

        jLabel_FotoVeiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_FotoVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo/sem-imagem.png"))); // NOI18N
        jLabel_FotoVeiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Imagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Descricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Descricao))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_ID)
                                    .addComponent(jLabel_Descricao1)
                                    .addComponent(jLabel_ID11)
                                    .addComponent(jLabel_Descricao2))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton_SelecionarFoto))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_ID)
                                            .addComponent(jComboBox_TipoVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox_MarcaVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel_FotoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_Limpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Alterar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Salvar)
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Descricao)
                    .addComponent(jTextField_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Descricao1)
                    .addComponent(jComboBox_MarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Descricao2)
                    .addComponent(jComboBox_TipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ID11)
                    .addComponent(jButton_SelecionarFoto))
                .addGap(28, 28, 28)
                .addComponent(jLabel_FotoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpar)
                    .addComponent(jButton_Alterar)
                    .addComponent(jButton_Salvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));

        jLabel_EmblemaGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_EmblemaGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scgv.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel_EmblemaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel_EmblemaGrupo)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelos cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jTable_Saida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição ", "Marca", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Saida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SaidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Saida);
        if (jTable_Saida.getColumnModel().getColumnCount() > 0) {
            jTable_Saida.getColumnModel().getColumn(0).setResizable(false);
            jTable_Saida.getColumnModel().getColumn(1).setResizable(false);
            jTable_Saida.getColumnModel().getColumn(2).setResizable(false);
            jTable_Saida.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton_exportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excel.png"))); // NOI18N
        jButton_exportarExcel.setText("Exportar");
        jButton_exportarExcel.setMaximumSize(new java.awt.Dimension(103, 37));
        jButton_exportarExcel.setMinimumSize(new java.awt.Dimension(103, 37));
        jButton_exportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exportarExcelActionPerformed(evt);
            }
        });

        jButton_exportarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pdf.png"))); // NOI18N
        jButton_exportarPDF.setText("Exportar");
        jButton_exportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exportarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jButton_exportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_exportarPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_exportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_exportarPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SelecionarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelecionarFotoActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Imagem", "jpg", "jpeg", "png", "gif");
            File diretorioInicial = new File(".\\src\\img\\patch_modelo\\");
            fileChooser.setCurrentDirectory(diretorioInicial);
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                origemGlobal = fileChooser.getSelectedFile();
                setImagemModelo(fileChooser.getSelectedFile().getPath());
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_jButton_SelecionarFotoActionPerformed

    private void jButton_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VoltarActionPerformed
        dispose();
        TelaPrincipal voltaTelaPrincipal = new TelaPrincipal();
        voltaTelaPrincipal.dispose();
        voltaTelaPrincipal.setLocationRelativeTo(this);
        voltaTelaPrincipal.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        voltaTelaPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton_VoltarActionPerformed

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarActionPerformed
        try {
            Integer idMarca = null;
            for (Marca i : listaDeMarcas) {
                if (i.getDescricao().equals(jComboBox_MarcaVeiculo.getSelectedItem().toString())) {
                    idMarca = i.getId();
                }
            }
            Integer _id = -1;
            if (!jTextField_ID.getText().isBlank()) {
                _id = Integer.valueOf(jTextField_ID.getText());
            }
            ModeloVeiculo modelo = new ModeloVeiculo(
                    _id,
                    jTextField_Descricao.getText(),
                    jComboBox_MarcaVeiculo.getSelectedItem().toString(),
                    jComboBox_TipoVeiculo.getSelectedItem().toString(),
                    origemGlobal,
                    idMarca
            );
            tiposModeloControle.incluir(modelo);
            JOptionPane.showMessageDialog(rootPane, "Modelo cadastrado com Sucesso!");
            limparCampos();
            mostrarModelos();
            origemGlobal = null;
            setImagemModelo(".\\src\\img\\cnh\\sem-imagem.png");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButton_SalvarActionPerformed

    private void jTextField_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDKeyTyped
        // Campo ID , permitir somente numeros de 0-9
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_IDKeyTyped

    private void jTable_SaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SaidaMouseClicked
        // Evento da tabela, quando clicar preenchear os campos.
        try {
            jTextField_ID.setEnabled(false);
            int linha = jTable_Saida.getSelectedRow();
            String desc = "";
            for (Marca i : listaDeMarcas) {
                if (i.getDescricao().equals(jTable_Saida.getValueAt(linha, 2))) {
                    desc = i.getDescricao();
                }
            }
            String id = ((String) jTable_Saida.getValueAt(linha, 0));
            jTextField_ID.setText((String) jTable_Saida.getValueAt(linha, 0));
            ModeloVeiculo modeloVeiculo = tiposModeloControle.consultar(Integer.valueOf(id));
            jTextField_Descricao.setText(modeloVeiculo.getDescricao());
            jComboBox_MarcaVeiculo.setSelectedItem(desc);
            jComboBox_TipoVeiculo.setSelectedItem(modeloVeiculo.getTipoModelo());
            origemGlobal = new File(modeloVeiculo.getFotoModelo().getPath());
            setImagemModelo(modeloVeiculo.getFotoModelo().getPath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTable_SaidaMouseClicked

    private void jButton_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimparActionPerformed
        jTextField_ID.setEnabled(true);
        limparCampos();
        setImagemModelo(".\\src\\img\\cnh\\sem-imagem.png");
    }//GEN-LAST:event_jButton_LimparActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        try {
            String desc = "";
            Integer id = 0;
            for (Marca i : listaDeMarcas) {
                if (i.getDescricao().equals(jComboBox_MarcaVeiculo.getSelectedItem().toString())) {
                    desc = i.getDescricao();
                    id = i.getId();
                }
            }
            ModeloVeiculo modeloVeiculo = new ModeloVeiculo(
                    Integer.valueOf(jTextField_ID.getText()),
                    jTextField_Descricao.getText(),
                    desc,
                    jComboBox_TipoVeiculo.getSelectedItem().toString(),
                    origemGlobal,
                    id);
            tiposModeloControle.alterar(modeloVeiculo);
            mostrarModelos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_exportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exportarExcelActionPerformed
        ExcelExporter exporter = new ExcelExporter();
        try {
            exporter.exportToExcel(jTable_Saida);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_exportarExcelActionPerformed

    private void jButton_exportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exportarPDFActionPerformed
        PDFExporter pdfExporter = new PDFExporter();
        try {
            pdfExporter.exportToPDF(jTable_Saida);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_exportarPDFActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroModelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroModelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Limpar;
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JButton jButton_SelecionarFoto;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JButton jButton_exportarExcel;
    private javax.swing.JButton jButton_exportarPDF;
    private javax.swing.JComboBox<String> jComboBox_MarcaVeiculo;
    private javax.swing.JComboBox<String> jComboBox_TipoVeiculo;
    private javax.swing.JLabel jLabel_Descricao;
    private javax.swing.JLabel jLabel_Descricao1;
    private javax.swing.JLabel jLabel_Descricao2;
    private javax.swing.JLabel jLabel_EmblemaGrupo;
    private javax.swing.JLabel jLabel_FotoVeiculo;
    private javax.swing.JLabel jLabel_ID;
    private javax.swing.JLabel jLabel_ID11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Saida;
    private javax.swing.JTextField jTextField_Descricao;
    private javax.swing.JTextField jTextField_ID;
    // End of variables declaration//GEN-END:variables
}
