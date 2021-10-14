package com.dice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

class CustomException extends Exception
{

   // Parameterless Constructor
    public CustomException() {}

    // Constructor that accepts a message
    public CustomException(String message)
    {
        super(message);
    }
}
