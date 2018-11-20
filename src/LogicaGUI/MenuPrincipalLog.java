package LogicaGUI;

import java.awt.Dimension;
import org.jfree.*;


import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class MenuPrincipalLog{

    public MenuPrincipalLog() {
    }

	public ChartPanel generateChart(String titulo, String tipoBasura, String categoria, String periodoTiempo, DefaultCategoryDataset dataset){
		String SITIO_1 = "Probabilidad de valer verga";
		String SITIO_2 = "HOLA";

    // Visitas del sitio web 1
    dataset.setValue(1000, SITIO_1, "Lunes");
    dataset.setValue(120, SITIO_1, "Martes");
    dataset.setValue(110, SITIO_1, "Miércoles");
    dataset.setValue(103, SITIO_1, "Jueves");
    dataset.setValue(106, SITIO_1, "Viernes");

    // Visitas del sitio web 2
    dataset.setValue(60, SITIO_2, "Lunes");
    dataset.setValue(62, SITIO_2, "Martes");
    dataset.setValue(61, SITIO_2, "Miércoles");
    dataset.setValue(63, SITIO_2, "Jueves");
    dataset.setValue(66, SITIO_2, "Viernes");
	JFreeChart chart = ChartFactory.createBarChart(categoria, periodoTiempo,"Basura generada (kg)", dataset, PlotOrientation.VERTICAL, true, true, false);
	
	ChartPanel panel = new ChartPanel(chart);
	panel.setPreferredSize(new Dimension(685, 397));
	return panel;

	}

}
