/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente.vista;

import Cliente.sop_rmi.ClienteImpl;
import Cliente.utilidades.UtilidadesRegistroC;
import Servidor.sop_rmi.IServidorUsuarios;
import com.sbix.jnotify.NPosition;
import com.sbix.jnotify.NoticeType;
import com.sbix.jnotify.NoticeWindow;
import java.awt.Color;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author JhonMZ
 */
public class GUICliente extends javax.swing.JFrame {
    
    /**
     * Creates new form GUICliente
     */
    public GUICliente() {
        initComponents();
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
        lblNick = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tbxMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaUsuarios = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 0));
        setForeground(new java.awt.Color(153, 153, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblNick.setBackground(java.awt.Color.darkGray);
        lblNick.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNick.setForeground(new java.awt.Color(255, 255, 255));
        lblNick.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNick.setText("  ");
        jPanel1.add(lblNick, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(java.awt.Color.darkGray);

        tbxMensaje.setBackground(new java.awt.Color(69, 73, 75));
        tbxMensaje.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tbxMensaje.setForeground(new java.awt.Color(255, 255, 255));
        tbxMensaje.setCaretColor(new java.awt.Color(255, 255, 255));
        tbxMensaje.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tbxMensaje.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        tbxMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxMensajeActionPerformed(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(60, 63, 66));
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbxMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txaChat.setEditable(false);
        txaChat.setBackground(new java.awt.Color(69, 73, 75));
        txaChat.setColumns(20);
        txaChat.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        txaChat.setForeground(new java.awt.Color(255, 255, 255));
        txaChat.setLineWrap(true);
        txaChat.setRows(5);
        jScrollPane1.setViewportView(txaChat);

        txaUsuarios.setEditable(false);
        txaUsuarios.setBackground(new java.awt.Color(69, 73, 75));
        txaUsuarios.setColumns(20);
        txaUsuarios.setForeground(new java.awt.Color(102, 255, 0));
        txaUsuarios.setRows(5);
        txaUsuarios.setCaretColor(new java.awt.Color(255, 255, 255));
        txaUsuarios.setDisabledTextColor(new java.awt.Color(102, 255, 0));
        txaUsuarios.setSelectedTextColor(new java.awt.Color(51, 255, 0));
        jScrollPane4.setViewportView(txaUsuarios);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("En Linea");

        btnCerrar.setBackground(new java.awt.Color(60, 63, 66));
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("Cerrar sesion");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCerrar)
                                .addGap(42, 42, 42)))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked

        try {
            txaChat.append(this.nickName+":"+tbxMensaje.getText()+"-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss yyyy/MM/dd"))+"\n");
            objRemoto.enviarMensaje(tbxMensaje.getText(), this.nickName);
            tbxMensaje.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarMouseClicked

    private void tbxMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxMensajeActionPerformed
        try {
            txaChat.append(this.nickName+":"+tbxMensaje.getText()+"-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss yyyy/MM/dd"))+"\n");
            objRemoto.enviarMensaje(tbxMensaje.getText(), this.nickName);
            tbxMensaje.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbxMensajeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            System.out.println("");
            objRemoto.desconectar(objCliente, this.nickName);
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        try {
            System.out.println("");
            objRemoto.desconectar(objCliente, this.nickName);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private IServidorUsuarios objRemoto;
    ClienteImpl objCliente;
    String nickName;
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
           java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(GUICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
        //</editor-fold>

        /* Create and display the form */
        GUICliente objGUICliente =  new GUICliente();
        objGUICliente.conectarse();
        objGUICliente.registrarse();
        objGUICliente.getContentPane().setBackground(Color.DARK_GRAY);
        objGUICliente.jPanel1.setBackground(Color.DARK_GRAY);
        objGUICliente.setVisible(true);
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            }
        });*/
    }
    
    private void registrarse(){
        String nickName = "";
        boolean registro = false;
        String mensaje = "NickName:";
        
        while(!registro){
            nickName = (String)JOptionPane.showInputDialog(
                    this,
                    mensaje,
                    "Registrar NickName",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    "");
            if(nickName == null)System.exit(0);
            if(!nickName.equals("")){
                try {
                    objCliente = new ClienteImpl(this);
                    if(objRemoto.registrarCliente(objCliente, nickName)){
                        registro=true;
                    }else{
                        mensaje = "El NickName "+nickName+" ya esta en uso\n NickName:";
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                mensaje = "El NickName no puede estar vacio\n NickName:";
            }
        }
        this.lblNick.setText("NickName:"+nickName);
        this.nickName = nickName;
    }
    
    private void conectarse(){
            Scanner reader = new Scanner(System.in);
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";

            System.out.print("Cual es el la dirección ip donde se encuentra  el rmiregistry:");
            direccionIpRMIRegistry = reader.nextLine();

            System.out.print("Cual es el número de puerto por el cual escucha el rmiregistry:");
            numPuertoRMIRegistry = reader.nextInt();
            
            objRemoto = (IServidorUsuarios) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "servidorUsuarios");
    }
    
    private static void mostrarNotificaion(String nickName){
        System.out.println(nickName+" se ha conectado");
        new NoticeWindow(NoticeType.SUCCESS_NOTIFICATION, nickName+" se ha conectado", NoticeWindow.LONG_DELAY, NPosition.BOTTOM_RIGHT);
    }
    
    public void fijarTexto(String mensaje){
        txaChat.append(mensaje+"\n");
    }
    
    public void fijarContactos(ArrayList<String> contactos){
        String usuarios="";
        for (String string : contactos) {
            usuarios += string+"\n";
        }
        txaUsuarios.setText(usuarios);
    }
    
    public void fijarContacto(String nickName) throws InterruptedException{
        mostrarNotificaion(nickName);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNick;
    private javax.swing.JTextField tbxMensaje;
    private javax.swing.JTextArea txaChat;
    private javax.swing.JTextArea txaUsuarios;
    // End of variables declaration//GEN-END:variables
}
