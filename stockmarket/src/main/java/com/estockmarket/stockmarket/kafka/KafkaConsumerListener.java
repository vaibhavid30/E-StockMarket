package com.estockmarket.stockmarket.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.estockmarket.stockmarket.model.User;


@Service
public class KafkaConsumerListener {
	
	 private static final String UserTOPIC = "kafkaUserTopic";
	//  private static final String AirLineTOPIC = "kafkaAirLineTopic";

	    @KafkaListener(topics = UserTOPIC, groupId="user_group_id", containerFactory = "userKafkaListenerFactory")
	    public void consumeUser(User user) {
	        System.out.println("User " + user.getEmail()+" registered successfully");
	    }
	    
	    
	
	//   @KafkaListener(topics = AirLineTOPIC, groupId="group_id", containerFactory =
	//   "airLineKafkaListenerFactory") public void consumeAirLine(AirLine airLine) {
	//   System.out.println("New AirLine "+
	//   airLine.getFlightName()+" with FlightNumber "+airLine.getFlightNo()+
	//   " added to AirLine-List successfully "); }
	 
}
