package com.trainapp.database;

import java.util.TreeSet;

import com.trainapp.objects.Station;

/**
* QueryManager retrieves all DB information
*
* @author  Joao Coucelo
* @version 1.0
* @since   2015-12-17
*/

public class QueryManager {
	private static QueryManager instance = null;
	   
	protected QueryManager() {
	}	
	
	public static QueryManager getInstance() {
		if(instance == null) {
			instance = new QueryManager();
		}
		return instance;
	}
	
	/**
	 * This method retrieves all the existing Stations in the DB
	 * @return TreeSet<Station>
	 */
	public TreeSet<Station> selectAllStations()
	{
		TreeSet<Station> stations = new TreeSet<Station>();		
		stations.add(new Station("DARTFORD"));
		stations.add(new Station("DARTMOUTH"));
		stations.add(new Station("TOWER HILL"));
		stations.add(new Station("DERBY"));
		stations.add(new Station("LIVERPOOL"));
		stations.add(new Station("LIVERPOOL LIME STREET"));
		stations.add(new Station("PADDINGTON"));
		stations.add(new Station("EUSTON"));
		stations.add(new Station("LONDON BRIDGE"));
		stations.add(new Station("VICTORIA"));
		return stations;
	}
}
