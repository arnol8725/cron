/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.elektra.uniformes.comercio.cron.dao.modelo;


public class EstructuraCorreo {

    
    public EstructuraCorreo(){                
    }
    
    public String th(String nombre){
        return "<th>"+nombre+"</th>";
    }
    
    public String td(String nombre){
        return "<td>"+nombre+"</td>";
    }

    public String td(int nombre){
        return "<td>"+nombre+"</td>";
    }      
    
    public String td(long nombre){
        return "<td>"+nombre+"</td>";
    }      
    
    public String salto(){
        return "<br/>";
    }
    
    public String h2(String nombre){
        return "<h2>"+nombre+"</h2>";
    }    
    
    public String h3(String nombre){
        return "<h3>"+nombre+"</h3>";
    }
    
    public String tr(String nombre){
        return "<tr>"+nombre+"</tr>";
    }    
    
    public String head(){
        return "<head> " +
                "<style type=\"text/css\"> " +
                "body{ " +
                "     font-family     : Verdana, Arial;" +
                "     font-size       : 10px;" +
                "     text-align:center;" +
                "}" +
                "table{ " +
                "     empty-cells     : show;" +
                "     border-collapse : collapse;" +
                "     width           : 100%;" + 
                "     border          : solid 2px #444444;" +
                "} " +
                "td{ " + 
                "     border: solid 1px #444444;" +
                "     font-size       : 12px;" +
                "     padding         : 5px;} " +
                "th{ " +
                "     background      : #EEEEEE;" +
                "     border          : solid 1px #444444;" +
                "     font-size       : 14px;" +
                "     padding         : 8px;}" +
                "</style>" +
                "</head>";
    }
}
