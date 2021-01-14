/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoupkullanımı;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


// JSoup ile basit hava durumu uygulaması

public class JSoupKullanımı implements GetData{
    Document doc;
    public JSoupKullanımı() throws IOException{
        doc = Jsoup.connect("https://www.google.com/search?client=firefox-b-d&sxsrf=ALeKk01vCSOx24EMnxI8i-dAdr5-T1b0vQ%3A1610653383147&ei=x54AYKLNCPTEgwfryJrQAw&q=k%C4%B1r%C5%9Fehir+hava+durumu&oq=k%C4%B1r%C5%9Fehir+hava+durumu&gs_lcp=CgZwc3ktYWIQAzIICAAQsQMQgwEyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgAEEc6BggAEAgQHjoICAAQCBAKEB5QgyFY_CZg6ypoAHABeACAAa0BiAGuApIBAzAuMpgBAKABAaoBB2d3cy13aXrIAQjAAQE&sclient=psy-ab&ved=0ahUKEwjizIi2l5zuAhV04uAKHWukBjoQ4dUDCAw&uact=5").get();
        String htmlTitle = doc.title();
        
        System.out.println(htmlTitle);
    }

    @Override
    public String getdata() {
        Elements element = this.doc.select("span#wob_tm");
        return element.html();
    }
    
    public static void main(String args[]) throws IOException{
        JSoupKullanımı j1 = new JSoupKullanımı();
        System.err.println("Kırşehir Hava Durumu Derecesi : " + j1.getdata() + "°C");
    }
    
    
}
