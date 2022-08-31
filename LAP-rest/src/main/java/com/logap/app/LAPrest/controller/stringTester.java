package com.logap.app.LAPrest.controller;

import com.logap.app.LAPrest.controller.models.StringModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class stringTester {

    String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String v = "aeiouAEIOU";
    String c = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";


    @GetMapping(path = "/api/stringTest/{string}")
    public StringModel testString(@PathVariable("string") String string){
        long startTime = System.nanoTime();
        String treatedString = stringTreatment((string));
        Integer t = stringTest(treatedString);
        Character p = string.charAt(t);

        StringModel testingString = new StringModel();

        testingString.string = string;
        testingString.vogal = p.toString();
        Integer elapsedTime = (int) ((System.nanoTime() - startTime) /10000);
        testingString.tempoTotal = elapsedTime.toString() + " ms";

        return testingString;
    }

    public Integer stringTest(@NotNull String string){
        Integer k = 0;

        for(int i = 2; i < string.length(); i++){
            k = 0;
            if(isAVowel(string.charAt(i))){
                if(isAConsonant(string.charAt(i - 1))){
                    if(isAVowel(string.charAt(i - 2))){
                        for(int j = 0; j < i; j++){
                            if((string.charAt(j) == string.charAt(i))){
                                k = -1;
                            }
                        }

                        if(k != -1){
                            k = i;
                            return k;
                        }
                    }
                }
            }
        }

        k = null;
        return k;
    }

    public String stringTreatment(String string){
        String result = "";
        for(int i = 0; i < string.length(); i++){
            for(int j = 0; j < a.length(); j++){
                if(string.charAt(i) == a.charAt(j)){
                    if(j > 25){
                        result += a.charAt(j - 26);
                    }else{
                        result += a.charAt(j);
                    }
                    break;
                }
            }
        }

        return result;
    }

    public boolean isAVowel(char t){
        for(int j = 0; j < 10; j++){
            if(t == v.charAt(j)){ //se a letra no indice i da string for uma vogal:
                return true;
            }
        }
        return false;
    }

    public boolean isAConsonant(char t){
        for(int j = 0; j < 42; j++){
            if(t == c.charAt(j)){ //se a letra no indice i da string for uma consoante:
                return true;
            }
        }
        return false;
    }

}
