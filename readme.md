1.Multithreded web server 
operating system 
Computer networks

will take till 1million request on our server and will test how multithreded server works
and thread pool implementation how it works and how single threaded works 

Webserver
whenever we open browser then html css js will be bring and static components like imaes video from somewhere that is called server 
there is server it will be serving for client 
user requesting anything to the server then work  of server is to serve static dynamic everything then it is called websever 

how client will be knowing which server he needs to request ?
there is adress which is assigned to everyone 
client->server 
server will be one region 
ISP will be exposing the Ip adress if anyone wants to requests then there is public ip adress 192. something ipv6
ISP we have many machines in whcih it has public IP adress 
so we get request in ISP then we have routers (traffic route) at the end will be having one server or any assigned server so its running program IP adress is like street number and port is like house number  ISP is state country and with port will be comming with eact PC

clinet ---> www.google.com
		|
		192.21.12.....8080
		
so google.com dont no the machines and routers 
so we have DNS so 1st client request will go to DNS -> DNS is server just mapping is adress for example- google.com is key and for this value is ip adres
so client will get IP adress  

how clinet reaches till webserver 
there are some adresses through which client cann reach webserver  so for this it will be having IP adress port which will get from  DNS - so routing will happen through computer network 


client -><- server How data flow is happening here like will be sending 1010 in bits so we need medium we need wires so now we have wireless and it is wireless communication 

protocols -> 
communication -> DNS DNs wil provide Ip adress so with that help client will ttake to server in between this is called network 

client ---> Server 
client will tell I need to do connection with you i will send data and you need to send back me the data so server will say how I can Identify as client then before this will be having protocols 
if we are doing with TCP then we need to to do 3way handshake or if we are doing with UDP we can do directly data communication 
UDP is staight forward 
tcp is used more because data deliver and error wil less for example if we are sending message in whatsapp msg should be sent completely 
comming to UDP anyone is watching video so if we miss any frame is also fine so in this will be using UDP

so what is in TCP overhead 

client --- server 

whenever data is sending by clinet or revciving from server so there will be 3 way handshake so there will be protocol 
protocol is nothing but we need to give meta data or headers need to give meta data means extra data because to understand the server

so client will send the flag as sync to syncronaise -client will tell server to syncronise with me 
then server will be having socket so whenver socket accepts the connection then only it will send back the sync-Ack to client 
so server says to client ye now I got your request so now you can setup connection   so client will send back again ACK that yes now willl be ready to communicate 


HTTP protocl work on tcp through http we are requesting to identify our server so we have identified the server using 3 way handshake 

HTTP we have two types 
1. https->1.0 - non persistant 
2. 1.1-> persistant 


non-persistant => client->server 
client request to server using shocket (its pipe through which data flow happens )
so whenever http request hits server will open one shocket through that socket server will be sent data so when client get data immidiately  it biterated and disconnected connection with server so this type is called non-persistant 


 Persistant 
 in this its completly opposite 
 server will say take any amount of data and socket will be open untill timeout so this good client will be persistant 
 
=> So whenever if we dont want to keep timeout or there is no timeout so we need to do it manually 
 so I will be sending flag as fin(finish) and from server end will get ASK will get acknowlegement 
 and sockets will be closedd 
 
 
 questions asked on above topics
 TCP 
 3way handshake 
 persistant and non persistant 
 
We have seen the basic of client server architecture  so client and server will communicate through protocols to set protocol they will be using 3way handshake and when communication is set then  they will communicate through http 
When we send mail in that will be using SMTP(Simple mail transfer protocol) 
data transfer - FTP
but will be looking into http

 comming to sockets what are sockets 
 
 socktes will happens through operating system
 
 client -> Server 
 both will be having operating system may be server end there is no gui there is terminal but still it has many resourses it has kernel which interacts directly with hardware 
 
 client=> socket/api
 server=> socket/api it can be linux mac we can use sockets
 
  
 
 whenever I want to request to server before that I wil be opening socket(IP adress, and Port) we need to take from os all this is abstract, operating system work is it needs to check which port is empty so it will pick that port and it will attach ip adress then it will define complete adress
 =>server end also IP adress and Port is defined similarly by the operating system, so here the socket opened will be always will be listening. socket.listen()
 so whenever i will be sending connection from client when it commes to server end socket then 3way handshake will take place. socket .accept()
 
=> one thing is missing is that whenver socket.accept happens then it will not happen on socket.listen this will take place on diffrent socket 
so if its persistant it will set timeout and if non persistant automaticaly it will cancel 

 so this is happend with client1 so again will be having diffrents clients client2 clint 3 etc and serve will be listening 
 
 so here comes the concept of Threads 
 
 Threads - whenever the pieace of code is running like we are listening audio video program is running so to run this one worker is required so we call this as Thread 

Thread is simple programatic implementation, penomenon where it picks program and allocates resourses and etc so that the program can run 


In this Single threaded 
client -> server 
client request send requests and request.accept() and server opens the socket socket.listen 
client c1 communication is going on and so c2 requests so server says I am single threaded I have alredy opened one socket that is going on  because I am single threaded and I dont have any other threads  so it is blocked and code cant run 
so c2 needs to wait and after completing c1 the socket will be free and availabe and c2 will confirm with server socket is socket is availabe then it says socket is available so c2 will be sharing the communication data 


Multithreaded
 
 
 client -> server 
 
 I will say server you keep listing with socket your Ip adress is known will be everyone so any request you get you create socket and it in thread and rember that you are multithreaded you can create multiple threads you will be having 4 cores and 8 cores 
 
 =>so if I have 4 cpu then 4 threads will be running  independently 
 
 conclution: client request to server then new socket will be opend in server end then it depends how client handles through server 
 => if someone is handling single threaddely  so it possible that thread will be blocked then 2nd cleint comes then it will not be able to give connection server 
 => if its multithreaded then server simeltaneously handle and if any thread is taking more time to execute t1 and t2 will come then t2 is executing in less time then t2 will execute 1st untill then t1 will be ideal 
 
 => context switching, concerant request because of alll this  multithreaded server will be fast 
 
 so it has drawbackk (25:30) 
 
