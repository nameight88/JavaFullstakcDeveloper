<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KakaoMap</title>
    <script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=0f707f1345a7faa2a15c9a77b6124fc3&libraries=services"></script>
    <style>
        #map {
            width: 100%;
            height: 100vh;
        }
    </style>
</head>
<body>
    <div id="map"></div>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            let coordinates = [];
            let name = "";
            const nameToSigCdMapping = {};
            const polygons = [];

            fetch("../lib/data/SIG_seoul.json")
                .then(response => response.json())
                .then(jsonData => {
                    const mapOptions = {
                        center: new kakao.maps.LatLng(37.566826, 126.9786567),
                        level: 9,
                        disableDoubleClickZoom: true
                    };
                    const map = new kakao.maps.Map(document.getElementById("map"), mapOptions);

                    jsonData.features.forEach(val => {
                        coordinates = val.geometry.coordinates;
                        name = val.properties.SIG_KOR_NM;
                        const LAWD_CD = val.properties.SIG_CD;
                        nameToSigCdMapping[name] = LAWD_CD;
                        displayArea(coordinates, name, map);
                    });

                    map.setDraggable(false);
                    map.setZoomable(false);
                })
                .catch(error => console.error("Error loading geojson:", error));

            function displayArea(coordinates, name, map) {
                let path = [];

                coordinates[0].forEach(coordinate => {
                    path.push(new kakao.maps.LatLng(coordinate[1], coordinate[0]));
                });

                const polygon = new kakao.maps.Polygon({
                    map: map,
                    path: path,
                    strokeWeight: 2,
                    strokeColor: "#004c80",
                    strokeOpacity: 0.8,
                    strokeStyle: "solid",
                    fillColor: "#fff",
                    fillOpacity: 0.2
                });

                polygons.push(polygon);

                kakao.maps.event.addListener(polygon, "mouseover", function (mouseEvent) {
                    polygon.setOptions({ fillColor: "#09f" });
                    // Add custom overlay logic here
                });

                kakao.maps.event.addListener(polygon, "mousemove", function (mouseEvent) {
                    // Add custom overlay logic here
                });

                kakao.maps.event.addListener(polygon, "mouseout", function () {
                    polygon.setOptions({ fillColor: "#fff" });
                    // Remove custom overlay logic here
                });

                kakao.maps.event.addListener(polygon, "click", function (mouseEvent) {
                    // Add click event logic here
                });
            }
        });
    </script>
</body>
</html>
