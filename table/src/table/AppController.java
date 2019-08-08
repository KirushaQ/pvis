package table;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppController {

	ArrayList<String> sName;
	ArrayList<String> wName;
	ArrayList<String> wSName;
	ArrayList<String> wFName;
	ArrayList<LocalDate> date;
	ArrayList<Integer> tPrise;
	int current;
	int recOnPage;
	int pages;
	int allRec;
	
	public AppController(){
		sName = new ArrayList<String>();
		wName = new ArrayList<String>();
		wSName = new ArrayList<String>();
		wFName = new ArrayList<String>();
		date = new ArrayList<LocalDate>();
		tPrise = new ArrayList<Integer>();
		current = 1;
		recOnPage = 5;
		pages = 1;
		allRec = 5;
		
		sName.add("Футбольчик");
		wName.add("Сергей");
		wSName.add("Сергеев");
		wFName.add("Сергеевич");
		date.add(LocalDate.of(2016, 10, 10));
		tPrise.add(228);
		
		sName.add("Баскетбол");
		wName.add("Иван");
		wSName.add("Иванов");
		wFName.add("Иванович");
		date.add(LocalDate.of(2014, 11, 22));
		tPrise.add(1400);
		
		sName.add("Волейбол");
		wName.add("Андрей");
		wSName.add("Андреев");
		wFName.add("Андреевич");
		date.add(LocalDate.of(2000, 8, 15));
		tPrise.add(228);
		
		sName.add("Футбольчик");
		wName.add("Сергей");
		wSName.add("Андреев");
		wFName.add("Иванович");
		date.add(LocalDate.of(2014, 11, 22));
		tPrise.add(500);
		
		sName.add("Шахматы");
		wName.add("Иван");
		wSName.add("Сергеев");
		wFName.add("Андреевич");
		date.add(LocalDate.of(2016, 10, 10));
		tPrise.add(777);

	}
	
	public AppController(int x){
		sName = new ArrayList<String>();
		wName = new ArrayList<String>();
		wSName = new ArrayList<String>();
		wFName = new ArrayList<String>();
		date = new ArrayList<LocalDate>();
		tPrise = new ArrayList<Integer>();
		current = 1;
		recOnPage = 5;
		pages = 1;
		allRec = 0;
	}
	
	public void copy(AppController controller){
		this.current = controller.current;
		this.recOnPage = controller.recOnPage;
		this.pages = controller.pages;
		this.allRec = controller.allRec;
		 
		this.sName.clear();
		this.wName.clear();
		this.wSName.clear();
		this.wFName.clear();
		this.date.clear();
		this.tPrise.clear();
		
		this.sName = (ArrayList<String>) controller.sName.clone();
		this.wName =  (ArrayList<String>) controller.wName.clone();
		this.wSName =  (ArrayList<String>) controller.wSName.clone();
		this.wFName =  (ArrayList<String>) controller.wFName.clone();
		this.date =  (ArrayList<LocalDate>) controller.date.clone();
		this.tPrise =  (ArrayList<Integer>) controller.tPrise.clone();
			
			
	}
}
