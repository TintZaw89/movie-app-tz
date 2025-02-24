<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="components/video_modal.css" media="screen" />
 
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

<embed src="video/bf3vu.mp4" showcontrols="true" width="425" height="350"></embed>


<h2>Video Popup</h2>
[{Video url='https://www.youtube.com/watch?v=rYEDA3JcQqw' width=560 height=315}]

<!-- Trigger/Open The Modal -->
<div class="dropdown">

  <button class="dropbtn">Dropdown</button>
  
  <div id="dcont" class="dropdown-content">
        <%
        String[] arr=new String[10];
        arr[1]="file:///C:/Users/WCT/Desktop/MyApp/Eclipse_JAVA_PROJ/video/bf3vu.mp4";
        arr[2]="video/bf3vu.mp4";
        /*arr[3]="video/example.mp4";*/

        %> 
        <a>
       <%for(int i=1;i<3;i++){%>  
     
       <input id="myBtn<%=i%>" onclick="javascript:vidsub(this.id)" type="submit" value="<%=arr[i]%>">
      
       
       <%}%>
        </a>
  </div>
     
</div>
<EMBED src="file:///C:/Users/WCT/Desktop/MyApp/Eclipse_JAVA_PROJ/video/bf3vu.mp4" 
       height="50%" 
       width="50%" 
       autostart="true">
</EMBED>
 
<!-- The Modal -->
<div id="myModal" class="modal">
   
    <div class='modal-content'>
      <!-- Modal content -->
      <span class='close'>&times;</span>
      <div id="mcont"></div>      
    </div>
</div>

    <script>
            // Get the modal
            var modal = document.getElementById("myModal");   
           
            // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];

            // When the user clicks the button, open the modal
            function vidsub(clk) {
          
            var btn = document.getElementById(clk);
             
            var aval=btn.value;
                
            var temp=JSON.stringify(aval);
               
            document.getElementById("mcont").innerHTML =" <video autoplay id='vid' loop controls width='100%' height='100%'> <source src="+temp+" type='video/mp4'> <object data='js/video-js.swf' width='720' height='480'></object> </video>";
      
             modal.style.display = "block";
            };

            // When the user clicks on <span> (x), close the modal
            
            span.onclick = function() 
			{
    		document.getElementById("mcont").innerHTML =""; 
    		modal.style.display = "none";
    		x.pause();
			}
        
           // span.onclick = function() {
            //  modal.style.display = "none";
             // x.pause();
           // }

            // When the user clicks anywhere outside of the modal, close it
           // window.onclick = function(event) {
            //  if (event.target == modal) {
            //    modal.style.display = "none";
            //  }
            }
    </script>
</body>
</html>