package com.example.javafxbarchart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class JavaFXBarChartController {

//    public Button showTableView;
//    public Button showBarChart;
    @FXML
    public TableView iphone_sales;

    @FXML
    private TableColumn<Iphone, String> sales_id;
    @FXML
    private TableColumn<Iphone, String> sales_year;
    @FXML
    private TableColumn<Iphone, String> sales_region;
    @FXML
    private TableColumn<Iphone, String> sales_amount;

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    // Static variable to track current view mode (0 for bar chart, 1 for table)
    static int i;

    // Initializes the controller
    public void initialize() {
        if (i == 0) {
            // Create a map to store colors for each year
            Map<Integer, String> yearColorMap = new HashMap<>();
            yearColorMap.put(2015, "#d62728"); // Red
            yearColorMap.put(2017, "#ff7f0e"); // Orange
            yearColorMap.put(2019, "#2ca02c"); // Green
            yearColorMap.put(2021, "#1f77b4"); // Blue
            yearColorMap.put(2023, "#000080"); // Navy Blue

            try (Connection connection = new DatabaseConnector().connect()) {
                // Fetch iPhone sales data for alternating years
                for (int year = 2015; year <= 2023; year += 2) {
                    String query = "SELECT sales_region, sales_amount FROM iphone_sales WHERE sales_year = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, year);
                    ResultSet resultSet = statement.executeQuery();

                    XYChart.Series<String, Number> series = new XYChart.Series<>();
                    series.setName(Integer.toString(year));
                    // Populate the series with fetched data
                    while (resultSet.next()) {
                        String region = resultSet.getString("sales_region");
                        double sale = resultSet.getDouble("sales_amount");
                        series.getData().add(new XYChart.Data<>(region, sale));
                    }

                    // Add series to the chart before setting colors
                    barChart.getData().add(series);

                    // Set colors for the series
                    String color = yearColorMap.get(year);
                    for (XYChart.Data<String, Number> data : series.getData()) {
                        data.getNode().setStyle("-fx-bar-fill: " + color);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Customize x-axis ordering
            CategoryAxis xAxis = (CategoryAxis) barChart.getXAxis();
            xAxis.setCategories(FXCollections.observableArrayList(
                    "Americas", "Europe", "China", "Japan", "Rest of Asia Pacific"
            ));
        }

        if (i == 1) {
            // Set up the TableView with data fetched from the database
            // Bind the sales_id column to the idProperty of the Iphone object
            sales_id.setCellValueFactory(cellData -> cellData.getValue().idProperty());
            // Bind the sales_year column..., and also sales_region.... and sales_amount....
            sales_year.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
            sales_region.setCellValueFactory(cellData -> cellData.getValue().regionProperty());
            sales_amount.setCellValueFactory(cellData -> cellData.getValue().salesProperty());

            // Try to establish a connection to the database
            try (Connection connection = new DatabaseConnector().connect();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM `iphone_sales`")){
                // Create an ObservableList to store the fetched data
                ObservableList<Iphone> iphone = FXCollections.observableArrayList();
                while (resultSet.next()){
                    String id = resultSet.getString("sales_id");
                    String year = resultSet.getString("sales_year");
                    String region = resultSet.getString("sales_region");
                    String sales = resultSet.getString("sales_amount");
                    iphone.add(new Iphone(id, year, region, sales));
                }
                iphone_sales.setItems(iphone); // Set the data into TableView
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    // Switches to the bar chart view
    public void switchToBarChart (ActionEvent event) throws IOException{
        i=0;
        Parent root = FXMLLoader.load(getClass().getResource("barchart-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Switches to the table view
    public void switchToTable (ActionEvent event) throws IOException {
        i=1;
        Parent root = FXMLLoader.load(getClass().getResource("table-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}


