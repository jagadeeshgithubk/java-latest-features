global class SOAPWebServiceTest
{
    webService static String display(String Name) 
    {
        //Book__c loadedBook = [SELECT Name FROM Book__c where id='a1Ge0000000tvpzEAA'];
        Book__c loadedBook = [SELECT Name FROM Book__c where id=:Name];
        return 'Book name for the given ID is : '+loadedBook.Name;
        //return 'Hello .......'+Name+'..... from SalesForce.com';
        //test
    }
}