/**
 * 
 */
//페이지 로드 시 실행되는 코드
$(function(){
	// 마커를 담을 배열입니다
	var markers = [];

	// 지도 표출 
	var mapContainer = document.getElementById('map');
	var mapOptions = {
			center: new kakao.maps.LatLng(37.5665, 126.9780), // 서울의 좌표
			level: 8
	};

	var map = new kakao.maps.Map(mapContainer, mapOptions);
	//currentlocation(map);

	$(".property_addr").each(function() {
		var addr = $(this).text();

		//ps.keywordSearch(addr, placesSearchCB);
		//updateMap(map,addr);

		if (!addr || addr.trim() === "") {
			// 현재 위치로 지도 업데이트
			currentlocation(map);
		} else {
			// 주소를 이용하여 지도 업데이트
			updateMap(map, addr);
		}
	});



	function currentlocation(map){
		// 현재 위치로 지도에 표시
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
		} else {
			// 현재 위치를 가져올 수 없는 경우 서울 시청의 좌표로 지도의 중심 설정
			var seoulCityHallCoords = new kakao.maps.LatLng(37.5662952, 126.9779451);
			map.setCenter(seoulCityHallCoords);
		}

	}

	//지도 업데이트 함수(맵)	
	function updateMap(map, searchText){ 
		//alert(searchText);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(searchText, function(result, status) {

			// 정상적으로 검색이 완료된다면
			if (status === kakao.maps.services.Status.OK) {

				var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				// 기존에 표시된 마커 제거
				//map.removeOverlayMapTypeId(kakao.maps.MapTypeId.MARKER);

				// 결과값으로 받은 위치를 마커로 표시
				var marker = new kakao.maps.Marker({
					map: map,
					position: coords,
					level: 4 // 레벨 조정
				});

				// 인포윈도우로 장소에 대한 설명을 표시합니다
				var infowindow = new kakao.maps.InfoWindow({
					content: '<div style="width:150px;text-align:center;padding:6px 0;">매물위치</div>'
				});
				infowindow.open(map, marker);

				// 지도의 중심을 결과값으로 받은 위치로 이동
				map.setCenter(coords);

				kakao.maps.event.addListener(marker, 'click', (function(marker) {
					return function() {
						var propertyId = $(this).siblings('input[name="property_id"]').val();
						alert("ee"+propertyId);
						//window.location.href = propertyDetailURL + propertyId;
					};
				})(marker));
			}else{
				//alert("주소를 찾을 수 없습니다.");
			}
		});


	}

});





