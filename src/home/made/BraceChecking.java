package home.made;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BraceChecking {
    public boolean isValid(String braces) {
        // Atmetam iskarto kur stringas yra neporinis ir pradzia prasideda su uzdarymo simboliu.
        if((braces.length() % 2 != 0) || Pattern.matches("^[\\}\\)\\]].+", braces)){
            return false;
        }
        // Suskaldom ir sudedam i array
        String[] bracesArr =  braces.split("");
        // ArrayList naudojam nes nuo nezinom kiek reikes nariu rezervuoti.
        List<String> checker = new ArrayList<>();
        // Uzsukam cikla
        for(int i = 0; i < bracesArr.length; i++) {
            // panaudoju regex paterna issiaiskinti ar tai pradzios ar pabaigos simbolis
            if(Pattern.matches("[\\{\\(\\[]", bracesArr[i])) {
                // pradzios simboli idedu i kaupykle
                checker.add(bracesArr[i]);
            } else {
                // jei kaupykleje nieko nera reiskia parejo uzdarymo simbolis neasant atidarymo. Blogai!
                if(checker.size() == 0) {return false;}
                // paiimu paskutini ideta i kaupykle simboli
                String lastBrace = checker.get(checker.size() - 1);
                // patikrinu ar paskutinis idetas simbolis sutampa su uzdarymo simboliu
                if (
                        (lastBrace.equals("(")  && bracesArr[i].equals(")")) ||
                                (lastBrace.equals("{") && bracesArr[i].equals("}")) ||
                                (lastBrace.equals("[") && bracesArr[i].equals("]"))
                ) {
                    // jei sutampa issimu is kaupykles sutapeli.
                    checker.remove(checker.size() - 1);
                } else { return false; }
            }
        }
        // duotas simboliu kratinys yra valydus jei kaupykleje atidarymo simboliu nebeliko.
        return checker.size() == 0 ? true : false;
    }
}
