package com.trainapp.objects;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
* <h1>Station</h1>
* The Station Object contains all the information regarding a train Station
*
* @author  Joao Coucelo
* @version 1.0
* @since   2015-12-17
*/

public class Station implements Comparable<Station> {

	public Station(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Station s2) {
		//Assuming Station names are only CAPS, no need for compareToIgnoreCase
		return this.name.compareTo( s2.name );
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * This method indicates if the station name is valid, i.e.,
	 * only contains alphabetic or whitespace characters
	 * @param stationName is the name to be validates
	 * @return Boolean true if valid
	 */
	public static Boolean isStationNameValid(final String stationName)
	{
		return Pattern.matches("^[a-zA-Z\\s]+$", stationName);
	}
	
	/**
	 * Convert a TreeSet of stations to a String with all its names
	 * @return String
	 */
	public static String getStationsNames(final TreeSet<Station> stations) {
		String printStations = "";
		Iterator<Station> iteratorStations = stations.iterator();
		while(iteratorStations.hasNext()) {
			printStations += ((Station) iteratorStations.next()).getName() + "; ";
		}
		
		return printStations;
	}

	private String name;
}
