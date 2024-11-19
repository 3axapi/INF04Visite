using System;
using System.Collections.Generic;

public class HelloWorld
{
    public static void Main(string[] args)
    {
        Console.WriteLine(StringReading.CountVoice("A SDwASasd!2qasd f1"));
        Console.WriteLine(StringReading.ReadUndoubletapably("Tthisss'___  Innnde;;"));
    }


    /***********************************************
        klasa:  <StringReading>
        opis:   <Reprezentuje manipulację stringami w sposób wyczytujący wyniki
                Ma dwie metody statyczne: jedna liczy samogłoski stringa, a druga wyczytyje modyfikowany string bez powtórzeń poprzednich znaków>
        metody: <CountVoice - int>
                <ReadUndoubletapably - string>
        author: 20051003
    ***********************************************/
    class StringReading
    {
        public static int CountVoice (string text)
        {
            if (text == null) return 0;
            
            string voice_chars = "AĄOÓUYEĘaąoóuyeę";
            int voices_count = 0;
        
            foreach (char letter in text)
            {
                foreach (char voice_letter in voice_chars)
                {
                    if (letter == voice_letter) voices_count++;
                }
            }
            
            return voices_count;
        }
        
        public static string ReadUndoubletapably (string text)
        {
            if (text == null) return "0";
            
            List<char> chars_list = new List<char>();
            char previous_char = 'π';
            
            foreach (char letter in text)
            {
                if (previous_char == 'π') 
                {
                    previous_char = letter;
                    chars_list.Add(letter);
                    continue;
                }
                
                if (letter == previous_char) continue;
                
                previous_char = letter;
                chars_list.Add(letter);
                continue;
                
            }
            
            string edited_text = String.Concat(chars_list);
            
            return edited_text;
        }
    }
}
