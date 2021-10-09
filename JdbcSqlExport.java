package jdbcsqlexport;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;


public class JdbcSqlExport extends javax.swing.JFrame {

    boolean state = false;

    //Writing SQL Server, username and passeword to json file
    void config() throws IOException, JSONException {
        String path = new File("json.json").getCanonicalPath();
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        jsonObject.put("SQL_Server", SQL_Server.getText());
        jsonObject.put("User", User.getText());
        jsonObject.put("Password", Password.getText());
        jsonObject.put("Stanje", "true");

        try {
            FileWriter file = new FileWriter(path);
            file.write(jsonObject.toString());
            file.close();
        } catch (Exception e) {
          
            e.printStackTrace();
        }
    }
    //Reading SQL Server, username and passeword from json file
    void load() throws IOException, JSONException {
        String path = new File("json.json").getCanonicalPath();
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject obj = new JSONObject(jsonString);
        String SQL_Server_json = obj.getString("SQL_Server");
        String User_json = obj.getString("User");
        String Password_json = obj.getString("Password");
        JdbcSqlExport u = new JdbcSqlExport();
        SQL_Server.setText(obj.getString("SQL_Server"));
        User.setText(User_json);
        Password.setText(Password_json);
        System.out.println(SQL_Server_json + User_json + Password_json);
    }

