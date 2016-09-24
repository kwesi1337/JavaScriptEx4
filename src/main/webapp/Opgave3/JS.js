/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    
    $("#timeinput").val(getTime());
   
   function getTime(){
       
       var currentTme = new Date();
       var timeString = currentTime.getHours() + ":" 
               + currentTime.getMintes() + ":" +
               currentTime.getSeconds();
       
       return timeString;
       
       
   };
   
   $("#timeupdate").on("click", function(){
       
       var jqxhr = $.get({
           
           url:"/JavaScriptEx4/ServletThree"
           
       });
       
       jqxhr.done(function(data, status){
           
           
           $("#timeinput").val(data);
           
       });
   });
   
   // Opgave 4
   
   $("#svddiv").on("click", function(evt){
       var target = evt.target;
       var targetParent = target.parentNode;
       var idForParent = $(targetParent).attr("id");
       alert("Clicked element: " + idForParent);
       
   });
   
});
