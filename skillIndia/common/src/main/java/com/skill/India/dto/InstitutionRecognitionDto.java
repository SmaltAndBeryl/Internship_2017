package com.skill.India.dto;

public class InstitutionRecognitionDto {
    private final String nameOfRecognizingBody;
    private final String recognitionNumber;
    private final String yearOfRecognition;
    private final String validityOfRecognition;

    public String getNameOfRecognizingBody() {
        return nameOfRecognizingBody;
    }

    public String getRecognitionNumber() {
        return recognitionNumber;
    }

    public String getYearOfRecognition() {
        return yearOfRecognition;
    }

    public String getValidityOfRecognition() {
        return validityOfRecognition;
    }

    public InstitutionRecognitionDto(String nameOfRecognizingBody, String recognitionNumber, String yearOfRecognition, String validityOfRecognition) {
        this.nameOfRecognizingBody = nameOfRecognizingBody;

        this.recognitionNumber = recognitionNumber;
        this.yearOfRecognition = yearOfRecognition;
        this.validityOfRecognition = validityOfRecognition;
    }
}
