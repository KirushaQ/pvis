package ppvis_2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
 	int page = 1;
 	int maxPage = 1;
 	int recOnPage = 10;
 	int fullRecords = 0;
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
    }
}
