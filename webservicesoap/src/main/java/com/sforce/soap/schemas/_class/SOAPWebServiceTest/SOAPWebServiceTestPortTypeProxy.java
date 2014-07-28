package com.sforce.soap.schemas._class.SOAPWebServiceTest;

public class SOAPWebServiceTestPortTypeProxy implements com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestPortType {
  private String _endpoint = null;
  private com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestPortType sOAPWebServiceTestPortType = null;
  
  public SOAPWebServiceTestPortTypeProxy() {
    _initSOAPWebServiceTestPortTypeProxy();
  }
  
  public SOAPWebServiceTestPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPWebServiceTestPortTypeProxy();
  }
  
  private void _initSOAPWebServiceTestPortTypeProxy() {
    try {
      sOAPWebServiceTestPortType = (new com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestServiceLocator()).getSOAPWebServiceTest();
      if (sOAPWebServiceTestPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPWebServiceTestPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPWebServiceTestPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPWebServiceTestPortType != null)
      ((javax.xml.rpc.Stub)sOAPWebServiceTestPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestPortType getSOAPWebServiceTestPortType() {
    if (sOAPWebServiceTestPortType == null)
      _initSOAPWebServiceTestPortTypeProxy();
    return sOAPWebServiceTestPortType;
  }
  
  public java.lang.String display(java.lang.String name) throws java.rmi.RemoteException{
    if (sOAPWebServiceTestPortType == null)
      _initSOAPWebServiceTestPortTypeProxy();
    return sOAPWebServiceTestPortType.display(name);
  }
  
  
}