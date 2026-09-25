
package compiladorjaime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author CYBERTRON
 */
public class compilador extends javax.swing.JFrame {

    LineNumberingTextArea numerolinea;
    
    public compilador() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
         numerolinea = new LineNumberingTextArea(textArea);
        jScrollPane4.setRowHeaderView(numerolinea);
        Guardar.setEnabled(false);
        CerrarProyecto.setEnabled(false);
        guardar.setEnabled(false);
        Copiar.setEnabled(false);
        Cortar.setEnabled(false);
        copiar.setEnabled(false);
        cortar.setEnabled(false);
        Pegar.setEnabled(false);
        Compilar.setEnabled(false);
        CompilarYCorrer.setEnabled(false);
        compilarYCorrer.setEnabled(false);
        compilar.setEnabled(false);
        pegar.setEnabled(false);
        
         JFrame frame = new JFrame("Compilador");
 
         
         botonnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Solicita el nombre del proyecto
                String nombreProyecto = JOptionPane.showInputDialog("Ingresa el nombre del nuevo proyecto:");
                if (nombreProyecto != null && !nombreProyecto.trim().isEmpty()) {
                    // Crea un nuevo JTextArea con numeración de líneas
                    JTextArea nuevoTextArea = new JTextArea();
                    LineNumberingTextArea nuevoNumerolinea = new LineNumberingTextArea(nuevoTextArea);
                    JScrollPane nuevoScrollPane = new JScrollPane(nuevoTextArea);
                    nuevoScrollPane.setRowHeaderView(nuevoNumerolinea);
                    
                    nuevoTextArea.setComponentPopupMenu(jPopupMenu1); 
 
                    // Añade la pestaña con el nombre del proyecto
                    tabpane.addTab(nombreProyecto, nuevoScrollPane);
 
                    // Actualiza la numeración de filas y columnas en el nuevo proyecto
                    nuevoTextArea.addCaretListener(new javax.swing.event.CaretListener() {
                        public void caretUpdate(javax.swing.event.CaretEvent e) {
                            int caretPos = nuevoTextArea.getCaretPosition();
                            try {
                                // Calcula el renglón y añade 1
                                int row = nuevoTextArea.getLineOfOffset(caretPos) + 1;
                                // Calcula la columna y añade 1
                                int col = caretPos - nuevoTextArea.getLineStartOffset(row - 1) + 1;
                                statusLabel.setText("Columna: " + col + ", Renglón: " + row);
                            } catch (javax.swing.text.BadLocationException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    
                    nuevoTextArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                        @Override
                        public void insertUpdate(javax.swing.event.DocumentEvent e) {
                            habilitarGuardar();
                        }

                        @Override
                        public void removeUpdate(javax.swing.event.DocumentEvent e) {
                            habilitarGuardar();
                        }

                        @Override
                        public void changedUpdate(javax.swing.event.DocumentEvent e) {
                            habilitarGuardar();
                        }
                    });
                    
                      /*nuevoTextArea.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            if (e.isPopupTrigger()) {
                                jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                            }
                        }
                        public void mouseReleased(MouseEvent e) {
                            if (e.isPopupTrigger()) {
                                jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                            }
                        }
                      });*/
                }
            }
        });
         
         nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Solicita el nombre del proyecto
                String nombreProyecto = JOptionPane.showInputDialog("Ingresa el nombre del nuevo proyecto:");
                if (nombreProyecto != null && !nombreProyecto.trim().isEmpty()) {
                    // Crea un nuevo JTextArea con numeración de líneas
                    JTextArea nuevoTextArea = new JTextArea();
                    LineNumberingTextArea nuevoNumerolinea = new LineNumberingTextArea(nuevoTextArea);
                    JScrollPane nuevoScrollPane = new JScrollPane(nuevoTextArea);
                    nuevoScrollPane.setRowHeaderView(nuevoNumerolinea);
                    
                    nuevoTextArea.setComponentPopupMenu(jPopupMenu1);
 
                    // Añade la pestaña con el nombre del proyecto
                    tabpane.addTab(nombreProyecto, nuevoScrollPane);
 
                    // Actualiza la numeración de filas y columnas en el nuevo proyecto
                    nuevoTextArea.addCaretListener(new javax.swing.event.CaretListener() {
                        public void caretUpdate(javax.swing.event.CaretEvent e) {
                            int caretPos = nuevoTextArea.getCaretPosition();
                            try {
                                // Calcula el renglón y añade 1
                                int row = nuevoTextArea.getLineOfOffset(caretPos) + 1;
                                // Calcula la columna y añade 1
                                int col = caretPos - nuevoTextArea.getLineStartOffset(row - 1) + 1;
                                statusLabel.setText("Columna: " + col + ", Renglón: " + row);
                            } catch (javax.swing.text.BadLocationException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    
                    nuevoTextArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                        @Override
                        public void insertUpdate(javax.swing.event.DocumentEvent e) {
                            habilitarGuardar();
                        }

                        @Override
                        public void removeUpdate(javax.swing.event.DocumentEvent e) {
                            habilitarGuardar();
                        }

                        @Override
                        public void changedUpdate(javax.swing.event.DocumentEvent e) {
                            habilitarGuardar();
                        }
                    });
                    
                     /* nuevoTextArea.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            if (e.isPopupTrigger()) {
                                jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                            }
                        }
                        public void mouseReleased(MouseEvent e) {
                            if (e.isPopupTrigger()) {
                                jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                            }
                        }
                      });*/
                }
            }
        });
         
         
        Timer timer = new Timer(1000, e -> actualizarHora());
        timer.start(); // Iniciar el Timer
        
    }
    
    private void actualizarHora() {
        // Formatear la hora
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String horaActual = sdf.format(new Date());

        // Asignar la hora actual al JLabel
        labelhora.setText("Hora Local-> "+horaActual); // Asegúrate de que labelHora sea el nombre correcto
    }
    
    
    private void habilitarGuardar() {
    Guardar.setEnabled(true); // Habilitar el botón Guardar
    guardar.setEnabled(true); // Habilitar el menú Guardar
    CerrarProyecto.setEnabled(true); // Habilitar el menú Guardar
    Copiar.setEnabled(true);
    Cortar.setEnabled(true);
    Pegar.setEnabled(true);
    pegar.setEnabled(true);
    copiar.setEnabled(true);
    cortar.setEnabled(true);
    compilar.setEnabled(true);
    Compilar.setEnabled(true);
    CompilarYCorrer.setEnabled(true);
    compilarYCorrer.setEnabled(true);
    
    
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        botonnuevo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        GuardartodoB = new javax.swing.JButton();
        copiar = new javax.swing.JButton();
        cortar = new javax.swing.JButton();
        pegar = new javax.swing.JButton();
        compilarYCorrer = new javax.swing.JButton();
        compilar = new javax.swing.JButton();
        DeshacerB = new javax.swing.JButton();
        RehacerB = new javax.swing.JButton();
        ComentarDescomentarB = new javax.swing.JButton();
        tabpane = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        labelhora = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        Guardartodo = new javax.swing.JMenuItem();
        CerrarProyecto1 = new javax.swing.JMenuItem();
        CerrarProyecto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Copiar = new javax.swing.JMenuItem();
        Cortar = new javax.swing.JMenuItem();
        Pegar = new javax.swing.JMenuItem();
        Deshacer = new javax.swing.JMenuItem();
        Rehacer = new javax.swing.JMenuItem();
        ComentarDescomentar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Compilar = new javax.swing.JMenuItem();
        CompilarYCorrer = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Compilar1 = new javax.swing.JMenuItem();
        CompilarYCorrer1 = new javax.swing.JMenuItem();

        jMenuItem5.setText("Copiar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        jMenuItem12.setText("Cortar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem12);

        jMenuItem13.setText("Pegar");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem13);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CompiladorLC");

        jToolBar1.setRollover(true);

        botonnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/newdocument.png"))); // NOI18N
        botonnuevo.setFocusable(false);
        botonnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonnuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(botonnuevo);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/file.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/savetwo.png"))); // NOI18N
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);

        GuardartodoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar_todo.png"))); // NOI18N
        GuardartodoB.setFocusable(false);
        GuardartodoB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GuardartodoB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        GuardartodoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardartodoBActionPerformed(evt);
            }
        });
        jToolBar1.add(GuardartodoB);

        copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/documents.png"))); // NOI18N
        copiar.setToolTipText("");
        copiar.setFocusable(false);
        copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(copiar);

        cortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tijeras.png"))); // NOI18N
        cortar.setFocusable(false);
        cortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cortar);

        pegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tabla.png"))); // NOI18N
        pegar.setFocusable(false);
        pegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pegar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(pegar);

        compilarYCorrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/engrajes.png"))); // NOI18N
        compilarYCorrer.setFocusable(false);
        compilarYCorrer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        compilarYCorrer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(compilarYCorrer);

        compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play.png"))); // NOI18N
        compilar.setFocusable(false);
        compilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        compilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(compilar);

        DeshacerB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/deshacer.png"))); // NOI18N
        DeshacerB.setActionCommand("Deshacer");
        DeshacerB.setFocusable(false);
        DeshacerB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeshacerB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DeshacerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeshacerBActionPerformed(evt);
            }
        });
        jToolBar1.add(DeshacerB);

        RehacerB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rehacer.png"))); // NOI18N
        RehacerB.setFocusable(false);
        RehacerB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RehacerB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RehacerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RehacerBActionPerformed(evt);
            }
        });
        jToolBar1.add(RehacerB);

        ComentarDescomentarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/comentar.png"))); // NOI18N
        ComentarDescomentarB.setFocusable(false);
        ComentarDescomentarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ComentarDescomentarB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ComentarDescomentarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComentarDescomentarBActionPerformed(evt);
            }
        });
        jToolBar1.add(ComentarDescomentarB);

        textArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent e) {
                int caretPos = textArea.getCaretPosition();
                try {
                    // Calcula el renglón y añade 1 para que empiece desde 1 en lugar de 0
                    int row = textArea.getLineOfOffset(caretPos) + 1;

                    // Calcula la columna y añade 1 para que empiece desde 1 en lugar de 0
                    int col = caretPos - textArea.getLineStartOffset(row - 1) + 1;

                    // Actualiza el JLabel con los valores de renglón y columna
                    statusLabel.setText("Columna: " + col + ", Renglón: " + row);
                } catch (javax.swing.text.BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        });
        textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                habilitarGuardar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                habilitarGuardar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                habilitarGuardar();
            }
        });
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textAreaMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(textArea);

        tabpane.addTab("--Proyecto--", jScrollPane4);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jTabbedPane5.addTab("--Resultados de Compilacion--", jScrollPane3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Token", "Lexema", "Region, Columna"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("--Tabla de Tokens--", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Identificador", "Tipo de Dato", "Valor"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("--Tabla de Simbolos--", jPanel2);

        jMenu1.setText("Archivo");

        nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevo);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Abrir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        Guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jMenu1.add(Guardar);

        Guardartodo.setText("Guardar todo");
        Guardartodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardartodo1ActionPerformed(evt);
            }
        });
        jMenu1.add(Guardartodo);

        CerrarProyecto1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CerrarProyecto1.setText("Guardar como");
        CerrarProyecto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarProyecto1ActionPerformed(evt);
            }
        });
        jMenu1.add(CerrarProyecto1);

        CerrarProyecto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        CerrarProyecto.setText("Cerrra Proyecto");
        CerrarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarProyectoActionPerformed(evt);
            }
        });
        jMenu1.add(CerrarProyecto);
        jMenu1.add(jSeparator1);

        jMenuItem11.setText("Salir");
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        Copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Copiar.setText("Copiar");
        Copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarActionPerformed(evt);
            }
        });
        jMenu2.add(Copiar);

        Cortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Cortar.setText("Cortar");
        jMenu2.add(Cortar);

        Pegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Pegar.setText("Pegar");
        Pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegarActionPerformed(evt);
            }
        });
        jMenu2.add(Pegar);

        Deshacer.setText("Deshacer");
        Deshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeshacerActionPerformed(evt);
            }
        });
        jMenu2.add(Deshacer);

        Rehacer.setText("Rehacer");
        Rehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RehacerActionPerformed(evt);
            }
        });
        jMenu2.add(Rehacer);

        ComentarDescomentar.setText("Comentar/Descomentar");
        ComentarDescomentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComentarDescomentarActionPerformed(evt);
            }
        });
        jMenu2.add(ComentarDescomentar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Compilar");

        Compilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        Compilar.setText("Compilar");
        jMenu3.add(Compilar);

        CompilarYCorrer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        CompilarYCorrer.setText("Compilar y Correr");
        jMenu3.add(CompilarYCorrer);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Herramientas");

        Compilar1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        Compilar1.setText("Cambiar tema");
        jMenu4.add(Compilar1);

        CompilarYCorrer1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        CompilarYCorrer1.setText("Cambiar fuente");
        CompilarYCorrer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompilarYCorrer1ActionPerformed(evt);
            }
        });
        jMenu4.add(CompilarYCorrer1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelhora, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                                    .addComponent(jTabbedPane5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTabbedPane2)
                                    .addComponent(jTabbedPane1))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(tabpane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2)
                        .addGap(17, 17, 17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(labelhora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textAreaMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) {
        jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    }//GEN-LAST:event_textAreaMouseReleased

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(true);
        CerrarProyecto.setEnabled(true);
        guardar.setEnabled(true);
        Copiar.setEnabled(true);
        Cortar.setEnabled(true);
        Pegar.setEnabled(true);
        pegar.setEnabled(true);
        copiar.setEnabled(true);
        cortar.setEnabled(true);
        Compilar.setEnabled(true);
        CompilarYCorrer.setEnabled(true);
        compilar.setEnabled(true);
        compilarYCorrer.setEnabled(true);
        
        
    }//GEN-LAST:event_nuevoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(true);
        CerrarProyecto.setEnabled(true);
        guardar.setEnabled(true);
        Copiar.setEnabled(true);
        Cortar.setEnabled(true);
        Pegar.setEnabled(true);
        pegar.setEnabled(true);
        copiar.setEnabled(true);
        cortar.setEnabled(true);
        Compilar.setEnabled(true);
        CompilarYCorrer.setEnabled(true);
        compilarYCorrer.setEnabled(true);
        compilar.setEnabled(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(false);
        guardar.setEnabled(false);
    }//GEN-LAST:event_GuardarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(false);
        guardar.setEnabled(false);
    }//GEN-LAST:event_guardarActionPerformed

    private void botonnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonnuevoActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(true);
        CerrarProyecto.setEnabled(true);
        guardar.setEnabled(true);
        Copiar.setEnabled(true);
        Cortar.setEnabled(true);
        Pegar.setEnabled(true);
        pegar.setEnabled(true);
        copiar.setEnabled(true);
        cortar.setEnabled(true);
        Compilar.setEnabled(true);
        CompilarYCorrer.setEnabled(true);
        compilarYCorrer.setEnabled(true);
        compilar.setEnabled(true);
    }//GEN-LAST:event_botonnuevoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(true);
        CerrarProyecto.setEnabled(true);
        guardar.setEnabled(true);
        Copiar.setEnabled(true);
        Cortar.setEnabled(true);
        Pegar.setEnabled(true);
        pegar.setEnabled(true);
        copiar.setEnabled(true);
        cortar.setEnabled(true);
        Compilar.setEnabled(true);
        CompilarYCorrer.setEnabled(true);
        compilar.setEnabled(true);
        compilarYCorrer.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CerrarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarProyectoActionPerformed
        // TODO add your handling code here:
        Guardar.setEnabled(false);
        CerrarProyecto.setEnabled(false);
        guardar.setEnabled(false);
        Copiar.setEnabled(false);
        Cortar.setEnabled(false);
        Pegar.setEnabled(false);
        pegar.setEnabled(false);
        copiar.setEnabled(false);
        cortar.setEnabled(false);
        Compilar.setEnabled(false);
        CompilarYCorrer.setEnabled(false);
        compilarYCorrer.setEnabled(false);
        compilar.setEnabled(false);
    }//GEN-LAST:event_CerrarProyectoActionPerformed

    private void CopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CopiarActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //textArea.copy();
        JTextArea textArea = (JTextArea) jPopupMenu1.getInvoker(); // Obtener el JTextArea asociado
        textArea.copy(); // Copiar el texto seleccionado
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        //textArea.cut();
        JTextArea textArea = (JTextArea) jPopupMenu1.getInvoker(); // Obtener el JTextArea asociado
        textArea.cut(); // Cortar el texto seleccionado
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        //textArea.paste();
        JTextArea textArea = (JTextArea) jPopupMenu1.getInvoker(); // Obtener el JTextArea asociado
        textArea.paste(); // Pegar el texto del portapapeles
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void CompilarYCorrer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompilarYCorrer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompilarYCorrer1ActionPerformed

    private void CerrarProyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarProyecto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CerrarProyecto1ActionPerformed

    private void Guardartodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardartodo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Guardartodo1ActionPerformed

    private void DeshacerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeshacerBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeshacerBActionPerformed

    private void PegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PegarActionPerformed

    private void DeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeshacerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeshacerActionPerformed

    private void RehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RehacerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RehacerActionPerformed

    private void ComentarDescomentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComentarDescomentarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComentarDescomentarActionPerformed

    private void RehacerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RehacerBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RehacerBActionPerformed

    private void GuardartodoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardartodoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardartodoBActionPerformed

    private void ComentarDescomentarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComentarDescomentarBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComentarDescomentarBActionPerformed

   
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
            java.util.logging.Logger.getLogger(compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CerrarProyecto;
    private javax.swing.JMenuItem CerrarProyecto1;
    private javax.swing.JMenuItem ComentarDescomentar;
    private javax.swing.JButton ComentarDescomentarB;
    private javax.swing.JMenuItem Compilar;
    private javax.swing.JMenuItem Compilar1;
    private javax.swing.JMenuItem CompilarYCorrer;
    private javax.swing.JMenuItem CompilarYCorrer1;
    private javax.swing.JMenuItem Copiar;
    private javax.swing.JMenuItem Cortar;
    private javax.swing.JMenuItem Deshacer;
    private javax.swing.JButton DeshacerB;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem Guardartodo;
    private javax.swing.JButton GuardartodoB;
    private javax.swing.JMenuItem Pegar;
    private javax.swing.JMenuItem Rehacer;
    private javax.swing.JButton RehacerB;
    private javax.swing.JButton botonnuevo;
    private javax.swing.JButton compilar;
    private javax.swing.JButton compilarYCorrer;
    private javax.swing.JButton copiar;
    private javax.swing.JButton cortar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelhora;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JButton pegar;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTabbedPane tabpane;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
