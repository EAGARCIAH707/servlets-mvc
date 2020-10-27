<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Welcome</title>
        <style>
            body{
                background-color: #2B2B2B;   
            }

            *{
                font-family: 'Raleway', sans-serif;
                color : #FFF;

            }


            div h3 span{
                color : #FFF;
                font-size:14px;
            }

            div span {
                font-weight: 200;
            }

            h1{
                font-weight: 200;
            }

            .login_box{
                background: #f32d27; /* Old browsers */
                /* IE9 SVG, needs conditional override of 'filter' to 'none' */
                background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMTAwJSIgeDI9IjEwMCUiIHkyPSIwJSI+CiAgICA8c3RvcCBvZmZzZXQ9IjUlIiBzdG9wLWNvbG9yPSIjZjMyZDI3IiBzdG9wLW9wYWNpdHk9IjEiLz4KICAgIDxzdG9wIG9mZnNldD0iOTklIiBzdG9wLWNvbG9yPSIjZmY2YjQ1IiBzdG9wLW9wYWNpdHk9IjEiLz4KICA8L2xpbmVhckdyYWRpZW50PgogIDxyZWN0IHg9IjAiIHk9IjAiIHdpZHRoPSIxIiBoZWlnaHQ9IjEiIGZpbGw9InVybCgjZ3JhZC11Y2dnLWdlbmVyYXRlZCkiIC8+Cjwvc3ZnPg==);
                background: -moz-linear-gradient(45deg,  #f32d27 5%, #ff6b45 99%); /* FF3.6+ */
                background: -webkit-gradient(linear, left bottom, right top, color-stop(5%,#f32d27), color-stop(99%,#ff6b45)); /* Chrome,Safari4+ */
                background: -webkit-linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* Chrome10+,Safari5.1+ */
                background: -o-linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* Opera 11.10+ */
                background: -ms-linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* IE10+ */
                background: linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* W3C */
                filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f32d27', endColorstr='#ff6b45',GradientType=1 ); /* IE6-8 fallback on horizontal gradient */

                width:35%;
                /* height:70%; */
                position:absolute;
                top:15%;
                left:32.5%;

                -webkit-box-shadow: 0px 0px 8px 0px rgba(50, 50, 50, 0.54);
                -moz-box-shadow:    0px 0px 8px 0px rgba(50, 50, 50, 0.54);
                box-shadow:         0px 0px 8px 0px rgba(50, 50, 50, 0.54);
            }

            @media (max-width: 767px) {
                .login_box{
                    background: #f32d27; /* Old browsers */
                    /* IE9 SVG, needs conditional override of 'filter' to 'none' */
                    background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMTAwJSIgeDI9IjEwMCUiIHkyPSIwJSI+CiAgICA8c3RvcCBvZmZzZXQ9IjUlIiBzdG9wLWNvbG9yPSIjZjMyZDI3IiBzdG9wLW9wYWNpdHk9IjEiLz4KICAgIDxzdG9wIG9mZnNldD0iOTklIiBzdG9wLWNvbG9yPSIjZmY2YjQ1IiBzdG9wLW9wYWNpdHk9IjEiLz4KICA8L2xpbmVhckdyYWRpZW50PgogIDxyZWN0IHg9IjAiIHk9IjAiIHdpZHRoPSIxIiBoZWlnaHQ9IjEiIGZpbGw9InVybCgjZ3JhZC11Y2dnLWdlbmVyYXRlZCkiIC8+Cjwvc3ZnPg==);
                    background: -moz-linear-gradient(45deg,  #f32d27 5%, #ff6b45 99%); /* FF3.6+ */
                    background: -webkit-gradient(linear, left bottom, right top, color-stop(5%,#f32d27), color-stop(99%,#ff6b45)); /* Chrome,Safari4+ */
                    background: -webkit-linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* Chrome10+,Safari5.1+ */
                    background: -o-linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* Opera 11.10+ */
                    background: -ms-linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* IE10+ */
                    background: linear-gradient(45deg,  #f32d27 5%,#ff6b45 99%); /* W3C */
                    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f32d27', endColorstr='#ff6b45',GradientType=1 ); /* IE6-8 fallback on horizontal gradient */

                    width:90%;
                    height:80%;
                    position:absolute;
                    top:10%;
                    left:5%;

                    -webkit-box-shadow: 0px 0px 8px 0px rgba(50, 50, 50, 0.54);
                    -moz-box-shadow:    0px 0px 8px 0px rgba(50, 50, 50, 0.54);
                    box-shadow:         0px 0px 8px 0px rgba(50, 50, 50, 0.54);
                }
            }

            .image-circle{
                border-radius: 50%;
                width: 175px;
                height: 175px;
                border: 4px solid #FFF;
                margin: 10px;
            }

            .follow{
                background-color:#FC563B;
                height: 80px;
                cursor:pointer;
            }

            .follow:hover {
                background-color:#F22F26;
                height: 80px;
                cursor:pointer;
            }

            .login_control{
                background-color:#FFF;
                padding:10px;

            }

            .control {
                color:#000;
                margin:10px;
            }

            .label {
                color: #EB4F26;
                font-size: 18px;
                font-weight: 500;
            }

            .form-control{
                color: #000000 !important;
                font-size: 25px;
                border: none;
                padding: 25px;
                padding-left: 10px;
                border-bottom: 1px solid #CCC;
                margin-bottom: 10px;
                outline: none;
                -webkit-box-shadow: none !important;
                -moz-box-shadow: none !important;
                box-shadow: none !important;
            }

            .form-control:focus{
                border-radius: 0px;
                border-bottom: 1px solid #FC563B;
                margin-bottom: 10px;
                outline: none;
                -webkit-box-shadow: none !important;
                -moz-box-shadow: none !important;
                box-shadow: none !important;
            }
            .btn-orange{
                background-color: #FC563B;
                border-radius: 0px;
                margin: 5px;
                padding: 5px;
                width: 150px;
                font-size: 20px;
                font-weight: inherit;
            }

            .btn-orange:hover {
                background-color: #F22F26;
                border-radius: 0px;
                margin: 5px;
                padding: 5px;
                width: 150px;
                font-size: 20px;
                font-weight: inherit;
                color:#FFF !important;
            }

            .line{
                border-bottom : 2px solid #F32D27;
            }


            .outter{
                padding: 0px;
                border: 1px solid rgba(255, 255, 255, 0.29);
                border-radius: 50%;
                width: 200px;
                height: 200px;
            }

        </style>
    </head>

    <body>

    <link href='http://fonts.googleapis.com/css?family=Raleway:400,200' rel='stylesheet' type='text/css'>

    <div class="container">
        <div class="row login_box">
            <div class="col-md-12 col-xs-12" align="center">
                <div class="line"><h3>12 : 30 AM</h3></div>
                <div class="outter"><img src="http://lorempixel.com/output/people-q-c-100-100-1.jpg" class="image-circle"/></div>   
                <h2>Bienvenido, <%=session.getAttribute("username")%></h2>
                <span>INDIAN</span>
            </div>
            <div class="col-md-6 col-xs-6 follow line" align="center">
                <h3>
                    125651 <br/> <span>FOLLOWERS</span>
                </h3>
            </div>
            <div class="col-md-6 col-xs-6 follow line" align="center">
                <h3>
                    125651 <br/> <span>FOLLOWERS</span>
                </h3>
            </div>

            <div class="col-md-12 col-xs-12 login_control">

                <div class="control">
                    <div class="label">Email Address</div>
                    <input type="text" class="form-control" value="admin@gmail.com"/>
                </div>

                <div class="control">
                    <div class="label">Password</div>
                    <input type="password" class="form-control" value="123456"/>
                </div>
                <div align="center">
                    <button class="btn btn-orange">LOGIN</button>
                </div>

            </div>





        </div>
    </div>                     

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
    crossorigin="anonymous"></script>

</body>
</html>
