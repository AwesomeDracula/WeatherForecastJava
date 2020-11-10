/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import control.HandleAPI;
import data.JsonResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Admin
 */
public class PrepareGUI {
    private WeatherApp weather;
    private JsonResult jsonresult;
    private int index = 0;

    public PrepareGUI() {
        weather = new WeatherApp();
        prepare();
    }

    public WeatherApp getWeather() {
        return weather;
    }
    
    private void prepare(){
        weather.getjButton1().setActionCommand("find");
        weather.getjButton1().addActionListener(new ButtonClick());
        
    }
    
    private void show(){
        String weath = "   Weather: " + jsonresult.getList()[index].getWeather()[0].getDescription();
        String temp = "   Temparature: " + jsonresult.getList()[index].getMain().getTemp() + " độ C";
        String press = "   Pressure: " + jsonresult.getList()[index].getMain().getPressure();
        String time = "   Time: " + jsonresult.getList()[index].getDt_txt();
        String ws = "   Wind speed: " + jsonresult.getList()[index].getWind().getSpeed();
        String hum = "   Humidity: " + jsonresult.getList()[index].getMain().getHumidity();
        
        weather.getLb_weather2().setText(weath);
        weather.getLb_weather4().setText(temp);
        weather.getLb_weather3().setText(press);
        weather.getLb_weather1().setText(time);
        weather.getLb_weather5().setText(ws);
        weather.getLb_weather().setText(hum);
    }
    
    public class ButtonClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            find();
            index = 0;
            show();
        }
        private void find(){
            jsonresult = HandleAPI.getJsonData((String) weather.getjTextField1().getText());
        }
    }
}
