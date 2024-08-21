/**
 * 
 */
//페이지 로드 시 실행되는 코드
$(function(){
	// 지도 표출 
	var mapContainer = document.getElementById('map');
	var mapOptions = {
			center: new kakao.maps.LatLng(37.5665, 126.9780), // 서울의 좌표
			level: 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOptions);

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	var search = $(".property_addr").text();
	console.log(search);

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(search, function(result, status) {

		// 정상적으로 검색이 완료된다면
		if (status === kakao.maps.services.Status.OK) {

			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 기존에 표시된 마커 제거
			//map.removeOverlayMapTypeId(kakao.maps.MapTypeId.MARKER);

			// 결과값으로 받은 위치를 마커로 표시
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});

			// 인포윈도우로 장소에 대한 설명을 표시합니다
			var infowindow = new kakao.maps.InfoWindow({
				content: '<div style="width:150px;text-align:center;padding:6px 0;">매물위치</div>'
			});
			infowindow.open(map, marker);

			// 지도의 중심을 결과값으로 받은 위치로 이동
			map.setCenter(coords);
		}
	});

	// 주변시설
//	var mapContainer2 = document.getElementById('map2');
//
//	var mapOptions2 = {
//			center: new kakao.maps.LatLng(37.5665, 126.9780), // 서울의 좌표
//			level: 3
//	};
//
//	var map2 = new kakao.maps.Map(mapContainer2, mapOptions2);
//	
//	
//
//	// 주소-좌표 변환 객체를 생성합니다
//	var geocoder2 = new kakao.maps.services.Geocoder();
//	var search2 = $(".property_addr").text();
//	console.log(search2);
//	
//
//	// 주소로 좌표를 검색합니다
//	geocoder2.addressSearch(search2, function(result, status) {
//
//		// 정상적으로 검색이 완료된다면
//		if (status === kakao.maps.services.Status.OK) {
//
//			var coords2 = new kakao.maps.LatLng(result[0].y, result[0].x);
//
//			// 기존에 표시된 마커 제거
//			//map.removeOverlayMapTypeId(kakao.maps.MapTypeId.MARKER);
//
//			// 결과값으로 받은 위치를 마커로 표시
//			var marker2 = new kakao.maps.Marker({
//				map: map2,
//				position: coords2
//			});
//
//			// 인포윈도우로 장소에 대한 설명을 표시합니다
//			var infowindow2 = new kakao.maps.InfoWindow({
//				content: '<div style="width:150px;text-align:center;padding:6px 0;">매물위치</div>'
//			});
//			infowindow2.open(map2, marker2);
//
//			// 지도의 중심을 결과값으로 받은 위치로 이동
//			map2.setCenter(coords2);
//
//
//		}
//	});

});




