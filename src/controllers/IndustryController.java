package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.InformationExpert;
import application.UserInformation;
import databasepackage.DBHandler;
import databasepackage.MySqlHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class IndustryController implements UserController {
	protected Stage stage;
	protected Scene scene;
	protected Parent root;
	@Override
	public void switchtoDashboard(ActionEvent e) throws IOException, SQLException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/fxmlFiles/industryfxml/Industry_Dashboard.fxml"));
		root = loader.load();
		SceneController contr = loader.getController();
		contr.setIndustry_Dashboard();
		contr.setAdminPieChart();
		contr.setAdminBar1();
		contr.setAdminBar2();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void switchtoCareer(ActionEvent e) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchtoContests(ActionEvent e) throws IOException, SQLException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/fxmlFiles/industryfxml/IndustryPerformance.fxml"));
		root = loader.load();
		SceneController contr = loader.getController();
		contr.setButton();
		contr.setQuizTable();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void switchtoSettings(ActionEvent e) throws IOException {
		// TODO Auto-generated method stub
		root = FXMLLoader.load(getClass().getResource("/fxmlFiles/industryfxml/Industry_Settings.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void switchtoJobInternship(ActionEvent e) throws IOException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchtoCourses(ActionEvent e) throws IOException, SQLException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/fxmlFiles/industryfxml/Industry_Offers.fxml"));
		root = loader.load();
		SceneController contr = loader.getController();
		contr.setAppliedTable();
		contr.setOffersTable();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void switchtoFeedback(ActionEvent e) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	////Changes////
	@Override
	public void switchtoStudyMaterial(ActionEvent e, UserInformation user) throws IOException, SQLException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/fxmlFiles/industryfxml/IndustryEnrolled.fxml"));
		root = loader.load();
		SceneController contr = loader.getController();
		contr.setEnrolledTable();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void switchtoAccount(ActionEvent e) throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/fxmlFiles/industryfxml/Industry_Accounts.fxml"));
		root = loader.load();
		SceneController contr = loader.getController();
		contr.setIndustry_Account();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void switchtoContestGeneric(ActionEvent e, String ContestID) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setBar(BarChart<String, Integer> StudentPart) throws SQLException {
		// TODO Auto-generated method stub
		XYChart.Series<String,Integer> series1 = new XYChart.Series<String, Integer>();
		series1.setName("CodeFast Monitor");
		series1.getData().add(new XYChart.Data<String, Integer>("Students",InformationExpert.getInstance().NumberOfStudents()));
		series1.getData().add(new XYChart.Data<String, Integer>("Industry",InformationExpert.getInstance().NumberOfindustry()));
		series1.getData().add(new XYChart.Data<String, Integer>("Courses",InformationExpert.getInstance().NumberOfCourses()));
		series1.getData().add(new XYChart.Data<String, Integer>("Quiz",InformationExpert.getInstance().NumberOfQuiz()));
		series1.getData().add(new XYChart.Data<String, Integer>("Contest",InformationExpert.getInstance().NumberOfContest()));
		StudentPart.getData().addAll(series1);
	}

}