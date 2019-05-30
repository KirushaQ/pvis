package ppvis_2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
 	int page = 1;
 	int maxPage = 5;
 	int recOnPage = 10;
 	int fullRecords = 50;
    ArrayList <String> tName = new ArrayList<>();
    ArrayList <LocalDate> tDate = new ArrayList<>(); 
    ArrayList <String> sName = new ArrayList<>();
    ArrayList <String> winnerName = new ArrayList<>();
    ArrayList <String> winnerSName = new ArrayList<>();
    ArrayList <String> winnerFName = new ArrayList<>();
    ArrayList <Integer> tPrise = new ArrayList<>();
    ArrayList <Integer> wPrise = new ArrayList<>();
    
   	LocalDate date1;
	//LocalDate date2;
	
    Data()
    {
 
    	tName.add("Боксыч");
    	tDate.add(date1.of(2014, 10, 10));
    	sName.add("Бокс");
    	winnerName.add("Вася");
        winnerSName.add("Васильев");
    	winnerFName.add("Васильевич");
    	tPrise.add(1000);
    	wPrise.add(tPrise.get(0)/10*6);
    	
    	tName.add("Тенисыч");
    	//tDate.add(date2.of(2012, 16, 13));
    	sName.add("Тенис");
    	winnerName.add("Иван");
    	winnerSName.add("Иванов");
    	winnerFName.add("Иванович");
    	tPrise.add(800);
    	wPrise.add(tPrise.get(0)/10*6);
    }
}
