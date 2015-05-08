/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiltech;

import java.io.File;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.WebServiceRef;
import org.netbeans.xml.schema.flightsinfo.FlightBooking;
import org.netbeans.xml.schema.flightsinfo.FlightType;

/**
 *
 * @author Wiliam
 */
@WebService(serviceName = "FlightsWS")
public class FlightsWS {

    //*************************** method to search bookings *********************
    //GenerateFlights getAllFlights = new GenerateFlights();
    
    @WebMethod(operationName = "searchJourney")
    public List<FlightType> searchJourney(String origin, String destination, String directFlight) {
        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //create the list of available flights to return
            List<FlightType> availableJourneysList = new ArrayList<FlightType>();

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //checks if city matches
                if (newJourney.getOriginCity().isEmpty()) {
                    System.out.println("Please enter origin city");
                } else {
                    if (origin.equalsIgnoreCase(newJourney.getOriginCity())
                            && destination.equalsIgnoreCase(newJourney.getDestinationCity())) {
                        if (directFlight.equalsIgnoreCase("yes")) {
                            if (newJourney.getConnections() < 1) {
                                availableJourneysList.add(newJourney);//Add matched city to the return list                                
                            }//ends if there is connection                            
                        }//ends if the user selected connection
                        else {
                            availableJourneysList.add(newJourney);//Add matched city to the return list
                        }//ends else                   

                    }//ends if statement found city
                }//ends else
            }//ends while loop

