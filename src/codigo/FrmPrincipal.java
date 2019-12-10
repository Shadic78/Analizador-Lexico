/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextArea;

/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {
    private JFileChooser chooser;
    //  Variables para las direcciones del archivo fuente y la ruta destino
    private File archivoFuente;
    private File directorioDestino;
    private String rutaArchivoFuente;
    private String rutaDirectorioDestino;
    private String nombreArchivo;
    private String[] partes;
    //  Variables para las tablas de simbolos
    private String IDS[][];
    private String TXT[][];
    private String VAL[][];
    private int contIDS = 0;
    private int contTXT = 0;
    private int contVAL = 0;

    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        IDS = new String[50][2];
        TXT = new String[50][2];
        VAL = new String[50][2];
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalizar1 = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        BtnSelectDestino = new javax.swing.JButton();
        BtnSelectArchivo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtCodigoFuente = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LbRutaArchivoFuente = new javax.swing.JLabel();
        LbRutaDirectorioDestino = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtResultadoSintactico = new javax.swing.JTextArea();
        BtnAnalizarSintaxis = new javax.swing.JButton();

        btnAnalizar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAnalizar1.setText("Archivo fuente");
        btnAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizar1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(725, 670));
        setPreferredSize(new java.awt.Dimension(725, 670));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 158, -1));

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 331, 240));

        BtnSelectDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnSelectDestino.setText("Ruta de destino");
        BtnSelectDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSelectDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSelectDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 163, -1));

        BtnSelectArchivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnSelectArchivo.setText("Cargar archivo");
        BtnSelectArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSelectArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSelectArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 163, -1));

        TxtCodigoFuente.setColumns(20);
        TxtCodigoFuente.setRows(5);
        jScrollPane2.setViewportView(TxtCodigoFuente);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 340, 240));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo fuente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tokens");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        LbRutaArchivoFuente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LbRutaArchivoFuente.setText("Ruta...");
        getContentPane().add(LbRutaArchivoFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        LbRutaDirectorioDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LbRutaDirectorioDestino.setText("Ruta...");
        getContentPane().add(LbRutaDirectorioDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Analizador léxico");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 462, 720, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Analizador sintáctico");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, -1));

        TxtResultadoSintactico.setColumns(20);
        TxtResultadoSintactico.setRows(5);
        jScrollPane3.setViewportView(TxtResultadoSintactico);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 690, 80));

        BtnAnalizarSintaxis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnAnalizarSintaxis.setText("Analizar");
        BtnAnalizarSintaxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnalizarSintaxisActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAnalizarSintaxis, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        try {
            if(rutaDirectorioDestino == null) {
                throw new FileNotFoundException();
            }
            // Variables para escribir los resultados del analisis lexico
            partes = archivoFuente.getName().split("\\.");     
            nombreArchivo = partes[0];
            File archivo = new File(rutaDirectorioDestino + "/" + nombreArchivo + ".lex");                            
            PrintWriter escribir = new PrintWriter(archivo);    
            
            // Archivo donde se almacenan las tablas de simbolos
            File tablaSimbolos = new File(rutaDirectorioDestino + "/" + nombreArchivo + ".sim");    
            PrintWriter escribirSimbolos = new PrintWriter(tablaSimbolos);                
            
            // Variables para hacer el analisis lexico
            Reader lector = new BufferedReader(new FileReader(rutaArchivoFuente));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            
            // Se hace el analisis lexico
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    txtResultado.setText(resultado);
                    escribir.print(resultado);
                    escribir.close();     
                    
                    // Escribir las tablas de simbolos
                    String tablaIDS = obtenerTextoMatriz(IDS, contIDS);
                    String tablaTXT = obtenerTextoMatriz(TXT, contTXT);
                    String tablaVAL = obtenerTextoMatriz(VAL, contVAL);                    
                    escribirSimbolos.print("IDS\n" + tablaIDS + "TXT\n" + tablaTXT + "VAL\n" + tablaVAL);
                    escribirSimbolos.close();
                    return;
                }
                switch (tokens) {
                    case ERROR:
                        resultado += "Simbolo no definido\n";
                        break;
                    case PROGRAMA: case FINPROG: case SI: case ENTONCES: case SINO: case FINSI: case REPITE: case VECES: case FINREP: case IMPRIME: case LEE:
                        resultado += lexer.lexeme + "\n";
                        break;                        
                    case Suma: case Resta: case Multiplicacion: case Division:
                        resultado += "[op_ar]" + "\n";
                        break;                          
                    case Identificador:
                        resultado += "[id]\n";
                        if(!verificarRepeticion(IDS, contIDS, lexer.lexeme)) {
                            IDS[contIDS][0] = lexer.lexeme;
                            IDS[contIDS][1] = "ID" + (contIDS + 1);  
                            System.out.println(IDS[contIDS][0] + ", " + IDS[contIDS][1]);
                            contIDS++;    
                        }
                        break;
                    case Numero:
                        resultado += "[val]\n";
                        if(!verificarRepeticion(VAL, contVAL, lexer.lexeme)) {
                            VAL[contVAL][0] = lexer.lexeme;
                            VAL[contVAL][1] = "VAL" + (contVAL + 1);  
                            System.out.println(VAL[contVAL][0] + ", " + VAL[contVAL][1]);
                            contVAL++;    
                        }                        
                        break;      
                     case MayorQue: case MenorQue:
                        resultado += "[op_rel]" + "\n";
                        break;       
                     case Asignacion:
                        resultado +=  "=\n";
                        break;     
                     case IgualA:
                        resultado +=  "==\n";
                        break;     
                     case LiteralDeTexto:
                        resultado +=  "[txt]\n";
                        if(!verificarRepeticion(TXT, contTXT, lexer.lexeme)) {
                            TXT[contTXT][0] = lexer.lexeme;
                            TXT[contTXT][1] = "TXT" + (contTXT + 1);  
                            System.out.println(TXT[contTXT][0] + ", " + TXT[contTXT][1]);
                            contTXT++;    
                        }                        
                        break;
                     case SaltoDeLinea:
                         break;
                     default:
                        resultado += "Simbolo desconocido\n";
                        break;                           
                }
            }
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No haz escogido la ruta de destino", "Error", ERROR_MESSAGE);
        } 
        catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "No haz escogido un archivo para analizar", "ERROR", ERROR_MESSAGE);
        }        
        catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnalizar1ActionPerformed

    private void BtnSelectDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSelectDestinoActionPerformed
        directorioDestino = seleccionarArchivo("Selecciona la ruta de destino", false);
        rutaDirectorioDestino = directorioDestino.getAbsolutePath();
        if(rutaDirectorioDestino != null) {
             getLbRutaDirectorioDestino().setText(rutaDirectorioDestino);           
        }
        else {
            getLbRutaDirectorioDestino().setText("Ruta...");            
        }        
    }//GEN-LAST:event_BtnSelectDestinoActionPerformed

    private void BtnSelectArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSelectArchivoActionPerformed
        archivoFuente = seleccionarArchivo("Selecciona tu archivo", true);
        rutaArchivoFuente = archivoFuente.getAbsolutePath();
        if(rutaArchivoFuente != null) {
             getLbRutaArchivoFuente().setText(rutaArchivoFuente); 
             getTxtCodigoFuente().setText( leerArchivo(rutaArchivoFuente) );
             getTxtResultado().setText("");
        }
        else {
            getLbRutaArchivoFuente().setText("Ruta..."); 
            getTxtCodigoFuente().setText("");
            getTxtResultado().setText("");            
        }        
    }//GEN-LAST:event_BtnSelectArchivoActionPerformed

    private void BtnAnalizarSintaxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnalizarSintaxisActionPerformed
        String tokens = leerArchivo(rutaDirectorioDestino + "/" + nombreArchivo + ".lex");
        Sintax sintax = new Sintax(new codigo.LexerCup(new StringReader(tokens)));
        try {
            sintax.parse();
            getTxtResultadoSintactico().setText("Compilacion exitosa");
        }   
        catch (Exception ex) {
            Symbol symbol  = sintax.getS();
            getTxtResultadoSintactico().setText("Error de sintaxis en la linea: " + (symbol.right + 1) + " columna: " + (symbol.left + 1 + " texto: \"" + symbol.value + "\""));            
        }    
        
    }//GEN-LAST:event_BtnAnalizarSintaxisActionPerformed
    
    public File seleccionarArchivo(String tituloVentana, boolean escogerArchivo) {
        File ruta = null;
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(tituloVentana);
        
        if(escogerArchivo) {
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);            
        }
        else {
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);            
        }
        // Desabilitar el "all files"
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ruta = chooser.getSelectedFile();
        } 
        else {
            System.out.println("No se escogio un archivo ");
        }       
        
        return ruta;
    }
    
    public String leerArchivo(String rutaArchivo) {
        BufferedReader reader;
        String linea = "";
        String texto = "";
        try {
            reader = new BufferedReader(new FileReader(rutaArchivo));
            linea = reader.readLine();
            while (linea != null) {
                texto += linea + "\n";                
                linea = reader.readLine();
            }
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }    
        return texto;
    }
    
    public boolean verificarRepeticion(String matriz[][], int filas, String cadena) {
        boolean repeticion = false;
        for(int i = 0; i < filas; i++){
            if(matriz[i][0].equals(cadena)) {
                repeticion = true;
                break;
            }
        }
        return repeticion;
    }
    
    String obtenerTextoMatriz(String matriz[][], int filas) {
        String texto = "";
        for(int i = 0; i < filas; i++) {
            texto += matriz[i][0] + ", " + matriz[i][1] + "\n";
        }
        texto += "\n";
        return texto;
    }

    public JTextArea getTxtResultadoSintactico() {
        return TxtResultadoSintactico;
    }

    public void setTxtResultadoSintactico(JTextArea TxtResultadoSintactico) {
        this.TxtResultadoSintactico = TxtResultadoSintactico;
    }
    
    public JTextArea getTxtResultado() {
        return txtResultado;
    }
    
    public JTextArea getTxtCodigoFuente() {
        return TxtCodigoFuente;
    }
    
    public JButton getBtnSelectArchivo() {
        return BtnSelectArchivo;
    }

    public JButton getBtnSelectDestino() {
        return BtnSelectDestino;
    }

    public JLabel getLbRutaArchivoFuente() {
        return LbRutaArchivoFuente;
    }

    public JLabel getLbRutaDirectorioDestino() {
        return LbRutaDirectorioDestino;
    }

    public JButton getBtnAnalizar() {
        return btnAnalizar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnalizarSintaxis;
    private javax.swing.JButton BtnSelectArchivo;
    private javax.swing.JButton BtnSelectDestino;
    private javax.swing.JLabel LbRutaArchivoFuente;
    private javax.swing.JLabel LbRutaDirectorioDestino;
    private javax.swing.JTextArea TxtCodigoFuente;
    private javax.swing.JTextArea TxtResultadoSintactico;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
