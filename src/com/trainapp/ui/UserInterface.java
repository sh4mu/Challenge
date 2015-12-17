package com.trainapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

import com.trainapp.database.QueryManager;
import com.trainapp.objects.Station;
import com.trainapp.services.AutoComplete;

public class UserInterface {
	public static void main(String args[])
	{
		AutoComplete a = new AutoComplete();	
		String input = "";
		Boolean validInput = false;		
		
		TreeSet<Station> stations = QueryManager.getInstance().selectAllStations();
		String printStations = Station.getStationsNames(stations);		
		System.out.print("Station List: " + printStations + "\n");

		do
		{
			if(input.isEmpty()) {
				System.out.print("\nInsert input: ");
			}
			
			try {
				//Get input from console
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				input = bufferRead.readLine();		
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			//Validate if input only contains allowed characters
			if(!input.isEmpty() && Station.isStationNameValid(input)) {
				validInput = true;
				input = input.toUpperCase();
			}
			else {
				input = "";
			}
		}
		while(!validInput);
		
		//get and print possible Stations from prefix
		TreeSet<Station> prefixedStations = a.getStationsPrefixedBy(stations, input);
		TreeSet<Character> nextChars = a.getStationsNextChar(prefixedStations, input);
		
		String printNames = "";
		Iterator<Station> iteratorStations = prefixedStations.iterator();
		while(iteratorStations.hasNext()) {
			printNames += (Station) iteratorStations.next() + "; ";
		}
		
		String printNextChars = "";
		Iterator<Character> iteratorChar = nextChars.iterator();
		while(iteratorChar.hasNext()) {
			printNextChars += "'" + (Character) iteratorChar.next() + "' ";
		}
		
		System.out.print("Matched Station: " + printNames + " \n");
		System.out.print("Station Next Characters: " + printNextChars + " \n");
	}	
}
