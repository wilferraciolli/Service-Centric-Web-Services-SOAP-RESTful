/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiltech;

import java.io.File;
import java.util.List;
import org.netbeans.xml.schema.flightsinfo.FlightBooking;
import org.netbeans.xml.schema.flightsinfo.FlightType;

/**
 *
 * @author Wiliam
 */
public class GenerateFlights {
    //********************** fill in flight details *************************
        //declare XML root element
        FlightBooking myFlight = new FlightBooking();
        //get the list of flights
        public List<FlightType> flightJourneys; 
//        private void fillFlights()
//        {
           // flightJourneys = new ArrayList<FlightType>();
        public void fillFlights(){
            
            FlightType newJourney = new FlightType();
            newJourney.setFlightID(1);
            newJourney.setOriginCity("London");
            newJourney.setOriginAddress("address 1");
            newJourney.setDestinationCity("Leeds");
            newJourney.setDestinationAddress("address 2");
            newJourney.setDate("01/01/15");
            newJourney.setTime("09:00");
            newJourney.setAirline("Britsh Airways");
            newJourney.setAvailableSeats(20);
            newJourney.setConnections(1);
            //Populate cpomplex type fare
            FlightType.Fare fare = new FlightType.Fare();
            fare.setCurrency("GBP");
            fare.setValue(100);
            newJourney.setFare(fare);//add the two values to the list            
            //add to the list
            flightJourneys.add(newJourney);
            
            //Add a journey
            newJourney = new FlightType();
            newJourney.setFlightID(2);
            newJourney.setOriginCity("London");
            newJourney.setOriginAddress("address 1");
            newJourney.setDestinationCity("Leeds");
            newJourney.setDestinationAddress("address 2");
            newJourney.setDate("01/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Ryanair");
            newJourney.setAvailableSeats(20);
            newJourney.setConnections(1);
            //Populate cpomplex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("GBP");
            fare.setValue(100);
            newJourney.setFare(fare);//add the two values to the list            
            //add to the list
            flightJourneys.add(newJourney);
            
            //Add a journey
            newJourney = new FlightType();
            newJourney.setFlightID(3);
            newJourney.setOriginCity("London");
            newJourney.setOriginAddress("address 1");
            newJourney.setDestinationCity("Leeds");
            newJourney.setDestinationAddress("address 2");
            newJourney.setDate("02/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Ryanair");
            newJourney.setAvailableSeats(20);
            newJourney.setConnections(1);
            //Populate cpomplex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("GBP");
            fare.setValue(100);
            newJourney.setFare(fare);//add the two values to the list            
            //add to the list
            flightJourneys.add(newJourney);
            
            
            //Add a new journey
            newJourney = new FlightType();
            newJourney.setFlightID(4);
            newJourney.setOriginCity("Birmingham");
            newJourney.setOriginAddress("address Origin");
            newJourney.setDestinationCity("Paris");
            newJourney.setDestinationAddress("dest address");
            newJourney.setDate("02/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Alitalia");
            newJourney.setAvailableSeats(50);
            newJourney.setConnections(0);
            //Populate complex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("EUR");
            fare.setValue(120);
            newJourney.setFare(fare);            
            //add to the list
            flightJourneys.add(newJourney);
            
            
            //Add a new journey
            newJourney = new FlightType();
            newJourney.setFlightID(5);
            newJourney.setOriginCity("Manchester");
            newJourney.setOriginAddress("ori addrss");
            newJourney.setDestinationCity("Belfast");
            newJourney.setDestinationAddress("dest address");
            newJourney.setDate("03/01/15");
            newJourney.setTime("09:00");
            newJourney.setAirline("Air Cyprus");
            newJourney.setAvailableSeats(60);
            newJourney.setConnections(2);
            //Populate complex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("EUR");
            fare.setValue(90);
            newJourney.setFare(fare);            
            //add to the list
            flightJourneys.add(newJourney);
            
            
            //Add a new journey
            newJourney = new FlightType();
            newJourney.setFlightID(6);
            newJourney.setOriginCity("East Midland");
            newJourney.setOriginAddress("ori addrss");
            newJourney.setDestinationCity("Amsterdam");
            newJourney.setDate("04/01/15");
            newJourney.setTime("09:00");
            newJourney.setAirline("Holland Airways");
            newJourney.setAvailableSeats(10);
            newJourney.setConnections(0);
            //Populate complex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("GBP");
            fare.setValue(160);
            newJourney.setFare(fare);            
            //add to the list
            flightJourneys.add(newJourney);
                        
        //}//ends fill flights
        
 //**************************** Marshal ***************************************
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlight.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(myFlight, System.out);
            
            //Writing the whole XML document to file
            File flightStore = new File("flights.xml");
            marshaller.marshal(myFlight, flightStore);
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
            
        }
            
           

    
    
}
