package com.example.javafxbarchart;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class JavaFXBarChartController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create Series instance
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("2015");
        series1.getData().add(new XYChart.Data<>("Americas", 70.3));
        series1.getData().add(new XYChart.Data<>("Europe", 33.9));
        series1.getData().add(new XYChart.Data<>("China", 71.2));
        series1.getData().add(new XYChart.Data<>("Japan", 15));
        series1.getData().add(new XYChart.Data<>("Rest of Asia Pacific", 12.2));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("2017");
        series2.getData().add(new XYChart.Data<>("Americas", 69.3));
        series2.getData().add(new XYChart.Data<>("Europe", 36.8));
        series2.getData().add(new XYChart.Data<>("China", 51.6));
        series2.getData().add(new XYChart.Data<>("Japan", 15.3));
        series2.getData().add(new XYChart.Data<>("Rest of Asia Pacific", 13.3));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("2019");
        series3.getData().add(new XYChart.Data<>("Americas", 65.7));
        series3.getData().add(new XYChart.Data<>("Europe", 36.3));
        series3.getData().add(new XYChart.Data<>("China", 31.4));
        series3.getData().add(new XYChart.Data<>("Japan", 14.8));
        series3.getData().add(new XYChart.Data<>("Rest of Asia Pacific", 12.8));

        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("2021");
        series4.getData().add(new XYChart.Data<>("Americas", 84.3));
        series4.getData().add(new XYChart.Data<>("Europe", 56.1));
        series4.getData().add(new XYChart.Data<>("China", 42.9));
        series4.getData().add(new XYChart.Data<>("Japan", 17.8));
        series4.getData().add(new XYChart.Data<>("Rest of Asia Pacific", 17.3));

        XYChart.Series<String, Number> series5 = new XYChart.Series<>();
        series5.setName("2023");
        series5.getData().add(new XYChart.Data<>("Americas", 98.1));
        series5.getData().add(new XYChart.Data<>("Europe", 56.8));
        series5.getData().add(new XYChart.Data<>("China", 43.7));
        series5.getData().add(new XYChart.Data<>("Japan", 14.6));
        series5.getData().add(new XYChart.Data<>("Rest of Asia Pacific", 17.8));

        // Add series to the chart
        barChart.getData().addAll(series1, series2, series3, series4, series5);

    }
}