package dndhelper.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Properties;

public class DatabaseManager {

	public static void Backupdbtosql() {
	    try {
	    	Properties properties = new Properties();
	    	properties.load(DatabaseManager.class.getResourceAsStream("/application.properties"));
	        /*NOTE: Getting path to the Jar file being executed*/
	        /*NOTE: YourImplementingClass-> replace with the class executing the code*/
	        CodeSource codeSource = DatabaseManager.class.getProtectionDomain().getCodeSource();
	        File jarFile = new File(codeSource.getLocation().toURI().getPath());
	        String jarDir = jarFile.getParentFile().getPath();


	        /*NOTE: Creating Database Constraints*/
	        String dbName = properties.getProperty("jdbc.dbname");
	        String dbUser = properties.getProperty("jdbc.username");
	        String dbPass = properties.getProperty("jdbc.password");

	        /*NOTE: Creating Path Constraints for folder saving*/
	        /*NOTE: Here the backup folder is created for saving inside it*/
	        String folderPath = jarDir + "\\backup";

	        /*NOTE: Creating Folder if it does not exist*/
	        File f1 = new File(folderPath);
	        f1.mkdir();

	        /*NOTE: Creating Path Constraints for backup saving*/
	        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
	         String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
	         System.out.println(savePath);
	        /*NOTE: Used to create a cmd command*/
	        String executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump --user=" 
	        		+ dbUser + " -p" + dbPass + " --host=127.0.0.1 --routines " + dbName + " -r " + savePath;
	        //executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump"
	        		//+ " --user=admin -padmin --host=127.0.0.1 dndhelper -r c:\\backup\\backup.sql";
	        /*NOTE: Executing the command here*/
	        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                                    
            // any error???
            int exitVal = runtimeProcess.waitFor(); 

	        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
	        if (exitVal == 0) {
	            System.out.println("Backup Complete " + exitVal);
	        } else {
	            System.out.println("Backup Failure not exception " + exitVal);
	        }

	    } catch (URISyntaxException | IOException | InterruptedException e) {
	    	System.out.println("Backup Failure at backup");
	    	e.printStackTrace();
	    }
	}
	
	public static void Restoredbfromsql() {
            /*NOTE: String s is the mysql file name including the .sql in its name*/
            /*NOTE: Getting path to the Jar file being executed*/
            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
        CodeSource codeSource = DatabaseManager.class.getProtectionDomain().getCodeSource();
        File jarFile;
		try {
	    	Properties properties = new Properties();
	    	properties.load(DatabaseManager.class.getResourceAsStream("/application.properties"));
			jarFile = new File(codeSource.getLocation().toURI().getPath());

            String jarDir = jarFile.getParentFile().getPath();

            /*NOTE: Creating Database Constraints*/
	        String dbName = properties.getProperty("jdbc.dbname");
	        String dbUser = properties.getProperty("jdbc.username");
	        String dbPass = properties.getProperty("jdbc.password");

            /*NOTE: Creating Path Constraints for restoring*/
	        String restorePath = jarDir + "\\backup\\" + "backup.sql";
            /*NOTE: Used to create a cmd command*/
            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
            String executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql"
            		+ " --user=" + dbUser + " -p" + dbPass + " --host=127.0.0.1" + " --execute=\"source " + restorePath + "\" " + dbName;
            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
	            System.out.println("Restore Complete");
            } else {
	            System.out.println("Restore Failed no exec");
            }
		} catch (URISyntaxException | IOException | InterruptedException e) {
			System.out.println("Restore Failed exec");
			e.printStackTrace();
		}


    }
}
