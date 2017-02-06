
package npay;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServiceSoap", targetNamespace = "nPAY")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServiceSoap {


    /**
     * 
     * @param processId
     * @param merchantId
     * @param cardDetails
     * @param merchantTxnId
     * @param merchantUserName
     * @param payAmt
     * @param descriptionMsg
     * @return
     *     returns npay.TxnResponse
     */
    @WebMethod(operationName = "DoTransaction", action = "nPAY/DoTransaction")
    @WebResult(name = "DoTransactionResult", targetNamespace = "nPAY")
    @RequestWrapper(localName = "DoTransaction", targetNamespace = "nPAY", className = "npay.DoTransaction")
    @ResponseWrapper(localName = "DoTransactionResponse", targetNamespace = "nPAY", className = "npay.DoTransactionResponse")
    public TxnResponse doTransaction(
            @WebParam(name = "ProcessId", targetNamespace = "nPAY")
            String processId,
            @WebParam(name = "MerchantId", targetNamespace = "nPAY")
            String merchantId,
            @WebParam(name = "MerchantTxnId", targetNamespace = "nPAY")
            String merchantTxnId,
            @WebParam(name = "MerchantUserName", targetNamespace = "nPAY")
            String merchantUserName,
            @WebParam(name = "PayAmt", targetNamespace = "nPAY")
            String payAmt,
            @WebParam(name = "DescriptionMsg", targetNamespace = "nPAY")
            String descriptionMsg,
            @WebParam(name = "CardDetails", targetNamespace = "nPAY")
            String cardDetails);

    /**
     * 
     * @param merchantPassword
     * @param amount
     * @param merchantId
     * @param signature
     * @param merchantTxnId
     * @param purchaseDescription
     * @param merchantUserName
     * @return
     *     returns npay.AuthenticateMerchant
     */
    @WebMethod(operationName = "ValidateMerchant", action = "nPAY/ValidateMerchant")
    @WebResult(name = "ValidateMerchantResult", targetNamespace = "nPAY")
    @RequestWrapper(localName = "ValidateMerchant", targetNamespace = "nPAY", className = "npay.ValidateMerchant")
    @ResponseWrapper(localName = "ValidateMerchantResponse", targetNamespace = "nPAY", className = "npay.ValidateMerchantResponse")
    public AuthenticateMerchant validateMerchant(
            @WebParam(name = "MerchantId", targetNamespace = "nPAY")
            String merchantId,
            @WebParam(name = "MerchantTxnId", targetNamespace = "nPAY")
            String merchantTxnId,
            @WebParam(name = "MerchantUserName", targetNamespace = "nPAY")
            String merchantUserName,
            @WebParam(name = "MerchantPassword", targetNamespace = "nPAY")
            String merchantPassword,
            @WebParam(name = "Signature", targetNamespace = "nPAY")
            String signature,
            @WebParam(name = "AMOUNT", targetNamespace = "nPAY")
            String amount,
            @WebParam(name = "purchaseDescription", targetNamespace = "nPAY")
            String purchaseDescription);

    /**
     * 
     * @param merchantPassword
     * @param merchantId
     * @param signature
     * @param gtwrefno
     * @param merchantTxnId
     * @param merchantUserName
     * @return
     *     returns npay.TransactionStatus
     */
    @WebMethod(operationName = "CheckTransactionStatus", action = "nPAY/CheckTransactionStatus")
    @WebResult(name = "CheckTransactionStatusResult", targetNamespace = "nPAY")
    @RequestWrapper(localName = "CheckTransactionStatus", targetNamespace = "nPAY", className = "npay.CheckTransactionStatus")
    @ResponseWrapper(localName = "CheckTransactionStatusResponse", targetNamespace = "nPAY", className = "npay.CheckTransactionStatusResponse")
    public TransactionStatus checkTransactionStatus(
            @WebParam(name = "MerchantId", targetNamespace = "nPAY")
            String merchantId,
            @WebParam(name = "MerchantTxnId", targetNamespace = "nPAY")
            String merchantTxnId,
            @WebParam(name = "MerchantUserName", targetNamespace = "nPAY")
            String merchantUserName,
            @WebParam(name = "MerchantPassword", targetNamespace = "nPAY")
            String merchantPassword,
            @WebParam(name = "Signature", targetNamespace = "nPAY")
            String signature,
            @WebParam(name = "GTWREFNO", targetNamespace = "nPAY")
            String gtwrefno);

    /**
     * 
     * @param merchantPassword
     * @param fromDate
     * @param merchantId
     * @param signature
     * @param toDate
     * @param merchantUserName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "QueryReport", action = "nPAY/QueryReport")
    @WebResult(name = "QueryReportResult", targetNamespace = "nPAY")
    @RequestWrapper(localName = "QueryReport", targetNamespace = "nPAY", className = "npay.QueryReport")
    @ResponseWrapper(localName = "QueryReportResponse", targetNamespace = "nPAY", className = "npay.QueryReportResponse")
    public String queryReport(
            @WebParam(name = "MerchantId", targetNamespace = "nPAY")
            String merchantId,
            @WebParam(name = "MerchantUserName", targetNamespace = "nPAY")
            String merchantUserName,
            @WebParam(name = "MerchantPassword", targetNamespace = "nPAY")
            String merchantPassword,
            @WebParam(name = "Signature", targetNamespace = "nPAY")
            String signature,
            @WebParam(name = "FromDate", targetNamespace = "nPAY")
            String fromDate,
            @WebParam(name = "ToDate", targetNamespace = "nPAY")
            String toDate);

}