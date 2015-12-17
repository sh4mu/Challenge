package com.trainapp.services;

import java.util.Iterator;
import java.util.TreeSet;
import com.trainapp.objects.Station;

/**
* The AutoComplete class provides the functions that retrieve all the possible 
* auto complete options for the search dialog box
*
* @author  Joao Coucelo
* @version 1.0
* @since   2015-12-17
*/

public class AutoComplete 
{	
	/**
	 * Obtains a subset of Station that start with the given prefix
	 * @param prefix of the Station
	 * @return TreeSet<Station> with the Station subset
	 */
	public TreeSet<Station> getStationsPrefixedBy(final TreeSet<Station> stations, final String prefix)
	{		
		//Optimal would be to use Strings directly instead of station, but wanted to give a taste of OOP
		return (TreeSet<Station>) stations.subSet( new Station(prefix), new Station(prefix + Character.MAX_VALUE ));
	}
		
	/**
	 * For each Station name it collects the Character following the prefix 
	 * @param station contains the list of Stations
	 * @param prefix of the Station
	 * @return TreeSet<Station> with the Station subset
	 */
	public TreeSet<Character> getStationsNextChar(final TreeSet<Station> stations, final String prefix)
	{
		//is treeset the best option?
		TreeSet<Character> nextChars = new TreeSet<Character>();
		
		if(stations.size() == 0) return nextChars;
		
		//is iterator pointing to first position? just get the bastards size
		int position = prefix.length();
		
		Iterator<Station> iterator = stations.iterator();
		while(iterator.hasNext()) {
			Station s = iterator.next();
			
			if(position >= s.getName().length()) {
				continue;
			}					
			
			nextChars.add(s.getName().charAt(position));
		}
		
		return nextChars;
	}	
}