            return availableJourneysList;//return a list of similar resources

        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        return null;
    }//ends public flight search journey method


    /*
     private String marshalFlights(FlightBooking listOfFlights){
     StringWriter xmlFlights = new StringWriter();
     try {            
     JAXBContext jaxbCtx = JAXBContext.newInstance(xmlFlights.getClass().getPackage().getName());
     Marshaller marshaller = jaxbCtx.createMarshaller();
     marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
     marshaller.marshal(xmlFlights, System.out);
     //return the list of flights
     return xmlFlights.toString();
     } catch (javax.xml.bind.JAXBException ex) {
     // XXXTODO Handle exception
     java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
     }
     return null;
     }*/
    /**
     * Web service operation
     */
    @WebMethod(operationName = "bookTicket")
    public FlightType bookTicket(int flightID, String passengerName, int numberOfTickets) {

        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            String name = "Mr/s " + passengerName;

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //checks if city matches
                if (flightID == 0) {
                    System.out.println("Please enter a flight ID");
                } else {
                    if (flightID == newJourney.getFlightID()) {
                        if (newJourney.getAvailableSeats() > numberOfTickets) {
                            newJourney.setAvailableSeats(newJourney.getAvailableSeats() - numberOfTickets);
                            // marshal the file back
                            try {
                                javax.xml.bind.JAXBContext jaxbCtxM = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
                                javax.xml.bind.Marshaller marshaller = jaxbCtxM.createMarshaller();
                                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                                //marshaller.marshal(myFlights, System.out);

                                //Writing the whole XML document to file
                                File flightStore = new File("C:\\Users\\Wiliam\\GlassFish_Server\\glassfish\\domains\\WilTech\\config\\flights.xml");
                                marshaller.marshal(myFlights, flightStore);

                            } catch (javax.xml.bind.JAXBException ex) {
                                // XXXTODO Handle exception
                                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                            }
                            return newJourney;
                        }
                    }//ends if fligtht Id matches
                }//ends else
            }//ends while loop
        }//ends try
        catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }//ends catch  

        return null;
    }

    /**
     * Web service operation to catch all of the origin destinations
     */
    @WebMethod(operationName = "getOriginCities")
    public List<String> getOriginCities() {
        List<String> getAllOrigins = new ArrayList();

        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //checks if city matches and add if not already there                
                if (!getAllOrigins.contains(newJourney.getOriginCity())) {
                    getAllOrigins.add(newJourney.getOriginCity());
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
//System.out.println(getAllOrigins);

        //remove duplicates
        Set<String> citiesSet = new LinkedHashSet<String>(getAllOrigins);
        //LinkedHashset<String>
        // LinkedHashSet<String>(Arrays.asList(getAllOrigins))
        return getAllOrigins;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDestinationCity")
    public List<String> getDestinationCity(@WebParam(name = "originCity") String originCity) {

        List<String> destinationCities = new ArrayList<String>();

        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //get the origin flights available avoiding duplicates               
                if (originCity.equals(newJourney.getOriginCity())) {
                    if (!destinationCities.contains(newJourney.getDestinationCity())) {
                        destinationCities.add(newJourney.getDestinationCity());
                    }
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        //TODO write your implementation code here:
        return destinationCities;
    }

    /**
     * Web service operation to get the number of seats available in a specific
     * flight
     */
    @WebMethod(operationName = "getAvailableSeats")
    public int getAvailableSeats(@WebParam(name = "flightID") int flightID) {

        int numberOfAvailableseats = 1;
         //List<String> availableSeats = new ArrayList<String>();

        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //get the origin flights available avoiding duplicates               
                if (flightID == newJourney.getFlightID()) {
                    numberOfAvailableseats = newJourney.getAvailableSeats();
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return numberOfAvailableseats;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFlightIDs")
    public List<String> getFlightIDs() {
        List<String> getAllflighIDs = new ArrayList();

        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //gets all the flight IDs 
                String flightIDs = String.valueOf(newJourney.getFlightID());
                getAllflighIDs.add(flightIDs);
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        return getAllflighIDs;
    }//ends get flight IDs

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fillFlights")
    public String fillFlights() {
        //********************** fill in flight details *************************
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
        newJourney.setDate("01/01/2015");
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
        newJourney.setDate("01/01/2015");
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
        newJourney.setDate("02/01/2015");
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
        newJourney.setDate("02/01/2015");
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
        newJourney.setDate("03/01/2015");
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
        newJourney.setDate("04/01/2015");
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
        newJourney.setDate("02/01/2015");
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
        newJourney.setOriginAddress("London");
        newJourney.setDestinationCity("Liverpool John Lennon Airport (LPL)");
        newJourney.setDestinationAddress("Liverpool");
        newJourney.setDate("01/01/2015");
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
        newJourney.setOriginAddress("London");
        newJourney.setDestinationCity("Barcelona International Airport (BCN)");
        newJourney.setDestinationAddress("Barcelona");
        newJourney.setDate("01/01/2015");
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
        newJourney.setOriginAddress("London");
        newJourney.setDestinationCity("Berlin Brandenburg (U.C.) Airport (BER)");
        newJourney.setDestinationAddress("Berlin");
        newJourney.setDate("01/01/2015");
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
        newJourney.setDate("02/01/2015");
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
        newJourney.setDate("02/01/2015");
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
        newJourney.setDate("03/01/2015");
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
        newJourney.setDate("03/01/2015");
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
        newJourney.setDate("04/01/2015");
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
        newJourney.setDate("04/01/2015");
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
        newJourney.setDate("05/01/2015");
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
        newJourney.setDate("05/01/2015");
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
        newJourney.setDate("05/01/2015");
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
            File flightStore = new File("flights.xml");
            marshaller.marshal(myFlight, flightStore);

        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        return "Done updating the flights";
    }

    /**
     * Web service operation to get all the addresses of the origin airport
     */
    @WebMethod(operationName = "getAirportAddress")
    public List<String> getAirportAddress() {
        List<String> getAllOrigins = new ArrayList();

        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //checks if city matches and add if not already there                
                if (!getAllOrigins.contains(newJourney.getOriginAddress())) {
                    getAllOrigins.add(newJourney.getOriginAddress());
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
//System.out.println(getAllOrigins);

        //remove duplicates
        Set<String> citiesSet = new LinkedHashSet<String>(getAllOrigins);
        //LinkedHashset<String>
        // LinkedHashSet<String>(Arrays.asList(getAllOrigins))
        return getAllOrigins;
    }

    //*******************************get flights by date *********************************************************
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFlightByDate")
    public List<FlightType> getFlightByDate(@WebParam(name = "date") String date) {
        //declare the list of flights XML root element
        FlightBooking myFlights = new FlightBooking();
        //unmarshal
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(myFlights.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            myFlights = (FlightBooking) unmarshaller.unmarshal(new java.io.File("flights.xml")); //NOI18N         

            //get the list of flights in the xml
            List<FlightType> flightJourney = myFlights.getFlightTrips();
            FlightType newJourney = new FlightType();

            //create the list of available flights to return
            List<FlightType> availableJourneysList = new ArrayList<FlightType>();

            //Create three dates, yesterday, today and tomorrow
            String dateYesterday = "";
            String dateToday = date;
            String dateTomorrow = "";
            
            //Create date formater and calendar to add dates
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar  calendar = Calendar.getInstance();
            Date dateChosen;
                    try {
                        dateChosen = df.parse(date);
                        calendar.setTime(dateChosen);
                        
                        calendar.add(Calendar.DATE,1);//get tomorrow flights date
                        dateTomorrow = df.format(calendar.getTime());
                        
                        calendar.add(Calendar.DATE,-2);//get yesterday flights date
                        dateYesterday = df.format(calendar.getTime());
//                        
//                        String newDateString = df.format(dateChosen);
//                        System.out.println(newDateString);
//                        System.out.println(dateTomorrow);
//                        System.out.println(dateToday);
//                        System.out.println(dateYesterday);
//                        System.out.println(date);                       
//                        
                    } catch (Exception e) {
                        e.getMessage();
                    }
            //iterates through the list of flights from XML file
            Iterator itr = flightJourney.iterator();
            while (itr.hasNext()) {
                newJourney = (FlightType) itr.next();
                //checks if date matches
                if (dateYesterday.equalsIgnoreCase(newJourney.getDate()) || dateToday.equalsIgnoreCase(newJourney.getDate()) || dateTomorrow.equalsIgnoreCase(newJourney.getDate())) {
                    //Save the journeys in an ArrayList to return to the client
                    availableJourneysList.add(newJourney);
                }//ends if statement
            }
            return availableJourneysList;//return the flight that matches the date

        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return null;
    }

}//ends the class
