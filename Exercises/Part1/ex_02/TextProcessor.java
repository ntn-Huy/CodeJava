package Part1.ex_02;

// class TextProcessor

public class TextProcessor{
    public static String formatName(String rawName){
        String[] words = rawName.trim().split("\\s+");
        StringBuilder formattedName = new StringBuilder();
        for (int i =0;i<words.length;i++){
            String word = words[i];
            if(!word.isEmpty()){
                String capitalizedWord = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
                formattedName.append(capitalizedWord);
                if (i<words.length-1){
                    formattedName.append(" ");
                }
            }
        }
        return formattedName.toString();
    }

}