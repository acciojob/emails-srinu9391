package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(this.password.equals(oldPassword)) {

            if (newPassword.length() >= 8) {

                int uc = 0;
                int lc = 0;
                int digit = 0;
                int sp = 0;
                for (int i = 0; i < newPassword.length(); i++) {
                    char ch = newPassword.charAt(i);
                    if (ch >= 'A' && ch <= 'Z')
                        uc++;
                    else if (ch >= 'a' && ch <= 'z')
                        lc++;
                    else if (ch >= '0' && ch <= '9')
                        digit++;
                    else
                        sp++;
                }
                if (uc >= 1 && lc >= 1 && digit >= 1 && sp >= 1) {
                    this.password = newPassword;
                }
            }
        }

    }
}
