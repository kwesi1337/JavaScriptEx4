/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




$(function () {
    
    
    start();
    function start(){
        
        var timeStamp = getTime();
        
        $("#timebox").val(timeStamp);
    };
    
    function getTime(){
        
        var currentTime = new Date();
        var timeString = currentTime.getHours() + ":" 
                + currentTime.getMinutes() + ":" + currentTime.getSeconds();
        
        return timeString;
        
    };
    
    
    $("#timebutton").on("click", function() {
        
        var jqxhr = $.ajax({
            
            url:"/JavaScriptEx4/SServlet",
            type: "GET"
        });
        
        jqxhr.done(function(data, textstatus){
            
            $("#timebox").val(data);
            console.log(data);
            console.log(textStatus);
            
        });
        
        
    });
    
    // Opgave 2
    
    
    $("#tableButton").on("click", function(){
        
        getFromServer();
    });
    
    
    function getFromServer(){
        
        var jqxhr = $.ajax({
            
            url:"/JavaScriptEx4/SServlet",
            type: "GET"
        });
        
        jqxhr.done(function(data, textStatus){
            
            console.log(data);
            console.log(textStatus);
            
            var arrayOfPersons = JSON.parse(data);
            $("#tbody").html("");
            $(arrayOfPersons).each(function() {
                
                var rowString = "<tr>";
                rowString += "<td>" + $(this).attr("name") + "</td>";
                rowString += "<td>" + $(this).attr("age") + "</td>";
                $("#tbody").append(rowString);
                
            });
        });
        
        
    };
    
    $("#submimtBut").on("click", function(){
        
        var person = new Object();
        console.log($("nameInput").val());
        person.name = $("#nameInput").val();
        person.age = $("ageInput").val();
        
        var json_data = JSON.stringify(person);
        
        var jqxhr = $.post({
            url:"/JavaScriptEx4/SServlet",
            data: json_data
        });
    
        jqxhr.done(function(data, textStatus){
            
            getFromServer();
            
        });
        
    });
    
    });