package ppvis_2;

import java.time.LocalDate;
import java.util.ArrayList;

public class AppController {

	private Data data;

	int page;
	int maxPage;
	int recOnPage;
	int fullRecords;
    ArrayList <String> tName;
    ArrayList <LocalDate> tDate; 
    ArrayList <String> sName;
    ArrayList <String> winnerName;
    ArrayList <String> winnerSName;
    ArrayList <String> winnerFName;
    ArrayList <Integer> tPrise;
    ArrayList <Integer> wPrise;
	
	public AppController(Data data) {
		this.data = data;
	 	page = data.page;
	 	maxPage = data.maxPage;
	 	recOnPage = data.recOnPage;
	    fullRecords = data.fullRecords;
	    tName = data.tName;
	    tDate = data.tDate;
	    sName = data.sName;
	    winnerName = data.winnerName;
	    winnerSName = data.winnerSName;
	    winnerFName = data.winnerFName;
	    tPrise = data.tPrise;
	    wPrise = data.wPrise;
	}

}
