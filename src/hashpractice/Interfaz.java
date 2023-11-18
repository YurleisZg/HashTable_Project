package hashpractice;

import hashpractice.factories.AbstractHashTable;
import hashpractice.factories.HashTablesFactory;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import hashpractice.factories.Entrada;
import javax.swing.JOptionPane;
public class Interfaz extends javax.swing.JFrame {
    private File file;
    private AbstractHashTable<Persona, Persona> hashTable;
    
    public Interfaz() {
        initComponents();
        jTextArea1.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m(kA mod 1)", "k mod m" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Archivo:");

        jLabel2.setText("Colisiones: 0");

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Close");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Operations");

        jMenuItem4.setText("Insert");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Delete");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Search");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("Separado por comas", "csv"));
        jFileChooser1.showOpenDialog(this);
        
        file = jFileChooser1.getSelectedFile();
        
        if(file == null){
            jLabel1.setText("Archivo: ");
            return;
        }
        
        if(!file.getName().endsWith(".csv")){
            jLabel1.setText("Archivo: ");
            return;            
        }
        
        jLabel1.setText("Archivo: " + file.getPath());
        
        int selected = jComboBox1.getSelectedIndex() + 1;
        
        hashTable = new HashTablesFactory().getHashTable(selected, 256);
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] campos = line.split(";");
                Persona nuevaPersona = new Persona(campos[0], campos[1], campos[2], campos[3]);
                hashTable.put(nuevaPersona, nuevaPersona);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        actualizarDatos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        String [] datos = new String[4];
        
        datos[0] = JOptionPane.showInputDialog("Input the ID: ");
        if(datos[0] == null){
            JOptionPane.showMessageDialog(null, "Insertion cancelled.");
            return;
        }
        if(datos[0].equals("")){
            JOptionPane.showMessageDialog(null, "This is not an ID.");
            return;
        }
        
        datos[1] = JOptionPane.showInputDialog("Input the FirstName: ");
        if(datos[1] == null){
            JOptionPane.showMessageDialog(null, "Insertion cancelled.");
            return;
        }
        
        datos[2] = JOptionPane.showInputDialog("Input the LastName: ");
        if(datos[2] == null){
            JOptionPane.showMessageDialog(null, "Insertion cancelled.");
            return;
        }
        
        datos[3] = JOptionPane.showInputDialog("Input the gender: ");
          if(datos[3] == null){
            JOptionPane.showMessageDialog(null, "Insertion cancelled.");
            return;
        }
        Persona persona = new Persona(datos[0], datos[1], datos[2], datos[3]);
        hashTable.put(persona, persona);
        JOptionPane.showMessageDialog(null, "Added!");
        actualizarDatos();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String llave = JOptionPane.showInputDialog("Input the ID to delete: ");
        if(llave == null) return;
        
        if(!hashTable.delete(new Persona(llave, null, null, null))){
            JOptionPane.showMessageDialog(null, "Nobody was deleted. ID is not registered");
            return;
        }
        JOptionPane.showMessageDialog(null, "Register deleted!");
        actualizarDatos();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        String llave = JOptionPane.showInputDialog("Input the ID to search: ");
        if(llave == null){
            return;
        }
        Persona persona = hashTable.search(new Persona(llave, null, null, null));
        if(persona == null){
            JOptionPane.showMessageDialog(null, "This ID is not registered.");
            return;
        }
        JOptionPane.showMessageDialog(null, 
                "ID: " + persona.getId() + "\n" +
                "First name: " + persona.getFirst_name() + "\n" +
                "Last name: " + persona.getLast_name() + "\n" +
                "Gender: " + persona.getGender() + "\n"
        );
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jTextArea1.setText("");
        file = null;
        jLabel1.setText("Archivo: ");
        hashTable = null;
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try
        {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            
            Lista<Entrada<Persona, Persona>> [] datos = hashTable.getArray();
            
            Lista<Lista<Entrada<Persona, Persona>>> datosValidos = new Lista();
            
            for(Lista<Entrada<Persona, Persona>> dato : datos)
            {
                if(dato == null) continue;
                datosValidos.add(dato);
            }
            
            Persona ultimo = datosValidos.get(datosValidos.size()-1).get(datosValidos.get(datosValidos.size()-1).size()-1).getValor();
            
            for(int i = 0; i < datosValidos.size()-1; i++)
            {
                for(int j = 0; j < datosValidos.get(i).size(); j++)
                {
                    Persona p = datosValidos.get(i).get(j).getValor();
                    writer.println(p.getId() + ";" + p.getFirst_name() + ";" + p.getLast_name() + ";" + p.getGender());
                }
            }
            
            for(int i = 0; i < datosValidos.get(datosValidos.size()-1).size(); i++)
            {
                Persona p = datosValidos.get((datosValidos.size()-1)).get(i).getValor();
                writer.println(p.getId() + ";" + p.getFirst_name() + ";" + p.getLast_name() + ";" + p.getGender());                
            }
            
            writer.print(ultimo.getId() + ";" + ultimo.getFirst_name() + ";" + ultimo.getLast_name() + ";" + ultimo.getGender());
            
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Registros guardados correctamente.");
        }
        catch(IOException e){
            
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void actualizarDatos()
    {
        Lista<Entrada<Persona, Persona>> [] datos = hashTable.getArray();
        StringBuilder sb = new StringBuilder();
        int i = -1;
        for(Lista<Entrada<Persona, Persona>> lista : datos)
        {
            i++;
            if(lista == null) continue;
            
            sb.append(i).append("\t");
            for(int j = 0; j < lista.size(); j++){
                sb.append(lista.get(j).getLlave().getId());
                if(j != lista.size()-1)
                {
                    sb.append(" --> ");
                }
            }
            sb.append("\n");
        }
        
        jTextArea1.setText(sb.toString());
        jLabel2.setText("Colisiones: " + hashTable.collisions());
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
