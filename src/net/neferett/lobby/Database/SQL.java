package net.neferett.lobby.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class SQL {
	
	static ResultSet resultat = null;
    private static Connection conn;
    static java.sql.Statement statement = null;
    
	static Player p;
	
	
	
	public static void connect() {
		try {
			String url = "jdbc:mysql://sql.linaris.fr/login_mc" ;	
			conn = DriverManager.getConnection(url, "tuc", "bANWZ78VREQwywuv");
	        statement = conn.createStatement();

			System.out.println("Base de donnée connectée avec succés A !"); 
		} catch (Exception except){
			System.out.println("Il y a un probleme avec la connection !");  
		}
	}

	
	public static void closeConnection(){
		try{
			SQL.conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
		public static int getLang(Player p){
	        try {
	            if (SQL.conn.isClosed()) {
	                SQL.connect();
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			
			try {
				java.sql.Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String verif = "SELECT * FROM `authme` WHERE `username` = '" + p.getName() + "'";
				ResultSet res = state.executeQuery(verif);
				while(res.next()){
				res.first();
				return res.getInt(15);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erreur lors de la verification de la lang");
			}
			return 0;
			
		}
		
		

		
		
		
		public static void setLang(int nb, Player p){
	        try {
	            if (SQL.conn.isClosed()) {
	                SQL.connect();
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			try{
				java.sql.Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String verif = "SELECT * FROM `authme` WHERE `username` = '" + p.getName() + "'";
				ResultSet res = state.executeQuery(verif);
				res.first();
				res.updateInt(15, nb);
				res.updateRow();
			} catch (Exception exept) {
				System.out.println("Joueur introuvable");
			}
		}
		

	

}   
