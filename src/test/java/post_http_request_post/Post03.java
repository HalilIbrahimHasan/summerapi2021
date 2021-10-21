package post_http_request_post;

public class Post03 {


     /*
        When
		 I send POST Request to the Url "http://api.agromonitoring.com/agro/1.0/polygons?appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0"
		 with the Request Body like  {
										   "name":"Polygon Sample",
										   "geo_json":{
										      "type":"Feature",
										      "properties":{},
										      "geometry":{
										         "type":"Polygon",
										         "coordinates":[
										            [
										               [-121.1958,37.6683],
										               [-121.1779,37.6687],
										               [-121.1773,37.6792],
										               [-121.1958,37.6792],
										               [-121.1958,37.6683]
										            ]
										         ]
										      }
										   }
										}
	Then
		Assert Status Code (201)
		And Response Body should be like {
										    "id": "5fd8c383714b523b2ce1f154",
										    "geo_json": {
										        "geometry": {
										            "coordinates": [
										                [
										                    [
										                        -121.1958,
										                        37.6683
										                    ],
										                    [
										                        -121.1779,
										                        37.6687
										                    ],
										                    [
										                        -121.1773,
										                        37.6792
										                    ],
										                    [
										                        -121.1958,
										                        37.6792
										                    ],
										                    [
										                        -121.1958,
										                        37.6683
										                    ]
										                ]
										            ],
										            "type": "Polygon"
										        },
										        "type": "Feature",
										        "properties": {

										        }
										    },
										    "name": "Polygon Sample",
										    "center": [
										        -121.1867,
										        37.67385
										    ],
										    "area": 190.9484,
										    "user_id": "5fd8c02a3da20c000759e0f8",
										    "created_at": 1608041347
										}
     */



}
