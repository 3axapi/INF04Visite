using System;

public class HelloWorld
{
    public static void Main(string[] args)
    {
        // Console.WriteLine(StringReading.CountVoice(""));
        Console.WriteLine(StringReading.ReadUndoubletapably("null"));
    }
    
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
            if (text == null) return "";
            
            string edited_text = "";
            char previous_char = 'π';
            
            foreach (char letter in text)
            {
                if (previous_char == 'π') 
                {
                    previous_char = letter;
                    edited_text[edited_text.lenght - 1];
                    continue;
                }
                
                if (letter == previous_char) continue;
                
                previous_char = letter;
                edited_text[edited_text.lenght - 1];
                continue;
                
            }
            
            return text;
        }
    }
}
