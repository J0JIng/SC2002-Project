package services;

import models.Enquiry;
import stores.DataStore;
import enums.MessageStatus;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;


public class EnquiryService {
    private Map<Integer, Enquiry> enquiryData;

    public EnquiryService(){
         enquiryData = DataStore.getEnquiryData(); 


    public boolean submitEnquiry(String senderID, String campName, String enquiryMessage) {
        int enquiryID = UUID.randomUUID().hashCode();
        Enquiry enquiry = new Enquiry(enquiryID, senderID, campName, enquiryMessage); 
        enquiry.setEnquiryStatus(MessageStatus.PENDING); 
        enquiryData.put(enquiryID, enquiry);
        DataStore.setEnquiryData(enquiryData);
         return true;
        }
    
    public Map<Integer, Enquiry> viewDraftEnquiries(String studentID) {
         return enquiryData.values().stream()
                 .filter(enquiry -> enquiry.getSenderID().equals(studentID) && enquiry.getEnquiryStatus() == MessageStatus.DRAFT)
                 .collect(Collectors.toMap(Enquiry::getEnquiryID, enquiry -> enquiry));
        }

    public boolean editDraftEnquiry(int enquiryID, String studentID, String newMessage) {
            if (enquiryData.containsKey(enquiryID)) {
                Enquiry enquiry = enquiryData.get(enquiryID);
                if (enquiry.getSenderID().equals(studentID) && enquiry.getEnquiryStatus() == MessageStatus.DRAFT) {
                    enquiry.setEnquiryMessage(newMessage);
                    DataStore.setEnquiryData(enquiryData);
                    return true;
                }
            }
            return false;
        }
    
        public boolean deleteDraftEnquiry(int enquiryID, String studentID) {
            if (enquiryData.containsKey(enquiryID)) {
                Enquiry enquiry = enquiryData.get(enquiryID);
                if (enquiry.getSenderID().equals(studentID) && enquiry.getEnquiryStatus() == MessageStatus.DRAFT) {
                    enquiryData.remove(enquiryID);
                    DataStore.setEnquiryData(enquiryData);
                    return true;
                }
            }
            return false;
        }



  /*   public Map<Integer, Enquiry> viewCampEnquiries(String campName, String staffID) */
      
          

   
     public boolean respondToEnquiry(int enquiryID, String responderID, MessageStatus status, String response) {
        if (enquiryData.containsKey(enquiryID)) {
            Enquiry enquiry = enquiryData.get(enquiryID);
            enquiry.setResponderID(responderID);
            enquiry.setEnquiryResponse(response);
            enquiry.setEnquiryStatus(status);
            DataStore.setEnquiryData(enquiryData);
            return true;
            }
            return false;
        }
    
    


    }