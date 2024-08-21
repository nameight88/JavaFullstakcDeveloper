$(function(){
	var mapContainer = document.getElementById('map2');
	var mapOption = {
		center: new kakao.maps.LatLng(37.566826, 126.9786567),
		level: 4
	};  

	var map = new kakao.maps.Map(mapContainer, mapOption);
	var markers = [];
	var infowindow = new kakao.maps.InfoWindow({});

	var geocoder = new kakao.maps.services.Geocoder();
	var search = $(".property_addr").text();
	console.log(search);

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(search, function(result, status) {
		// 정상적으로 검색이 완료된다면
		if (status === kakao.maps.services.Status.OK) {
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
			infowindow.setContent('<div style="width:150px;text-align:center;padding:2px 0;">매물위치</div>');
			infowindow.open(map, marker);
			map.setCenter(coords);
		}
	});

	// 지하철 클릭시 근처 지하철역 표시
	$("#subway").click(function(){
		mapSearch('SW8');
	});
	//버스 클릭시 근처 지하철역 표시
	$("#bus").click(function(){
		mapSearch('SC4');
	});
	
	// 병원 클릭시 근처 병원 표시
	$("#hospital").click(function(){
		mapSearch('HP8');
	});

	// 마트 클릭시 근처 마트 표시
	$("#mart").click(function(){
		mapSearch('MT1');
	});

	// 카테고리로 장소 검색하는 함수
	function mapSearch(categoryCode){
		var geocoder = new kakao.maps.services.Geocoder();
		var search = $(".property_addr").text();

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(search, function(result, status) {
			// 정상적으로 검색이 완료된다면
			if (status === kakao.maps.services.Status.OK) {
				var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				var ps = new kakao.maps.services.Places();

				// 이전 마커들 제거
				removeMarkers();

				// 특정 카테고리로 장소 검색	
				ps.categorySearch(categoryCode, function(data, status, pagination) {
					if (status === kakao.maps.services.Status.OK) {
						for (var i = 0; i < data.length; i++) {
							displayMarker(data[i]);
						}
					}
				}, {location: coords, radius: 1000});

				map.setCenter(coords);
			}
		});
	}

	// 검색된 장소를 지도에 표시하는 함수
	function displayMarker(place) {
		var marker = new kakao.maps.Marker({
			map: map,
			position: new kakao.maps.LatLng(place.y, place.x)
		});
		markers.push(marker);

		kakao.maps.event.addListener(marker, 'click', function() {
			infowindow.setContent('<div style="width:150px;text-align:center;padding:6px 0;">' + place.place_name + '</div>');
			infowindow.open(map, marker);
		});
	}

	// 기존 마커들을 제거하는 함수
	function removeMarkers() {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
		}
		markers = [];
	}
});
