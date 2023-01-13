package com.cxf55200132.changedfiles;

import java.sql.*;

import java.io.*;
import java.util.*;
import java.math.*;
public class labTables
{
    static
    {   try
    {

        Class.forName ("com.ibm.db2.jcc.DB2Driver");
    }
    catch (Exception e)
    {   System.exit(1);
    }
    }
    public static void main( String args[]) throws Exception
    {
        try {

            Connection sample = DriverManager.getConnection("jdbc:db2://192.168.31.130:50000/sample","student","Cxx197559");

            DatabaseMetaData dbmd = sample.getMetaData();


            String [] tableTypes = {"TABLE", "VIEW"};


            ResultSet rs = dbmd.getTables(null, "STUDENT", "%",tableTypes);

            while (rs.next()) {
                String s = rs.getString(1);
                System.out.println("\nCatalog Name: " + s + " Schema Name: " + rs.getString(2) +
                        " Table Name: " + rs.getString(3) );
            }
        }  // End try
        catch (Exception e)
        { System.out.println ("\n Error MetaData Call");
            System.out.println ("\n " + e);
            System.exit(1);
        }
    }
}
