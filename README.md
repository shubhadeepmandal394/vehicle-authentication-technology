# **Vehicle Authentication Technology**

### What is this technology all about ?

Many residential society administrations, tolls, business complexes and parking spaces in India lack an computerized system for car parking and vehicle monitoring.Most of the commercial and residential places face an impending problem of illegal car/vehicle parking inside their premises. This issue is not bounded to just parking, but also adds to the
security concerns inside those establishments.

This Technology helps the Security Personnel of any residential societies, business complex, parking spaces, or any real estate buildings in the detection, identification, and monitoring of vehicles entering/leaving the premises by using image processing of the licence plate pumbers of the vehicles using out Android Application(VNP Scanner - Vehicle Number Plate Scanner) and matching the same with the database.

### How does it work ?

Let's consider we want to implement this technology in a residential society(which consists of more than 10-15 multi-storey building) where it becomes very difficult for the security of the establishment to keep a note of every vehicle moving in and out of the building is actually owned by any resident of the society or is just a guest or is any public vehicle.

In this Technology, we the developers [Shubhadeep Mandal](https://github.com/shubhadeepmandal394) and [Sapnanil Das](https://github.com/sapnanil7) have tried to narrow down this problem;

Let's go step by step,

- The residents of the residential society are provided with a [Website](<give the link to the website here>) where they are to register themselves along with their Vehicle Details (if they own any).
- After registration the same will data will be uploaded to our database.
- The Security Personnel of the establishment will be provided with an Android Smartphone with our [Android Application](https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/application) installed in it.
- Now, whenever any vehicle enters the establishment the security personnel scans the vehicle's number plate using the App and if the Vehicle belongs to any of the Redsidents it will show the message "VEHICLE REGISTERED" else it will show "VEHICLE NOT REGISTERED", and thus they can take actions accordingly.

### Technology Stack

insert images here


### How to Start ?
<a href="https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/LICENSE"><img src="https://img.shields.io/badge/License-MIT-orange"></a>
#### Installing and Configuring XAMPP
<a><img src="https://img.shields.io/badge/Server-Apache-yellow"></a>
<a><img src="https://img.shields.io/badge/Database-MySQL-blue"></a>


- Install and configure [XAMPP](https://pureinfotech.com/install-xampp-windows-10/) on Windows 10.
  NOTE : *In this project we will be using Apache HTTP server and MySQL database configured using XAMPP on our localhost*
  
  <a><img src="https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/assets/img/xampp_screenshot_1.jpg" width="500" height="250"></a>
  
- Now, after you have finished installing XAMPP and fixed all errors (if any), Start the Apache HTTP server and MySQL database.

  <a><img src="https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/assets/img/xampp_screenshot_2.png" width="500" height="250"></a>
  
- Click on **Admin** button next to MySQL or alternatively you can go to your browser and type in the url **http://localhost/phpmyadmin/**
- Now, go to the column on the left side of the screen and select **New**, it will create a new database. Give it a name, here I gave **vehicle_authentication** and leave the collation default and hit **Create**.

  <a><img src="https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/assets/img/xampp_screenshot_3.png" width="500" height="250"></a>
  
- Now, create a table name **users** and with 6 columns for storing **Seriel Number**(primary key), **First Name**, **Last Name**, **E-Mail**, **Phone Number** and lastly **Vehicle Licence Plate Number**.

  <a><img src="https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/assets/img/xampp_screenshot_4.png" width="500" height="250"></a>
  
  That's it !!
  
#### Setting up the Website
> Now, setup the [Website](https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/website) to get the project up and running.

#### Setting up the Android Application
> Now, setup the [Android Application](https://github.com/shubhadeepmandal394/vehicle-authentication-technology/blob/master/application) to get the project up and running.


### Contributers
- [Shubhadeep Mandal](https://github.com/shubhadeepmandal394)
- [Sapnanil Das](https://github.com/sapnanil7)

Loved the work ? [Support Me](https://paypal.me/shubhadeepmandal394?locale.x=en_GB) for my next project 😇