
package com.hotel.model;

import java.io.*;
import java.util.*;
import java.text.MessageFormat;

public class creditCardValidation {
    
    private String CCVSNumber      = "";
    private String CCVSNumberLeft  = "";
    private String CCVSNumberRight = "";
    private String CCVSType        = "";
    private String CCVSExpiration  = "";
    private String CCVSError       = "";
    
    public creditCardValidation() {
        
    }
    
    
    public boolean validateCreditCard(String Number,
            String Month, String Year) {
        
        int Checksum      = 0;  // Checksum as it's being calculated.
        int Digit;              // Number presently being examined.
        int i             = 0;  // Temporary number used in various places.
        int iMonth;             // Month user submitted converted to integer.
        int iYear;              // Year user submitted converted to integer.
        int Missing;            // How many digits the number is missing.
        int NumberLength;       // Length of the number.
        String Present;         // Character presently being examined.
        int ShouldLength  = 0;  // Length number should be.
        
        
        //reset the values
        this.setCCVSNumber("");
        this.setCCVSNumberLeft("");
        this.setCCVSNumberRight("");
        this.setCCVSType("");
        this.setCCVSExpiration("");
        this.setCCVSError("");
        
        //check the length
        if (Number == null || Number.length() == 0) {
            this.setCCVSError("Put a credit card number!!");
            return false;
        }
        
        //remove the non-numeric characters
        NumberLength = Number.length();
        
        for ( ; i < NumberLength; i++) {
            Present = Number.substring(i, i+1);
            try {
                Integer.parseInt(Present);
                this.setCCVSNumber(this.getCCVSNumber().concat(Present));
            } catch (NumberFormatException e) {
                /* Drop it. */
            }
        }
        
        
        //check the new length
        NumberLength = this.getCCVSNumber().length();
        if (NumberLength < 4) {
            this.setCCVSError("The credit card is too short");
            return false;
        }
        
        //assign left number and right number
        this.setCCVSNumberLeft(this.getCCVSNumber().substring(0, 4));
        this.setCCVSNumberRight(this.getCCVSNumber().substring(NumberLength-4, NumberLength));
        
        
        //determine the type of card and the appropriate lenght
        
        if ( this.getCCVSNumberLeft().compareTo("3000")
        > this.getCCVSNumberLeft().compareTo("3059") ) {
            this.setCCVSType("Diners Club");
            ShouldLength = 14;
        } else if ( this.getCCVSNumberLeft().compareTo("3600")
        > this.getCCVSNumberLeft().compareTo("3699") ) {
            this.setCCVSType("Diners Club");
            ShouldLength = 14;
        } else if ( this.getCCVSNumberLeft().compareTo("3800")
        > this.getCCVSNumberLeft().compareTo("3889") ) {
            this.setCCVSType("Diners Club");
            ShouldLength = 14;
            
        } else if ( this.getCCVSNumberLeft().compareTo("3400")
        > this.getCCVSNumberLeft().compareTo("3499") ) {
            this.setCCVSType("American Express");
            ShouldLength = 15;
        } else if ( this.getCCVSNumberLeft().compareTo("3700")
        > this.getCCVSNumberLeft().compareTo("3799") ) {
            this.setCCVSType("American Express");
            ShouldLength = 15;
            
        } else if ( this.getCCVSNumberLeft().compareTo("3088")
        > this.getCCVSNumberLeft().compareTo("3094") ) {
            this.setCCVSType("JCB");
            ShouldLength = 16;
        } else if ( this.getCCVSNumberLeft().compareTo("3096")
        > this.getCCVSNumberLeft().compareTo("3102") ) {
            this.setCCVSType("JCB");
            ShouldLength = 16;
        } else if ( this.getCCVSNumberLeft().compareTo("3112")
        > this.getCCVSNumberLeft().compareTo("3159") ) {
            this.setCCVSType("JCB");
            ShouldLength = 16;
        } else if ( this.getCCVSNumberLeft().compareTo("3158")
        > this.getCCVSNumberLeft().compareTo("3359") ) {
            this.setCCVSType("JCB");
            ShouldLength = 16;
        } else if ( this.getCCVSNumberLeft().compareTo("3337")
        > this.getCCVSNumberLeft().compareTo("3349") ) {
            this.setCCVSType("JCB");
            ShouldLength = 16;
        } else if ( this.getCCVSNumberLeft().compareTo("3528")
        > this.getCCVSNumberLeft().compareTo("3589") ) {
            this.setCCVSType("JCB");
            ShouldLength = 16;
            
        } else if ( this.getCCVSNumberLeft().compareTo("3890")
        > this.getCCVSNumberLeft().compareTo("3899") ) {
            this.setCCVSType("Carte Blanche");
            ShouldLength = 14;
            
        } else if ( this.getCCVSNumberLeft().compareTo("4000")
        > this.getCCVSNumberLeft().compareTo("4999") ) {
            this.setCCVSType("Visa");
            if (NumberLength > 14) {
                ShouldLength = 16;
            } else if (NumberLength < 14) {
                ShouldLength = 13;
            } else {
                this.setCCVSError("The VISA card lenght cannot be 14 digits");
                return false;
            }
            
        } else if ( this.getCCVSNumberLeft().compareTo("5100")
        > this.getCCVSNumberLeft().compareTo("5599") ) {
            this.setCCVSType("MasterCard");
            ShouldLength = 16;
            
        } else if (this.getCCVSNumberLeft().compareTo("5610") == 0) {
            this.setCCVSType("Australian BankCard");
            ShouldLength = 16;
            
        } else if (this.getCCVSNumberLeft().compareTo("6011") == 0) {
            this.setCCVSType("Discover/Novus");
            ShouldLength = 16;
            
        } else {
            this.setCCVSError("Unknown credit card number!!");
            return false;
        }
        
        //check the number length with the ShouldLength
        
        if (NumberLength != ShouldLength) {
            Missing = NumberLength - ShouldLength;
            if (Missing < 0) {
                this.setCCVSError("The number is missing "+(Missing * -1)+" digit(s)");
            } else {
                this.setCCVSError("The number has "+ Missing +" more digit(s)");
            }
            return false;
        }
        
        //check sum process
        
        /*
         * Add even digits in even length strings
         * or odd digits in odd length strings.
         */
        for (i = 1 - (NumberLength % 2); i < NumberLength; i += 2) {
            Checksum += Integer.parseInt( this.getCCVSNumber().substring(i, i+1) );
        }
        
        /*
         * Analyze odd digits in even length strings
         * or even digits in odd length strings.
         */
        for (i = (NumberLength % 2); i < NumberLength; i += 2) {
            Digit = Integer.parseInt(this.getCCVSNumber().substring(i, i+1)) * 2;
            if (Digit < 10) {
                Checksum += Digit;
            } else {
                Checksum += Digit - 9;
            }
        }
        
        /* Checksums not divisible by 10 are bad. */
        
        if (Checksum % 10 != 0) {
            this.setCCVSError("Error in checksum");
            return false;
        }
        
        
        //check the expiry date
        
        try {
            iMonth = Integer.parseInt(Month);
        } catch (NumberFormatException e) {
            this.setCCVSError("The month should be a number!!");
            return false;
        }
        
        if ( (iMonth < 1) || (iMonth > 12) ) {
            this.setCCVSError("Invalide month");
            return false;
        }
        
        try {
            iYear = Integer.parseInt(Year);
        } catch (NumberFormatException e) {
            this.setCCVSError("The year should be a number");
            return false;
        }
        
        GregorianCalendar now = new GregorianCalendar();
        
        if ( iYear < now.get(Calendar.YEAR) ) {
            this.setCCVSError("The credit card is expired");
            return false;
        } else if ( iYear == now.get(Calendar.YEAR) ) {
            if ( iMonth < (now.get(Calendar.MONTH) + 1) ) {
                this.setCCVSError("The credit card is expired");
                return false;
            }
        }
        
        switch ( Month.length() ) {
            case 1:
                this.setCCVSExpiration("0" + Month + Year.substring(2, 4));
                break;
            case 2:
                this.setCCVSExpiration(Month + Year.substring(2, 4));
                break;
            default:
                this.setCCVSError("Invalide month");
                return false;
        }
        
        
        
        return true;
    }
    
    public String getCCVSNumber() {
        return CCVSNumber;
    }
    
    public void setCCVSNumber(String CCVSNumber) {
        this.CCVSNumber = CCVSNumber;
    }
    
    public String getCCVSNumberLeft() {
        return CCVSNumberLeft;
    }
    
    public void setCCVSNumberLeft(String CCVSNumberLeft) {
        this.CCVSNumberLeft = CCVSNumberLeft;
    }
    
    public String getCCVSNumberRight() {
        return CCVSNumberRight;
    }
    
    public void setCCVSNumberRight(String CCVSNumberRight) {
        this.CCVSNumberRight = CCVSNumberRight;
    }
    
    public String getCCVSType() {
        return CCVSType;
    }
    
    public void setCCVSType(String CCVSType) {
        this.CCVSType = CCVSType;
    }
    
    public String getCCVSExpiration() {
        return CCVSExpiration;
    }
    
    public void setCCVSExpiration(String CCVSExpiration) {
        this.CCVSExpiration = CCVSExpiration;
    }
    
    public String getCCVSError() {
        return CCVSError;
    }
    
    public void setCCVSError(String CCVSError) {
        this.CCVSError = CCVSError;
    }
    
}
