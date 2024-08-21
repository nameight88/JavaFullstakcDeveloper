<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>지도 초기값 설정 예시</title>
    <!-- 카카오 지도 API 불러오기 -->
    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=0f707f1345a7faa2a15c9a77b6124fc3"></script>
</head>
<body>
    <div id="map"></div>
    <script>
        var mapContainer = document.getElementById('map');
        var mapOptions = {
            center: new kakao.maps.LatLng(37.5665, 126.9780), // 서울의 좌표
            level: 3
        };

        var map = new kakao.maps.Map(mapContainer, mapOptions);

        // 현재 위치 받아오기
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var lat = position.coords.latitude;
                var lng = position.coords.longitude;

                var currentPosition = new kakao.maps.LatLng(lat, lng);

                var marker = new kakao.maps.Marker({
                    map: map,
                    position: currentPosition
                });

                map.setCenter(currentPosition);
            });
        }
    </script>
</body>
</html>
