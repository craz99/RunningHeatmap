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
		var lat = 42.725103; 
		var lon = -78.891551; 
		var map = L.map('map').setView([lat, lon], 13);
		L.tileLayer('http://{s}.tiles.mapbox.com/v3/kendrickb.jmgka5g9/{z}/{x}/{y}.png', {
		    attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
		    maxZoom: 18
		}).addTo(map);
		var data = ${raw(geojson)};
		L.geoJson(data).addTo(map);
	</script>
</body>
</html>