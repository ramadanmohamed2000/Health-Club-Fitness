package HealthAndFitnessClub;
import java.util.*;
public class Data {
	static String role = "";
	static String email = "";
	private Data() {
		
	}
	static Map<String, String> user(){
		DatabaseManager db = new DatabaseManager();
		String query = "SELECT * FROM "+role+" WHERE EMAIL='"+email+"'";
		Map<String, String> result = db.executeQuery(query);
		db.closeConnection();
		return result;
	}
	static Map<String, String> loyaltyPoints() {
		int id = Integer.parseInt(user().get("memberid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT sum(pointsearned) as pointsearned, sum(pointsredeemed) as pointsredeemed FROM loyaltyprogram where memberid="+id+"";
		Map<String, String> result = db.executeQuery(query);
		db.closeConnection();
		return result;
	}
	static Map<String, List<String>> session(){
		int id = Integer.parseInt(user().get("memberid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT name, date, time FROM PersonalTrainingSession inner join Trainer on PersonalTrainingSession.trainerid = Trainer.trainerid where memberid="+id+"";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	static Map<String, List<String>> sessionTrainerId(){
		int id = Integer.parseInt(user().get("trainerid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT sessionid, name, date, time FROM PersonalTrainingSession inner join Member on PersonalTrainingSession.memberid = Member.memberid where trainerid="+id+"";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	static Map<String, List<String>> sessionTrainer(){
		int id = Integer.parseInt(user().get("trainerid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT name, date, time FROM PersonalTrainingSession inner join Member on PersonalTrainingSession.memberid = Member.memberid where trainerid="+id+"";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	static Map<String, List<String>> classes(){
		int id = Integer.parseInt(user().get("memberid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT classname, date, time, name FROM GroupFitnessClass inner join Trainer on GroupFitnessClass.trainerid = Trainer.trainerid";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	static Map<String, List<String>> events(){
		
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT eventname, date, time FROM Event";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	static Map<String, List<String>> equipments(){
		
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT equipmentname, maintenancestatus FROM Equipment";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	static Map<String, List<String>> bills(){
		int id = Integer.parseInt(user().get("memberid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT date, amount, paymentstatus FROM Billing where memberid="+id+"";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
	}
	public static Map<String, List<String>> myClasses() {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(user().get("trainerid"));
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT classname, date, time FROM GroupFitnessClass where trainerid ="+id+"";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
		
	}
	public static Map<String, List<String>> rooms() {
		// TODO Auto-generated method stub
		DatabaseManager db = new DatabaseManager();
		
		String query = "SELECT roomname, availability FROM room";
		Map<String, List<String>> result = db.executeQueryAsKeyAndArray(query);
		db.closeConnection();
		return result;
	}
}
