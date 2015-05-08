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
public class FillFlights {
     public static void main(String[] args) {
        // TODO code application logic here
        
        
        //********************** fill in flight details **************************
        //declare XML root element
        FlightBooking myFlight = new FlightBooking();
        //get the list of flights
        List<FlightType> flightJourneys = myFlight.getFlightTrips(); 
//        private void fillFlights()
//        {
           // flightJourneys = new ArrayList<FlightType>();
            
            FlightType newJourney = new FlightType();
            newJourney.setFlightID(1);
            newJourney.setOriginCity("London Heathrow Airport (LHR)");
            newJourney.setOriginAddress("London");
            newJourney.setDestinationCity("Leeds Bradford Airport (LBA)");
            newJourney.setDestinationAddress("Leeds");
            newJourney.setDate("01/01/15");
            newJourney.setTime("09:00");
            newJourney.setAirline("Britsh Airways");
            newJourney.setAvailableSeats(30);
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
            newJourney.setOriginCity("London Heathrow Airport (LHR)");
            newJourney.setOriginAddress("London");
            newJourney.setDestinationCity("Leeds Bradford Airport (LBA)");
            newJourney.setDestinationAddress("Leeds");
            newJourney.setDate("01/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Ryanair");
            newJourney.setAvailableSeats(20);
            newJourney.setConnections(0);
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
            newJourney.setOriginCity("London Heathrow Airport (LHR)");
            newJourney.setOriginAddress("London");
            newJourney.setDestinationCity("Leeds Bradford Airport (LBA)");
            newJourney.setDestinationAddress("Leeds");
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
            newJourney.setOriginCity("Birmingham International Airport (BHX)");
            newJourney.setOriginAddress("Birmingham");
            newJourney.setDestinationCity("Paris Beauvais Tillé Airport (BVA)");
            newJourney.setDestinationAddress("Paris");
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
            newJourney.setOriginCity("Manchester Airport (MAN)");
            newJourney.setOriginAddress("Manchester");
            newJourney.setDestinationCity("Belfast International Airport (BFS)");
            newJourney.setDestinationAddress("Belfast");
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
            newJourney.setOriginCity("East Midlands Airport (EMA)");
            newJourney.setOriginAddress("East Midlands");
            newJourney.setDestinationCity("Amsterdam Schiphol Airport (AMS)");
             newJourney.setDestinationAddress("Amsterdam");
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
            
            //Add a new journey
            newJourney = new FlightType();
            newJourney.setFlightID(7);
            newJourney.setOriginCity("Bristol International Airport (BRS)");
            newJourney.setOriginAddress("Bristol");
            newJourney.setDestinationCity("Glasgow International Airport (GLA)");
            newJourney.setDestinationAddress("Glascow");
            newJourney.setDate("02/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Alitalia");
            newJourney.setAvailableSeats(50);
            newJourney.setConnections(0);
            //Populate complex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("GBP");
            fare.setValue(120);
            newJourney.setFare(fare);            
            //add to the list
            flightJourneys.add(newJourney);
            
            //Add a journey
            newJourney = new FlightType();
            newJourney.setFlightID(8);
            newJourney.setOriginCity("London Heathrow Airport (LHR)");
            newJourney.setOriginAddress("london");
            newJourney.setDestinationCity("Liverpool John Lennon Airport (LPL)");
            newJourney.setDestinationAddress("Liverpool");
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
            newJourney.setFlightID(9);
            newJourney.setOriginCity("London Heathrow Airport (LHR)");
            newJourney.setOriginAddress("london");
            newJourney.setDestinationCity("Barcelona International Airport (BCN)");
            newJourney.setDestinationAddress("Barcelona");
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
            newJourney.setFlightID(10);
            newJourney.setOriginCity("London Heathrow Airport (LHR)");
            newJourney.setOriginAddress("london");
            newJourney.setDestinationCity("Berlin Brandenburg (U.C.) Airport (BER)");
            newJourney.setDestinationAddress("Berlin");
            newJourney.setDate("01/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Easy Jet");
            newJourney.setAvailableSeats(100);
            newJourney.setConnections(0);
            //Populate cpomplex type fare
            fare = new FlightType.Fare();
            fare.setCurrency("GBP");
            fare.setValue(100);
            newJourney.setFare(fare);//add the two values to the list            
            //add to the list
            flightJourneys.add(newJourney);
            
            //Add a journey
            newJourney = new FlightType();
            newJourney.setFlightID(11);
            newJourney.setOriginCity("Milano / Bresso Airport (LIMB)");
            newJourney.setOriginAddress("Milano");
            newJourney.setDestinationCity("Berlin Brandenburg (U.C.) Airport (BER)");
            newJourney.setDestinationAddress("Berlin");
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
            
            //Add a journey
            newJourney = new FlightType();
            newJourney.setFlightID(12);
            newJourney.setOriginCity("Berlin Brandenburg (U.C.) Airport (BER)");
            newJourney.setOriginAddress("Berlin");
            newJourney.setDestinationCity("Barcelona International Airport (BCN)");
            newJourney.setDestinationAddress("Barcelona");
            newJourney.setDate("02/01/15");
            newJourney.setTime("10:00");
            newJourney.setAirline("Ryanair");
            newJourney.setAvailableSeats(40);
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
            newJourney.setFlightID(13);
            newJourney.setOriginCity("Barcelona International Airport (BCN)");
            newJourney.setOriginAddress("Barcelona");
            newJourney.setDestinationCity("Milano / Bresso Airport (LIMB)");
            newJourney.setDestinationAddress("Milano");
            newJourney.setDate("03/01/15");
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
            newJourney.setFlightID(14);
            newJourney.setOriginCity("Bristol International Airport (BRS)");
            newJourney.setOriginAddress("Bristol");
            newJourney.setDestinationCity("Liverpool John Lennon Airport (LPL)");
            newJourney.setDestinationAddress("Liverpool");
            newJourney.setDate("03/01/15");
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
            newJourney.setFlightID(15);
            newJourney.setOriginCity("Leeds Bradford Airport (LBA)");
            newJourney.setOriginAddress("Leeds");
            newJourney.setDestinationCity("Liverpool John Lennon Airport (LPL)");
            newJourney.setDestinationAddress("Liverpool");
            newJourney.setDate("04/01/15");
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
            newJourney.setFlightID(16);
            newJourney.setOriginCity("Paris Beauvais Tillé Airport (BVA)");
            newJourney.setOriginAddress("Paris");
            newJourney.setDestinationCity("Amsterdam Schiphol Airport (AMS)");
            newJourney.setDestinationAddress("Amsterdam");
            newJourney.setDate("04/01/15");
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
            newJourney.setFlightID(17);
            newJourney.setOriginCity("Manchester Airport (MAN)");
            newJourney.setOriginAddress("Manchester");
            newJourney.setDestinationCity("Belfast International Airport (BFS)");
            newJourney.setDestinationAddress("Liverpool");
            newJourney.setDate("05/01/15");
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
            newJourney.setFlightID(18);
            newJourney.setOriginCity("Belfast International Airport (BFS)");
            newJourney.setOriginAddress("Belfast");
            newJourney.setDestinationCity("Liverpool John Lennon Airport (LPL)");
            newJourney.setDestinationAddress("Liverpool");
            newJourney.setDate("05/01/15");
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
            newJourney.setFlightID(19);
            newJourney.setOriginCity("East Midlands Airport (EMA)");
            newJourney.setOriginAddress("East Midlands");
            newJourney.setDestinationCity("Liverpool John Lennon Airport (LPL)");
            newJourney.setDestinationAddress("Liverpool");
            newJourney.setDate("05/01/15");
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
        //}//ends fill flights
        
 //**************************** Marshal ***************************************
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlight.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(myFlight, System.out);
            
            //Writing the whole XML document to file
            File flightStore = new File("C:\\Users\\Wiliam\\GlassFish_Server\\glassfish\\domains\\WilTech\\config\\flights.xml");
            marshaller.marshal(myFlight, flightStore);
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
     }

    
}
