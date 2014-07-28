package com.test.main;

import java.net.URL;

import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.SessionHeader;
import com.sforce.soap.partner.SforceServiceLocator;
import com.sforce.soap.partner.SoapBindingStub;
import com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestBindingStub;
import com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestServiceLocator;
 
public class WebserviceMain 
{
   public static void main(String[] args) 
   {
       try 
       {
         //Get a stub for calling partner WSDL's login method in order to get SessionID
         SoapBindingStub bind= (SoapBindingStub)new SforceServiceLocator().getSoap();
         
         //login 'user name' and 'password+Security Token' 
         LoginResult lr=bind.login("jagadeesh.kongara@hibu.com.train02", "nopassword@9htU1AnBj5rpo8D8rMkiYwebE");
 
         //Create a sessionHeader object and set its sessioId property to sessionId 
         //received in loginResult object                        
         SessionHeader sh=new SessionHeader();
         sh.setSessionId(lr.getSessionId());
 
         //Create a service locator object for your custom web service
         SOAPWebServiceTestServiceLocator locator=new SOAPWebServiceTestServiceLocator();
 
         //Get URL for your custom web service
         URL url=new URL(locator.getSOAPWebServiceTestAddress());
 
         //Create a stub for your custom web service with URL for your service and locator as parameters
         SOAPWebServiceTestBindingStub stub=new SOAPWebServiceTestBindingStub(url, locator);
 
         //Set the header property of stub with name "SessionHeader" and value as sh-sessionHeader 
         //object created above 
         stub.setHeader(locator.getSOAPWebServiceTestAddress(), "SessionHeader", sh);
 
         //now make call to custom service-in our case its "display(String name)"
         String display = stub.display("a1Ge0000000tvqYEAQ");
		System.out.println(display);
        }
        catch (Exception e) 
        {e.printStackTrace(); }  
   } 
}