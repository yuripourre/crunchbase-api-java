package examples.application;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import br.com.etyllica.awt.SVGColor;
import br.com.etyllica.awt.components.chooser.FileChooser;
import br.com.etyllica.awt.components.chooser.SelectFileListener;
import br.com.etyllica.core.context.Application;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.Button;
import br.com.etyllica.gui.label.TextLabel;
import br.com.etyllica.layer.Layer;
import br.com.etyllica.network.crunchbase.export.Exporter;
import br.com.etyllica.network.crunchbase.export.SheetExporter;
import br.com.etyllica.util.PathHelper;

public class ExporterApplication extends Application implements SelectFileListener, Runnable {

	private String path = "";
	private String pathText = "Choose a file...";
	
	private FileChooser companyFileChooser;

	private Button loadButton;
	private Button startButton;

	private Layer loadingBar;
	private int loaded = 0;
	private String loadedInfo = "Loading Companies";
	private boolean started = false;
	private boolean converting = false;

	public ExporterApplication(int w, int h) {
		super(w,h);
	}

	public void load() {
		
		int offsetY = 50;
		
		loadButton = new Button(300, offsetY, 60, 30);
		loadButton.setLabel(new TextLabel("File"));
		loadButton.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "openFileChooser"));

		startButton = new Button(loadButton.getX()+loadButton.getW()+5, loadButton.getY(), 60, 30);
		startButton.setLabel(new TextLabel("Start"));
		startButton.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, new Action(this, "startConversion"));

		companyFileChooser = new FileChooser(this.parent.getComponent(), PathHelper.currentDirectory());
		companyFileChooser.setListener(this);

		addView(loadButton);
		addView(startButton);

		loadingBar = new Layer(20, loadButton.getY()+40, 406, 32);
	}

	@Override
	public void draw(Graphic g) {
		g.setColor(SVGColor.MEDIUM_SLATE_BLUE);
		g.fillRect(this);

		g.setAlpha(80);
		g.setColor(Color.WHITE);
		g.fillRect(20, loadButton.getY(), 268, 32);
		g.setColor(Color.BLACK);
		g.drawString(pathText, 24, loadButton.getY()+24);

		if(converting) {
			g.setColor(Color.WHITE);
			g.fillRect(loadingBar);
			
			g.setColor(SVGColor.CADET_BLUE);
			g.fillRect(loadingBar.getX(), loadingBar.getY(), loadingBar.getW()*loaded/100, loadingBar.getH());
			
			g.setColor(Color.BLACK);
			g.drawString(loadingBar, loaded+"%");
		}
		if(started) {
			g.drawString(loadedInfo, 24, loadingBar.getY()+loadingBar.getH()+26);
		}
		
		g.resetOpacity();
	}

	public void openFileChooser() {
		companyFileChooser.openDialog();
	}

	@Override
	public void onSelectFile(String path) {
		this.path = path;
		this.pathText = path;

		int textLength = 30;
		if(pathText.length() > textLength) {
			pathText = pathText.substring(0, textLength)+"...";
		}
	}

	public void startConversion() {
		if(converting) {
			return;
		}
		converting = true;
		started = true;
		loadedInfo = "Conversion started";
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		String apiKey = "";
		List<String> companies = new ArrayList<String>();
		
		try {
			apiKey = SheetExporter.loadKey("key.txt");
		} catch (IOException e) {
			loadedInfo = "File key.txt not found.";
			return;
		}

		try {
			loadedInfo = "Loading: "+path;
			companies = SheetExporter.loadCompanies(path);
		} catch (IOException e) {
			loadedInfo = "File not found: "+path;
		}

		try {
			exportCompanies(apiKey, companies);
		} catch (FileNotFoundException e) {
			loadedInfo = "Error loading file.";
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			loadedInfo = "Error loading file.";
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			loadedInfo = "Error loading file.";
			e.printStackTrace();
		} catch (IOException e) {
			loadedInfo = "Error loading file.";
			e.printStackTrace();
		}
	}
	
	private void exportCompanies(String apiKey, List<String>companies)
			throws FileNotFoundException, UnsupportedEncodingException,
			ClientProtocolException, IOException {
		
		//Open files
		PrintWriter companyWriter = Exporter.openFile(SheetExporter.COMPANY_CSV);
		PrintWriter roundsWriter = Exporter.openFile(SheetExporter.ROUNDS_CSV);
		PrintWriter investmentsWriter = Exporter.openFile(SheetExporter.INVESTMENTS_CSV);
		PrintWriter aquisitionsWriter = Exporter.openFile(SheetExporter.AQUISITIONS_CSV);
		
		SheetExporter.exportHeaders(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);

		int count = 0;
		for(String permalink: companies) {
			loadedInfo = "Loading: "+permalink;
			System.out.println(permalink);

			SheetExporter.exportCompany(apiKey, companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter, permalink);
			count++;
			loaded = (count*100)/companies.size();
		}

		SheetExporter.closeFiles(companyWriter, roundsWriter, investmentsWriter, aquisitionsWriter);
		loadedInfo = "Complete!";
	}

}
