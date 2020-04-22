# ticket-microservice
Post method to create a flight ticket:
localhost:8090/ticket/create

Data to create a flight ticket:

{
	"passengerName":"Pepe",
	"passengerAge":55,
	"price":256.3,
	"luggageStorage":true,
	"itinerary":{
		"departureDate":"2020-05-12",
		"arrivalDate":"2020-05-12",
		"cityOrigin":"Jujuy",
		"cityDestination":"Cordoba",
		"departureTime":"15:00",
		"arrivalTime":"16:15"
	}
}

Get method to get a ticket o itinerary by id:

localhost:8090/ticket/list/1
localhost:8090/itinerary/list/1

