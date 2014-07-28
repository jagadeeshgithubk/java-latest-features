/**
 * SOAPWebServiceTestServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.schemas._class.SOAPWebServiceTest;

public class SOAPWebServiceTestServiceLocator extends org.apache.axis.client.Service implements com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestService {

    public SOAPWebServiceTestServiceLocator() {
    }


    public SOAPWebServiceTestServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAPWebServiceTestServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAPWebServiceTest
    private java.lang.String SOAPWebServiceTest_address = "https://cs15.salesforce.com/services/Soap/class/SOAPWebServiceTest";

    public java.lang.String getSOAPWebServiceTestAddress() {
        return SOAPWebServiceTest_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAPWebServiceTestWSDDServiceName = "SOAPWebServiceTest";

    public java.lang.String getSOAPWebServiceTestWSDDServiceName() {
        return SOAPWebServiceTestWSDDServiceName;
    }

    public void setSOAPWebServiceTestWSDDServiceName(java.lang.String name) {
        SOAPWebServiceTestWSDDServiceName = name;
    }

    public com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestPortType getSOAPWebServiceTest() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAPWebServiceTest_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAPWebServiceTest(endpoint);
    }

    public com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestPortType getSOAPWebServiceTest(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestBindingStub _stub = new com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestBindingStub(portAddress, this);
            _stub.setPortName(getSOAPWebServiceTestWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAPWebServiceTestEndpointAddress(java.lang.String address) {
        SOAPWebServiceTest_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestBindingStub _stub = new com.sforce.soap.schemas._class.SOAPWebServiceTest.SOAPWebServiceTestBindingStub(new java.net.URL(SOAPWebServiceTest_address), this);
                _stub.setPortName(getSOAPWebServiceTestWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOAPWebServiceTest".equals(inputPortName)) {
            return getSOAPWebServiceTest();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/SOAPWebServiceTest", "SOAPWebServiceTestService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.sforce.com/schemas/class/SOAPWebServiceTest", "SOAPWebServiceTest"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAPWebServiceTest".equals(portName)) {
            setSOAPWebServiceTestEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
