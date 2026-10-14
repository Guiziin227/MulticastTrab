package chatMulticast;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import util.ComunicadorUDP;
import util.GerenciadorHistorico;
import util.ProtocoloMensagem;

public class JFrame_chatMulticast extends javax.swing.JFrame {

    InetAddress grupo;
    MulticastSocket socket;
    LinkedList<String> lista = new LinkedList<>();
    DefaultListModel<String> modelUsuarios = new DefaultListModel<>();

    public JFrame_chatMulticast() {
        initComponents();
        modelUsuarios.addElement("Todos");
        jList_usuariosOnline.setModel(modelUsuarios);
        jList_usuariosOnline.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Chat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Mensagens = new javax.swing.JTextArea();
        jTextField_textoDeEnvio = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jLabel_Porta = new javax.swing.JLabel();
        jTextField_Porta = new javax.swing.JTextField();
        jLabel_ServidorIP = new javax.swing.JLabel();
        jButton_Sair = new javax.swing.JButton();
        jTextField_GrupoIP = new javax.swing.JTextField();
        jLabel_Nick = new javax.swing.JLabel();
        jTextField_Nick = new javax.swing.JTextField();
        jButton_Conectar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_usuariosOnline = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea_Mensagens.setEditable(false);
        jTextArea_Mensagens.setColumns(20);
        jTextArea_Mensagens.setRows(5);
        jTextArea_Mensagens.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea_Mensagens);

