package ppvis_2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
 	int page = 1;
 	int maxPage = 1;
 	int recOnPage = 10;
 	int fullRecords = 2;
    ArrayList <String> tName = new ArrayList<>();
    ArrayList <LocalDate> tDate = new ArrayList<>(); 
    ArrayList <String> sName = new ArrayList<>();
    ArrayList <String> winnerName = new ArrayList<>();
    ArrayList <String> winnerSName = new ArrayList<>();
    ArrayList <String> winnerFName = new ArrayList<>();
    ArrayList <Integer> tPrise = new ArrayList<>();
    ArrayList <Integer> wPrise = new ArrayList<>();
    
	
    Data()
    {
 
    	tName.add("������");
    	tDate.add(LocalDate.of(2014, 10, 10));
    	sName.add("����");
    	winnerName.add("����");
        winnerSName.add("��������");
    	winnerFName.add("����������");
    	tPrise.add(1000);
    	wPrise.add(tPrise.get(0)/10*6);
    	
    	tName.add("�������");
    	tDate.add(LocalDate.of(2012, 12, 13));
    	sName.add("�����");
    	winnerName.add("����");
    	winnerSName.add("������");
    	winnerFName.add("��������");
    	tPrise.add(800);
    	wPrise.add(tPrise.get(1)/10*6);
    }
}
