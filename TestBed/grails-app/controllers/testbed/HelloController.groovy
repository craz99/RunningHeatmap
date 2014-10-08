package testbed

import grails.converters.JSON
import groovy.json.JsonBuilder

class HelloController {

    def index() {
		def builder = new JsonBuilder()
		def root = builder.type { LineString { coordinates( [-78.891551, 42.715103], [-78.890551, 42.714103] ) }}
		def feature = [:]
		feature['type'] = "Feature"
		def properties = [:]
		properties['name'] = "GeoTest"
		feature['properties'] = properties
		def result = [:]
		result['type'] = "LineString"
		// Another change just cause
		def coords = []
		(1..2).each { i ->
		  (1..2).each { j ->
			  double latitude = 42.715103 + (0.01*i)
			  double longitude = -78.891551 + (0.01*j)
			  coords << [longitude, latitude]
		  }
		}
		result['coordinates'] = coords
		feature['geometry'] = result
		[ geojson: new JSON(feature).toString() ]
		//{"type":{"LineString":{
		//"coordinates":[[42.715103,-78.891551],[42.714103,-78.890551]]}}
		//}
		//{ "type": "LineString",
		//"coordinates": [ [100.0, 0.0], [101.0, 1.0] ]
    	//}
		
		/**
		 * //${gpsList.get(0).latitude};
		//${gpsList.get(0).longitude};
		//var latlngs = [];
		//<g:each in="${gpsList}" var="gps">
		//latlngs.push(L.latLng(${gps.latitude}, ${gps.longitude}));
		//</g:each>
		//var polyline = L.polyline(latlngs, {color: 'red'}).addTo(map);
		 */
		//		def gpsList = [new GPS(latitude:42.715103, longitude:-78.891551)]
//		def gpsList = []
//		(1..2).each { i ->
//		  (1..2).each { j ->
//			  double latitude = 42.715103 + (0.01*i)
//			  double longitude = -78.891551 + (0.01*j)
//			  gpsList << new GPS(latitude:latitude, longitude:longitude)
//		  }
//		}
//		[ gpsList:gpsList ]
	}
	
	def hi() {
		render (view:'index.gsp')
	}
}