        jTextField_textoDeEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_textoDeEnvioKeyPressed(evt);
            }
        });

        jButton_Enviar.setText("Enviar");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        jLabel_Porta.setText("Porta");

        jTextField_Porta.setText("3456");

        jLabel_ServidorIP.setText("Grupo IP:");

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        jTextField_GrupoIP.setText("239.1.2.3");

        jLabel_Nick.setText("Nick:");

        jButton_Conectar.setText("Conectar");
        jButton_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConectarActionPerformed(evt);
            }
        });

        jList_usuariosOnline.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList_usuariosOnline);

        javax.swing.GroupLayout jPanel_ChatLayout = new javax.swing.GroupLayout(jPanel_Chat);
        jPanel_Chat.setLayout(jPanel_ChatLayout);
        jPanel_ChatLayout.setHorizontalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel_ServidorIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_GrupoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Porta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Nick)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_Conectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton_Sair)
                .addGap(2, 2, 2))
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addComponent(jTextField_textoDeEnvio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Enviar))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
        );
        jPanel_ChatLayout.setVerticalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_textoDeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Enviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ServidorIP)
                    .addComponent(jTextField_GrupoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Porta)
                    .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nick)
                    .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Conectar)
                    .addComponent(jButton_Sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_Chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class ThreadReceptora extends Thread {

        @Override
        public void run() {
            JFrame meuFrame = JFrame_chatMulticast.this;
            while (socket != null && !socket.isClosed()) {
                try {
                    DatagramPacket pacote = ComunicadorUDP.recebeMensagem(socket);
                    if (pacote == null) {
                        break;
                    }

                    String msgRecebida = new String(pacote.getData(), 0, pacote.getLength()).trim();
                    String meuNick = jTextField_Nick.getText().trim();

                    ProtocoloMensagem msg = ProtocoloMensagem.interpretar(msgRecebida);
                    if (msg == null) {
                        continue;
                    }

                    switch (msg.getTipo()) {
                        case "ENTROU":
                            adicionarUsuarioNaLista(msg.getRemetente(), meuNick);
                            if (!msg.getRemetente().equals(meuNick)) {
                                enviarPacoteProtocolo(ProtocoloMensagem.montarOnline(meuNick));
                            }
                            registrarMensagem("[" + msg.getHorario() + "] " + msg.getRemetente() + " entrou na sala");
                            break;

                        case "ONLINE":
                            adicionarUsuarioNaLista(msg.getRemetente(), meuNick);
                            break;

                        case "SAIU":
                            modelUsuarios.removeElement(msg.getRemetente());
                            if (jList_usuariosOnline.getSelectedValue() == null) {
                                jList_usuariosOnline.setSelectedIndex(0);
                            }
                            registrarMensagem("[" + msg.getHorario() + "] " + msg.getRemetente() + " saiu da sala");
                            break;

                        case "MSG":
                            if (msg.deveExibirPara(meuNick)) {
                                registrarMensagem(msg.formatarExibicao(meuNick));
                            }
                            break;
                    }
                } catch (Exception e) {
                    if (socket != null && !socket.isClosed()) {
                        JOptionPane.showMessageDialog(meuFrame, e.getMessage());
                    }
                }
            }
        }
    }

    private void adicionarUsuarioNaLista(String usuario, String meuNick) {
        if (!usuario.equals(meuNick) && !modelUsuarios.contains(usuario)) {
            modelUsuarios.addElement(usuario);
        }
    }

    private void registrarMensagem(String linha) {
        lista.add(linha);
        String meuNick = jTextField_Nick.getText().trim();
        GerenciadorHistorico.salvarLinha(meuNick, linha);
        atualizarAreaTexto();
    }

    private void atualizarAreaTexto() {
        jTextArea_Mensagens.setText("");
        Iterator<String> i = lista.iterator();
        while (i.hasNext()) {
            jTextArea_Mensagens.append(i.next() + "\n");
        }
    }

    private void carregarHistoricoUsuario(String meuNick) {
        lista.clear();
        String historico = GerenciadorHistorico.carregar(meuNick);
        if (!historico.isBlank()) {
            String[] linhas = historico.split("\\R");
            for (String linha : linhas) {
                if (!linha.isBlank()) {
                    lista.add(linha);
                }
            }
        }
        atualizarAreaTexto();
    }

    private void enviarPacoteProtocolo(String dados) throws IOException {
        DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                dados,
                jTextField_GrupoIP.getText().trim(),
                Integer.parseInt(jTextField_Porta.getText().trim())
        );
        socket.send(pacote);
    }

    private void sairDoSistema() throws IOException, NumberFormatException, NullPointerException {
        if (socket == null || socket.isClosed()) {
            JOptionPane.showMessageDialog(this, "Você está saindo sem ter se conectado");
            return;
        }
        try {
            String meuNick = jTextField_Nick.getText().trim();
            enviarPacoteProtocolo(ProtocoloMensagem.montarSaida(meuNick));
            socket.leaveGroup(grupo);
            socket.close();
        } catch (IOException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } finally {
            modelUsuarios.clear();
            modelUsuarios.addElement("Todos");
            jList_usuariosOnline.setSelectedIndex(0);
            jButton_Conectar.setEnabled(true);
            jTextField_Nick.setEnabled(true);
            jTextField_GrupoIP.setEnabled(true);
            jTextField_Porta.setEnabled(true);
        }
    }

    private void jButton_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConectarActionPerformed
        try {
            String meuNick = jTextField_Nick.getText().trim();
            if (meuNick.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha seu nick");
                jTextField_Nick.requestFocus();
            } else {
                grupo = InetAddress.getByName(jTextField_GrupoIP.getText().trim());
                socket = new MulticastSocket(Integer.parseInt(jTextField_Porta.getText().trim()));
                socket.joinGroup(grupo);

                modelUsuarios.clear();
                modelUsuarios.addElement("Todos");
                jList_usuariosOnline.setSelectedIndex(0);

                carregarHistoricoUsuario(meuNick);

                ThreadReceptora tR = new ThreadReceptora();
                tR.start();

                JOptionPane.showMessageDialog(this, "Conectado com sucesso!");
                jButton_Conectar.setEnabled(false);
                jTextField_Nick.setEnabled(false);
                jTextField_GrupoIP.setEnabled(false);
                jTextField_Porta.setEnabled(false);

                enviarPacoteProtocolo(ProtocoloMensagem.montarEntrada(meuNick));
                jTextField_textoDeEnvio.requestFocus();
            }
        } catch (HeadlessException | IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton_ConectarActionPerformed

    private void enviarMsg() throws IOException, NumberFormatException, NullPointerException {
        try {
            if (socket == null || socket.isClosed()) {
                JOptionPane.showMessageDialog(this, "Você precisa conectar antes de enviar msgs");
                return;
            }
            String texto = jTextField_textoDeEnvio.getText().trim();
            if (texto.isEmpty()) {
                return;
            }
            String meuNick = jTextField_Nick.getText().trim();
            String destinatario = jList_usuariosOnline.getSelectedValue();
            if (destinatario == null) {
                destinatario = "Todos";
            }

            String msg = ProtocoloMensagem.montarTexto(meuNick, destinatario, texto);
            enviarPacoteProtocolo(msg);
            jTextField_textoDeEnvio.setText("");
        } catch (IOException | NumberFormatException | NullPointerException e) {
            if (e instanceof NullPointerException) {
                JOptionPane.showMessageDialog(this, "Você precisa conectar antes de enviar msgs");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        try {
            this.enviarMsg();
            jTextField_textoDeEnvio.requestFocus();
        } catch (IOException | NumberFormatException | NullPointerException e) {

        }
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        try {
            this.sairDoSistema();
        } catch (IOException | NumberFormatException | NullPointerException e) {

        }
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void jTextField_textoDeEnvioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_textoDeEnvioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.enviarMsg();
            } catch (IOException | NumberFormatException | NullPointerException e) {

            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            try {
                this.sairDoSistema();
            } catch (IOException | NumberFormatException | NullPointerException e) {

            }
        }
    }//GEN-LAST:event_jTextField_textoDeEnvioKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_chatMulticast().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Conectar;
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JLabel jLabel_Nick;
    private javax.swing.JLabel jLabel_Porta;
    private javax.swing.JLabel jLabel_ServidorIP;
    private javax.swing.JList<String> jList_usuariosOnline;
    private javax.swing.JPanel jPanel_Chat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_Mensagens;
    private javax.swing.JTextField jTextField_GrupoIP;
    private javax.swing.JTextField jTextField_Nick;
    private javax.swing.JTextField jTextField_Porta;
    private javax.swing.JTextField jTextField_textoDeEnvio;
    // End of variables declaration//GEN-END:variables
}