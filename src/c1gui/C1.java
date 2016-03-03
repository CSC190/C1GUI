/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1gui;

import static c1gui.Panel1.HourA;
import static c1gui.Panel1.MinuteA;
import static c1gui.Panel1.SecondsA;
import java.awt.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Long;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.write.*;
import jxl.write.Number;

import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author Alex
 */
public class C1 extends javax.swing.JFrame {

    FileWriter dir;
    FileWriter writer;
    static Connection conn;
    private double timeA, timeB;
    BufferedWriter buff;
    static int timeElap[] = new int[30000];
    static String eventBox[] = new String[30000];
    String [] lineList = new String[160000];
    String [] set = new String[160000];
    String chipNum;
    int [] cNum = new int[160000];
    String channel;
    int [] cChan = new int[160000];
    String status;
    int [] cstatus = new int[160000];
    String time;
    int [] milli = new int[160000];
    int [] hour = new int[160000];
    int [] numTick = new int[160000]; 
    int [] min = new int[160000];
    int [] sec = new int[160000];
    int [] milliTimer = new int[160000];
    long [] unix = new long[160000];
    
    
    /**
     * Creates new form C1
     */
    public C1() {
        initComponents();
    
    }
    
    private static Connection connect() {
        if (conn == null)
        {
            String url = "jdbc:mysql://10.160.32.61:3306/BCMS";
            String dbName = "BCMS";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, userName, password);
                System.out.println("Connected to " + dbName + " with " + userName);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } 
        }
        return conn;
    }
    
       
    public void getAddressPort()
    {
        String temp;
        
        if ( (String)panel1.Log170_1.getSelectedItem() != "Channel"  )
        {
            temp = panel1.jLabel9.getText();
            panel1.log170Channel[panel1.Log170_1.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_2.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel10.getText();
            panel1.log170Channel[panel1.Log170_2.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_3.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel11.getText();
            panel1.log170Channel[panel1.Log170_3.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_4.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel12.getText();
            panel1.log170Channel[panel1.Log170_4.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_5.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel13.getText();
            panel1.log170Channel[panel1.Log170_5.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_6.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel14.getText();
            panel1.log170Channel[panel1.Log170_6.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_7.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel15.getText();
            panel1.log170Channel[panel1.Log170_7.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_8.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel16.getText();
            panel1.log170Channel[panel1.Log170_8.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_9.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel17.getText();
            panel1.log170Channel[panel1.Log170_9.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_10.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel18.getText();
            panel1.log170Channel[panel1.Log170_10.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_11.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel19.getText();
            panel1.log170Channel[panel1.Log170_11.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_12.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel20.getText();
            panel1.log170Channel[panel1.Log170_12.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_13.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel21.getText();
            panel1.log170Channel[panel1.Log170_13.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_14.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel8.getText();
            panel1.log170Channel[panel1.Log170_14.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_15.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel22.getText();
            panel1.log170Channel[panel1.Log170_15.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_16.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel23.getText();
            panel1.log170Channel[panel1.Log170_16.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_17.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel24.getText();
            panel1.log170Channel[panel1.Log170_17.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_18.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel25.getText();
            panel1.log170Channel[panel1.Log170_18.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_19.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel26.getText();
            panel1.log170Channel[panel1.Log170_19.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_20.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel27.getText();
            panel1.log170Channel[panel1.Log170_20.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_21.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel28.getText();
            panel1.log170Channel[panel1.Log170_21.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_22.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel29.getText();
            panel1.log170Channel[panel1.Log170_22.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_23.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel30.getText();
            panel1.log170Channel[panel1.Log170_23.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_24.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel31.getText();
            panel1.log170Channel[panel1.Log170_24.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_25.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel32.getText();
            panel1.log170Channel[panel1.Log170_25.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_26.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel33.getText();
            panel1.log170Channel[panel1.Log170_26.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_27.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel34.getText();
            panel1.log170Channel[panel1.Log170_27.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_28.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel35.getText();
            panel1.log170Channel[panel1.Log170_28.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_29.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel36.getText();
            panel1.log170Channel[panel1.Log170_29.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_30.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel37.getText();
            panel1.log170Channel[panel1.Log170_30.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_31.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel38.getText();
            panel1.log170Channel[panel1.Log170_31.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_32.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel39.getText();
            panel1.log170Channel[panel1.Log170_32.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_33.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel40.getText();
            panel1.log170Channel[panel1.Log170_33.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_34.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel41.getText();
            panel1.log170Channel[panel1.Log170_34.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_35.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel42.getText();
            panel1.log170Channel[panel1.Log170_35.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_36.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel43.getText();
            panel1.log170Channel[panel1.Log170_36.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_37.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel44.getText();
            panel1.log170Channel[panel1.Log170_37.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_38.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel45.getText();
            panel1.log170Channel[panel1.Log170_38.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_39.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel46.getText();
            panel1.log170Channel[panel1.Log170_39.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel1.Log170_40.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel1.jLabel47.getText();
            panel1.log170Channel[panel1.Log170_40.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_41.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel48.getText();
            panel1.log170Channel[panel2.Log170_41.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_42.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel49.getText();
            panel1.log170Channel[panel2.Log170_42.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_43.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel50.getText();
            panel1.log170Channel[panel2.Log170_43.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_44.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel51.getText();
            panel1.log170Channel[panel2.Log170_44.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_45.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel52.getText();
            panel1.log170Channel[panel2.Log170_45.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_46.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel53.getText();
            panel1.log170Channel[panel2.Log170_46.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_47.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel54.getText();
            panel1.log170Channel[panel2.Log170_47.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_48.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel55.getText();
            panel1.log170Channel[panel2.Log170_48.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_49.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel56.getText();
            panel1.log170Channel[panel2.Log170_49.getSelectedIndex()-1] = temp;
            System.out.println("we got 49 at index " + (panel2.Log170_49.getSelectedIndex()-1) + "!");
        }
        
        if ( (String)panel2.Log170_50.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel57.getText();
            panel1.log170Channel[panel2.Log170_50.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_51.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel58.getText();
            panel1.log170Channel[panel2.Log170_51.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_52.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel59.getText();
            panel1.log170Channel[panel2.Log170_52.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_53.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel60.getText();
            panel1.log170Channel[panel2.Log170_53.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_54.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel61.getText();
            panel1.log170Channel[panel2.Log170_54.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_55.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel62.getText();
            panel1.log170Channel[panel2.Log170_55.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_56.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel63.getText();
            panel1.log170Channel[panel2.Log170_56.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_57.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel64.getText();
            panel1.log170Channel[panel2.Log170_57.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_58.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel65.getText();
            panel1.log170Channel[panel2.Log170_58.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_59.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel66.getText();
            panel1.log170Channel[panel2.Log170_59.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_60.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel67.getText();
            panel1.log170Channel[panel2.Log170_60.getSelectedIndex()-1] = temp;
            System.out.println("we got 60 at index " + (panel2.Log170_60.getSelectedIndex()-1) + "!");
        }
        
        if ( (String)panel2.Log170_61.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel68.getText();
            panel1.log170Channel[panel2.Log170_61.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_62.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel69.getText();
            panel1.log170Channel[panel2.Log170_62.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_63.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel70.getText();
            panel1.log170Channel[panel2.Log170_63.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_64.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel71.getText();
            panel1.log170Channel[panel2.Log170_64.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_65.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel72.getText();
            panel1.log170Channel[panel2.Log170_65.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_66.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel73.getText();
            panel1.log170Channel[panel2.Log170_66.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_67.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel74.getText();
            panel1.log170Channel[panel2.Log170_67.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_68.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel75.getText();
            panel1.log170Channel[panel2.Log170_68.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_69.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel76.getText();
            panel1.log170Channel[panel2.Log170_69.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_70.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel77.getText();
            panel1.log170Channel[panel2.Log170_70.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_71.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel78.getText();
            panel1.log170Channel[panel2.Log170_71.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_72.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel79.getText();
            panel1.log170Channel[panel2.Log170_72.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_73.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel80.getText();
            panel1.log170Channel[panel2.Log170_73.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_74.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel81.getText();
            panel1.log170Channel[panel2.Log170_74.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_75.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel82.getText();
            panel1.log170Channel[panel2.Log170_75.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_76.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel83.getText();
            panel1.log170Channel[panel2.Log170_76.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_77.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel84.getText();
            panel1.log170Channel[panel2.Log170_77.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_78.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel85.getText();
            panel1.log170Channel[panel2.Log170_78.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_79.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel86.getText();
            panel1.log170Channel[panel2.Log170_79.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_80.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel87.getText();
            panel1.log170Channel[panel2.Log170_80.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_81.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel88.getText();
            panel1.log170Channel[panel2.Log170_81.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_82.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel89.getText();
            panel1.log170Channel[panel2.Log170_82.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_83.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel90.getText();
            panel1.log170Channel[panel2.Log170_83.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_84.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel91.getText();
            panel1.log170Channel[panel2.Log170_84.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_85.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel92.getText();
            panel1.log170Channel[panel2.Log170_85.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_86.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel93.getText();
            panel1.log170Channel[panel2.Log170_86.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_87.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel94.getText();
            panel1.log170Channel[panel2.Log170_87.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_88.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel95.getText();
            panel1.log170Channel[panel2.Log170_88.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_89.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel96.getText();
            panel1.log170Channel[panel2.Log170_89.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_90.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel97.getText();
            panel1.log170Channel[panel2.Log170_90.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_91.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel98.getText();
            panel1.log170Channel[panel2.Log170_91.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_92.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel99.getText();
            panel1.log170Channel[panel2.Log170_92.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_93.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel100.getText();
            panel1.log170Channel[panel2.Log170_93.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_94.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel101.getText();
            panel1.log170Channel[panel2.Log170_94.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_95.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel108.getText();
            panel1.log170Channel[panel2.Log170_95.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_96.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel103.getText();
            panel1.log170Channel[panel2.Log170_96.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_97.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel104.getText();
            panel1.log170Channel[panel2.Log170_97.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel2.Log170_98.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel105.getText();
            panel1.log170Channel[panel2.Log170_98.getSelectedIndex()-1] = temp;
            System.out.println("we got 98 at index " + (panel2.Log170_98.getSelectedIndex()-1) + "!");
        }
        
        if ( (String)panel2.Log170_99.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel106.getText();
            panel1.log170Channel[panel2.Log170_99.getSelectedIndex()-1] = temp;
            System.out.println("we got 99 at index " + (panel2.Log170_99.getSelectedIndex()-1) +  "!");
        }
        
        if ( (String)panel2.Log170_100.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel2.jLabel107.getText();
            panel1.log170Channel[panel2.Log170_100.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_101.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel108.getText();
            panel1.log170Channel[panel3.Log170_101.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_102.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel109.getText();
            panel1.log170Channel[panel3.Log170_102.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_103.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel110.getText();
            panel1.log170Channel[panel3.Log170_103.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_104.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel111.getText();
            panel1.log170Channel[panel3.Log170_104.getSelectedIndex()-1] = temp;
        }
            
        if ( (String)panel3.Log170_105.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel112.getText();
            panel1.log170Channel[panel3.Log170_105.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_106.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel113.getText();
            panel1.log170Channel[panel3.Log170_106.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_107.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel114.getText();
            panel1.log170Channel[panel3.Log170_107.getSelectedIndex()-1] = temp;
        }
    
        if ( (String)panel3.Log170_108.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel115.getText();
            panel1.log170Channel[panel3.Log170_108.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_109.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel116.getText();
            panel1.log170Channel[panel3.Log170_109.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_110.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel117.getText();
            panel1.log170Channel[panel3.Log170_110.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_111.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel118.getText();
            panel1.log170Channel[panel3.Log170_111.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_112.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel119.getText();
            panel1.log170Channel[panel3.Log170_112.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_113.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel120.getText();
            panel1.log170Channel[panel3.Log170_113.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_114.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel121.getText();
            panel1.log170Channel[panel3.Log170_114.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_115.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel122.getText();
            panel1.log170Channel[panel3.Log170_115.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_116.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel123.getText();
            panel1.log170Channel[panel3.Log170_116.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_117.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel124.getText();
            panel1.log170Channel[panel3.Log170_117.getSelectedIndex()-1] = temp;
        }
    
        if ( (String)panel3.Log170_118.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel125.getText();
            panel1.log170Channel[panel3.Log170_118.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_119.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel126.getText();
            panel1.log170Channel[panel3.Log170_119.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_120.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel127.getText();
            panel1.log170Channel[panel3.Log170_120.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_121.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel128.getText();
            panel1.log170Channel[panel3.Log170_121.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_122.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel129.getText();
            panel1.log170Channel[panel3.Log170_122.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_123.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel130.getText();
            panel1.log170Channel[panel3.Log170_123.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_124.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel131.getText();
            panel1.log170Channel[panel3.Log170_124.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_125.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel132.getText();
            panel1.log170Channel[panel3.Log170_125.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_126.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel133.getText();
            panel1.log170Channel[panel3.Log170_126.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_127.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel134.getText();
            panel1.log170Channel[panel3.Log170_127.getSelectedIndex()-1] = temp;
        }
    
        if ( (String)panel3.Log170_128.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel135.getText();
            panel1.log170Channel[panel3.Log170_128.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_129.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel136.getText();
            panel1.log170Channel[panel3.Log170_129.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_130.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel137.getText();
            panel1.log170Channel[panel3.Log170_130.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_131.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel138.getText();
            panel1.log170Channel[panel3.Log170_131.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_132.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel139.getText();
            panel1.log170Channel[panel3.Log170_132.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_133.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel140.getText();
            panel1.log170Channel[panel3.Log170_133.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_134.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel141.getText();
            panel1.log170Channel[panel3.Log170_134.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_135.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel142.getText();
            panel1.log170Channel[panel3.Log170_135.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_136.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel143.getText();
            panel1.log170Channel[panel3.Log170_136.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_137.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel144.getText();
            panel1.log170Channel[panel3.Log170_137.getSelectedIndex()-1] = temp;
        }
    
        if ( (String)panel3.Log170_138.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel145.getText();
            panel1.log170Channel[panel3.Log170_138.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_139.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel146.getText();
            panel1.log170Channel[panel3.Log170_139.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_140.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel147.getText();
            panel1.log170Channel[panel3.Log170_140.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_141.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel148.getText();
            panel1.log170Channel[panel3.Log170_141.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_142.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel149.getText();
            panel1.log170Channel[panel3.Log170_142.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_143.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel150.getText();
            panel1.log170Channel[panel3.Log170_143.getSelectedIndex()-1] = temp;
        }
        
        if ( (String)panel3.Log170_144.getSelectedItem() != "Channel"  )
        {
            temp = (String)panel3.jLabel111.getText();
            panel1.log170Channel[panel3.Log170_104.getSelectedIndex()-1] = temp;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelCard = new javax.swing.JPanel();
        panel1 = new c1gui.Panel1();
        panel2 = new c1gui.Panel2();
        panel3 = new c1gui.Panel3();
        tabbedPanel1 = new c1gui.TabbedPanel1();
        jPanel2 = new javax.swing.JPanel();
        Volume = new javax.swing.JButton();
        Occupancy = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Page1 = new javax.swing.JButton();
        Page2 = new javax.swing.JButton();
        Page3 = new javax.swing.JButton();
        Upload = new javax.swing.JButton();
        DirBrowse = new javax.swing.JTextField();
        Model = new javax.swing.JComboBox();
        Generate = new javax.swing.JButton();
        ReadFile = new javax.swing.JButton();
        sync_db = new javax.swing.JButton();
        headway = new javax.swing.JButton();
        length = new javax.swing.JButton();
        adjust = new javax.swing.JButton();
        factorTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1150, 1000));
        setMaximumSize(new java.awt.Dimension(1200, 1100));
        setMinimumSize(new java.awt.Dimension(1150, 1000));
        setPreferredSize(new java.awt.Dimension(1150, 1000));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0};
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {1.0};
        getContentPane().setLayout(layout);

        PanelCard.setMaximumSize(new java.awt.Dimension(8647, 8647));
        PanelCard.setMinimumSize(new java.awt.Dimension(1200, 750));
        PanelCard.setPreferredSize(new java.awt.Dimension(1200, 750));
        PanelCard.setRequestFocusEnabled(false);
        PanelCard.setLayout(new java.awt.CardLayout());

        panel1.setMaximumSize(new java.awt.Dimension(8767, 8767));
        panel1.setMinimumSize(new java.awt.Dimension(1150, 700));
        panel1.setName(""); // NOI18N
        panel1.setPreferredSize(new java.awt.Dimension(1150, 700));
        PanelCard.add(panel1, "Panel 1");
        PanelCard.add(panel2, "Panel 2");

        panel3.setMinimumSize(new java.awt.Dimension(935, 550));
        PanelCard.add(panel3, "Panel 3");

        javax.swing.GroupLayout tabbedPanel1Layout = new javax.swing.GroupLayout(tabbedPanel1);
        tabbedPanel1.setLayout(tabbedPanel1Layout);
        tabbedPanel1Layout.setHorizontalGroup(
            tabbedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        tabbedPanel1Layout.setVerticalGroup(
            tabbedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        PanelCard.add(tabbedPanel1, "Panel 4");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(PanelCard, gridBagConstraints);

        jPanel2.setMaximumSize(new java.awt.Dimension(8767, 8767));
        jPanel2.setMinimumSize(new java.awt.Dimension(1150, 300));

        Volume.setText("Volume");
        Volume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolumeActionPerformed(evt);
            }
        });

        Occupancy.setText("Occupancy");
        Occupancy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccupancyActionPerformed(evt);
            }
        });

        jButton6.setText("Speed");

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Page1.setText("Page1");
        Page1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Page1ActionPerformed(evt);
            }
        });

        Page2.setText("Page 2");
        Page2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Page2ActionPerformed(evt);
            }
        });

        Page3.setText("Page 3");
        Page3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Page3ActionPerformed(evt);
            }
        });

        Upload.setText("Upload");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        Model.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "332", "333", "334" }));
        Model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelActionPerformed(evt);
            }
        });

        Generate.setText("Generate");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });

        ReadFile.setText("ReadFile");
        ReadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadFileActionPerformed(evt);
            }
        });

        sync_db.setText("Sync DB");
        sync_db.setActionCommand("sync_db");
        sync_db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sync_dbActionPerformed(evt);
            }
        });

        headway.setLabel("Headway");
        headway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headwayActionPerformed(evt);
            }
        });

        length.setText("Length");

        adjust.setText("Adjust");
        adjust.setToolTipText("what does this do?");
        adjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustActionPerformed(evt);
            }
        });

        factorTextField.setToolTipText("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fudge Factor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DirBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Generate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(ReadFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sync_db, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(Volume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(factorTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Occupancy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(headway, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(length, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                            .addComponent(adjust, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Page2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Page3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Page1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Page1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Upload)
                                    .addComponent(DirBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Generate)
                                .addComponent(Volume)
                                .addComponent(Occupancy)
                                .addComponent(jButton6))
                            .addComponent(Page2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ReadFile)
                                    .addComponent(sync_db)
                                    .addComponent(headway)
                                    .addComponent(length)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Page3))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Save)
                            .addComponent(Clear))))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adjust)
                    .addComponent(factorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void VolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolumeActionPerformed
        timeA = panel1.getUnixTimeA();                  // User selection of Time A represented in Unix timestamp in milliseconds
        timeB = panel1.getUnixTimeB();                  // User selection of Time B represented in Unix timestamp in milliseconds
        conn = connect();                               // Connects to database
        getAddressPort();                               // Assigns C1 pins to selected channels
        int eventCount = 0;                             // Counter for number of events
        int rangeA = (Integer.parseInt((String)panel1.HourA.getSelectedItem())*60) + Integer.parseInt((String)panel1.MinuteA.getSelectedItem());
        int rangeB = (Integer.parseInt((String)panel1.HourB.getSelectedItem())*60) + Integer.parseInt((String)panel1.MinuteB.getSelectedItem());
        int selMin = Integer.parseInt((String)panel1.MinuteA.getSelectedItem());
        int interval = 60;  //5 is a placeholder for jTextField which will contain user input of interval (value represents minutes)
        int rows = (rangeB - rangeA)/interval;              // Amount of rows depend on width of time range in correspondence with interval
        int volume;                                         // Value which is written to buffer
        try
        {
            JFileChooser volumeFile = new JFileChooser();   // Pop-up dialog box to name file and save it in desired location
            int retVal = volumeFile.showSaveDialog(null);

            if (retVal == JFileChooser.APPROVE_OPTION) {
                dir = new FileWriter(volumeFile.getSelectedFile());
            }
            buff = new BufferedWriter(dir);                 // Buffer in which headers and data is written
            buff.write("Time Range:  ");                                // Sets top-left corner empty

            for (int i = 0; i < 32; i++)                    // Loop goes through selected channels and displays them as headers
            {
                if (panel1.log170Channel[i] != null)        // If channel is assigned to a C1 pin...
                {
                    buff.write("c1pin: " + String.valueOf(i));    // Then write it as a header
                    buff.write(" ");
                }
            }
            buff.newLine();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }

        try
        {
            for (int i = 0; i < rows; i++)              // Loops through intervals of selected times
            {
                int hour1 = rangeA/60;                  //
                rangeA += interval;
                int hour2 = rangeA/60;

                int min1 = selMin;
                if (min1 > 59)
                {
                    min1 = min1 - 60;
                    selMin = 0;
                }
                selMin += interval;
                int min2 = selMin;
                if (min2 > 59)
                {
                    min2 = min2 - 60;
                    selMin = 0;
                }

                String minA = StringUtils.leftPad(Integer.toString(min1),2,"0");
                String minB = StringUtils.leftPad(Integer.toString(min2),2,"0");

                buff.write(hour1 + ":" + minA + "_" + hour2 + ":" + minB);
                buff.write("\t");

                for(int j = 0; j< 32; j++)
                {
                    if (panel1.log170Channel[j] != null)
                    {
                        int c1pin = Integer.parseInt(panel1.log170Channel[j]);
                        String query = "SELECT C1_Reader_State,C1_Reader_Millis FROM C1_Reader_Data WHERE C1_Pin = ? AND C1_Reader_Unix BETWEEN ? AND ?";
                        PreparedStatement statement = conn.prepareStatement(query);
                        statement.setInt(1, c1pin);
                        statement.setDouble(2, timeA);
                        statement.setDouble(3, timeA + (interval * 60000));
 
                            System.out.println("C1 pin: " + c1pin);
                            if (conn == null)
                            {
                                System.out.println("There was a problem connecting");
                            }

                            ResultSet rs = statement.executeQuery();                         
                            if (rs.equals(null))
                            {
                                buff.write("0");
                                buff.write(" ");
                            } 
                            else
                            {

                                while (rs.next())
                                {
                                    eventCount++;
                                }
                                volume = eventCount/2;
                                buff.write(String.valueOf(volume) );
                                buff.write(" ");
                                eventCount = 0;
                            }
                    }
                }
                buff.newLine();
                timeA = timeA + (interval * 60000);
            }
            buff.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }        // TODO add your handling code here:
    }//GEN-LAST:event_VolumeActionPerformed

    private void OccupancyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccupancyActionPerformed
        timeA = panel1.getUnixTimeA();                  // User selection of Time A represented in Unix timestamp in milliseconds
        timeB = panel1.getUnixTimeB();                  // User selection of Time B represented in Unix timestamp in milliseconds
        conn = connect();                               // Connects to database
        getAddressPort();                               // Assigns C1 pins to selected channels
        int timeOne = -1;                                // Time for event one must be high, initialized to zero to verify initial hight event
        int timeTwo = 0;                                // Time for event two
        int rangeA = (Integer.parseInt((String)panel1.HourA.getSelectedItem())*60) + Integer.parseInt((String)panel1.MinuteA.getSelectedItem());
        int rangeB = (Integer.parseInt((String)panel1.HourB.getSelectedItem())*60) + Integer.parseInt((String)panel1.MinuteB.getSelectedItem());
        int selMin = Integer.parseInt((String)panel1.MinuteA.getSelectedItem());
        int interval = 60;  //5 is a placeholder for jTextField which will contain user input of interval (value represents minutes)
        int rows = (rangeB - rangeA)/interval;              // Amount of rows depend on width of time range in correspondence with interval
        int occupancy = 0;                                    // Value which is written to buffer
        int change = 0;
       
        
        try
        {
            JFileChooser volumeFile = new JFileChooser();   // Pop-up dialog box to name file and save it in desired location
            int retVal = volumeFile.showSaveDialog(null);

            if (retVal == JFileChooser.APPROVE_OPTION) {
                dir = new FileWriter(volumeFile.getSelectedFile());
            }
            buff = new BufferedWriter(dir);                 // Buffer in which headers and data is written
            buff.write("Time Range  ");                                // Sets top-left corner empty

            for (int i = 0; i < 32; i++)                    // Loop goes through selected channels and displays them as headers
            {
                if (panel1.log170Channel[i] != null)        // If channel is assigned to a C1 pin...
                {
                    buff.write("" + String.valueOf(i));    // Then write it as a header
                    buff.write(" ");
                }
            }
            buff.newLine();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }  // TODO add your handling code here:

        try
        {
            for (int i = 0; i < rows; i++)              // Loops through intervals of selected times
            {
                int hour1 = rangeA/60;                  //
                rangeA += interval;
                int hour2 = rangeA/60;

                int min1 = selMin;
                if (min1 > 59)
                {
                    min1 = min1 - 60;
                    selMin = 0;
                }
                selMin += interval;
                int min2 = selMin;
                if (min2 > 59)
                {
                    min2 = min2 - 60;
                    selMin = 0;
                }

                String minA = StringUtils.leftPad(Integer.toString(min1),2,"0");
                String minB = StringUtils.leftPad(Integer.toString(min2),2,"0");

                buff.write(hour1 + ":" + minA + "_" + hour2 + ":" + minB);
                buff.write(" ");

                for(int j = 0; j< 32; j++)
                {
                    if (panel1.log170Channel[j] != null)
                    {
          
                        int c1pin = Integer.parseInt(panel1.log170Channel[j]);
                        String query = "SELECT C1_Reader_State, C1_Reader_Millis FROM C1_Reader_Data WHERE C1_Pin = ? AND C1_Reader_Unix BETWEEN ? AND ?";
                        PreparedStatement statement = conn.prepareStatement(query);
                        statement.setInt(1, c1pin);
                        statement.setDouble(2, timeA);
                        statement.setDouble(3, timeA + (interval * 60000));
                
                            System.out.println("C1 pin: " + c1pin);
                            if (conn == null)
                            {
                                System.out.println("There was a problem connecting");
                            }

                            ResultSet rs = statement.executeQuery();
                            if (rs.equals(null))
                            {
                                buff.write("0");
                                buff.write(" ");
                            }
                            else
                            {
                                
                                while (rs.next())                               
                                {            
                                    if(rs.getInt("C1_Reader_State") == 1)
                                    {
                                        timeOne = rs.getInt("C1_Reader_Millis");
                                        System.out.println("timeOne: " + timeOne);
                                    }                                                         
                                    if(rs.getInt("C1_Reader_State") == 0)
                                    {
                                        timeTwo = rs.getInt("C1_Reader_Millis");
                                        System.out.println("timeTwo: " + timeTwo);
                                    }
                                    if(timeOne == -1)   // used to throw out first row value with low state
                                    {
                                        timeTwo = -1;                                  
                                    }
                                    if (timeOne == -1 || timeTwo == -1)
                                    {
                                        continue;
                                    }
                                    else if ((timeOne != -1) && (timeOne > timeTwo))
                                    {
                                        continue;
                                    }
                                    else
                                    {
                                        change = timeTwo-timeOne;  
                                        occupancy += change;
                                        timeOne = -1;
                                        timeTwo = -1;
                                        
                                        System.out.println("change: " + change);
                                        System.out.println("occupancy: " + occupancy);
                                    }
                                }
                                buff.write(String.valueOf(occupancy));
                                buff.write(" ");
                      
                                occupancy = 0;
                            }
                        }
                    }
                    buff.newLine();
                    timeA = timeA + (interval * 60000);
                }
                buff.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
   
    }//GEN-LAST:event_OccupancyActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try{
            /*int test = panel1.Log170_1.getSelectedIndex();
            System.out.println("The test: " + test);*/
            JFileChooser templateFile = new JFileChooser();
            int retVal = templateFile.showSaveDialog(null);

            if (retVal == JFileChooser.APPROVE_OPTION) {
                dir = new FileWriter(templateFile.getSelectedFile());
            }
            /* BufferedWriter writes a single character only, thus the selected index values must be in String */
            buff = new BufferedWriter(dir);
            buff.write(String.valueOf(panel1.Log170_1.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_2.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_3.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_4.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_5.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_6.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_7.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_8.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_9.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_10.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_11.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_12.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_13.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_14.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_15.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_16.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_17.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_18.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_19.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_20.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_21.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_22.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_23.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_24.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_25.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_26.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_27.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_28.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_29.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_30.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_31.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_32.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_33.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_34.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_35.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_36.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_37.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_38.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_39.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel1.Log170_40.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_41.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_42.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_43.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_44.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_45.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_46.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_47.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_48.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_49.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_50.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_51.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_52.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_53.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_54.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_55.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_56.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_57.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_58.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_59.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_60.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_61.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_62.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_63.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_64.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_65.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_66.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_67.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_68.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_69.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_70.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_71.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_72.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_73.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_74.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_75.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_76.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_77.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_78.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_79.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_80.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_81.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_82.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_83.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_84.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_85.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_86.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_87.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_88.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_89.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_90.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_91.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_92.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_93.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_94.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_95.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_96.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_97.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_98.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_99.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel2.Log170_100.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_101.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_102.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_103.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_104.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_105.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_106.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_107.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_108.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_109.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_110.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_111.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_112.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_113.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_114.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_115.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_116.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_117.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_118.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_119.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_120.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_121.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_122.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_123.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_124.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_125.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_126.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_127.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_128.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_129.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_130.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_131.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_132.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_133.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_134.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_135.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_136.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_137.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_138.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_139.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_140.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_141.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_142.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_143.getSelectedIndex()));
            buff.newLine();
            buff.write(String.valueOf(panel3.Log170_144.getSelectedIndex()));
            buff.close();

            System.out.println("Here is the first one: " + panel1.Log170_1.getSelectedIndex());

        } catch (IOException io) {
            io.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_SaveActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        panel1.jTextField1.setText("");
        panel1.jTextField2.setText("");
        panel1.jTextField3.setText("");
        panel1.jTextField4.setText("");
        panel1.jTextField5.setText("");
        panel1.jTextField6.setText("");
        panel1.jTextField7.setText("");
        panel1.jTextField8.setText("");
        panel1.jTextField9.setText("");
        panel1.jTextField10.setText("");
        panel1.jTextField11.setText("");
        panel1.jTextField12.setText("");
        panel1.jTextField13.setText("");
        panel1.jTextField14.setText("");
        panel1.jTextField15.setText("");
        panel1.jTextField16.setText("");
        panel1.jTextField17.setText("");
        panel1.jTextField18.setText("");
        panel1.jTextField19.setText("");
        panel1.jTextField20.setText("");
        panel1.jTextField21.setText("");
        panel1.jTextField22.setText("");
        panel1.jTextField23.setText("");
        panel1.jTextField24.setText("");
        panel1.jTextField25.setText("");
        panel1.jTextField26.setText("");
        panel1.jTextField27.setText("");
        panel1.jTextField28.setText("");
        panel1.jTextField29.setText("");
        panel1.jTextField30.setText("");
        panel1.jTextField31.setText("");
        panel1.jTextField32.setText("");
        panel1.jTextField33.setText("");
        panel1.jTextField34.setText("");
        panel1.jTextField35.setText("");
        panel1.jTextField36.setText("");
        panel1.jTextField37.setText("");
        panel1.jTextField38.setText("");
        panel1.jTextField39.setText("");
        panel1.jTextField40.setText("");
        panel1.jTextField41.setText("");
        panel1.jTextField42.setText("");
        panel1.jTextField43.setText("");
        panel1.jTextField44.setText("");
        panel1.jTextField45.setText("");
        panel1.jTextField46.setText("");
        panel1.jTextField47.setText("");
        panel1.jTextField48.setText("");
        panel1.jTextField49.setText("");
        panel1.jTextField50.setText("");
        panel1.jTextField51.setText("");
        panel1.jTextField52.setText("");
        panel1.jTextField53.setText("");
        panel1.jTextField54.setText("");
        panel1.jTextField55.setText("");
        panel1.jTextField56.setText("");
        panel1.jTextField57.setText("");
        panel1.jTextField58.setText("");
        panel1.jTextField59.setText("");
        panel1.jTextField60.setText("");
        panel1.jTextField61.setText("");
        panel1.jTextField62.setText("");
        panel1.jTextField63.setText("");
        panel1.jTextField64.setText("");
        panel1.jTextField65.setText("");
        panel1.jTextField66.setText("");
        panel1.jTextField67.setText("");
        panel1.jTextField68.setText("");
        panel1.jTextField69.setText("");
        panel1.jTextField70.setText("");
        panel1.jTextField71.setText("");
        panel1.jTextField72.setText("");
        panel1.jTextField73.setText("");
        panel1.jTextField74.setText("");
        panel1.jTextField75.setText("");
        panel1.jTextField76.setText("");
        panel1.jTextField77.setText("");
        panel1.jTextField78.setText("");
        panel1.jTextField79.setText("");
        panel1.jTextField80.setText("");
        panel1.jTextField81.setText("");
        panel1.jTextField82.setText("");
        panel1.jTextField83.setText("");
        panel1.jTextField84.setText("");
        panel1.jTextField85.setText("");
        panel1.jTextField86.setText("");
        panel1.jTextField87.setText("");
        panel1.jTextField88.setText("");
        panel1.jTextField89.setText("");
        panel1.jTextField90.setText("");
        panel1.jTextField91.setText("");
        panel1.jTextField92.setText("");
        panel1.jTextField93.setText("");
        panel1.jTextField94.setText("");
        panel1.jTextField95.setText("");
        panel1.jTextField96.setText("");
        panel1.jTextField97.setText("");
        panel1.jTextField98.setText("");
        panel1.jTextField99.setText("");
        panel1.jTextField100.setText("");
        panel1.jTextField101.setText("");
        panel1.jTextField102.setText("");
        panel1.jTextField103.setText("");
        panel1.jTextField104.setText("");
        panel1.jTextField105.setText("");
        panel1.jTextField106.setText("");
        panel1.jTextField107.setText("");
        panel1.jTextField108.setText("");
        panel1.jTextField109.setText("");
        panel1.jTextField110.setText("");
        panel1.jTextField111.setText("");
        panel1.jTextField112.setText("");
        panel1.jTextField113.setText("");
        panel1.jTextField114.setText("");
        panel1.jTextField115.setText("");
        panel1.jTextField116.setText("");
        panel1.jTextField117.setText("");
        panel1.jTextField118.setText("");
        panel1.jTextField119.setText("");
        panel1.jTextField120.setText("");
        panel2.jTextField121.setText("");
        panel2.jTextField122.setText("");
        panel2.jTextField123.setText("");
        panel2.jTextField124.setText("");
        panel2.jTextField125.setText("");
        panel2.jTextField126.setText("");
        panel2.jTextField127.setText("");
        panel2.jTextField128.setText("");
        panel2.jTextField129.setText("");
        panel2.jTextField130.setText("");
        panel2.jTextField131.setText("");
        panel2.jTextField132.setText("");
        panel2.jTextField133.setText("");
        panel2.jTextField134.setText("");
        panel2.jTextField135.setText("");
        panel2.jTextField136.setText("");
        panel2.jTextField137.setText("");
        panel2.jTextField138.setText("");
        panel2.jTextField139.setText("");
        panel2.jTextField140.setText("");
        panel2.jTextField141.setText("");
        panel2.jTextField142.setText("");
        panel2.jTextField143.setText("");
        panel2.jTextField144.setText("");
        panel2.jTextField145.setText("");
        panel2.jTextField146.setText("");
        panel2.jTextField147.setText("");
        panel2.jTextField148.setText("");
        panel2.jTextField149.setText("");
        panel2.jTextField150.setText("");
        panel2.jTextField151.setText("");
        panel2.jTextField152.setText("");
        panel2.jTextField153.setText("");
        panel2.jTextField154.setText("");
        panel2.jTextField155.setText("");
        panel2.jTextField156.setText("");
        panel2.jTextField157.setText("");
        panel2.jTextField158.setText("");
        panel2.jTextField159.setText("");
        panel2.jTextField160.setText("");
        panel2.jTextField161.setText("");
        panel2.jTextField162.setText("");
        panel2.jTextField163.setText("");
        panel2.jTextField164.setText("");
        panel2.jTextField165.setText("");
        panel2.jTextField166.setText("");
        panel2.jTextField167.setText("");
        panel2.jTextField168.setText("");
        panel2.jTextField169.setText("");
        panel2.jTextField170.setText("");
        panel2.jTextField171.setText("");
        panel2.jTextField172.setText("");
        panel2.jTextField173.setText("");
        panel2.jTextField174.setText("");
        panel2.jTextField175.setText("");
        panel2.jTextField176.setText("");
        panel2.jTextField177.setText("");
        panel2.jTextField178.setText("");
        panel2.jTextField179.setText("");
        panel2.jTextField180.setText("");
        panel2.jTextField181.setText("");
        panel2.jTextField182.setText("");
        panel2.jTextField183.setText("");
        panel2.jTextField184.setText("");
        panel2.jTextField185.setText("");
        panel2.jTextField186.setText("");
        panel2.jTextField187.setText("");
        panel2.jTextField188.setText("");
        panel2.jTextField189.setText("");
        panel2.jTextField190.setText("");
        panel2.jTextField191.setText("");
        panel2.jTextField192.setText("");
        panel2.jTextField193.setText("");
        panel2.jTextField194.setText("");
        panel2.jTextField195.setText("");
        panel2.jTextField196.setText("");
        panel2.jTextField197.setText("");
        panel2.jTextField198.setText("");
        panel2.jTextField199.setText("");
        panel2.jTextField200.setText("");
        panel2.jTextField201.setText("");
        panel2.jTextField202.setText("");
        panel2.jTextField203.setText("");
        panel2.jTextField204.setText("");
        panel2.jTextField205.setText("");
        panel2.jTextField206.setText("");
        panel2.jTextField207.setText("");
        panel2.jTextField208.setText("");
        panel2.jTextField209.setText("");
        panel2.jTextField210.setText("");
        panel2.jTextField211.setText("");
        panel2.jTextField212.setText("");
        panel2.jTextField213.setText("");
        panel2.jTextField214.setText("");
        panel2.jTextField215.setText("");
        panel2.jTextField216.setText("");
        panel2.jTextField217.setText("");
        panel2.jTextField218.setText("");
        panel2.jTextField219.setText("");
        panel2.jTextField220.setText("");
        panel2.jTextField221.setText("");
        panel2.jTextField222.setText("");
        panel2.jTextField223.setText("");
        panel2.jTextField224.setText("");
        panel2.jTextField225.setText("");
        panel2.jTextField226.setText("");
        panel2.jTextField227.setText("");
        panel2.jTextField228.setText("");
        panel2.jTextField229.setText("");
        panel2.jTextField230.setText("");
        panel2.jTextField231.setText("");
        panel2.jTextField232.setText("");
        panel2.jTextField233.setText("");
        panel2.jTextField234.setText("");
        panel2.jTextField235.setText("");
        panel2.jTextField236.setText("");
        panel2.jTextField237.setText("");
        panel2.jTextField238.setText("");
        panel2.jTextField239.setText("");
        panel2.jTextField240.setText("");
        panel2.jTextField241.setText("");
        panel2.jTextField242.setText("");
        panel2.jTextField243.setText("");
        panel2.jTextField244.setText("");
        panel2.jTextField245.setText("");
        panel2.jTextField246.setText("");
        panel2.jTextField247.setText("");
        panel2.jTextField248.setText("");
        panel2.jTextField249.setText("");
        panel2.jTextField250.setText("");
        panel2.jTextField251.setText("");
        panel2.jTextField252.setText("");
        panel2.jTextField253.setText("");
        panel2.jTextField254.setText("");
        panel2.jTextField255.setText("");
        panel2.jTextField256.setText("");
        panel2.jTextField257.setText("");
        panel2.jTextField258.setText("");
        panel2.jTextField259.setText("");
        panel2.jTextField260.setText("");
        panel2.jTextField261.setText("");
        panel2.jTextField262.setText("");
        panel2.jTextField263.setText("");
        panel2.jTextField264.setText("");
        panel2.jTextField265.setText("");
        panel2.jTextField266.setText("");
        panel2.jTextField267.setText("");
        panel2.jTextField268.setText("");
        panel2.jTextField269.setText("");
        panel2.jTextField270.setText("");
        panel2.jTextField271.setText("");
        panel2.jTextField272.setText("");
        panel2.jTextField273.setText("");
        panel2.jTextField274.setText("");
        panel2.jTextField275.setText("");
        panel2.jTextField276.setText("");
        panel2.jTextField277.setText("");
        panel2.jTextField278.setText("");
        panel2.jTextField279.setText("");
        panel2.jTextField280.setText("");
        panel2.jTextField281.setText("");
        panel2.jTextField282.setText("");
        panel2.jTextField283.setText("");
        panel2.jTextField284.setText("");
        panel2.jTextField285.setText("");
        panel2.jTextField286.setText("");
        panel2.jTextField287.setText("");
        panel2.jTextField288.setText("");
        panel2.jTextField289.setText("");
        panel2.jTextField290.setText("");
        panel2.jTextField291.setText("");
        panel2.jTextField292.setText("");
        panel2.jTextField293.setText("");
        panel2.jTextField294.setText("");
        panel2.jTextField295.setText("");
        panel2.jTextField296.setText("");
        panel2.jTextField297.setText("");
        panel2.jTextField298.setText("");
        panel2.jTextField299.setText("");
        panel2.jTextField300.setText("");
        panel3.jTextField301.setText("");
        panel3.jTextField302.setText("");
        panel3.jTextField303.setText("");
        panel3.jTextField304.setText("");
        panel3.jTextField305.setText("");
        panel3.jTextField306.setText("");
        panel3.jTextField307.setText("");
        panel3.jTextField308.setText("");
        panel3.jTextField309.setText("");
        panel3.jTextField310.setText("");
        panel3.jTextField311.setText("");
        panel3.jTextField312.setText("");
        panel3.jTextField313.setText("");
        panel3.jTextField314.setText("");
        panel3.jTextField315.setText("");
        panel3.jTextField316.setText("");
        panel3.jTextField317.setText("");
        panel3.jTextField318.setText("");
        panel3.jTextField319.setText("");
        panel3.jTextField320.setText("");
        panel3.jTextField321.setText("");
        panel3.jTextField322.setText("");
        panel3.jTextField323.setText("");
        panel3.jTextField324.setText("");
        panel3.jTextField325.setText("");
        panel3.jTextField326.setText("");
        panel3.jTextField327.setText("");
        panel3.jTextField328.setText("");
        panel3.jTextField329.setText("");
        panel3.jTextField330.setText("");
        panel3.jTextField331.setText("");
        panel3.jTextField332.setText("");
        panel3.jTextField333.setText("");
        panel3.jTextField334.setText("");
        panel3.jTextField335.setText("");
        panel3.jTextField336.setText("");
        panel3.jTextField337.setText("");
        panel3.jTextField338.setText("");
        panel3.jTextField339.setText("");
        panel3.jTextField340.setText("");
        panel3.jTextField341.setText("");
        panel3.jTextField342.setText("");
        panel3.jTextField343.setText("");
        panel3.jTextField344.setText("");
        panel3.jTextField345.setText("");
        panel3.jTextField346.setText("");
        panel3.jTextField347.setText("");
        panel3.jTextField348.setText("");
        panel3.jTextField349.setText("");
        panel3.jTextField350.setText("");
        panel3.jTextField351.setText("");
        panel3.jTextField352.setText("");
        panel3.jTextField353.setText("");
        panel3.jTextField354.setText("");
        panel3.jTextField355.setText("");
        panel3.jTextField356.setText("");
        panel3.jTextField357.setText("");
        panel3.jTextField358.setText("");
        panel3.jTextField359.setText("");
        panel3.jTextField360.setText("");
        panel3.jTextField361.setText("");
        panel3.jTextField362.setText("");
        panel3.jTextField363.setText("");
        panel3.jTextField364.setText("");
        panel3.jTextField365.setText("");
        panel3.jTextField366.setText("");
        panel3.jTextField367.setText("");
        panel3.jTextField368.setText("");
        panel3.jTextField369.setText("");
        panel3.jTextField370.setText("");
        panel3.jTextField371.setText("");
        panel3.jTextField372.setText("");
        panel3.jTextField373.setText("");
        panel3.jTextField374.setText("");
        panel3.jTextField375.setText("");
        panel3.jTextField376.setText("");
        panel3.jTextField377.setText("");
        panel3.jTextField378.setText("");
        panel3.jTextField379.setText("");
        panel3.jTextField380.setText("");
        panel3.jTextField381.setText("");
        panel3.jTextField382.setText("");
        panel3.jTextField383.setText("");
        panel3.jTextField384.setText("");
        panel3.jTextField385.setText("");
        panel3.jTextField386.setText("");
        panel3.jTextField387.setText("");
        panel3.jTextField388.setText("");
        panel3.jTextField389.setText("");
        panel3.jTextField390.setText("");
        panel3.jTextField391.setText("");
        panel3.jTextField392.setText("");
        panel3.jTextField392.setText("");
        panel3.jTextField394.setText("");
        panel3.jTextField395.setText("");
        panel3.jTextField396.setText("");
        panel3.jTextField397.setText("");
        panel3.jTextField398.setText("");
        panel3.jTextField399.setText("");
        panel3.jTextField400.setText("");
        panel3.jTextField401.setText("");
        panel3.jTextField402.setText("");
        panel3.jTextField403.setText("");
        panel3.jTextField404.setText("");
        panel3.jTextField405.setText("");
        panel3.jTextField406.setText("");
        panel3.jTextField407.setText("");
        panel3.jTextField408.setText("");
        panel3.jTextField409.setText("");
        panel3.jTextField410.setText("");
        panel3.jTextField411.setText("");
        panel3.jTextField412.setText("");
        panel3.jTextField413.setText("");
        panel3.jTextField414.setText("");
        panel3.jTextField415.setText("");
        panel3.jTextField416.setText("");
        panel3.jTextField417.setText("");
        panel3.jTextField418.setText("");
        panel3.jTextField419.setText("");
        panel3.jTextField420.setText("");
        panel3.jTextField421.setText("");
        panel3.jTextField422.setText("");
        panel3.jTextField423.setText("");
        panel3.jTextField424.setText("");
        panel3.jTextField425.setText("");
        panel3.jTextField426.setText("");
        panel3.jTextField427.setText("");
        panel3.jTextField428.setText("");
        panel3.jTextField429.setText("");
        panel3.jTextField430.setText("");
        panel3.jTextField431.setText("");
        panel3.jTextField432.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_ClearActionPerformed

    private void Page1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Page1ActionPerformed
        CardLayout showPanel = (CardLayout) PanelCard.getLayout();
        showPanel.show(PanelCard, "Panel 1");        // TODO add your handling code here:
    }//GEN-LAST:event_Page1ActionPerformed

    private void Page2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Page2ActionPerformed
        CardLayout showPanel = (CardLayout) PanelCard.getLayout();
        showPanel.show(PanelCard, "Panel 2");          // TODO add your handling code here:
    }//GEN-LAST:event_Page2ActionPerformed

    private void Page3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Page3ActionPerformed
        CardLayout showPanel = (CardLayout) PanelCard.getLayout();
        showPanel.show(PanelCard, "Panel 3");          // TODO add your handling code here:
    }//GEN-LAST:event_Page3ActionPerformed

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        FileFilter filter = new FileNameExtensionFilter("TextFile","txt");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        DirBrowse.setText(filename);

        f = new File(DirBrowse.getText());

        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = null;
            int i = 0;
            int[] arrayList = new int[144];
            while ((line = br.readLine()) != null) {
                arrayList[i] = Integer.parseInt(line);
                i++;
            }
            panel1.Log170_1.setSelectedIndex(arrayList[0]);
            panel1.Log170_2.setSelectedIndex(arrayList[1]);
            panel1.Log170_3.setSelectedIndex(arrayList[2]);
            panel1.Log170_4.setSelectedIndex(arrayList[3]);
            panel1.Log170_5.setSelectedIndex(arrayList[4]);
            panel1.Log170_6.setSelectedIndex(arrayList[5]);
            panel1.Log170_7.setSelectedIndex(arrayList[6]);
            panel1.Log170_8.setSelectedIndex(arrayList[7]);
            panel1.Log170_9.setSelectedIndex(arrayList[8]);
            panel1.Log170_10.setSelectedIndex(arrayList[9]);
            panel1.Log170_11.setSelectedIndex(arrayList[10]);
            panel1.Log170_12.setSelectedIndex(arrayList[11]);
            panel1.Log170_13.setSelectedIndex(arrayList[12]);
            panel1.Log170_14.setSelectedIndex(arrayList[13]);
            panel1.Log170_15.setSelectedIndex(arrayList[14]);
            panel1.Log170_16.setSelectedIndex(arrayList[15]);
            panel1.Log170_17.setSelectedIndex(arrayList[16]);
            panel1.Log170_18.setSelectedIndex(arrayList[17]);
            panel1.Log170_19.setSelectedIndex(arrayList[18]);
            panel1.Log170_20.setSelectedIndex(arrayList[19]);
            panel1.Log170_21.setSelectedIndex(arrayList[20]);
            panel1.Log170_22.setSelectedIndex(arrayList[21]);
            panel1.Log170_23.setSelectedIndex(arrayList[22]);
            panel1.Log170_24.setSelectedIndex(arrayList[23]);
            panel1.Log170_25.setSelectedIndex(arrayList[24]);
            panel1.Log170_26.setSelectedIndex(arrayList[25]);
            panel1.Log170_27.setSelectedIndex(arrayList[26]);
            panel1.Log170_28.setSelectedIndex(arrayList[27]);
            panel1.Log170_29.setSelectedIndex(arrayList[28]);
            panel1.Log170_30.setSelectedIndex(arrayList[29]);
            panel1.Log170_31.setSelectedIndex(arrayList[30]);
            panel1.Log170_32.setSelectedIndex(arrayList[31]);
            panel1.Log170_33.setSelectedIndex(arrayList[32]);
            panel1.Log170_34.setSelectedIndex(arrayList[33]);
            panel1.Log170_35.setSelectedIndex(arrayList[34]);
            panel1.Log170_36.setSelectedIndex(arrayList[35]);
            panel1.Log170_37.setSelectedIndex(arrayList[36]);
            panel1.Log170_38.setSelectedIndex(arrayList[37]);
            panel1.Log170_39.setSelectedIndex(arrayList[38]);
            panel1.Log170_40.setSelectedIndex(arrayList[39]);
            panel2.Log170_41.setSelectedIndex(arrayList[40]);
            panel2.Log170_42.setSelectedIndex(arrayList[41]);
            panel2.Log170_43.setSelectedIndex(arrayList[42]);
            panel2.Log170_44.setSelectedIndex(arrayList[43]);
            panel2.Log170_45.setSelectedIndex(arrayList[44]);
            panel2.Log170_46.setSelectedIndex(arrayList[45]);
            panel2.Log170_47.setSelectedIndex(arrayList[46]);
            panel2.Log170_48.setSelectedIndex(arrayList[47]);
            panel2.Log170_49.setSelectedIndex(arrayList[48]);
            panel2.Log170_50.setSelectedIndex(arrayList[49]);
            panel2.Log170_51.setSelectedIndex(arrayList[50]);
            panel2.Log170_52.setSelectedIndex(arrayList[51]);
            panel2.Log170_53.setSelectedIndex(arrayList[52]);
            panel2.Log170_54.setSelectedIndex(arrayList[53]);
            panel2.Log170_55.setSelectedIndex(arrayList[54]);
            panel2.Log170_56.setSelectedIndex(arrayList[55]);
            panel2.Log170_57.setSelectedIndex(arrayList[56]);
            panel2.Log170_58.setSelectedIndex(arrayList[57]);
            panel2.Log170_59.setSelectedIndex(arrayList[58]);
            panel2.Log170_60.setSelectedIndex(arrayList[59]);
            panel2.Log170_61.setSelectedIndex(arrayList[60]);
            panel2.Log170_62.setSelectedIndex(arrayList[61]);
            panel2.Log170_63.setSelectedIndex(arrayList[62]);
            panel2.Log170_64.setSelectedIndex(arrayList[63]);
            panel2.Log170_65.setSelectedIndex(arrayList[64]);
            panel2.Log170_66.setSelectedIndex(arrayList[65]);
            panel2.Log170_67.setSelectedIndex(arrayList[66]);
            panel2.Log170_68.setSelectedIndex(arrayList[67]);
            panel2.Log170_69.setSelectedIndex(arrayList[68]);
            panel2.Log170_70.setSelectedIndex(arrayList[69]);
            panel2.Log170_71.setSelectedIndex(arrayList[70]);
            panel2.Log170_72.setSelectedIndex(arrayList[71]);
            panel2.Log170_73.setSelectedIndex(arrayList[72]);
            panel2.Log170_74.setSelectedIndex(arrayList[73]);
            panel2.Log170_75.setSelectedIndex(arrayList[74]);
            panel2.Log170_76.setSelectedIndex(arrayList[75]);
            panel2.Log170_77.setSelectedIndex(arrayList[76]);
            panel2.Log170_78.setSelectedIndex(arrayList[77]);
            panel2.Log170_79.setSelectedIndex(arrayList[78]);
            panel2.Log170_80.setSelectedIndex(arrayList[79]);
            panel2.Log170_81.setSelectedIndex(arrayList[80]);
            panel2.Log170_82.setSelectedIndex(arrayList[81]);
            panel2.Log170_83.setSelectedIndex(arrayList[82]);
            panel2.Log170_84.setSelectedIndex(arrayList[83]);
            panel2.Log170_85.setSelectedIndex(arrayList[84]);
            panel2.Log170_86.setSelectedIndex(arrayList[85]);
            panel2.Log170_87.setSelectedIndex(arrayList[86]);
            panel2.Log170_88.setSelectedIndex(arrayList[87]);
            panel2.Log170_89.setSelectedIndex(arrayList[88]);
            panel2.Log170_90.setSelectedIndex(arrayList[89]);
            panel2.Log170_91.setSelectedIndex(arrayList[90]);
            panel2.Log170_92.setSelectedIndex(arrayList[91]);
            panel2.Log170_93.setSelectedIndex(arrayList[92]);
            panel2.Log170_94.setSelectedIndex(arrayList[93]);
            panel2.Log170_95.setSelectedIndex(arrayList[94]);
            panel2.Log170_96.setSelectedIndex(arrayList[95]);
            panel2.Log170_97.setSelectedIndex(arrayList[96]);
            panel2.Log170_98.setSelectedIndex(arrayList[97]);
            panel2.Log170_99.setSelectedIndex(arrayList[98]);
            panel2.Log170_100.setSelectedIndex(arrayList[99]);
            panel3.Log170_101.setSelectedIndex(arrayList[100]);
            panel3.Log170_102.setSelectedIndex(arrayList[101]);
            panel3.Log170_103.setSelectedIndex(arrayList[102]);
            panel3.Log170_104.setSelectedIndex(arrayList[103]);
            panel3.Log170_105.setSelectedIndex(arrayList[104]);
            panel3.Log170_106.setSelectedIndex(arrayList[105]);
            panel3.Log170_107.setSelectedIndex(arrayList[106]);
            panel3.Log170_108.setSelectedIndex(arrayList[107]);
            panel3.Log170_109.setSelectedIndex(arrayList[108]);
            panel3.Log170_110.setSelectedIndex(arrayList[109]);
            panel3.Log170_111.setSelectedIndex(arrayList[110]);
            panel3.Log170_112.setSelectedIndex(arrayList[111]);
            panel3.Log170_113.setSelectedIndex(arrayList[112]);
            panel3.Log170_114.setSelectedIndex(arrayList[113]);
            panel3.Log170_115.setSelectedIndex(arrayList[114]);
            panel3.Log170_116.setSelectedIndex(arrayList[115]);
            panel3.Log170_117.setSelectedIndex(arrayList[116]);
            panel3.Log170_118.setSelectedIndex(arrayList[117]);
            panel3.Log170_119.setSelectedIndex(arrayList[118]);
            panel3.Log170_120.setSelectedIndex(arrayList[119]);
            panel3.Log170_121.setSelectedIndex(arrayList[120]);
            panel3.Log170_122.setSelectedIndex(arrayList[121]);
            panel3.Log170_123.setSelectedIndex(arrayList[122]);
            panel3.Log170_124.setSelectedIndex(arrayList[123]);
            panel3.Log170_125.setSelectedIndex(arrayList[124]);
            panel3.Log170_126.setSelectedIndex(arrayList[125]);
            panel3.Log170_127.setSelectedIndex(arrayList[126]);
            panel3.Log170_128.setSelectedIndex(arrayList[127]);
            panel3.Log170_129.setSelectedIndex(arrayList[128]);
            panel3.Log170_130.setSelectedIndex(arrayList[129]);
            panel3.Log170_131.setSelectedIndex(arrayList[130]);
            panel3.Log170_132.setSelectedIndex(arrayList[131]);
            panel3.Log170_133.setSelectedIndex(arrayList[132]);
            panel3.Log170_134.setSelectedIndex(arrayList[133]);
            panel3.Log170_135.setSelectedIndex(arrayList[134]);
            panel3.Log170_136.setSelectedIndex(arrayList[135]);
            panel3.Log170_137.setSelectedIndex(arrayList[136]);
            panel3.Log170_138.setSelectedIndex(arrayList[137]);
            panel3.Log170_139.setSelectedIndex(arrayList[138]);
            panel3.Log170_140.setSelectedIndex(arrayList[139]);
            panel3.Log170_141.setSelectedIndex(arrayList[140]);
            panel3.Log170_142.setSelectedIndex(arrayList[141]);
            panel3.Log170_143.setSelectedIndex(arrayList[142]);
            panel3.Log170_144.setSelectedIndex(arrayList[143]);

            System.out.println(arrayList[32]);
            br.close();
        } catch (IOException e) {
            System.out.println("Problem with reading file");
        }// TODO add your handling code here:
    }//GEN-LAST:event_UploadActionPerformed

    private void ModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelActionPerformed
        switch(Model.getSelectedIndex())
        {
            case 1:
            panel1.jTextField1.setText("LOGIC GROUND");
            panel1.jTextField4.setText("4P DONT WALK");
            panel1.jTextField7.setText("4P WALK");
            panel1.jTextField10.setText("04 RED");
            panel1.jTextField13.setText("04 YELLOW");
            panel1.jTextField16.setText("04 GREEN");
            panel1.jTextField19.setText("03 RED");
            panel1.jTextField22.setText("03 YELLOW");
            panel1.jTextField25.setText("03 GREEN");
            panel1.jTextField28.setText("2P DONT WALK");
            panel1.jTextField31.setText("2P WALK");
            panel1.jTextField34.setText("02 RED");
            panel1.jTextField37.setText("02 YELLOW");
            panel1.jTextField40.setText("INPUT GROUND");
            panel1.jTextField43.setText("02 GREEN");
            panel1.jTextField46.setText("01 RED");
            panel1.jTextField49.setText("01 YELLOW");
            panel1.jTextField52.setText("01 GREEN");
            panel1.jTextField55.setText("8P DONT WALK");
            panel1.jTextField58.setText("8P WALK");
            panel1.jTextField61.setText("08 RED");
            panel1.jTextField64.setText("08 YELLOW");
            panel1.jTextField67.setText("08 GREEN");
            panel1.jTextField70.setText("07 RED");
            panel1.jTextField73.setText("07 YELLOW");
            panel1.jTextField76.setText("07 GREEN");
            panel1.jTextField79.setText("6P DONT WALK");
            panel1.jTextField82.setText("6P WALK");
            panel1.jTextField85.setText("06 RED");
            panel1.jTextField88.setText("06 YELLOW");
            panel1.jTextField91.setText("06 GREEN");
            panel1.jTextField94.setText("05 RED");
            panel1.jTextField97.setText("05 YELLOW");
            panel1.jTextField100.setText("05 GREEN");
            panel1.jTextField103.setText("GREEN ARROW A 2PED YEL");
            panel1.jTextField106.setText("GREEN ARROW B 6PED YEL");
            panel1.jTextField109.setText("YELLOW ARROW A 4PED YEL");
            panel1.jTextField112.setText("YELLOW ARROW B 8PED YEL");
            panel1.jTextField115.setText("02 COUNT+CALL+EXTEND");
            panel1.jTextField118.setText("06 COUNT+CALL+EXTEND");
            panel2.jTextField121.setText("04 COUNT+CALL+EXTEND");
            panel2.jTextField124.setText("08 COUNT+CALL+EXTEND");
            panel2.jTextField127.setText("02 COUNT+CALL+EXTEND");
            panel2.jTextField130.setText("06 COUNT+CALL+EXTEND");
            panel2.jTextField133.setText("04 COUNT+CALL+EXTEND");
            panel2.jTextField136.setText("08 COUNT+CALL+EXTEND");
            panel2.jTextField139.setText("02 LIMITED");
            panel2.jTextField142.setText("06 LIMITED");
            panel2.jTextField145.setText("04 LIMITED");
            panel2.jTextField148.setText("08 LIMITED");
            panel2.jTextField151.setText("RR1 (FLASH)");
            panel2.jTextField154.setText("RR2 (LIM.SERV.)");
            panel2.jTextField157.setText("SPARE 1");
            panel2.jTextField160.setText("SPARE 2");
            panel2.jTextField163.setText("05 COUNT+CALL+EXTEND");
            panel2.jTextField166.setText("01 COUNT+CALL+EXTEND");
            panel2.jTextField169.setText("07 COUNT+CALL+EXTEND");
            panel2.jTextField172.setText("03 COUNT+CALL+EXTEND");
            panel2.jTextField175.setText("05 COUNT+CALL+EXTEND");
            panel2.jTextField178.setText("01 COUNT+CALL+EXTEND");
            panel2.jTextField181.setText("07 COUNT+CALL+EXTEND");
            panel2.jTextField184.setText("03 COUNT+CALL+EXTEND");
            panel2.jTextField187.setText("02 COUNT+CALL+EXTEND");
            panel2.jTextField190.setText("06 COUNT+CALL+EXTEND");
            panel2.jTextField193.setText("04 COUNT+CALL+EXTEND");
            panel2.jTextField196.setText("08 COUNT+CALL+EXTEND");
            panel2.jTextField199.setText("02 PEDESTRIAN PB");
            panel2.jTextField202.setText("06 PEDESTRIAN PB");
            panel2.jTextField205.setText("04 PEDESTRIAN PB");
            panel2.jTextField208.setText("08 PEDESTRIAN PB");
            panel2.jTextField211.setText("EVA PREEMPT");
            panel2.jTextField214.setText("EVB PREEMPT");
            panel2.jTextField217.setText("EVC PREEMPT");
            panel2.jTextField220.setText("EVD PREEMPT");
            panel2.jTextField223.setText("SPARE 3");
            panel2.jTextField226.setText("02 CALL+EXTEND");
            panel2.jTextField229.setText("06 CALL+EXTEND");
            panel2.jTextField232.setText("04 CALL+EXTEND");
            panel2.jTextField235.setText("08 CALL+EXTEND");
            panel2.jTextField238.setText("ADVANCE");
            panel2.jTextField241.setText("FLASH SENSE");
            panel2.jTextField244.setText("STOP TIME");
            panel2.jTextField247.setText("SPECIAL FUNCTION 1");
            panel2.jTextField250.setText("SPECIAL FUNCTION 3");
            panel2.jTextField253.setText("OVERLAP B RED (AUX5)");
            panel2.jTextField256.setText("OVERLAP B YELLOW (AUX5)");
            panel2.jTextField259.setText("OVERLAP B GREEN (AUX5)");
            panel2.jTextField262.setText("OVERLAP A RED (AUX4)");
            panel2.jTextField265.setText("OVERLAP A YELLOW (AUX4)");
            panel2.jTextField268.setText("OVERLAP A GREEN (AUX4)");
            panel2.jTextField271.setText("OFFSET 1 (AUX3 RED)");
            panel2.jTextField274.setText("LOGIC GROUND");
            panel2.jTextField277.setText("DIAL 3 (AUX3 GRN)");
            panel2.jTextField280.setText("OVERLAP D RED (AUX2)");
            panel2.jTextField283.setText("OVERLAP D YELLOW (AUX2)");
            panel2.jTextField286.setText("OVERLAP D GREEN (AUX2)");
            panel2.jTextField289.setText("OVERLAP C RED (AUX1)");
            panel2.jTextField292.setText("OVERLAP C YELLOW (AUX1)");
            panel2.jTextField295.setText("OVERLAP C GREEN (AUX1)");
            panel2.jTextField298.setText("SPECIAL FUNCTION 2");
            panel3.jTextField301.setText("SPECIAL FUNCTION 4");
            panel3.jTextField304.setText("DETECTOR RESET");
            panel3.jTextField307.setText("WATCHDOG");
            panel3.jTextField310.setText("LOGIC GROUND");
            break;
            case 2:
            break;
            case 3:
            break;
        }// TODO add your handling code here:
    }//GEN-LAST:event_ModelActionPerformed

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
       try
        {
            int[] ticks = new int[4000];
            String[] c1pin = new String[4000];
            int[] log170CH = new int[4000];
            int[] state = new int[4000];           
            long[] milliTime = new long[4000];
            double[] seconds = new double[4000];
            //timeA = panel1.getUnixTimeA();                          // User selection of Time A represented in Unix timestamp in milliseconds
            //timeB = panel1.getUnixTimeB();                          // User selection of Time B represented in Unix timestamp in milliseconds
            long msA = panel1.getmillisecondsA();
            long msB = panel1.getmillisecondsB();
            long secA = msA/1000/*panel1.elapSecA()*/;                          // Total seconds elapsed since previous midnight (Time A)
            long secB = msB/1000/*panel1.elapSecB()*/; 
            
            //boolean makeTime = true;
            //boolean midFlag = false;
            //int temp = 0;
            //int index = 0;
            //int qCount = 0;

           //getAddressPort();                                       // Assigns C1 pins to selected channels
           /* for(int alpha = 0; alpha < 32; alpha++)
            {
                System.out.println("Log 170 Index: " + alpha + " Value: " + panel1.log170Channel[alpha]);
            }*/
                
            conn = connect();                                       // Connects to database

            JFileChooser genFile = new JFileChooser();              // Pop-up dialog box to name file and save it in desired location
            int retVal = genFile.showSaveDialog(null);

            if (retVal == JFileChooser.APPROVE_OPTION) {
                dir = new FileWriter(genFile.getSelectedFile());
            }
            buff = new BufferedWriter(dir);
            //This statement is for data table
            PreparedStatement statement = conn.prepareStatement("SELECT C1_Reader_State, C1_Reader_Ticks, C1_Reader_Millis, C1_Pin FROM C1_Reader_Data_Test_Videosync_15 WHERE C1_Reader_Millis BETWEEN ? AND ?");
                  
            statement.setLong(1, msA);
            statement.setLong(2, msB);
            System.out.println(statement);
            if (conn == null) // If connection to database fails, convey this message
            {
                System.err.println("conn failed");
            }

            ResultSet rs = statement.executeQuery();
            int i = 0;
            while (rs.next())
            {
                ticks[i] = rs.getInt("C1_Reader_Ticks");
                c1pin[i] = rs.getString("C1_Pin");
                state[i] = rs.getInt("C1_Reader_State");               
                milliTime[i] = rs.getInt("C1_Reader_Millis");
                seconds[i] = ((double)milliTime[i])/1000;
                i++;
            }
            
            //for (int l=0; l<32; l++){
            //    log170CH[l]="0";
            //}
			
            for (int z=0; z<i; z++){
                int tempch = getChannel(c1pin[z]);
		log170CH[z]=tempch;
                System.out.println("log170CH[" + z + "]: "+log170CH[z]);
            }
            
            
            System.out.println("i: "+i);
            int j = 0; 
            //int t = 0;
                while (secA < secB)
                {
                    buff.write("AB");               // Writes the FEATURE
                    buff.write(StringUtils.leftPad((Long.toHexString(secA)), 5, "0"));          // Writes elapsed seconds since midnight
                
                    while (j < i)        
                    {    
                         System.out.println("C1pin is: " + c1pin[j]);
                         System.out.println("State is: " + state[j]);
                         System.out.println("Ticks is: " + ticks[j]);
                         System.out.println("Seconds is: " + seconds[j]);
                         System.out.println("secA: " + secA);
                         System.out.println("secAplus: " + (secA+1));
                         System.out.println("About to enter for loop");
                       
                        if ((seconds[j] >= secA) && (seconds[j] < (secA+1)))
                        {
                                System.out.println("Status Made Time");                                                  
                                
//                                if (c1pin[j].equals("0"))
//                                {
//                                    System.out.println("C1 pin can't equal to 0");
//                                    break;
//                                }
//                            
                                
                            for(int k = 0; k < i; k++)
                            {  
//                                if (panel1.log170Channel[k] == null)
//                                {
//                                    //System.out.println("That c1 pin was not one of the selected channels");
//                                    k++;
//                                    //break;
//                                }
                                //System.out.println("j: " + j);
                                System.out.println("log170CH[j]: " + log170CH[j]);
                                if (log170CH[j] != -1)
                                {
                                    System.out.println("We found one!");                  
                                    state[j] = state[j] * 32;                                                         // shift state 5 bits left
                                    ticks[j] = ticks[j] * 64;                                                         // shift ticks 6 bits left
                                    String binState = Integer.toBinaryString(state[j]);                            // sets state(base 10) to binState(base 2)
                                    binState = StringUtils.leftPad(binState, 16, "0");                          // setting length of binState to 16 with '0'

                                    String binTicks = Integer.toBinaryString(ticks[j]);                            // sets ticks(base 10) to binTicks(base 2)
                                    binTicks = StringUtils.leftPad(binTicks, 16, "0");                          // setting length of binTicks to 16 with '0'
 
                                    String binChan = Integer.toBinaryString(log170CH[j]);                             // sets index(base 10) to binChan(base 2)
                                    binChan = StringUtils.leftPad(binChan, 16, "0");                            // setting length of binChan to 16 with '0'

                                    int inState = Integer.parseInt(binState, 2);                                // sets binState(base 2) to inState(base 10)
                                    int inTicks = Integer.parseInt(binTicks, 2);                                // sets binTicks(base 2) to inTicks(base 10)
                                    int inChan = Integer.parseInt(binChan, 2);                                  // sets binChan(base 2)  to inChan(base 10)

                                    int sum = inState + inTicks + inChan;                                       // grabs summation on inState, inTicks & inChan
                                    String binSum = StringUtils.leftPad(Integer.toBinaryString(sum), 12, "0");  // sets sum(base 2) to binSum(String) and pads left with '0' to achieve length of 12
                                    String hexSum = Integer.toHexString(Integer.parseInt(binSum,2));            // sets binSum(String) to hexSum(base 16)
                                    String event = hexSum;                                                      // event is the value to be written to file
                                    buff.write(StringUtils.leftPad(event,3,"0"));                               // pads left '0' to ensure length of 3 and writes to buffer
                                    j++;
                                    //t++;
                                    //System.out.println("j: " + j);
                                    break;
                                }
                                System.out.println("j: "+j);
                                //System.out.println("event per second: " + t);
                            }    
                        } 
                        else
                        {   
                            System.out.println("Status Didn't Make Time");                           
                            break;
                        }                       
                                              
                    }  
                    buff.write("BA");
                    secA++;
                    buff.newLine();               
                }
                buff.close();
                
        } catch (IOException io) {
            System.err.println("Error: " + io.getMessage());
        } catch (SQLException se) {
            System.err.println("Error: " + se.getMessage());
        } catch (NullPointerException ne) {
            System.out.println("Nothing to point to");
            ne.printStackTrace();
        }
     
   
	
    }//GEN-LAST:event_GenerateActionPerformed

    private void ReadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadFileActionPerformed
        FileFilter filter = new FileNameExtensionFilter("TextFile","txt");
        JFileChooser C1 = new JFileChooser();
        C1.setFileFilter(filter);
        C1.showOpenDialog(null);
        File data = C1.getSelectedFile();
        data = new File(data.getAbsolutePath());
         
        try { 
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
               int YEAR, DAY, month = 0;
                YEAR = Integer.parseInt((String)panel1.Year.getSelectedItem());
                DAY = Integer.parseInt(panel1.Date.getText());
                cal.set(Calendar.YEAR,YEAR);
                cal.set(Calendar.MONTH,month);
                cal.set(Calendar.DAY_OF_MONTH, DAY);
                switch((String)panel1.Month.getSelectedItem()){
                  case "January":     month = 0;
                  break;
                  case "February":    month = 1;
                  break;
                  case "March":       month = 2;
                  break;
                  case "April":       month = 3;
                  break;
                  case "May":         month = 4;
                  break;
                  case "June":        month = 5;
                  break;
                  case "July":        month = 6;
                  break;
                  case "August":      month = 7;
                  break;
                  case "September":   month = 8;
                  break;
                  case "October":     month = 9;
                  break;
                  case "November":    month = 10;
                  break;
                  case "December":    month = 11;
                  break;
                  default:            break;
                }
            BufferedReader br = new BufferedReader(new FileReader(data));
            String line;
            int i = 0;
            int j = 0;
            int k = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;   
            
            while((line = br.readLine()) != null)
            {
                lineList[i] = line;
                i++;
            }
            br.close();
            
            lineList = Arrays.stream(lineList).filter(s -> (s!= null && s.length() > 0)).toArray(String[]::new);
          
            for(j = 0; j < lineList.length; j++)
            {       
                set = lineList[j].split(" ");
                set = Arrays.stream(set).filter(s -> (s!= null && s.length() > 0)).toArray(String[]::new);
                for(k = 0; k < set.length; k++)
                {
                    if(k % 4 == 0)
                    {
                        chipNum = set[k];
                        cNum[a] = Integer.valueOf(chipNum);
                        a++;
                        //System.out.println("Chip Num: " + cNum);
                    }
                    else if((k-1) % 4 == 0)
                    {
                        channel = set[k];
                        cChan[b] = Integer.valueOf(channel);
                        b++;
                        //System.out.println("Channel: " + channel);
                    }
                    else if((k-2) % 4 == 0)
                    {
                        status = set[k];
                        cstatus[c] = Integer.valueOf(status);
                        c++;
                        //System.out.println("Status: " + status);
                    }
                    else if((k-3) % 4 == 0)
                    {
                        time = set[k];
                        milli[d] = Integer.parseInt(time);
                        //System.out.println("Time: " + milli);
                        int hourMilli, minMilli;
                        int secMilli;
                        hourMilli = milli[d] / 3600000;
                        minMilli = milli[d] - (hourMilli * 3600000);
                        min[d] = minMilli / 60000;
                        secMilli = minMilli - (min[d]*60000);
                        sec[d] = secMilli / 1000;
                        milliTimer[d] = secMilli - (sec[d]*1000);
                        numTick[d] = milliTimer[d]/17;
                        cal.set(Calendar.HOUR_OF_DAY, milli[d]/3600000);
                        cal.set(Calendar.MINUTE, min[d]);
                        cal.set(Calendar.SECOND, sec[d]);
                        cal.set(Calendar.MILLISECOND,milliTimer[d]);
                        unix[d] = (cal.getTimeInMillis());
                        d++;
                                                                  
                    }
                }
            }
         
          System.out.println(cNum.length);
        } catch(IOException e){
            System.out.println("File could not be opened");
        }
       
        try {
            makefile();
           
        } catch (IOException ex) {
        } catch (WriteException ex) {}
        
      /*  try {
            
            JFileChooser Data = new JFileChooser();     
            int retVal = Data.showSaveDialog(null);
            File dat = Data.getSelectedFile();
            String LOG = dat.getAbsolutePath()+".dat";
            if (retVal == JFileChooser.APPROVE_OPTION) {
              dir = new FileWriter(LOG);
            }
            buff = new BufferedWriter(dir);
           
            buff.close();
        }catch (IOException io) {
            io.printStackTrace();
        }*/
    }//GEN-LAST:event_ReadFileActionPerformed

    private void sync_dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sync_dbActionPerformed
        int YEAR = 0, DAY = 0, month = 0;
        String _month;
        String datacsv="";
        FileFilter filter = new FileNameExtensionFilter("TextFile","txt");
        JFileChooser C1 = new JFileChooser();
        C1.setFileFilter(filter);
        C1.showOpenDialog(null);
        File data = C1.getSelectedFile();
        data = new File(data.getAbsolutePath());
       
         
        try { 
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("PST"));
               
                YEAR = Integer.parseInt((String)panel1.Year.getSelectedItem());
                DAY = Integer.parseInt(panel1.Date.getText());
                cal.set(Calendar.YEAR,YEAR);
                cal.set(Calendar.MONTH,month);
                cal.set(Calendar.DAY_OF_MONTH, DAY);
                switch((String)panel1.Month.getSelectedItem()){
                  case "January":     month = 1;
                  break;
                  case "February":    month = 2;
                  break;
                  case "March":       month = 3;
                  break;
                  case "April":       month = 4;
                  break;
                  case "May":         month = 5;
                  break;
                  case "June":        month = 6;
                  break;
                  case "July":        month = 7;
                  break;
                  case "August":      month = 8;
                  break;
                  case "September":   month = 9;
                  break;
                  case "October":     month = 10;
                  break;
                  case "November":    month = 11;
                  break;
                  case "December":    month = 12;
                  break;
                  default:            break;
                }
            BufferedReader br = new BufferedReader(new FileReader(data));
            String line;
            int i = 0;
            int j = 0;
            int k = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;   
            
            while((line = br.readLine()) != null)
            {
                lineList[i] = line;
                i++;
            }
            br.close();
            
            lineList = Arrays.stream(lineList).filter(s -> (s!= null && s.length() > 0)).toArray(String[]::new);
          
            for(j = 0; j < lineList.length; j++)
            {       
                set = lineList[j].split(" ");
                set = Arrays.stream(set).filter(s -> (s!= null && s.length() > 0)).toArray(String[]::new);
                for(k = 0; k < set.length; k++)
                {
                    if(k % 4 == 0){
                        chipNum = set[k];
                        cNum[a] = Integer.valueOf(chipNum);
                        a++;
                        //System.out.println("Chip Num: " + cNum);
                    }
                    else if((k-1) % 4 == 0)
                    {
                        channel = set[k];
                        cChan[b] = Integer.valueOf(channel);
                        b++;
                        //System.out.println("Channel: " + channel);
                    }
                    else if((k-2) % 4 == 0)
                    {
                        status = set[k];
                        cstatus[c] = Integer.valueOf(status);
                        c++;
                        //System.out.println("Status: " + status);
                    }
                    else if((k-3) % 4 == 0)
                    {
                        time = set[k];
                        milli[d] = Integer.parseInt(time);
                        //System.out.println("Time: " + milli);
                        int hourMilli, minMilli;
                        int secMilli;
                        hourMilli = milli[d] / 3600000;
                        minMilli = milli[d] - (hourMilli * 3600000);
                        min[d] = minMilli / 60000;
                        secMilli = minMilli - (min[d]*60000);
                        sec[d] = secMilli / 1000;
                        milliTimer[d] = secMilli - (sec[d]*1000);
                        numTick[d] = milliTimer[d]/17;
                        cal.set(Calendar.HOUR_OF_DAY, milli[d]/3600000);
                        cal.set(Calendar.MINUTE, min[d]);
                        cal.set(Calendar.SECOND, sec[d]);
                        cal.set(Calendar.MILLISECOND,milliTimer[d]);
                        unix[d] = (cal.getTimeInMillis());
                        d++;
                                                                  
                    }
                }
            }
         
          System.out.println(cNum.length);
        } catch(IOException e){
            System.out.println("File could not be opened");
        }
       
        try {
                int i = 0;
                datacsv = "/Users/caltrans/Documents/tempdata/C1.txt";
                PrintWriter writer = new PrintWriter(datacsv, "UTF-8");
                //datacsv = "/Users/caltrans/Documents/tempdata/C1.txt";
                //FileWriter writer = new FileWriter(datacsv);
         
        	int [] time = new int[1000];
       		time = milli;
        	int len = 0;
        	for(int z = 0; z < time.length; z++)
       		{
                    if(time[z] != 0)
                    {
                        len++;
                    }
       		} 
      
        	for(i = 0; i < len; i++)
        	{
                    writer.append(Integer.toString(cNum[i]));
                    writer.append(',');
                    writer.append(Integer.toString(cChan[i]));
                    writer.append(',');
                    writer.append(Integer.toString(39));
                    writer.append(',');
                    writer.append(Integer.toString(0));
                    writer.append(',');
                    writer.append(Integer.toString(cstatus[i]));
                    writer.append(',');
                    writer.append(Integer.toString(numTick[i]));
                    writer.append(',');
                    writer.append(Integer.toString(milli[i]));
                    writer.append(',');
                    writer.append(Long.toString(unix[i]));
                    writer.append('\n');           
       		}
        	writer.close();
           		
            } catch (IOException ex) {
            } 
        
        try
        {
        conn = connect();
       
        String query = "LOAD DATA LOCAL INFILE '" + datacsv +"' INTO TABLE C1_Reader_Data_Test_Videosync_15 FIELDS TERMINATED BY \',\' LINES TERMINATED BY ?" +  
                "(C1_Chip_Num, C1_Reader_Channel, C1_Pin, Log170_Channel, C1_Reader_State, C1_Reader_Ticks, C1_Reader_Millis, C1_Reader_Unix) SET C1_Date = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, "\n");
        if (month < 10){
            _month = "0" + Integer.toString(month);
        }else{
            _month = Integer.toString(month);
        }
        String date_db = Integer.toString(YEAR) + _month + Integer.toString(DAY);
        statement.setString(2,date_db);
        //statement.setString(2,Integer.toString(YEAR));
        //statement.setString(3,Integer.toString(month));
        //statement.setString(4,Integer.toString(DAY));
        ResultSet count = statement.executeQuery();
        
        System.out.println(count);
        
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }//GEN-LAST:event_sync_dbActionPerformed

    private void headwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headwayActionPerformed
        timeA = panel1.getUnixTimeA();                  // User selection of Time A represented in Unix timestamp in milliseconds
        timeB = panel1.getUnixTimeB();                  // User selection of Time B represented in Unix timestamp in milliseconds
        conn = connect();                               // Connects to database
        getAddressPort();                               // Assigns C1 pins to selected channels
        int timeMinus = -1;                                // Time for event one must be high, initialized to zero to verify initial hight event
        int time = 0;                                // Time for event two
        int rangeA = (Integer.parseInt((String)panel1.HourA.getSelectedItem())*60) + Integer.parseInt((String)panel1.MinuteA.getSelectedItem());
        int rangeB = (Integer.parseInt((String)panel1.HourB.getSelectedItem())*60) + Integer.parseInt((String)panel1.MinuteB.getSelectedItem());
        int selMin = Integer.parseInt((String)panel1.MinuteA.getSelectedItem());
        int interval = 60;  //5 is a placeholder for jTextField which will contain user input of interval (value represents minutes)
        int rows = (rangeB - rangeA)/interval;              // Amount of rows depend on width of time range in correspondence with interval
        int headway = 0;                                    // Value which is written to buffer
        int headwayTotal = 0;       
        
        try
        {
            JFileChooser volumeFile = new JFileChooser();   // Pop-up dialog box to name file and save it in desired location
            int retVal = volumeFile.showSaveDialog(null);

            if (retVal == JFileChooser.APPROVE_OPTION) {
                dir = new FileWriter(volumeFile.getSelectedFile());
            }
            buff = new BufferedWriter(dir);                 // Buffer in which headers and data is written
            buff.write("Time Range  ");                                // Sets top-left corner empty

            for (int i = 0; i < 32; i++)                    // Loop goes through selected channels and displays them as headers
            {
                if (panel1.log170Channel[i] != null)        // If channel is assigned to a C1 pin...
                {
                    buff.write("" + String.valueOf(i));    // Then write it as a header
                    buff.write(" ");
                }
            }
            buff.newLine();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }  // TODO add your handling code here:

        try
        {
            for (int i = 0; i < rows; i++)              // Loops through intervals of selected times
            {
                int hour1 = rangeA/60;                  //
                rangeA += interval;
                int hour2 = rangeA/60;

                int min1 = selMin;
                if (min1 > 59)
                {
                    min1 = min1 - 60;
                    selMin = 0;
                }
                selMin += interval;
                int min2 = selMin;
                if (min2 > 59)
                {
                    min2 = min2 - 60;
                    selMin = 0;
                }

                String minA = StringUtils.leftPad(Integer.toString(min1),2,"0");
                String minB = StringUtils.leftPad(Integer.toString(min2),2,"0");

                buff.write(hour1 + ":" + minA + "_" + hour2 + ":" + minB);
                buff.write(" ");

                for(int j = 0; j< 32; j++)
                {
                    if (panel1.log170Channel[j] != null)
                    {
          
                        int c1pin = Integer.parseInt(panel1.log170Channel[j]);
                        String query = "SELECT C1_Reader_State, C1_Reader_Millis FROM C1_Reader_Data WHERE C1_Pin = ? AND C1_Reader_Unix BETWEEN ? AND ?";
                        PreparedStatement statement = conn.prepareStatement(query);
                        statement.setInt(1, c1pin);
                        statement.setDouble(2, timeA);
                        statement.setDouble(3, timeA + (interval * 60000));
                
                            System.out.println("C1 pin: " + c1pin);
                            if (conn == null)
                            {
                                System.out.println("There was a problem connecting");
                            }

                            ResultSet rs = statement.executeQuery();
                            if (rs.equals(null))
                            {
                                buff.write("0");
                                buff.write(" ");
                            }
                            else
                            {
                                
                                while (rs.next())                               
                                {            
                                    if(rs.getInt("C1_Reader_State") == 1)
                                    {
                                        if (timeMinus == -1)
                                        {
                                            timeMinus = rs.getInt("C1_Reader_Millis");                                         
                                            System.out.println("timeOne: " + timeMinus);
                                            //System.out.println("timeOne: " + time);
                                        }
                                        else
                                        {
                                            time = rs.getInt("C1_Reader_Millis");
                                            headway = time-timeMinus;
                                            timeMinus = time;
                                        }
                                        //buff.write(String.valueOf(headway));
                                        //buff.write("  ");                                                                                                                                               
                                    }
                                    headwayTotal += headway;                                                                             
                                    System.out.println("headway: " + headway);
                                    System.out.println("headwayTotal: " + headwayTotal);
                                }
                                buff.write(String.valueOf(headwayTotal));
                                buff.write("  ");                  
                                headwayTotal = 0;
                            }
                        }
                    }
                    buff.newLine();
                    timeA = timeA + (interval * 60000);
                }
                buff.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
    }//GEN-LAST:event_headwayActionPerformed
    
    // function to extend or shrink log170 data from file
    private void adjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustActionPerformed
        
        Charset charset = Charset.forName("US-ASCII");
        long mil_initial=0;
        Path tempfile = null;
        
        JFileChooser File1 = new JFileChooser();
        int retVal1 = File1.showOpenDialog(null);      
        File reading = File1.getSelectedFile();
        String infile = reading.getAbsolutePath();
        
        /*JFileChooser File = new JFileChooser();
        int retVal = File.showSaveDialog(null);
        File writing = File.getSelectedFile();
        String outfile = writing.getAbsolutePath();
        */
        try {
                tempfile = Files.createTempFile("outfile", ".txt");
                System.out.format("The temporary file" + " has been created: %s%n", tempfile);
        } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
        }
        
        Path path = Paths.get(infile);
	Path path2 = Paths.get("outfile.txt");
	String [] packet = new String [36010];
	int count = 0;
        int i = 0;
        
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                packet[count] = line;               
                mil_initial = (Long.parseLong(packet[0].substring(2,7), 16))*1000;                       	
                count++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
		
        //String headers = "170channel  ,  170state,  170Ticks,  170millis  ,  170Unix  ,  170Date\n"; 
	try (BufferedWriter writer = Files.newBufferedWriter(path2, charset)) {
            //writer.write(headers, 0, headers.length());		// headers
            while (i < count){
            	if (packet[i].length() > 9){
                    int j=0;
                    while (j < (packet[i].length() - 9)/3){
            		long seconds = Long.parseLong(packet[i].substring(2,7), 16);
                	long code = Long.parseLong(packet[i].substring((3*(j+2)+1),3*(j+3)+1), 16);
            			
            		long mil = seconds * 1000;
               		String bicode = Long.toBinaryString(code);
            			
            		//System.out.println("bicode len: " + bicode.length());
         		if (bicode.length() < 12){ //add leading zeros
                            if (bicode.length() == 0) {
        			bicode = "000000000000" + bicode;
                            }
                            if (bicode.length() == 1) { 
        			bicode = "00000000000" + bicode;
                            }
                            if (bicode.length() == 2) {
  				bicode = "0000000000" + bicode;
                            }
                            if (bicode.length() == 3) {     
        			bicode = "000000000" + bicode;
                            }
                            if (bicode.length() == 4) {     
        			bicode = "00000000" + bicode;
                            }
                            if (bicode.length() == 5) {    
        			bicode = "0000000" + bicode;
                            }
                            if (bicode.length() == 6) {  
        			bicode = "000000" + bicode;
                            }
                            if (bicode.length() == 7) {     
        			bicode = "00000" + bicode;
               		    }
                            if (bicode.length() == 8) {    
        			bicode = "0000" + bicode;
                            }
                            if (bicode.length() == 9) {     
        			bicode = "000" + bicode;
                            }
                            if (bicode.length() == 10) {       
        			bicode = "00" + bicode;
                            }
        		    if (bicode.length() == 11) {     
        			bicode = "0" + bicode;        					
                            }	
            		} 
            			
                        //System.out.println("code: " + code);
                        //System.out.println("bicode: " + bicode);
            			
            		String biticks = bicode.substring(0,6);
            		char bistate = bicode.charAt(6);          			
            		String bichannel = bicode.substring(7, 12);
            			
          		long ticks = Long.parseLong(biticks, 2);
            		long channel = Long.parseLong(bichannel, 2);
                        
            		mil = mil + (ticks*17);
            		
                        System.out.println("milinitial: " + mil_initial);
                        System.out.println("mil: " + mil);
                        
            		double mill = (mil - mil_initial) * Float.parseFloat(factorTextField.getText()); //relative zero and multiplied by fudge factor
            		long milli = (long) mill; 
                        
                       
                        String c1pin;
                        int channelint = (int)channel;
                        switch (channelint) {
                        case 0:  c1pin = "47";
                                break;
                        case 1:  c1pin = "48";
                                break;
                        case 2:  c1pin = "49";
                                break;
                        case 3:  c1pin = "50";
                                break;
                        case 6:  c1pin = "53";
                                break;
                        case 7:  c1pin = "54";
                                break;
                        case 8:  c1pin = "55";
                                break;
                        case 9:  c1pin = "56";
                                break;
                        case 10:  c1pin = "57";
                                break;
                        case 11: c1pin = "58";
                                break;
                        case 12: c1pin = "59";
                                break;
                        case 13: c1pin = "60";
                                break;
                        case 14:  c1pin = "61";
                                break;
                        case 15:  c1pin = "62";
                                break;
                        case 24:  c1pin = "75";
                                break;
                        case 25:  c1pin = "76";
                                break;
                        case 26:  c1pin = "77";
                                break;
                        case 27:  c1pin = "78";
                                break;
                        case 28:  c1pin = "79";
                                break;
                        case 29:  c1pin = "80";
                                break;   
                        default: c1pin = "c1pin unknown";
                                break;
                        }
                        
                                   			            			
            		String sticks = Long.toString(ticks);
            		String schannel = Long.toString(channel);
            		String	millis = Long.toString(milli);
            		String state = "" + bistate;
            			             		          	
            		writer.write(schannel, 0, schannel.length());
            		writer.write("  ,  ");
                        writer.write(c1pin, 0, c1pin.length());
            		writer.write("  ,  ");
            		writer.write(state, 0, state.length());
            		writer.write("  ,  ");
            		writer.write(sticks, 0, sticks.length());
			writer.write("  ,  ");
                        writer.write(millis, 0, millis.length());
			writer.write("  ,  ");
			writer.write("0", 0, 1);
			writer.write("  ,  ");
                        writer.write("0", 0, 1);
			writer.newLine();	
                        j++;
                    }
		}
		i++;            						
            }
        }catch (IOException x) {
            System.err.format("IOException: %s%n", x);
	}
        
        try
        {
            conn = connect();
            String outfile2 = "/tmp/outfile.txt";

            String query = "LOAD DATA LOCAL INFILE '" + outfile2 +"' INTO TABLE C1_Reader_Data_Test_11 FIELDS TERMINATED BY \',\' LINES TERMINATED BY ?" +
            "(170Channel, C1Pin, 170State, 170Ticks, 170Millis) SET 170Unix = \'0\' AND 170Date = \'2015-007-09\'";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "\n");
            ResultSet list = statement.executeQuery();

            System.out.println(list);

        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        
        GenerateLog170();
    }//GEN-LAST:event_adjustActionPerformed
    
      public void GenerateLog170() {                                         
        try
        {
            int[] ticks = new int[14000];
            String[] c1pin = new String[14000];
            String[] channel170 = new String[32];
            int[] state = new int[14000];           
            long[] milliTime = new long[14000];
            double[] seconds = new double[14000];
            timeA = panel1.getUnixTimeA();                          // User selection of Time A represented in Unix timestamp in milliseconds
            timeB = panel1.getUnixTimeB();                          // User selection of Time B represented in Unix timestamp in milliseconds
            long secA = panel1.elapSecA();                          // Total seconds elapsed since previous midnight (Time A)
            long secB = panel1.elapSecB();                          // Total seconds elapsed since previous midnight (Time B)
            boolean makeTime = true;
            //boolean mi     unt = 0;
            
            for (int l=0; l<32; l++){
                channel170[l]= Integer.toString(l);
            }

            getAddressPort();                                       // Assigns C1 pins to selected channels
           /* for(int alpha = 0; alpha < 32; alpha++)
            {  
                System.out.println("Log 170 Index: " + alpha + " Value: " + panel1.log170Channel[alpha]);
            }*/
                
            conn = connect();                                       // Connects to database

            JFileChooser genFile = new JFileChooser();              // Pop-up dialog box to name file and save it in desired location
            int retVal = genFile.showSaveDialog(null);

            if (retVal == JFileChooser.APPROVE_OPTION) {
                dir = new FileWriter(genFile.getSelectedFile());
            }
            buff = new BufferedWriter(dir);
            //This statement is for data table
            //PreparedStatement statement = conn.prepareStatement("SELECT C1_Reader_State, C1_Reader_Ticks, C1_Reader_Millis, C1_Pin FROM C1_Reader_Data_Test_Videosync WHERE C1_Reader_Unix BETWEEN ? AND ?");
            PreparedStatement statement = conn.prepareStatement("SELECT 170State, 170Ticks, 170Millis, 170Channel FROM C1_Reader_Data_Test_11");     
            //statement.setDouble(1, timeA);
            //statement.setDouble(2, timeB);
            System.out.println(statement);
            if (conn == null) // If connection to database fails, convey this message
            {
                System.err.println("conn failed");
            }

            ResultSet rs = statement.executeQuery();
            int i = 0;
            while (rs.next())
            {
                ticks[i] = rs.getInt("170Ticks");
                c1pin[i] = rs.getString("170Channel");
                state[i] = rs.getInt("170State");               
                milliTime[i] = rs.getInt("170Millis");
                seconds[i] = ((double)milliTime[i])/1000;
                i++;
            }
            System.out.println("i: "+i);
            int j = 0;            
                while (secA < secB)
                {
                    buff.write("AB");               // Writes the FEATURE
                    buff.write(StringUtils.leftPad((Long.toHexString(secA)), 5, "0"));          // Writes elapsed seconds since midnight
                
                    while (j < i)        
                    {    
                         System.out.println("C1pin is: " + c1pin[j]);
                         System.out.println("State is: " + state[j]);
                         System.out.println("Ticks is: " + ticks[j]);
                         System.out.println("Seconds is: " + seconds[j]);
                         System.out.println("secA: " + secA);
                         System.out.println("secAplus: " + (secA+1));
                         System.out.println("About to enter for loop");
                       
                        if ((seconds[j] >= secA) && (seconds[j] < (secA+1)))
                        {
                                System.out.println("Status Made Time");                                                  
                                
//                                if (c1pin[j].equals("0"))
//                                {
//                                    System.out.println("C1 pin can't equal to 0");
//                                    break;
//                                }
//                            
//                                
                            for (int k = 0; k < 32; k++)
                            {
                                if (panel1.log170Channel[k] == null)
                                {
                                    System.out.println("That c1 pin was not one of the selected channels");
                                    panel1.log170Channel[k] = "-1";
                                    
                                }
                                //System.out.println("k: " + k);
                                //System.out.println("panel1.log170Channel[k]: " + panel1.log170Channel[k]);
                                
                                if (channel170[k].equals(c1pin[j]))
                                {
                                    System.out.println("We found one!");                  
                                    state[j] = state[j] * 32;                                                         // shift state 5 bits left
                                    ticks[j] = ticks[j] * 64;                                                         // shift ticks 6 bits left
                                    String binState = Integer.toBinaryString(state[j]);                            // sets state(base 10) to binState(base 2)
                                    binState = StringUtils.leftPad(binState, 16, "0");                          // setting length of binState to 16 with '0'

                                    String binTicks = Integer.toBinaryString(ticks[j]);                            // sets ticks(base 10) to binTicks(base 2)
                                    binTicks = StringUtils.leftPad(binTicks, 16, "0");                          // setting length of binTicks to 16 with '0'

                                    String binChan = Integer.toBinaryString(k);                             // sets index(base 10) to binChan(base 2)
                                    binChan = StringUtils.leftPad(binChan, 16, "0");                            // setting length of binChan to 16 with '0'

                                    int inState = Integer.parseInt(binState, 2);                                // sets binState(base 2) to inState(base 10)
                                    int inTicks = Integer.parseInt(binTicks, 2);                                // sets binTicks(base 2) to inTicks(base 10)
                                    int inChan = Integer.parseInt(binChan, 2);                                  // sets binChan(base 2)  to inChan(base 10)

                                    int sum = inState + inTicks + inChan;                                       // grabs summation on inState, inTicks & inChan
                                    String binSum = StringUtils.leftPad(Integer.toBinaryString(sum), 12, "0");  // sets sum(base 2) to binSum(String) and pads left with '0' to achieve length of 12
                                    String hexSum = Integer.toHexString(Integer.parseInt(binSum,2));            // sets binSum(String) to hexSum(base 16)
                                    String event = hexSum;                                                      // event is the value to be written to file
                                    buff.write(StringUtils.leftPad(event,3,"0"));                               // pads left '0' to ensure length of 3 and writes to buffer
                                    j++;
                                    break;
                                }
                                if (k == 31)
                                {
                                    j++;
                                }
                            }    
                        } 
                        else
                        {   
                            System.out.println("Status Didn't Make Time");                           
                            break;
                        }                       
                        System.out.println("j: "+j);                      
                    }  
                    buff.write("BA");
                    secA++;
                    buff.newLine();               
                }
                buff.close();
                
        } catch (IOException io) {
            System.err.println("Error: " + io.getMessage());
        } catch (SQLException se) {
            System.err.println("Error: " + se.getMessage());
        } catch (NullPointerException ne) {
            System.out.println("Nothing to point to");
            ne.printStackTrace();
        }  // TODO add your handlin
    }   
    
    public void makefile() throws IOException, WriteException{
        int i = 0;  
        
        JFileChooser CSVFile = new JFileChooser();
        int retVal = CSVFile.showSaveDialog(null);
        File writing = CSVFile.getSelectedFile();
        String LOG = writing.getAbsolutePath()+".csv";
        if(retVal == JFileChooser.APPROVE_OPTION) {
            writer = new FileWriter(LOG);
        }
        //FileWriter writer = new FileWriter("C:\\Users\\Alex\\Desktop\\C1\\C1.csv");
         
        int [] time = new int[1000];
        time = milli;
        int len = 0;
        for(int z = 0; z < time.length; z++)
        {
            if(time[z] != 0)
            {
                len++;
            }
        } 
      
        for(i = 0; i < len; i++)
        {
            writer.append(Integer.toString(cNum[i]));
            writer.append(',');
            writer.append(Integer.toString(cChan[i]));
            writer.append(',');
            writer.append(Integer.toString(panel1.PinNumber.getSelectedIndex()));
            writer.append(',');
            writer.append(Integer.toString(cstatus[i]));
            writer.append(',');
            writer.append(Integer.toString(numTick[i]));
            writer.append(',');
            writer.append(Integer.toString(milli[i]));
            writer.append(',');         
            hour[i] = milli[i]/3600000;
            writer.append(Integer.toString(hour[i]));
            writer.append(',');
            writer.append(Integer.toString(min[i]));
            writer.append(',');
            writer.append(Integer.toString(sec[i]));
            writer.append(',');
            writer.append(Integer.toString(milliTimer[i]));
            writer.append(',');           
            writer.append(Long.toString(unix[i]));
            writer.append('\n');           
        }
        writer.close();
  }
    
    // function that maps c1pin to log170 channel for now only input c1pins  47-83 minus cpins 71-74
    public int getChannel(String inputpin)
	{
                int tempinputpin = Integer.parseInt(inputpin);
                int outputch = -1; 
                //assigned comboPin "100" to inactive c1pins since 170 controller only reads 32 channels
                for (int i=1; i < 39; i++){
                    if (tempinputpin == i)
                        outputch = -1;
                }
                for (int i=39, j=0; i < 63; i++, j++){
                    if (tempinputpin == i)
                        outputch = j;
                }
		for (int i=63, j=0; i < 75; i++, j++){ // must assignchannels to translate to log 170
                    if (tempinputpin == i)
                        outputch = j;
                }
                for (int i=75, j=24; i < 83; i++, j++){
                    if (tempinputpin == i)
                        outputch = j;
                }
                for (int i=83; i < 105; i++){
                    if (tempinputpin == i)
                        outputch = -1;
                }
		//System.out.println("comboPin[0] is: " + comboPin);
		return outputch;
	}
    
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
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JTextField DirBrowse;
    private javax.swing.JButton Generate;
    private javax.swing.JComboBox Model;
    private javax.swing.JButton Occupancy;
    private javax.swing.JButton Page1;
    private javax.swing.JButton Page2;
    private javax.swing.JButton Page3;
    private javax.swing.JPanel PanelCard;
    private javax.swing.JButton ReadFile;
    private javax.swing.JButton Save;
    private javax.swing.JButton Upload;
    private javax.swing.JButton Volume;
    private javax.swing.JButton adjust;
    private javax.swing.JTextField factorTextField;
    private javax.swing.JButton headway;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton length;
    private c1gui.Panel1 panel1;
    private c1gui.Panel2 panel2;
    private c1gui.Panel3 panel3;
    private javax.swing.JButton sync_db;
    private c1gui.TabbedPanel1 tabbedPanel1;
    // End of variables declaration//GEN-END:variables
}