    /**
     * Creates new form JdbcSqlExport
     */
    public JdbcSqlExport() {

        initComponents();

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SQL_Server = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SQL ");

        jLabel1.setText("SQL Server");

        jLabel2.setText("User");

        jLabel3.setText("Password");

        jButton2.setText("Export CSV");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("--Add SQL Query ");
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Open SQL Query");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Save Query");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Export XLS");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Export Table");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Run Query");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Load");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Save");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(604, 604, 604))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SQL_Server, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(User)
                            .addComponent(Password))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1))
                            .addComponent(jButton5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SQL_Server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        try {
            SQL_Server.setText(sqlServer());
        } catch (IOException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            User.setText(sqlUser());
        } catch (IOException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jCheckBox1.setSelected(stanje());
        } catch (IOException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        //Input fields
        
        String sqlServer = SQL_Server.getText();
        String user = User.getText();
        String password = Password.getText();
        String upit = jTextArea1.getText();
        File file = new File("");
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        Component modalToComponent = null;
        if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            
            file = new File(fileChooser.getSelectedFile().toString() + ".csv");
        }
        //Connection on SQL Server
        try {
            Writer fw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://" + sqlServer.trim() + ";databaseName=master;user=" + user.trim() + ";password=" + password + ";useUnicode=true;characterEncoding=UTF-8");
           
            String query = upit;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //Add header to CSV
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int y = 1; y <= columnCount; y++) {
                fw.append(rsmd.getColumnName(y));
                fw.append(',');

                //fw.append('\n');
            }
            //SQL query to CSV
            fw.append('\n');
            while (rs.next()) {

                for (int i = 1; i <= columnCount; i++) {

                    fw.append(rs.getString(i));
                    //System.out.println(rs.getString(i));
                    fw.append(',');
                }
                fw.append('\n');
            }

            fw.flush();

            fw.close();
            conn.close();
            //System.out.println("CSV File is created successfully.");
            Desktop desktop = Desktop.getDesktop();

            desktop.open(file);
        } catch (SQLServerException se) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Check connection or SQL Query.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException fe) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "No file or file is in use.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {

            e.printStackTrace();
    }//GEN-LAST:event_jButton2ActionPerformed
    }

    //Setting the path for the csv file
    public static void pathForCsv() {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }

    }

 
    //Read Sql Query from file
    public String readSqlQueryFromFile() {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());

        }
        File selectedFile = jfc.getSelectedFile();
        return selectedFile.getAbsolutePath();
    }
    
    //Load SQL Query from file
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jTextArea1.setText(citaj());
        } catch (IOException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //SaveSQL Query to file
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // save to file
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            Component modalToComponent = null;
            if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
                 File file = new File(fileChooser.getSelectedFile().toString() + ".sql");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(jTextArea1.getText());
                bw.close();
                System.out.println(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // String filename = Putanja.getText();
        String sqlServer = SQL_Server.getText();
        String user = User.getText();
        String password = Password.getText();
        String upit = jTextArea1.getText();
        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel panel = new JPanel();   //
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" + sqlServer.trim() + ";databaseName=master;user=" + user.trim() + ";password=" + password + ";useUnicode=true;characterEncoding=UTF-8");
            String sql = upit;
            Statement statement = con.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            resultSet.close();
            statement.close();

        } catch (SQLServerException se) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Check connection or SQL Query.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);

        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }

        File file = new File("");
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        Component modalToComponent = null;
        if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().toString() + ".xls");
        }
        toExcel(table, file);
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.open(file);

        } catch (FileNotFoundException fe) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "No file or file is in use.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {

            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    void toExcel(JTable table, File file) {
        try {
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }

            excel.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }

            excel.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    //Export SQL Query to jTable
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String sqlServer = SQL_Server.getText();
        String user = User.getText();
        String password = Password.getText();
        String upit = jTextArea1.getText();
        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel panel = new JPanel();   //
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" + sqlServer.trim() + ";databaseName=master;user=" + user.trim() + ";password=" + password + ";useUnicode=true;characterEncoding=UTF-8");
            String sql = upit;
            Statement statement = con.createStatement();
            statement.executeQuery(upit);
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            resultSet.close();
            statement.close();

        } catch (SQLServerException se) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Check connection or SQL Query.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);

        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }
        panel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 53, 927, 480);
        panel.add(scrollPane);
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);         //adding panel to the frame

        JLabel lblNewLabel = new JLabel("Table");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 11, 927, 31);
        panel.add(lblNewLabel);
        frame.setSize(963, 600); //setting frame size
        frame.setVisible(true);  //setting visibility true

        JButton Print = new JButton("Print");
        Print.setHorizontalAlignment(SwingConstants.CENTER);
        Print.setFont(new Font("Tahoma", Font.BOLD, 14));
        Print.setBounds(10, 11, 70, 31);
        panel.add(Print);
        frame.setSize(963, 600); //setting frame size
        frame.setVisible(true);  //setting visibility true

        Print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MessageFormat header = new MessageFormat("Page {0,number,integer}");
                try {
                    table.print(JTable.PrintMode.FIT_WIDTH, header, null);
                } catch (java.awt.print.PrinterException ep) {
                    System.err.format("Cannot print %s%n", ep.getMessage());
                }
            }
        });

    }//GEN-LAST:event_jButton8ActionPerformed

    //Run SQL Query 
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String sqlServer = SQL_Server.getText();
        String user = User.getText();
        String password = Password.getText();
        String upit = jTextArea1.getText();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlserver://" + sqlServer.trim() + ";databaseName=master;user=" + user.trim() + ";password=" + password + ";useUnicode=true;characterEncoding=UTF-8");
            String sql = upit;
            Statement statement = con.createStatement();
            statement.executeQuery(upit);
            statement.close();

        } catch (SQLServerException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_jButton9ActionPerformed
    //Save credentials to json file
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            config();
        } catch (IOException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    //Read credentials from json file
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            load();      
        } catch (IOException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    //Check box for save credentials
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        check();

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged

    }//GEN-LAST:event_jCheckBox1StateChanged

    //Mehtod for reading SQL Query from file
    public String citaj() throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(readSqlQueryFromFile()))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, JSONException {
      
        Thread t = new Thread(() -> {
            new JdbcSqlExport().setVisible(true);
            new JdbcSqlExport().jButton5.doClick(WIDTH);
 
        } 
        );
        t.start();

    }
    //creating json object for Sql Server
    static String sqlServer() throws IOException, JSONException {
        String path = new File("json.json").getCanonicalPath();
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject obj = new JSONObject(jsonString);
        String SQL_Server_json = obj.getString("SQL_Server");

        return SQL_Server_json;

    }
     //creating json object for user
    static String sqlUser() throws IOException, JSONException {
        String path = new File("json.json").getCanonicalPath();
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject obj = new JSONObject(jsonString);
        String User_json = obj.getString("User");

        return User_json;

    }
     //creating json object for password
    static String sqlPassword() throws IOException, JSONException {
        String path = new File("json.json").getCanonicalPath();
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject obj = new JSONObject(jsonString);
        String Password_json = obj.getString("Password");

        return Password_json;

    }
     //creating json object for state
    static boolean stanje() throws IOException, JSONException {
        String path = new File("json.json").getCanonicalPath();
        String jsonString = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject obj = new JSONObject(jsonString);
        String stanje = obj.getString("Stanje");

        return new Boolean(stanje);

    }
    //Method for check box
    void check() {

        if (jCheckBox1.isSelected()) {
            jCheckBox1.setSelected(true);
            try {
                config();
            } catch (IOException ex) {
                Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(JdbcSqlExport.class.getName()).log(Level.SEVERE, null, ex);
            }
            SQL_Server.setEnabled(false);
            User.setEnabled(false);
            Password.setEnabled(false);
        } else {
            SQL_Server.setEnabled(true);
            User.setEnabled(true);
            Password.setEnabled(true);
            jCheckBox1.setSelected(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField SQL_Server;
    private javax.swing.JTextField User;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
 
}
