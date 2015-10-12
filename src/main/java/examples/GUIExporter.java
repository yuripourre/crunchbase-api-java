package examples;

import br.com.etyllica.EtyllicaFrame;
import br.com.etyllica.core.context.Application;
import examples.application.ExporterApplication;

public class GUIExporter extends EtyllicaFrame {

	private static final long serialVersionUID = 1L;

	public GUIExporter() {
		super(450, 180);
	}
	
	public static void main(String[] args) {
		GUIExporter exporter = new GUIExporter();
		exporter.setTitle("Crunchbase Exporter");
		exporter.init();
	}

	@Override
	public Application startApplication() {
		initialSetup("../");

		return new ExporterApplication(w,h);
	}
	
}
