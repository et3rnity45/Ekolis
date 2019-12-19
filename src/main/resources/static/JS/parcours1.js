var mymap = L.map('mapid').setView([47.8989, 1.9015], 15);

	L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
			'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
		id: 'mapbox/streets-v11'
	}).addTo(mymap);

var arrivalIcon = L.icon({
    iconUrl: '../pictures/arrivee.svg',
    iconSize:     [38, 95], 
    iconAnchor:   [22, 94], 
    popupAnchor:  [-3, -76] 
});

var departIcon = L.icon({
    iconUrl: '../pictures/home.svg',
    iconSize:     [38, 95],
    iconAnchor:   [22, 94], 
    popupAnchor:  [-3, -76]
});

function showDepart(){
	var markerDepart = L.marker([47.89400, 1.89510], {icon: departIcon}).addTo(mymap);
	mymap.setView([47.89400, 1.89510], 18);
	markerDepart.bindPopup("<b>Départ</b><br>WildCodeSchool").openPopup();
}
document.getElementById('depart').onclick=showDepart;

function showArrivee(){
	var markerArrivee = L.marker([47.90986, 1.91220], {icon: arrivalIcon}).addTo(mymap);
	mymap.setView([47.90986, 1.91220], 18);
	markerArrivee.bindPopup("<b>Arrivée</b><br>Palais des sports").openPopup();
}
document.getElementById('arrivee').onclick=showArrivee;

