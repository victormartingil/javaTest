package main.testing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class OgoneTest {

    String passphrase = "Carrefour1Carrefour1";
    String operation = "SAS";
    String pspid = "ESM400Z6";
    String pswd = "c4mktplce";
    String refid = "MKTPLCESPGRP";
    String refkind = "MGID";
    String userId = "MKTPLCESPGRP_API";
    String url = "https://secure.ogone.com/ncol/prod/maintenancedirect.asp";

    public void main() {
        String orderId = "52827856";
        String totalPrice = "3495";
        String messageToShaEncrypt = buildMessageToShaSignKey(orderId, totalPrice);
        String shaHashKey = getShaSignKey(messageToShaEncrypt);
        String ogoneParams = buildOgoneMaintenanceParams(orderId, totalPrice, shaHashKey);
        String finalUrlWithParams = url + ogoneParams;

        System.out.println(finalUrlWithParams);
    }

    public String buildMessageToShaSignKey(String orderId, String totalPrice) {
        //todo REVIEW IF TOTALPRICE IS WITH DECIMALS, AND ORDER-ID WITH "-A"
        // total price -> comes from TIBCO order.getTotal_price (seems with decimals)
        // orderId -> comes from TIBCO order.getOrderId (seems with "-A")
        String response = "AMOUNT=" + totalPrice +
                passphrase +
                "OPERATION=" + operation +
                passphrase +
//                "ORDERID=" + orderId.split("-")[0] +
                "ORDERID=" + orderId +
                passphrase +
                "PSPID=" + pspid +
                passphrase +
                "PSWD=" + pswd +
                passphrase +
                "REFID=" + refid +
                passphrase +
                "REFKIND=" + refkind +
                passphrase +
                "USERID=" + userId;
        System.out.println(response);
        return response;
    }

    public String getShaSignKey(String message) {
        byte[] digest = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(message.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    public String buildOgoneMaintenanceParams(String orderId, String totalPrice, String shaHashKey) {
        //To build params to Ogone, orderId needs to be removed last "-A"
        return "?AMOUNT=" + totalPrice +
                "&OPERATION=" + operation +
                "&ORDERID=" + orderId.split("-")[0] +
                "&PSPID=" + pspid +
                "&PSWD=" + pswd +
                "&REFID=" + refid +
                "&REFKIND=" + refkind +
                "&USERID=" + userId +
                "&SHASIGN=" + shaHashKey;
    }
}
