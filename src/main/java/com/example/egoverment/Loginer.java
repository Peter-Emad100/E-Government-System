package com.example.egoverment;


public class Loginer extends Human {
    private String loginName;
    private String Password;

    public Loginer(String name, String id, String loginName, String Password) {
        super(name, id);
        this.loginName = loginName;
        this.Password = Password;

    }

    protected String getLoginName() {
        return loginName;
    }

    protected String getPassword() {
        return Password;
    }

    /* Email and Username Validation */
    public void setLoginName(String loginName) {
        boolean isEmail = false;
        String[] emails = {"@gmail.com", "@yahoo.com", "@outlook.com", "@icloud.com", "@hotmail.com"};

        // Check if loginName contains any of the valid email domains
        for (String emailDomain : emails) {
            if (loginName.contains(emailDomain)) {
                isEmail = true;
                break;  // Exit the loop once a valid email domain is found
            } else {
                System.out.println("Email must contain a correct domain.");
            }
        }
        // Username validation
        if (loginName.length() < 5 || loginName.length() > 15) {
            System.out.println("Username must be between 5 and 15 characters long.");
            return;
        }
        if (Character.isDigit(loginName.charAt(0))) {
            System.out.println("Username must not start with a number.");
            return;
        }

        // If validation is passed, set the login name
        this.loginName = loginName;
        System.out.println("Login name set successfully!");
    }


    /* Password Validation */
    public void setPassword(String newPassword) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
        //Check length
        if (newPassword.length() < 10) {
            System.out.println("Password must be at least 10 characters long.");
        }// Check for numbers
        boolean hasNumber = newPassword.matches(".*\\d.*");
        // Check for special characters
        boolean hasSpecialChar = newPassword.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");
        if (!hasNumber) {
            System.out.println("Password must include at least one numeric character.");
        } if (!hasSpecialChar) {
            System.out.println("Password must include at least one special character.");
        } if (hasNumber && hasSpecialChar) {
            this.Password = newPassword;
            System.out.println("Password set successfully!");
            }
        }
    }







