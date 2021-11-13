import java.io.*;
import java.net.*;

public class HTML {

    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        String endereco;
        String html;
        String entrada;
        String parada = "FIM";
        entrada = MyIO.readLine();
        while (compare(entrada, parada) == false) {
            endereco = MyIO.readLine();
            html = ht(endereco);
            int c = 0;
            int c2 = 0;
            c = table(html);
            c2 = br(html);
            MyIO.setCharset("ISO8859-1");
            MyIO.print("a("+(lerA(html)-(1*c))+")");
            MyIO.print(" e("+(lerE(html)-(1*c))+")");
            MyIO.print(" i("+lerI(html)+")");
            MyIO.print(" o("+lerO(html)+")");
            MyIO.print(" u("+lerU(html)+")");
            MyIO.print(" á("+lerA2(html)+")");
            MyIO.print(" é("+lerE2(html)+")");
            MyIO.print(" í("+lerI2(html)+")");
            MyIO.print(" ó("+lerO2(html)+")");
            MyIO.print(" ú("+lerU2(html)+")");
            MyIO.print(" à("+lerA3(html)+")");
            MyIO.print(" è("+lerE3(html)+")");
            MyIO.print(" ì("+lerI3(html)+")");
            MyIO.print(" ò("+lerO3(html)+")");
            MyIO.print(" ù("+lerU3(html)+")");
            MyIO.print(" ã("+lerA4(html)+")");
            MyIO.print(" õ("+lerO4(html)+")");
            MyIO.print(" â("+lerA5(html)+")");
            MyIO.print(" ê("+lerE5(html)+")");
            MyIO.print(" î("+lerI5(html)+")");
            MyIO.print(" ô("+lerO5(html)+")");
            MyIO.print(" û("+lerU5(html)+")");
            MyIO.print(" consoante("+(consoante(html)-(c * 3)-(c2 * 2))+")");
            MyIO.print(" <br>("+br(html)+")");
            MyIO.print(" <table>("+table(html)+")");
            MyIO.print(" " + entrada + "\n");
            entrada = MyIO.readLine();
        }
    }

    
    public static boolean compare(String s, String t) {
        boolean r = true;
        int tamanho;
        tamanho = s.length();
        if (s.length() == t.length()) {
            for (int i = tamanho - 1; i >= 0; i--) {
                if (s.charAt(i) != t.charAt(i)) {
                    r = false;
                }
            }
        } else {
            r = false;
        }
        return r;
    }

    
    public static String ht(String endereco) {
        URL f;
        InputStream t = null;
        BufferedReader b;
        String r = "";
        String linha;
        try {
            f = new URL(endereco);
            t = f.openStream();
            b = new BufferedReader(new InputStreamReader(t));
            while ((linha = b.readLine()) != null) {
                r += linha + "\n";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            t.close();
        } catch (IOException i) {
        }
        return r;
    }

   
    public static int lerA(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 'a') {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerE(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 'e') {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerI(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 'i') {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerO(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 'o') {
                cont++;
            }
        }
        return cont;
    }

  
    public static int lerU(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 'u') {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerA2(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 160) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerE2(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 130) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerI2(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 161) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerO2(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 162) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerU2(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 163) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerA3(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 133) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerE3(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 138) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerI3(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 141) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerO3(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 149) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerU3(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 151) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerA4(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 198) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerO4(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 228) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerA5(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 131) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerE5(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 136) {
                cont++;
            }
        }
        return cont;
    }

   
    public static int lerI5(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 140) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerO5(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 147) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int lerU5(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == 150) {
                cont++;
            }
        }
        return cont;
    }

    
    public static int consoante(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) > 'a' && html.charAt(i) <= 'z') {
                if (html.charAt(i) != 'e' && html.charAt(i) != 'i' && html.charAt(i) != 'o' && html.charAt(i) != 'u') {
                    cont++;
                }
            }
        }
        return cont;
    }

    
    public static int br(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<') {
                if (html.charAt(i + 1) == 'b') {
                    if (html.charAt(i + 2) == 'r') {
                        if (html.charAt(i + 3) == '>') {
                            cont++;
                        }
                    }
                }
            }
        }
        return cont;
    }

    
    public static int table(String html) {
        int cont = 0;
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<') {
                if (html.charAt(i + 1) == 't') {
                    if (html.charAt(i + 2) == 'a') {
                        if (html.charAt(i + 3) == 'b') {
                            if (html.charAt(i + 4) == 'l') {
                                if (html.charAt(i + 5) == 'e') {
                                    if (html.charAt(i + 6) == '>') {
                                        cont++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return cont;
    }

}
