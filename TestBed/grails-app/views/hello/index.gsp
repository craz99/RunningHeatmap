<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'leaflet.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'map.css')}" type="text/css">
    <meta name="layout" content="main"/>
    <title>Render Domain</title>
</head>
<body>
<div id="map"></div>
	<g:javascript src="leaflet.js" />
	<script>
		var lat = ${gpsList.get(0).latitude};
		var lon = ${gpsList.get(0).longitude};
		var map = L.map('map').setView([lat, lon], 13);
		L.tileLayer('http://{s}.tiles.mapbox.com/v3/kendrickb.jmgka5g9/{z}/{x}/{y}.png', {
		    attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
		    maxZoom: 18
		}).addTo(map);
		var latlngs = [];
		<g:each in="${gpsList}" var="gps">
		latlngs.push(L.latLng(${gps.latitude}, ${gps.longitude}));
		</g:each>
		var polyline = L.polyline(latlngs, {color: 'red'}).addTo(map);
		
	</script>

</body>
</html>